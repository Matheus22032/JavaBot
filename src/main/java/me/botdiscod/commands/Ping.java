package me.botdiscod.commands;

import me.botdiscod.app.BotLauncher;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split(" ");
        MessageChannelUnion textChannel = event.getChannel();

        if (args[0].equalsIgnoreCase("!" + "ping")) {
            textChannel.sendMessage(BotLauncher.bot.getGatewayPing() + "ms").queue();
        }
    }
}
