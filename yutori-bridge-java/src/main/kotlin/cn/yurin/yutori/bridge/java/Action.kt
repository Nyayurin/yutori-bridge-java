@file:Suppress("MemberVisibilityCanBePrivate")

package cn.yurin.yutori.bridge.java

import cn.yurin.yutori.*
import cn.yurin.yutori.message.element.MessageElement
import kotlinx.coroutines.runBlocking

class JavaActionRootBridge(
    val actions: ActionRoot,
) {
    private val methods = AdapterActionService::class.java.methods

    fun channelGet(
        channelId: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "channelGet" }
            ?.invoke(actions.service, actions.platform, actions.userId, channelId, contents)
    }

    fun channelList(
        guildId: String,
        next: String?,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "channelList" }
            ?.invoke(actions.service, actions.platform, actions.userId, guildId, next, contents)
    }

    fun channelCreate(
        guildId: String,
        data: Channel,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "channelCreate" }
            ?.invoke(actions.service, actions.platform, actions.userId, guildId, data, contents)
    }

    fun channelUpdate(
        channelId: String,
        data: Channel,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "channelUpdate" }
            ?.invoke(actions.service, actions.platform, actions.userId, channelId, data, contents)
    }

    fun channelDelete(
        channelId: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "channelDelete" }
            ?.invoke(actions.service, actions.platform, actions.userId, channelId, contents)
    }

    fun channelMute(
        channelId: String,
        duration: Number,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "channelMute" }
            ?.invoke(actions.service, actions.platform, actions.userId, channelId, duration, contents)
    }

    fun guildGet(
        guildId: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildGet" }
            ?.invoke(actions.service, actions.platform, actions.userId, guildId, contents)
    }

    fun guildList(
        next: String?,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildList" }
            ?.invoke(actions.service, actions.platform, actions.userId, next, contents)
    }

    fun guildApprove(
        messageId: String,
        approve: Boolean,
        comment: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildApprove" }
            ?.invoke(actions.service, actions.platform, actions.userId, messageId, approve, comment, contents)
    }

    fun guildMemberGet(
        guildId: String,
        userId: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildMemberGet" }
            ?.invoke(actions.service, actions.platform, actions.userId, guildId, userId, contents)
    }

    fun guildMemberList(
        guildId: String,
        next: String?,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildMemberList" }
            ?.invoke(actions.service, actions.platform, actions.userId, guildId, next, contents)
    }

    fun guildMemberKick(
        guildId: String,
        userId: String,
        permanent: Boolean?,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildMemberKick" }
            ?.invoke(actions.service, actions.platform, actions.userId, guildId, userId, permanent, contents)
    }

    fun guildMemberMute(
        guildId: String,
        userId: String,
        duration: Number,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildMemberMute" }
            ?.invoke(actions.service, actions.platform, actions.userId, guildId, userId, duration, contents)
    }

    fun guildMemberApprove(
        messageId: String,
        approve: Boolean,
        comment: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildMemberApprove" }
            ?.invoke(actions.service, actions.platform, actions.userId, messageId, approve, comment, contents)
    }

    fun guildMemberRoleSet(
        guildId: String,
        userId: String,
        roleId: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildMemberRoleSet" }
            ?.invoke(actions.service, actions.platform, actions.userId, guildId, userId, roleId, contents)
    }

    fun guildMemberRoleUnset(
        guildId: String,
        userId: String,
        roleId: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildMemberRoleUnset" }
            ?.invoke(actions.service, actions.platform, actions.userId, guildId, userId, roleId, contents)
    }

    fun guildRoleList(
        guildId: String,
        next: String?,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildRoleList" }
            ?.invoke(actions.service, actions.platform, actions.userId, guildId, next, contents)
    }

    fun guildRoleCreate(
        guildId: String,
        role: GuildRole,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildRoleCreate" }
            ?.invoke(actions.service, actions.platform, actions.userId, guildId, role, contents)
    }

    fun guildRoleUpdate(
        guildId: String,
        roleId: String,
        role: GuildRole,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildRoleUpdate" }
            ?.invoke(actions.service, actions.platform, actions.userId, guildId, roleId, role, contents)
    }

    fun guildRoleDelete(
        guildId: String,
        roleId: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "guildRoleDelete" }
            ?.invoke(actions.service, actions.platform, actions.userId, guildId, roleId, contents)
    }

    fun loginGet(
        contents: Array<Pair<String, Any>>
    ) = runBlocking {
        methods.find { it.name == "loginGet" }
            ?.invoke(actions.service, actions.platform, actions.userId, contents)
    }

    fun messageCreate(
        channelId: String,
        content: List<MessageElement>,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "messageCreate" }
            ?.invoke(actions.service, actions.platform, actions.userId, channelId, content, contents)
    }

    fun messageGet(
        channelId: String,
        messageId: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "messageGet" }
            ?.invoke(actions.service, actions.platform, actions.userId, channelId, messageId, contents)
    }

    fun messageDelete(
        channelId: String,
        messageId: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "messageDelete" }
            ?.invoke(actions.service, actions.platform, actions.userId, channelId, messageId, contents)
    }

    fun messageUpdate(
        channelId: String,
        messageId: String,
        content: List<MessageElement>,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "messageDelete" }
            ?.invoke(actions.service, actions.platform, actions.userId, channelId, messageId, content, contents)
    }

    fun messageList(
        channelId: String,
        next: String?,
        direction: BidiPagingList.Direction?,
        limit: Number?,
        order: BidiPagingList.Order?,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "messageList" }
            ?.invoke(actions.service, actions.platform, actions.userId, channelId, next, direction, limit, order, contents)
    }

    fun reactionCreate(
        channelId: String,
        messageId: String,
        emoji: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "reactionCreate" }
            ?.invoke(actions.service, actions.platform, actions.userId, channelId, messageId, emoji, contents)
    }

    fun reactionDelete(
        channelId: String,
        messageId: String,
        emoji: String,
        userId: String?,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "reactionDelete" }
            ?.invoke(actions.service, actions.platform, actions.userId, channelId, messageId, emoji, userId, contents)
    }

    fun reactionClear(
        channelId: String,
        messageId: String,
        emoji: String?,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "reactionClear" }
            ?.invoke(actions.service, actions.platform, actions.userId, channelId, messageId, emoji, contents)
    }

    fun reactionList(
        channelId: String,
        messageId: String,
        emoji: String,
        next: String?,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "reactionList" }
            ?.invoke(actions.service, actions.platform, actions.userId, channelId, messageId, emoji, next, contents)
    }

    fun userGet(
        userId: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "userGet" }
            ?.invoke(actions.service, actions.platform, actions.userId, userId, contents)
    }

    fun userChannelCreate(
        userId: String,
        guildId: String?,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "userChannelCreate" }
            ?.invoke(actions.service, actions.platform, actions.userId, userId, guildId, contents)
    }

    fun friendList(
        next: String?,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "friendList" }
            ?.invoke(actions.service, actions.platform, actions.userId, next, contents)
    }

    fun friendApprove(
        messageId: String,
        approve: Boolean,
        comment: String?,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "friendApprove" }
            ?.invoke(actions.service, actions.platform, actions.userId, messageId, approve, comment, contents)
    }

    fun uploadCreate(
        contents: Array<FormData>
    ) = runBlocking {
        methods.find { it.name == "uploadCreate" }
            ?.invoke(actions.service, actions.platform, actions.userId, contents)
    }

    fun adminLoginList(
        contents: Array<Pair<String, Any>>
    ) = runBlocking {
        methods.find { it.name == "adminLoginList" }
            ?.invoke(actions.service, contents)
    }

    fun adminWebhookCreate(
        url: String,
        token: String?,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "adminWebhookCreate" }
            ?.invoke(actions.service, url, token, contents)
    }

    fun adminWebhookDelete(
        url: String,
        contents: Array<Pair<String, Any>>,
    ) = runBlocking {
        methods.find { it.name == "adminWebhookDelete" }
            ?.invoke(actions.service, url, contents)
    }
}