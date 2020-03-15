package bot.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ImageHelper {

    public static final String GTA_5_RP_THUMBNAIL = "https://i.imgur.com/pBqpM6D.gif";

    private static final List<String> WELCOME_IMAGES_LINKS = Arrays.asList(
            "https://i.imgur.com/2HqOdVo.jpg",
            "https://i.imgur.com/67RC06I.jpg",
            "https://i.imgur.com/JH1ePff.jpg",
            "https://i.imgur.com/FBmJc2D.jpg",
            "https://i.imgur.com/FkveHnC.jpg",
            "https://i.imgur.com/BIyHG4I.jpg",
            "https://i.imgur.com/i5SbNYO.jpg",
            "https://i.imgur.com/H0uXLhH.jpg",
            "https://i.imgur.com/jdXbHnZ.jpg",
            "https://i.imgur.com/S1dwJ3M.jpg",
            "https://i.imgur.com/STg9r6e.jpg",
            "https://i.imgur.com/EJh9WoK.jpg",
            "https://i.imgur.com/mxbMUyJ.jpg",
            "https://i.imgur.com/InVFvmz.jpg",
            "https://i.imgur.com/zZJAJEp.jpg",
            "https://i.imgur.com/3j4zaQ8.jpg",
            "https://i.imgur.com/i6fo3g3.jpg",
            "https://i.imgur.com/g9LLAMo.jpg",
            "https://i.imgur.com/oudQnfz.jpg",
            "https://i.imgur.com/ysFAmcI.jpg",
            "https://i.imgur.com/lPtY1ng.jpg",
            "https://i.imgur.com/uBLt2G8.png",
            "https://i.imgur.com/2IL6tGn.jpg",
            "https://i.imgur.com/NkYd2jr.jpg",
            "https://i.imgur.com/4fwlss0.jpg",
            "https://i.imgur.com/IbM8FXg.jpg",
            "https://i.imgur.com/hFQ686A.jpg"
    );

    public static String getRandomImageUrl() {
        Random random = new Random();
        int randomValue = random.nextInt(27);
        return WELCOME_IMAGES_LINKS.get(randomValue);
    }

}
