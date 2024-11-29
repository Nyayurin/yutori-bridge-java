package cn.yurin.yutori.bridge.java;

import cn.yurin.yutori.*;
import cn.yurin.yutori.message.element.MessageElement;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;

import java.util.List;
import java.util.Map;

@SuppressWarnings({"unused", "unchecked"})
public class JavaActionRoot {
    private final JavaActionRootBridge bridge;

    public JavaActionRoot(JavaActionRootBridge bridge) {
        this.bridge = bridge;
    }

    public Result<Channel> channelGet(
            String channelId,
            Pair<String, Object>... contents
    ) {
        return (Result<Channel>) bridge.channelGet(channelId, contents);
    }

    public Result<PagingList<Channel>> channelList(
            String guildId,
            Pair<String, Object>... contents
    ) {
        return (Result<PagingList<Channel>>) bridge.channelList(guildId, null, contents);
    }

    public Result<PagingList<Channel>> channelList(
            String guildId,
            String next,
            Pair<String, Object>... contents
    ) {
        return (Result<PagingList<Channel>>) bridge.channelList(guildId, next, contents);
    }

    public Result<Channel> channelCreate(
            String guildId,
            Channel data,
            Pair<String, Object>... contents
    ) {
        return (Result<Channel>) bridge.channelCreate(guildId, data, contents);
    }

    public Result<Unit> channelUpdate(
            String channelId,
            Channel data,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.channelUpdate(channelId, data, contents);
    }

    public Result<Unit> channelDelete(
            String channelId,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.channelDelete(channelId, contents);
    }

    public Result<Unit> channelMute(
            String channelId,
            Number duration,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.channelMute(channelId, duration, contents);
    }

    public Result<Guild> guildGet(
            String guildId,
            Pair<String, Object>... contents
    ) {
        return (Result<Guild>) bridge.guildGet(guildId, contents);
    }

    public Result<PagingList<Guild>> guildList(Pair<String, Object>... contents) {
        return (Result<PagingList<Guild>>) bridge.guildList(null, contents);
    }

    public Result<PagingList<Guild>> guildList(
            String next,
            Pair<String, Object>... contents
    ) {
        return (Result<PagingList<Guild>>) bridge.guildList(next, contents);
    }

    public Result<Unit> guildApprove(
            String messageId,
            Boolean approve,
            String comment,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.guildApprove(messageId, approve, comment, contents);
    }

    public Result<GuildMember> guildMemberGet(
            String guildId,
            String userId,
            Pair<String, Object>... contents
    ) {
        return (Result<GuildMember>) bridge.guildMemberGet(guildId, userId, contents);
    }

    public Result<PagingList<GuildMember>> guildMemberList(
            String guildId,
            Pair<String, Object>... contents
    ) {
        return (Result<PagingList<GuildMember>>) bridge.guildMemberList(guildId, null, contents);
    }

    public Result<PagingList<GuildMember>> guildMemberList(
            String guildId,
            String next,
            Pair<String, Object>... contents
    ) {
        return (Result<PagingList<GuildMember>>) bridge.guildMemberList(guildId, next, contents);
    }

    public Result<Unit> guildMemberKick(
            String guildId,
            String userId,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.guildMemberKick(guildId, userId, null, contents);
    }

    public Result<Unit> guildMemberKick(
            String guildId,
            String userId,
            Boolean permanent,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.guildMemberKick(guildId, userId, permanent, contents);
    }

    public Result<Unit> guildMemberMute(
            String guildId,
            String userId,
            Number duration,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.guildMemberMute(guildId, userId, duration, contents);
    }

    public Result<Unit> guildMemberApprove(
            String messageId,
            Boolean approve,
            String comment,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.guildMemberApprove(messageId, approve, comment, contents);
    }

    public Result<Unit> guildMemberRoleSet(
            String guildId,
            String userId,
            String roleId,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.guildMemberRoleSet(guildId, userId, roleId, contents);
    }

    public Result<Unit> guildMemberRoleUnset(
            String guildId,
            String userId,
            String roleId,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.guildMemberRoleUnset(guildId, userId, roleId, contents);
    }

    public Result<PagingList<GuildRole>> guildRoleList(
            String guildId,
            Pair<String, Object>... contents
    ) {
        return (Result<PagingList<GuildRole>>) bridge.guildRoleList(guildId, null, contents);
    }

    public Result<PagingList<GuildRole>> guildRoleList(
            String guildId,
            String next,
            Pair<String, Object>... contents
    ) {
        return (Result<PagingList<GuildRole>>) bridge.guildRoleList(guildId, next, contents);
    }

    public Result<GuildRole> guildRoleCreate(
            String guildId,
            GuildRole role,
            Pair<String, Object>... contents
    ) {
        return (Result<GuildRole>) bridge.guildRoleCreate(guildId, role, contents);
    }

    public Result<Unit> guildRoleUpdate(
            String guildId,
            String roleId,
            GuildRole role,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.guildRoleUpdate(guildId, roleId, role, contents);
    }

    public Result<Unit> guildRoleDelete(
            String guildId,
            String roleId,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.guildRoleDelete(guildId, roleId, contents);
    }

    public Result<Login> loginGet(Pair<String, Object>... contents) {
        return (Result<Login>) bridge.loginGet(contents);
    }

    public Result<List<Message>> messageCreate(
            String channelId,
            List<MessageElement> content,
            Pair<String, Object>... contents
    ) {
        return (Result<List<Message>>) bridge.messageCreate(channelId, content, contents);
    }

    public Result<Message> messageGet(
            String channelId,
            String messageId,
            Pair<String, Object>... contents
    ) {
        return (Result<Message>) bridge.messageGet(channelId, messageId, contents);
    }

    public Result<Unit> messageDelete(
            String channelId,
            String messageId,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.messageDelete(channelId, messageId, contents);
    }

    public Result<Unit> messageUpdate(
            String channelId,
            String messageId,
            List<MessageElement> content,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.messageUpdate(channelId, messageId, content, contents);
    }

    public Result<BidiPagingList<Message>> messageList(
            String channelId,
            Pair<String, Object>... contents
    ) {
        return (Result<BidiPagingList<Message>>) bridge.messageList(channelId, null, null, null, null, contents);
    }

    public Result<BidiPagingList<Message>> messageList(
            String channelId,
            String next,
            Pair<String, Object>... contents
    ) {
        return (Result<BidiPagingList<Message>>) bridge.messageList(channelId, next, null, null, null, contents);
    }

    public Result<BidiPagingList<Message>> messageList(
            String channelId,
            String next,
            BidiPagingList.Direction direction,
            Pair<String, Object>... contents
    ) {
        return (Result<BidiPagingList<Message>>) bridge.messageList(channelId, next, direction, null, null, contents);
    }

    public Result<BidiPagingList<Message>> messageList(
            String channelId,
            String next,
            BidiPagingList.Direction direction,
            Number limit,
            Pair<String, Object>... contents
    ) {
        return (Result<BidiPagingList<Message>>) bridge.messageList(channelId, next, direction, limit, null, contents);
    }

    public Result<BidiPagingList<Message>> messageList(
            String channelId,
            String next,
            BidiPagingList.Direction direction,
            Number limit,
            BidiPagingList.Order order,
            Pair<String, Object>... contents
    ) {
        return (Result<BidiPagingList<Message>>) bridge.messageList(channelId, next, direction, limit, order, contents);
    }

    public Result<Unit> reactionCreate(
            String channelId,
            String messageId,
            String emoji,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.reactionCreate(channelId, messageId, emoji, contents);
    }

    public Result<Unit> reactionDelete(
            String channelId,
            String messageId,
            String emoji,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.reactionDelete(channelId, messageId, emoji, null, contents);
    }

    public Result<Unit> reactionDelete(
            String channelId,
            String messageId,
            String emoji,
            String userId,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.reactionDelete(channelId, messageId, emoji, userId, contents);
    }

    public Result<Unit> reactionClear(
            String channelId,
            String messageId,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.reactionClear(channelId, messageId, null, contents);
    }

    public Result<Unit> reactionClear(
            String channelId,
            String messageId,
            String emoji,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.reactionClear(channelId, messageId, emoji, contents);
    }

    public Result<PagingList<User>> reactionList(
            String channelId,
            String messageId,
            String emoji,
            Pair<String, Object>... contents
    ) {
        return (Result<PagingList<User>>) bridge.reactionList(channelId, messageId, emoji, null, contents);
    }

    public Result<PagingList<User>> reactionList(
            String channelId,
            String messageId,
            String emoji,
            String next,
            Pair<String, Object>... contents
    ) {
        return (Result<PagingList<User>>) bridge.reactionList(channelId, messageId, emoji, next, contents);
    }

    public Result<User> userGet(
            String userId,
            Pair<String, Object>... contents
    ) {
        return (Result<User>) bridge.userGet(userId, contents);
    }

    public Result<Channel> userChannelCreate(
            String userId,
            Pair<String, Object>... contents
    ) {
        return (Result<Channel>) bridge.userChannelCreate(userId, null, contents);
    }

    public Result<Channel> userChannelCreate(
            String userId,
            String guildId,
            Pair<String, Object>... contents
    ) {
        return (Result<Channel>) bridge.userChannelCreate(userId, guildId, contents);
    }

    public Result<PagingList<User>> friendList(Pair<String, Object>... contents) {
        return (Result<PagingList<User>>) bridge.friendList(null, contents);
    }

    public Result<PagingList<User>> friendList(
            String next,
            Pair<String, Object>... contents
    ) {
        return (Result<PagingList<User>>) bridge.friendList(next, contents);
    }

    public Result<Unit> friendApprove(
            String messageId,
            Boolean approve,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.friendApprove(messageId, approve, null, contents);
    }

    public Result<Unit> friendApprove(
            String messageId,
            Boolean approve,
            String comment,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.friendApprove(messageId, approve, comment, contents);
    }

    public Result<Map<String, String>> uploadCreate(FormData... contents) {
        return (Result<Map<String, String>>) bridge.uploadCreate(contents);
    }

    public Result<List<Login>> adminLoginList(Pair<String, Object>... contents) {
        return (Result<List<Login>>) bridge.adminLoginList(contents);
    }

    public Result<Unit> adminWebhookCreate(
            String url,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.adminWebhookCreate(url, null, contents);
    }

    public Result<Unit> adminWebhookCreate(
            String url,
            String token,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.adminWebhookCreate(url, token, contents);
    }

    public Result<Unit> adminWebhookDelete(
            String url,
            Pair<String, Object>... contents
    ) {
        return (Result<Unit>) bridge.adminWebhookDelete(url, contents);
    }
}