package me.botdiscod.events;

import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class ChangeNickname extends ListenerAdapter {
    @Override
    public void onGuildMemberUpdateNickname(GuildMemberUpdateNicknameEvent event) {

        List<TextChannel> textChannels = event.getGuild().getTextChannelsByName("geral", true);

        for (TextChannel ch :
                textChannels) {
            if (event.getNewNickname() == null) {
                ch.sendMessage(event.getOldNickname() + " agora é " + event.getMember().getEffectiveName()).queue();
            } else {
                if (event.getOldNickname() == null) {
                    ch.sendMessage(event.getMember().getEffectiveName() + " agora é " + event.getNewNickname()).queue();
                } else {
                    ch.sendMessage(event.getOldNickname() + " agora é " + event.getNewNickname()).queue();
                }
            }
            ch.sendMessage(event.getUser().getAsTag()).queue();
        }


    }

}
