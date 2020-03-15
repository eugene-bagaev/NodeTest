package bot.util;

import bot.service.MailService;
import com.sun.javafx.collections.MappingChange;

import java.awt.*;
import java.util.*;
import java.util.List;

public class BotUtils {

    public static final ArrayList<String> COMMAND_LIST = new ArrayList<String>(Arrays.asList("!admins", "!clearChannel"));
    public static final ArrayList<String> EMAIL_LIST = new ArrayList<String>(Arrays.asList("dockbreaking@gmail.com", "eugene.bagaev@gmail.com"));


    public static Boolean sendErrorMessageToAdmins(String subject, String body) {

        boolean isSuccess = false;

        try {
            MailService service = MailService.getInstance();

            service.send(
                    subject,
                    body,
                    "bot@discorg.bot",
                    "eugene.bagaev@gmail.com"
            );
            isSuccess = true;
        } catch (Exception ex) {
            System.out.println("Email error. Check developer console.");
            BotUtils.sendErrorMessageToAdmins(ex);
        }
        return isSuccess;
    }

    public static Boolean sendErrorMessageToAdmins(Exception exception) {

        boolean isSuccess = true;

        try {
            MailService service = MailService.getInstance();

            service.send(
                    "Discord Bot Error Occurred",
                    exception.toString(),
                    "bot@discorg.bot",
                    "eugene.bagaev@gmail.com"
            );
        } catch (Exception ex) {
            isSuccess = false;
            System.out.println("Email error. Check developer console.");
            ex.printStackTrace();
            BotUtils.sendErrorMessageToAdmins(ex);
        }
        return isSuccess;
    }

    public static Color getRandomColor() {
        Random rand = new Random();

        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();

        return new Color(r, g, b);
    }

}