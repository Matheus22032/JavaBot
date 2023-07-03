package me.botdiscod.app;

import me.botdiscod.database.CRUD;
import me.botdiscod.events.ChangeNickname;
import me.botdiscod.commands.JoinAndLeftChannel;
import me.botdiscod.commands.Ping;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class BotLauncher {
    public static JDA bot;
    public static final String BOT_TOKEN = System.getenv("BOT_TOKEN");
    public static Map<String, Character> prefixMap = new HashMap<>();
    public static void main(String[] args) throws InterruptedException {

        bot = JDABuilder.create(BOT_TOKEN,
                        EnumSet.allOf(GatewayIntent.class))
                .setActivity(Activity.playing("?????"))
                .build();

        bot.awaitReady();
        bot.addEventListener(new Ping());
        bot.addEventListener(new JoinAndLeftChannel());
        bot.addEventListener(new ChangeNickname());

        CRUD.createTable();
        for (Guild guild:
             bot.getGuilds()) {
            CRUD.insert(guild.getId(),'!');
            CRUD.select(guild.getId());
        }
    }
}
