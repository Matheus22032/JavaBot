package me.botdiscod.database;

import me.botdiscod.app.BotLauncher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {
    public static void createTable() {
        String sql = """
                    CREATE TABLE IF NOT EXISTS tb_guild
                    (
                        guild_id varchar(55) NOT NULL UNIQUE,
                        prefix char(1)
                    );
                """;
        try {
            Statement statement = ConnectionFactory.connect().createStatement();
            statement.execute(sql);
            statement.close();
            ConnectionFactory.connect().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insert(String guildId, char prefix) {
        String sql = """
                    INSERT INTO tb_guild VALUES ('%s','%s') ON CONFLICT (guild_id) DO NOTHING;
                """.formatted(guildId, prefix);
        try {
            Statement statement = ConnectionFactory.connect().createStatement();
            statement.execute(sql);
            statement.close();
            ConnectionFactory.connect().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void select(String guildId) {
        String sql = """
                    SELECT * FROM tb_guild where guild_id = '%s';
                """.formatted(guildId);
        try {
            Statement statement = ConnectionFactory.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                BotLauncher.prefixMap.put(guildId, resultSet.getString("prefix").charAt(0));
            }

            statement.close();
            ConnectionFactory.connect().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
