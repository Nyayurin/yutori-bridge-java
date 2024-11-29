@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package cn.yurin.yutori.bridge.java

import cn.yurin.yutori.*
import kotlinx.coroutines.runBlocking

data class JavaAdapterContext(
    val actions: JavaActionRoot,
    val event: JavaEvent,
    val yutori: Yutori,
) {
    companion object {
        fun from(context: AdapterContext<*>) =
            JavaAdapterContext(
                actions = JavaActionRoot(JavaActionRootBridge(context.actions)),
                event = JavaEvent(context.event),
                yutori = context.yutori,
            )
    }
}

data class JavaServerContext<T : SigningRequest>(
    val request: Request<T>,
    val response: JavaResponse,
    val yutori: Yutori,
) {
    companion object {
        fun <T : SigningRequest> from(context: ServerContext<T>) =
            JavaServerContext(
                request = context.request,
                response = JavaResponse(context.response),
                yutori = context.yutori,
            )
    }
}

class JavaEvent(
    val event: Event<*>,
) {
    val id: Number by event.properties
    val type: String by event.properties
    val platform: String by event.properties
    val selfId: String by event.properties
    val timestamp: Number by event.properties
    val argv: Interaction.Argv? by event.properties
    val button: Interaction.Button? by event.properties
    val channel: Channel? by event.properties
    val guild: Guild? by event.properties
    val login: Login? by event.properties
    val member: GuildMember? by event.properties
    val message: Message? by event.properties
    val operator: User? by event.properties
    val role: GuildRole? by event.properties
    val user: User? by event.properties
}

class JavaResponse(
    val response: Response,
) {
    fun respond(content: String) = runBlocking { response.respond(content) }
}