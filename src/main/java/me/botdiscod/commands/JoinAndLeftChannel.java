package me.botdiscod.commands;

import net.dv8tion.jda.api.entities.channel.middleman.AudioChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class JoinAndLeftChannel extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split(" ");
        MessageChannelUnion textChannel = event.getChannel();
        AudioManager audioManager = event.getGuild().getAudioManager();

        if (event.getMessage().getContentRaw().startsWith("!join")) {
            audioManager.openAudioConnection((AudioChannel) textChannel);
        }
        if (event.getMessage().getContentRaw().startsWith("!leave")){
            audioManager.closeAudioConnection();
        }
    }
}
