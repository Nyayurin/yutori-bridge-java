@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package cn.yurin.yutori.bridge.java

import cn.yurin.yutori.*
import java.util.function.Consumer

class JavaAdapterListenersContainerBuilder {
    val builder = AdapterListenersContainerBuilder()

    fun onAny(listener: Consumer<JavaAdapterContext>) = builder.any { listener.accept(JavaAdapterContext.from(this)) }

    fun onGuildAdded(listener: Consumer<JavaAdapterContext>) = builder.guild.added { listener.accept(JavaAdapterContext.from(this)) }

    fun onGuildUpdated(listener: Consumer<JavaAdapterContext>) = builder.guild.updated { listener.accept(JavaAdapterContext.from(this)) }

    fun onGuildRemoved(listener: Consumer<JavaAdapterContext>) = builder.guild.removed { listener.accept(JavaAdapterContext.from(this)) }

    fun onGuildRequest(listener: Consumer<JavaAdapterContext>) = builder.guild.request { listener.accept(JavaAdapterContext.from(this)) }

    fun onGuildMemberAdded(listener: Consumer<JavaAdapterContext>) =
        builder.guild.member.added { listener.accept(JavaAdapterContext.from(this)) }

    fun onGuildMemberUpdated(listener: Consumer<JavaAdapterContext>) =
        builder.guild.member.updated { listener.accept(JavaAdapterContext.from(this)) }

    fun onGuildMemberRemoved(listener: Consumer<JavaAdapterContext>) =
        builder.guild.member.removed { listener.accept(JavaAdapterContext.from(this)) }

    fun onGuildMemberRequest(listener: Consumer<JavaAdapterContext>) =
        builder.guild.member.request { listener.accept(JavaAdapterContext.from(this)) }

    fun onGuildRoleCreated(listener: Consumer<JavaAdapterContext>) =
        builder.guild.role.created { listener.accept(JavaAdapterContext.from(this)) }

    fun onGuildRoleUpdated(listener: Consumer<JavaAdapterContext>) =
        builder.guild.role.updated { listener.accept(JavaAdapterContext.from(this)) }

    fun onGuildRoleDeleted(listener: Consumer<JavaAdapterContext>) =
        builder.guild.role.deleted { listener.accept(JavaAdapterContext.from(this)) }

    fun onInteractionButton(listener: Consumer<JavaAdapterContext>) =
        builder.interaction.button { listener.accept(JavaAdapterContext.from(this)) }

    fun onInteractionCommand(listener: Consumer<JavaAdapterContext>) =
        builder.interaction.command { listener.accept(JavaAdapterContext.from(this)) }

    fun onLoginAdded(listener: Consumer<JavaAdapterContext>) = builder.login.added { listener.accept(JavaAdapterContext.from(this)) }

    fun onLoginRemoved(listener: Consumer<JavaAdapterContext>) = builder.login.removed { listener.accept(JavaAdapterContext.from(this)) }

    fun onLoginUpdated(listener: Consumer<JavaAdapterContext>) = builder.login.updated { listener.accept(JavaAdapterContext.from(this)) }

    fun onMessageCreated(listener: Consumer<JavaAdapterContext>) =
        builder.message.created { listener.accept(JavaAdapterContext.from(this)) }

    fun onMessageUpdated(listener: Consumer<JavaAdapterContext>) =
        builder.message.updated { listener.accept(JavaAdapterContext.from(this)) }

    fun onMessageDeleted(listener: Consumer<JavaAdapterContext>) =
        builder.message.deleted { listener.accept(JavaAdapterContext.from(this)) }

    fun onReactionAdded(listener: Consumer<JavaAdapterContext>) = builder.reaction.added { listener.accept(JavaAdapterContext.from(this)) }

    fun onReactionRemoved(listener: Consumer<JavaAdapterContext>) =
        builder.reaction.removed { listener.accept(JavaAdapterContext.from(this)) }

    fun onFriendRequest(listener: Consumer<JavaAdapterContext>) = builder.friend.request { listener.accept(JavaAdapterContext.from(this)) }

    fun build() = builder
}