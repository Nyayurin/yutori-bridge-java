<div align="center">

# Yutori-Bridge-Java

Yutori 的 Java 桥接模块

</div>

## 如何使用

添加仓库

build.gradle.kts

```kotlin
maven {
    url = uri("https://maven.pkg.github.com/Nyayurin/yutori-bridge-java")
    credentials {
        username = project.findProperty("gpr.actor") as String? ?: System.getenv("GITHUB_ACTOR")
        password = project.findProperty("gpr.token") as String? ?: System.getenv("GITHUB_TOKEN")
    } 
}
```

settings.gradle.kts

```kotlin
maven {
    url = uri("https://maven.pkg.github.com/Nyayurin/yutori-bridge-java")
    credentials {
        username = providers.gradleProperty("gpr.actor").orNull ?: System.getenv("GITHUB_ACTOR")
        password = providers.gradleProperty("gpr.token").orNull ?: System.getenv("GITHUB_TOKEN")
    }
}
```

引入依赖

```kotlin
implementation(libs.yutori.bridge.java)
```

```toml
[versions]
yutori-bridge-java = "version"

[libraries]
yutori-bridge-java = { module = "cn.yurin.yutori.bridge:yutori-bridge-java", version.ref = "yutori-bridge-java" }
```

请从 [Github Packages](https://github.com/Nyayurin?tab=packages&repo_name=yutori-bridge-java) 获取版本<br>
对于稳定版, 它的版本号应该和 Release 中的 tag 一致<br>
对于开发板, 它的版本号应该和 Commit 的完整 SHA 值一致<br>
要获取一个 Commit 的完整 SHA 值, 请在 Commits 页面对应 Commit 处点击 Commit ID 右侧的复制按钮(Copy full SHA for *******)

使用

```java
public class Main {
    public static void main(String[] args) {
        JavaYutori
                .builder()
                .install(
                        new XxxAdapter(),
                        XxxAdapter.class
                )
                .adapter(adapter -> adapter.listening(builder ->
                        builder.onMessageCreated(context -> {
                            if ("test".equals(UtilKt.textContent(context.getEvent().getMessage().getContent()))) {
                                context.getActions().messageCreate(
                                        context.getEvent().getChannel().getId(),
                                        List.of(new Text("test done!"))
                                );
                            }
                        })
                ))
                .server(server -> server.routing(builder ->
                        builder.onMessageCreate(context -> {
                            context.getResponse().respond("");
                        })
                ))
                .build()
                .start();
    }
}
```