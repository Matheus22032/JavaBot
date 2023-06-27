package me.botdiscod.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class MemberJoin extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        List<TextChannel> textChannel = event.getGuild().getTextChannelsByName("geral", true);
        String userName = event.getUser().getName();
        textChannel.forEach(textChannel1 -> textChannel1.sendMessage(userName + " entrou no servidor!").queue());
    }
}
