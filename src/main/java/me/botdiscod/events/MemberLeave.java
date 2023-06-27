package me.botdiscod.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class MemberLeave  extends ListenerAdapter {

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        List<TextChannel> textChannel = event.getGuild().getTextChannelsByName("comandos", true);
        String userName = event.getUser().getName();
        textChannel.forEach(textChannel1 -> textChannel1.sendMessage(userName + " saiu do servidor!").queue());
    }
}
