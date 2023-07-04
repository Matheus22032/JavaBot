package me.botdiscod.commands;

import me.botdiscod.app.BotLauncher;
import me.botdiscod.database.CRUD;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class ChangePrefix  extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split(" ");
        MessageChannelUnion textChannel =  event.getChannel();

        if (args[0].equalsIgnoreCase(BotLauncher.prefixMap.get(event.getGuild().getId()) + "setprefix")) {
            if (args[1] == null){
                textChannel.sendMessage("Prefixo inválido").queue();
            }else {
                CRUD.update(event.getGuild().getId(),args[1].charAt(0));
                BotLauncher.prefixMap.replace(event.getGuild().getId(),args[1].charAt(0));
                textChannel.sendMessage("O prefixo agora é: " + BotLauncher.prefixMap.get(event.getGuild().getId())).queue();
            }


        }
    }
}
