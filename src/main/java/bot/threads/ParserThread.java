package bot.threads;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParserThread extends Thread {

    @Override
    public void run() {

        try {
            Document document = Jsoup.connect("https://rage.mp/masterlist/").get();

            Elements body = document.select("body");
            System.out.println("Body: " + body);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
