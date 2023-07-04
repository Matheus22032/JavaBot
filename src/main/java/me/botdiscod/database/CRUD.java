package me.botdiscod.database;

import me.botdiscod.app.BotLauncher;

import java.sql.PreparedStatement;
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
                    INSERT INTO tb_guild VALUES (?,?) ON CONFLICT (guild_id) DO NOTHING;
                """;
        try {
            PreparedStatement statement = ConnectionFactory.connect().prepareStatement(sql);
            statement.setString(1,guildId);
            statement.setString(2,String.valueOf(prefix));
            statement.execute();
            statement.close();
            ConnectionFactory.connect().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void select(String guildId) {
        String sql = """
                    SELECT * FROM tb_guild where guild_id = ?;
                """;
        try {
            PreparedStatement statement = ConnectionFactory.connect().prepareStatement(sql);
            statement.setString(1,guildId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                BotLauncher.prefixMap.put(guildId, resultSet.getString("prefix").charAt(0));
            }
            statement.close();
            ConnectionFactory.connect().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void update(String guildId, char newPrefix){
        String sql = """
                UPDATE tb_guild SET prefix = ? WHERE guild_id = ?;
                """;
        try {
            PreparedStatement statement = ConnectionFactory.connect().prepareStatement(sql);
            statement.setString(1, String.valueOf(newPrefix));
            statement.setString(2, guildId);
            statement.executeUpdate();
            statement.close();
            ConnectionFactory.connect().close();
        }catch (SQLException e ){
            System.out.println(e.getMessage());
        }

    }


}
