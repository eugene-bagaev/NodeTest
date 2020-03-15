package bot.start;

import bot.commands.AdminsCommand;
import bot.commands.ClearCommand;
import bot.threads.ParserThread;
import bot.util.BotUtils;
import bot.util.CarsUtil;
import bot.util.Constants;
import bot.util.ImageHelper;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.ServerChannel;
import org.javacord.api.entity.channel.ServerVoiceChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageSet;
import org.javacord.api.entity.message.embed.Embed;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.message.embed.EmbedField;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.channel.server.voice.ServerVoiceChannelMemberJoinEvent;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.event.server.member.ServerMemberJoinEvent;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    private static final Long TEST_CHANNEL_ID       = 646090987021533221L;
    private static final Long WELCOME_CHANNEL_Id    = 645204890456686612L;
    private static final Long NITRO_ROLE_ID         = 621453235965788180L;

    public static final Long MY_ID = 544874438936625153L;


//    private static final String GTA_5_RP_BOT_TOKEN  = "MzE3Njk1MTgwMjQ3NDAwNDQ5.XdPv7g.EWokWBVz5yYtwRiey8moyNWjjRU";
    private static final String GTA_5_RP_BOT_TOKEN  = "MzE3Njk1MTgwMjQ3NDAwNDQ5.Xi9lOg.ikmOHsfd3KgFACP9zMxd8r7cJkM";
    private static final String MY_TOKEN = "NjM3OTUzNTY1OTgxNDA5Mjgw.XdqDDA.ciWwQDMMFqFmBQwVKNcgxQxHECk";

    private static final String WELCOME_FIELD_CHANNELS = "" +
            "\n[\uD83D\uDCD6Основные правила](https://canary.discordapp.com/channels/577311012236165122/599577947426521116)" +
            "\n[\uD83D\uDC40Как начать играть](https://canary.discordapp.com/channels/577311012236165122/593457960097677332)" +
            "\n[\uD83D\uDD0DНавигация проекта](https://canary.discordapp.com/channels/577311012236165122/599577053435658242)";

    public static final String WELCOME_PUBLIC_CHAT = "\n[#общий чат](https://canary.discordapp.com/channels/577311012236165122/592637875405848587)";

    private static final String WELCOME_FIELD_LINKS = "" +
            "\n[<:zvezd:645198494717706250>Сайт](https://gta5rp.com)" +
            "\n[<:zvezd:645198494717706250>Форум](https://forum.gta5rp.com/)" +
            "\n[<:yout:645198494901993482>YouTube канал](https://www.youtube.com/channel/UCLy1N4gPCMNE2W8rZGcfXpw)" +
            "\n[<:vk:645198494524506125>Группа ВК](https://www.vk.com/gta5rp/)" +
            "\n[<:vk:645198494524506125>Свободное сообщество игроков](https://vk.com/gta_rp)" +
            "\n[<:vk:645198494524506125>Беседа ВК](https://vk.me/join/AJQ1d/qDnhXrkz8I118F7iPN)";


    public static void main(String[] args) {

        if (args.length > 0) {
            System.out.println("ARG 0: " + args[0]);
        }

        DiscordApi api = new DiscordApiBuilder().setToken(GTA_5_RP_BOT_TOKEN).login().join();

        // define all listeners
        // when user post message
        api.addMessageCreateListener(Main::messageListener);
        // when user join voice channel
        api.addServerVoiceChannelMemberJoinListener(Main::memberJoinVoice);
        // when user connected to server
//        api.addServerMemberJoinListener(Main::memberJoinListener);

        CommandHandler handler = new JavacordHandler(api);
        handler.registerCommand(new ClearCommand());
        handler.registerCommand(new AdminsCommand());
    }

    private static void memberJoinVoice(ServerVoiceChannelMemberJoinEvent event) {

        if (event.getUser().getId() == MY_ID) {
            System.out.println("Members: " + event.getServer().getMemberCount());
            Long serId = 652749334659465217L;

//            ServerVoiceChannel targetChannel = event.getServer().getVoiceChannelById(serId).get();
//            event.getServer().moveUser(event.getServer().getMemberById(MY_ID).get(), targetChannel);

            for (ServerChannel item : event.getServer().getChannels()) {
//                System.out.println("Channel: " + item.getType() + ". Id: " + item.getId() + ". Name: " + item.getName());
                if (item.getType().toString() == "SERVER_VOICE_CHANNEL") {

//                    System.out.println("Channel: " + item.asServerVoiceChannel().get().getName() + ". " + item.asServerVoiceChannel().get().getConnectedUsers());
                }
            }
        }
//        ParserThread thread = new ParserThread();
//        thread.run();
        // paste logic when user join voice channel
//        System.out.println("Send EMAIL");
//        BotUtils.sendErrorMessageToAdmins("test", "test");
    }

    private static void memberJoinListener(ServerMemberJoinEvent event) {
        try {
            EmbedBuilder welcomeMessage = new EmbedBuilder()
                    .setTitle("")
                    .setColor(BotUtils.getRandomColor())
                    .setThumbnail(ImageHelper.GTA_5_RP_THUMBNAIL)
                    .setImage(ImageHelper.getRandomImageUrl())
                    .setAuthor("Добро пожаловать на официальный дискорд проекта GTA 5 RP",  "",  "https://i.imgur.com/IbM8FXg.jpg")
                    .addField("**Для комфортного времяпрепровождение**\n**рекомендуем озокомиться с каналами:**", WELCOME_FIELD_CHANNELS)
                    .addField("**Общий чат игроков:**", WELCOME_PUBLIC_CHAT)
                    .addField("**Полезные ссылки:**", WELCOME_FIELD_LINKS)
                    .addField("Пользователей на сервере: ", event.getServer().getMemberCount() + "!");

            event.getServer().getChannelById(WELCOME_CHANNEL_Id).get().asServerTextChannel().get().sendMessage(welcomeMessage);
        } catch (Exception ex) {
            System.out.println("Error in member join to server: " + ex.getMessage());
            ex.printStackTrace();
            BotUtils.sendErrorMessageToAdmins("Ошибка при коннекте челика к серверу.", "Коннект к серверу от игрока не удачен " + ex.getMessage());
        }
    }

    private static void messageListener(MessageCreateEvent event) {

        // if sender not bot user
        if (!event.getMessage().getAuthor().isBotUser()) {

             // if message was sent in testpool channel
            if (event.getChannel().getId() == TEST_CHANNEL_ID) {

                if (BotUtils.COMMAND_LIST.contains(event.getMessageContent())) {
                    System.out.println("Message content from command list.");
                    return;
                }

//                for (ServerChannel item : event.getServer().get().getChannels()) {
//                    System.out.println("Channel: " + item.getType() + ". Id: " + item.getId() + ". Name: " + item.getName());
//
//                    if (item.getType().toString() == "SERVER_VOICE_CHANNEL") {
//                        System.out.println("Channel: " + item.asServerVoiceChannel().get().getConnectedUsers());
//                    }
//                }

                processMessageInTestChannel(event);
            }
        }
    }

    private static void processMessageInTestChannel(MessageCreateEvent event) {
        try {
            Message message                 = event.getMessage();
            String messageContent           = event.getMessageContent();
            long messageUserIdForPublish    = 0;

            if (message.getAuthor().asUser().isPresent()) {
                messageUserIdForPublish =  message.getAuthor().asUser().get().getId();
            }

            boolean isMessageNotValid = !messageContent.toLowerCase().contains("куплю") && !messageContent.toLowerCase().contains("продам") && !messageContent.toLowerCase().contains("обменяю");

            if (!isMessageNotValid) {
                System.out.println("Valid message. Go next.");

                if (messageContent.length() >= 250) {
                    if (message.getAuthor().asUser().isPresent()) {
                        message.getAuthor().asUser().get().sendMessage(Constants.MESSAGE_TOO_LONG_ERROR);
                        message.delete();
                    }
                    return;
                }

                Color advColor = new Color(54, 57, 63);

                for (Role item : event.getMessageAuthor().asUser().get().getRoles(event.getServer().get())) {
                    if (item.getId() == NITRO_ROLE_ID) {
                        System.out.println("NITRO ROLE");
                        advColor = Color.YELLOW;
                    }
                }

                String attachmentUrl = getAttachmentURLFromMessage(message);

                CompletableFuture<MessageSet> messages = message.getChannel().getMessages(10);

                boolean isDuplicatedMessage = false;
                Iterator<Message> messageIterator = messages.get().iterator();

                while (messageIterator.hasNext()) {
                    Message messageItem     = messageIterator.next();
                    List<Embed> embedList   = messageItem.getEmbeds();

                    if (embedList.size() > 0) {
                        Embed singleEmbed               = embedList.get(0);
                        List<EmbedField> embedFields    = singleEmbed.getFields();

                        if (embedFields.size() > 0) {
                            EmbedField field = embedFields.get(0);

                            try {
                                String userId = field.getValue().substring(field.getValue().indexOf("<@") + 2, field.getValue().indexOf(">"));
                                User messageAuthor = message.getApi().getUserById(userId).join();

                                System.out.println("StringUserId: " + userId);
                                System.out.println("User: " + messageAuthor);

                                if (messageAuthor.getId() == messageUserIdForPublish) {
                                    System.out.println("Duplicate!");
                                    isDuplicatedMessage = true;
                                }
                            } catch (Exception ex) {
                                System.out.println("Handled exception. Skip User check for duplicate.");

                            }
                        }
                    }
                }

                if (isDuplicatedMessage) {
                    message.getAuthor().asUser().get().sendMessage(Constants.MESSAGE_DUPLICATE_ERROR);
                    message.delete();
                } else {

                    String[] wordsInAdv = messageContent.split(" ");
                    String specialCharsRegex = "[`~!@#$%^&*()_+[\\]\\\\;\',./{}|:\"<>?]";

                    for (String item : wordsInAdv) {
                        String formattedValue = item.replaceAll(specialCharsRegex, "");
                        if (CarsUtil.getCars().containsKey(formattedValue)) {
                            attachmentUrl = CarsUtil.getCars().get(formattedValue);
                            break;
                        }
                    }

                    EmbedBuilder advMessage = new EmbedBuilder()
                            .setColor(advColor)
                            .setThumbnail(message.getAuthor().asUser().get().getAvatar().getUrl().toString())
                            .setImage(attachmentUrl)
                            .setAuthor(messageContent)
                            .addField("Контакты автора обьявления:", "Discord: " + message.getAuthor().asUser().get().getMentionTag() + ". " + message.getAuthor().asUser().get().getDiscriminatedName());

                    message.getChannel().sendMessage(advMessage).join();
                    message.delete().join();

                    System.out.println("Publish message. Remove unformatted.");
                }
            } else {
                removeNotValidMessage(message);
            }

        } catch (Exception ex) {
            System.out.println("Error msg com.bot.Main: " + ex.getMessage());

            BotUtils.sendErrorMessageToAdmins(ex);
        }
    }

    private static String getAttachmentURLFromMessage(Message message) {
        return message.getAttachments().size() > 0 ? message.getAttachments().get(0).getUrl().toString() : null;
    }

    private static void removeNotValidMessage(Message message) {
        User user = message.getAuthor().asUser().get();

        message.getChannel().sendMessage(user.getMentionTag() + " сообщение должно содержать куплю, продам или обменяю");

//        Timer timer = new Timer();
//
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                message.delete();
//            }
//        }, 1000);
    }
}
