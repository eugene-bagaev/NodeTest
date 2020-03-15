package bot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageSet;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;
import java.awt.*;
import java.util.Iterator;

public class ClearCommand implements CommandExecutor {

    @Command(aliases = "!clearChannel", async = true)
    public void handleCommand(Server server, TextChannel channel, Message message) {

        System.out.println("Perform clear command");

        final DiscordApi api = channel.getApi();

        MessageSet messages = channel.getMessages(50).join();

        Iterator<Message> messageIterator = messages.iterator();

        while (messageIterator.hasNext()) {
            messageIterator.next().delete();
        }

        channel.sendMessage("Удалено 50 сообщений");
    }
}