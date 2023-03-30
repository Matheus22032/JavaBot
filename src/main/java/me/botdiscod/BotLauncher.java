package me.botdiscod;

import me.botdiscod.commands.ChangeNickname;
import me.botdiscod.commands.JoinAndLeftChannel;
import me.botdiscod.commands.Ping;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;

public class BotLauncher {
    public static JDA bot;

    public static void main(String[] args) throws LoginException, InterruptedException {



        bot = JDABuilder.create(System.getenv("BOT_TOKEN"),
                        EnumSet.allOf(GatewayIntent.class))
                .setActivity(Activity.playing("?????"))
                .build();

        bot.awaitReady();
        bot.addEventListener(new Ping());
        bot.addEventListener(new JoinAndLeftChannel());
        bot.addEventListener(new ChangeNickname());
    }
}
