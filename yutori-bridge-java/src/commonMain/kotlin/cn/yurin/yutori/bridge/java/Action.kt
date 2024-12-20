@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package cn.yurin.yutori.bridge.java

import cn.yurin.yutori.*
import cn.yurin.yutori.message.element.MessageElement
import kotlinx.coroutines.runBlocking

class JavaActionRoot(
    val actions: ActionRoot,
) {
    fun channelGet(
        channelId: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.channel.get(channelId, *contents)
    }

    @JvmOverloads
    fun channelList(
        guildId: String,
        next: String? = null,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.channel.list(guildId, next, *contents)
    }

    fun channelCreate(
        guildId: String,
        data: Channel,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.channel.create(guildId, data, *contents)
    }

    fun channelUpdate(
        channelId: String,
        data: Channel,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.channel.update(channelId, data, *contents)
    }

    fun channelDelete(
        channelId: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.channel.delete(channelId, *contents)
    }

    fun channelMute(
        channelId: String,
        duration: Number,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.channel.mute(channelId, duration, *contents)
    }

    fun guildGet(
        guildId: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.get(guildId, *contents)
    }

    @JvmOverloads
    fun guildList(
        next: String? = null,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.list(next, *contents)
    }

    fun guildApprove(
        messageId: String,
        approve: Boolean,
        comment: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.approve(messageId, approve, comment, *contents)
    }

    fun guildMemberGet(
        guildId: String,
        userId: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.member.get(guildId, userId, *contents)
    }

    @JvmOverloads
    fun guildMemberList(
        guildId: String,
        next: String? = null,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.member.list(guildId, next, *contents)
    }

    @JvmOverloads
    fun guildMemberKick(
        guildId: String,
        userId: String,
        permanent: Boolean? = null,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.member.kick(guildId, userId, permanent, *contents)
    }

    fun guildMemberMute(
        guildId: String,
        userId: String,
        duration: Number,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.member.mute(guildId, userId, duration, *contents)
    }

    fun guildMemberApprove(
        messageId: String,
        approve: Boolean,
        comment: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.member.approve(messageId, approve, comment, *contents)
    }

    fun guildMemberRoleSet(
        guildId: String,
        userId: String,
        roleId: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.member.role.set(guildId, userId, roleId, *contents)
    }

    fun guildMemberRoleUnset(
        guildId: String,
        userId: String,
        roleId: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.member.role.unset(guildId, userId, roleId, *contents)
    }

    @JvmOverloads
    fun guildRoleList(
        guildId: String,
        next: String? = null,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.role.list(guildId, next, *contents)
    }

    fun guildRoleCreate(
        guildId: String,
        role: GuildRole,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.role.create(guildId, role, *contents)
    }

    fun guildRoleUpdate(
        guildId: String,
        roleId: String,
        role: GuildRole,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.role.update(guildId, roleId, role, *contents)
    }

    fun guildRoleDelete(
        guildId: String,
        roleId: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.guild.role.delete(guildId, roleId, *contents)
    }

    fun loginGet(
        vararg contents: Pair<String, Any>
    ) = runBlocking {
        actions.login.get(*contents)
    }

    fun messageCreate(
        channelId: String,
        content: List<MessageElement>,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.message.create(channelId, content, *contents)
    }

    fun messageGet(
        channelId: String,
        messageId: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.message.get(channelId, messageId, *contents)
    }

    fun messageDelete(
        channelId: String,
        messageId: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.message.delete(channelId, messageId, *contents)
    }

    fun messageUpdate(
        channelId: String,
        messageId: String,
        content: List<MessageElement>,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.message.update(channelId, messageId, content, *contents)
    }

    @JvmOverloads
    fun messageList(
        channelId: String,
        next: String? = null,
        direction: BidiPagingList.Direction? = null,
        limit: Number? = null,
        order: BidiPagingList.Order? = null,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.message.list(channelId, next, direction, limit, order, *contents)
    }

    fun reactionCreate(
        channelId: String,
        messageId: String,
        emoji: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.reaction.create(channelId, messageId, emoji, *contents)
    }

    @JvmOverloads
    fun reactionDelete(
        channelId: String,
        messageId: String,
        emoji: String,
        userId: String? = null,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.reaction.delete(channelId, messageId, emoji, userId, *contents)
    }

    @JvmOverloads
    fun reactionClear(
        channelId: String,
        messageId: String,
        emoji: String? = null,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.reaction.clear(channelId, messageId, emoji, *contents)
    }

    @JvmOverloads
    fun reactionList(
        channelId: String,
        messageId: String,
        emoji: String,
        next: String? = null,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.reaction.list(channelId, messageId, emoji, next, *contents)
    }

    fun userGet(
        userId: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.user.get(userId, *contents)
    }

    @JvmOverloads
    fun userChannelCreate(
        userId: String,
        guildId: String? = null,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.user.channel.create(userId, guildId, *contents)
    }

    @JvmOverloads
    fun friendList(
        next: String? = null,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.friend.list(next, *contents)
    }

    @JvmOverloads
    fun friendApprove(
        messageId: String,
        approve: Boolean,
        comment: String? = null,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.friend.approve(messageId, approve, comment, *contents)
    }

    fun uploadCreate(
        vararg contents: FormData
    ) = runBlocking {
        actions.upload.create(*contents)
    }

    fun adminLoginList(
        vararg contents: Pair<String, Any>
    ) = runBlocking {
        actions.admin.login.list(*contents)
    }

    @JvmOverloads
    fun adminWebhookCreate(
        url: String,
        token: String? = null,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.admin.webhook.create(url, token, *contents)
    }

    fun adminWebhookDelete(
        url: String,
        vararg contents: Pair<String, Any>,
    ) = runBlocking {
        actions.admin.webhook.delete(url, *contents)
    }
}