<div align="center">

# Yutori-Bridge-Java

Yutori 的 Java 桥接模块

| Module             | Platforms          |
|--------------------|--------------------|
| yutori-bridge-java | JVM(8), Android(8) |

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
// 如果你是 KMP 项目, 请使用这个
implementation(libs.yutori.bridge.java.multiplatform)
// 如果你不知道什么是 KMP, 请使用下面的
implementation(libs.yutori.bridge.java.jvm)
implementation(libs.yutori.bridge.java.android.debug)
implementation(libs.yutori.bridge.java.android.release)
```

```toml
[versions]
yutori-bridge-java = "version"

[libraries]
yutori-bridge-java-multiplatform = { module = "cn.yurin.yutori.bridge:yutori-bridge", version.ref = "yutori-bridge-java" }
yutori-bridge-java-jvm = { module = "cn.yurin.yutori.bridge:yutori-bridge-java", version.ref = "yutori-bridge-java" }
yutori-bridge-java-android-debug = { module = "cn.yurin.yutori.bridge:yutori-bridge-android-debug", version.ref = "yutori-bridge-java" }
yutori-bridge-java-android-release = { module = "cn.yurin.yutori.bridge:yutori-bridge-android-release", version.ref = "yutori-bridge-java" }
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

## 其他语言

### Scala

添加仓库

```sbt
credentials += Credentials("GitHub Package Registry", "maven.pkg.github.com", sys.env("GITHUB_ACTOR"), sys.env("GITHUB_TOKEN"))

resolvers += "GitHub Package Registry" at "https://maven.pkg.github.com/Nyayurin/yutori-bridge-java"
```

引入依赖

```sbt
libraryDependencies += "cn.yurin.yutori.bridge" % "yutori-bridge-java-jvm" % "version"
```

使用

```scala 3
@main
def main(): Unit =
  JavaYutori.builder()
    .adapter(adapter => adapter.listening(builder =>
      builder.onMessageUpdated(context =>
        if UtilKt.textContent(context.getEvent.getMessage.getContent) == "test" then
          context.getActions.messageCreate(
            context.getEvent.getChannel.getId,
            java.util.List.of(Text("test dont!"))
          )
      )
    ))
    .server(server => server.routing(builder =>
      builder.onMessageCreate(context =>
        context.getResponse.respond("")
      )
    ))
    .build()
    .start()
```

### C#

添加 IKVM

```xml
<ItemGroup>
    <PackageReference Include="IKVM.Maven.Sdk" Version="1.8.2"/>
</ItemGroup>
```

添加仓库(~/.m2/settings.xml)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.2.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.2.0 https://maven.apache.org/xsd/settings-1.2.0.xsd">
    <servers>
        <server>
            <id>yutori-bridge-java</id>
            <username>actor</username>
            <password>token</password>
        </server>
    </servers>
    <profiles>
        <profile>
            <id>yutori-bridge-java</id>
            <repositories>
                <repository>
                    <id>yutori-bridge-java</id>
                    <url>https://maven.pkg.github.com/Nyayurin/yutori-bridge-java</url>
                </repository>
            </repositories>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>yutori-bridge-java</activeProfile>
    </activeProfiles>
</settings>
```

请注意修改 servers 内的 username 和 password

引入依赖

```xml
<MavenReference
        Include="cn.yurin.yutori.bridge:yutori-bridge-java-jvm"
        version="version"/>
```

使用

```csharp
JavaYutori
    .builder()
    .adapter(new ConsumerBridge<JavaYutoriBuilder.Adapter>(adapter => {
        adapter.listening(new ConsumerBridge<JavaAdapterListenersContainerBuilder>(builder => {
            builder.onMessageCreated(new ConsumerBridge<JavaAdapterContext>(context => {
                if (UtilKt.textContent(context.getEvent().getMessage().getContent()) == "test") {
                    context.getActions().messageCreate(
                        channelId: context.getEvent().getChannel().getId(),
                        content: List.of(new Text("test done!"))
                    );
                }
            }));
        }));
    }))
    .server(new ConsumerBridge<JavaYutoriBuilder.Server>(server => {
        server.routing(new ConsumerBridge<JavaServerListenersContainerBuilder>(builder => {
            builder.onMessageCreate(new ConsumerBridge<JavaServerContext>(context => {
                context.getResponse().respond("");
            }));
        }));
    }))
    .build()
    .start();

internal class ConsumerBridge<T>(Action<T> action) : Consumer {
    public void accept(object t) {
        action((T)t);
    }

    public Consumer andThen(Consumer after) {
        throw new NotImplementedException();
    }
}
```