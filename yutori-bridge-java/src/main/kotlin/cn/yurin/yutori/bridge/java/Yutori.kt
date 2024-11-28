package cn.yurin.yutori.bridge.java

import cn.yurin.yutori.*
import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.function.BiConsumer
import java.util.function.Consumer
import kotlin.coroutines.CoroutineContext

class JavaYutori(
    val yutori: Yutori,
) {
    fun start() =
        runBlocking {
            yutori.modules.filterIsInstance<Startable>().forEach { module ->
                launch {
                    try {
                        module.start(yutori)
                    } catch (e: Exception) {
                        Logger.w(e) { "Module start failed" }
                    }
                }
            }
        }

    fun stop() = yutori.modules.filterIsInstance<Stopable>().forEach { adapter -> adapter.stop(yutori) }

    companion object {
        @JvmStatic
        @JvmOverloads
        fun builder(name: String = "Yutori") = JavaYutoriBuilder(name)
    }
}

class JavaYutoriBuilder(
    private val name: String,
) {
    private val builder = YutoriBuilder(name)

    fun <T : Module> install(
        module: T,
        `class`: Class<T>,
    ): JavaYutoriBuilder {
        if (module !is Reinstallable && builder.modules.any { it::class == `class` }) {
            throw ModuleReinstallException(module.toString())
        }
        if (module.alias != null && builder.modules.any { it.alias == module.alias }) {
            throw ModuleAliasDuplicateException(module.alias!!)
        }
        module.install(builder)
        builder.modules += module
        return this
    }

    fun <T : Module> uninstall(`class`: Class<T>) {
        for (module in builder.modules.filter {
            var superClass = it::class.java.superclass
            while (superClass != null) {
                if (it::class.java.superclass == `class`) return@filter true
                superClass = superClass.superclass
            }
            false
        }) {
            uninstall(module)
        }
    }

    fun uninstall(alias: String? = null) {
        builder.modules.find { it.alias == alias }?.let { uninstall(it) }
    }

    fun uninstall(module: Module) {
        module.uninstall(builder)
        builder.modules -= module
    }

    fun adapter(block: Consumer<Adapter>): JavaYutoriBuilder {
        builder.adapter = Adapter(name).apply { block.accept(this) }.build()
        return this
    }

    fun server(block: Consumer<Server>): JavaYutoriBuilder {
        builder.server = Server(name).apply { block.accept(this) }.build()
        return this
    }

    fun build() = JavaYutori(builder.build())

    class Adapter(
        private val name: String,
    ) {
        var exceptionHandler: BiConsumer<CoroutineContext, Throwable> =
            BiConsumer { _, throwable ->
                Logger.w(name, throwable) { "监听器发生异常" }
            }
        private var container = JavaAdapterListenersContainerBuilder()

        fun listening(block: Consumer<JavaAdapterListenersContainerBuilder>) {
            container = JavaAdapterListenersContainerBuilder().apply { block.accept(this) }
        }

        fun build() =
            YutoriBuilder.Adapter(name).apply {
                exceptionHandler =
                    CoroutineExceptionHandler { context, throwable ->
                        this@Adapter.exceptionHandler.accept(context, throwable)
                    }

                container = this@Adapter.container.build()
            }
    }

    class Server(
        private val name: String,
    ) {
        var exceptionHandler: BiConsumer<CoroutineContext, Throwable> =
            BiConsumer { _, throwable ->
                Logger.w(name, throwable) { "监听器发生异常" }
            }
        private var container = JavaServerListenersContainerBuilder()

        fun routing(block: Consumer<JavaServerListenersContainerBuilder>) {
            container = JavaServerListenersContainerBuilder().apply { block.accept(this) }
        }

        fun build() =
            YutoriBuilder.Server(name).apply {
                exceptionHandler =
                    CoroutineExceptionHandler { context, throwable ->
                        this@Server.exceptionHandler.accept(context, throwable)
                    }

                container = this@Server.container.build()
            }
    }
}