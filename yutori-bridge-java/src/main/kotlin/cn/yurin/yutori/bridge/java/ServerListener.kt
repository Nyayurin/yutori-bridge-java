package cn.yurin.yutori.bridge.java

import cn.yurin.yutori.*
import java.util.function.Consumer

class JavaServerListenersContainerBuilder {
    val builder = ServerListenersContainerBuilder()

    fun onAny(listener: Consumer<JavaServerContext<SigningRequest>>) = builder.any { listener.accept(JavaServerContext.from(this)) }

    fun onChannelGet(listener: Consumer<JavaServerContext<ChannelGetRequest>>) =
        builder.channel.get { listener.accept(JavaServerContext.from(this)) }

    fun onChannelList(listener: Consumer<JavaServerContext<ChannelListRequest>>) =
        builder.channel.list { listener.accept(JavaServerContext.from(this)) }

    fun onChannelCreate(listener: Consumer<JavaServerContext<ChannelCreateRequest>>) =
        builder.channel.create { listener.accept(JavaServerContext.from(this)) }

    fun onChannelUpdate(listener: Consumer<JavaServerContext<ChannelUpdateRequest>>) =
        builder.channel.update { listener.accept(JavaServerContext.from(this)) }

    fun onChannelDelete(listener: Consumer<JavaServerContext<ChannelDeleteRequest>>) =
        builder.channel.delete { listener.accept(JavaServerContext.from(this)) }

    fun onChannelMute(listener: Consumer<JavaServerContext<ChannelMuteRequest>>) =
        builder.channel.mute { listener.accept(JavaServerContext.from(this)) }

    fun onGuildGet(listener: Consumer<JavaServerContext<GuildGetRequest>>) =
        builder.guild.get { listener.accept(JavaServerContext.from(this)) }

    fun onGuildList(listener: Consumer<JavaServerContext<GuildListRequest>>) =
        builder.guild.list { listener.accept(JavaServerContext.from(this)) }

    fun onGuildApprove(listener: Consumer<JavaServerContext<GuildApproveRequest>>) =
        builder.guild.approve { listener.accept(JavaServerContext.from(this)) }

    fun onGuildMemberGet(listener: Consumer<JavaServerContext<GuildMemberGetRequest>>) =
        builder.guild.member.get { listener.accept(JavaServerContext.from(this)) }

    fun onGuildMemberList(listener: Consumer<JavaServerContext<GuildMemberListRequest>>) =
        builder.guild.member.list { listener.accept(JavaServerContext.from(this)) }

    fun onGuildMemberKick(listener: Consumer<JavaServerContext<GuildMemberKickRequest>>) =
        builder.guild.member.kick { listener.accept(JavaServerContext.from(this)) }

    fun onGuildMemberMute(listener: Consumer<JavaServerContext<GuildMemberMuteRequest>>) =
        builder.guild.member.mute { listener.accept(JavaServerContext.from(this)) }

    fun onGuildMemberApprove(listener: Consumer<JavaServerContext<GuildMemberApproveRequest>>) =
        builder.guild.member.approve { listener.accept(JavaServerContext.from(this)) }

    fun onGuildMemberRoleSet(listener: Consumer<JavaServerContext<GuildMemberRoleSetRequest>>) =
        builder.guild.member.role
            .set { listener.accept(JavaServerContext.from(this)) }

    fun onGuildMemberRoleUnset(listener: Consumer<JavaServerContext<GuildMemberRoleUnsetRequest>>) =
        builder.guild.member.role
            .unset { listener.accept(JavaServerContext.from(this)) }

    fun onGuildRoleList(listener: Consumer<JavaServerContext<GuildRoleListRequest>>) =
        builder.guild.role.list { listener.accept(JavaServerContext.from(this)) }

    fun onGuildRoleCreate(listener: Consumer<JavaServerContext<GuildRoleCreateRequest>>) =
        builder.guild.role.create { listener.accept(JavaServerContext.from(this)) }

    fun onGuildRoleUpdate(listener: Consumer<JavaServerContext<GuildRoleUpdateRequest>>) =
        builder.guild.role.update { listener.accept(JavaServerContext.from(this)) }

    fun onGuildRoleDelete(listener: Consumer<JavaServerContext<GuildRoleDeleteRequest>>) =
        builder.guild.role.delete { listener.accept(JavaServerContext.from(this)) }

    fun onLoginGet(listener: Consumer<JavaServerContext<LoginGetRequest>>) =
        builder.login.get { listener.accept(JavaServerContext.from(this)) }

    fun onMessageCreate(listener: Consumer<JavaServerContext<MessageCreateRequest>>) =
        builder.message.create { listener.accept(JavaServerContext.from(this)) }

    fun onMessageGet(listener: Consumer<JavaServerContext<MessageGetRequest>>) =
        builder.message.get { listener.accept(JavaServerContext.from(this)) }

    fun onMessageDelete(listener: Consumer<JavaServerContext<MessageDeleteRequest>>) =
        builder.message.delete { listener.accept(JavaServerContext.from(this)) }

    fun onMessageUpdate(listener: Consumer<JavaServerContext<MessageUpdateRequest>>) =
        builder.message.update { listener.accept(JavaServerContext.from(this)) }

    fun onMessageList(listener: Consumer<JavaServerContext<MessageListRequest>>) =
        builder.message.list { listener.accept(JavaServerContext.from(this)) }

    fun onReactionCreate(listener: Consumer<JavaServerContext<ReactionCreateRequest>>) =
        builder.reaction.create { listener.accept(JavaServerContext.from(this)) }

    fun onReactionDelete(listener: Consumer<JavaServerContext<ReactionDeleteRequest>>) =
        builder.reaction.delete { listener.accept(JavaServerContext.from(this)) }

    fun onReactionClear(listener: Consumer<JavaServerContext<ReactionClearRequest>>) =
        builder.reaction.clear { listener.accept(JavaServerContext.from(this)) }

    fun onReactionList(listener: Consumer<JavaServerContext<ReactionListRequest>>) =
        builder.reaction.list { listener.accept(JavaServerContext.from(this)) }

    fun onUserGet(listener: Consumer<JavaServerContext<UserGetRequest>>) =
        builder.user.get { listener.accept(JavaServerContext.from(this)) }

    fun onUserChannelCreate(listener: Consumer<JavaServerContext<UserChannelCreateRequest>>) =
        builder.user.channel.create { listener.accept(JavaServerContext.from(this)) }

    fun onFriendList(listener: Consumer<JavaServerContext<FriendListRequest>>) =
        builder.friend.list { listener.accept(JavaServerContext.from(this)) }

    fun onFriendApprove(listener: Consumer<JavaServerContext<FriendApproveRequest>>) =
        builder.friend.approve { listener.accept(JavaServerContext.from(this)) }

    fun build() = builder
}