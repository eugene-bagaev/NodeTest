package bot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;
import java.awt.*;

public class AdminsCommand implements CommandExecutor {

    @Command(aliases = "!admins", async = true)
    public void handleCommand(Server server, TextChannel channel, Message message) {

        System.out.println("Perform admin command");

        final DiscordApi api = channel.getApi();

        System.out.println();

        EmbedBuilder embed = new EmbedBuilder()
                .setColor(Color.BLUE)
                .setTitle("Title")
                .setThumbnail(api.getYourself().getAvatar())
                .setDescription("Bot admins")
                .addInlineField("Name", "Value");

        channel.sendMessage(embed).join();
    }
}
