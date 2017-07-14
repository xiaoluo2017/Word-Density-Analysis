import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;

/**
 * Created by xiaol on 2017/7/13.
 */
public class Main {
    private String url;
    private int keywordNumber;
    private Document doc;
    private Map<String, Integer> map;
    private List<String> words;
    private WordParser w;

    private void crawlURL() {
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initStopWords() {
        w = new WordParser();
        w.parseStopWords();
        words = w.lemmatize(doc.text());
    }

    private void initMap() {
        map = new HashMap<String, Integer>();
        for (String word : words) {
            if (!w.isStopWord(word)) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        }
    }

    private List<String> findKeywords() {
        PriorityQueue<WordNode> queue = new PriorityQueue<WordNode>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            WordNode wn = new WordNode(entry.getKey(), entry.getValue());
            queue.offer(wn);
            if (queue.size() > keywordNumber) {
                queue.poll();
            }
        }
        List<String> res = new ArrayList<String>();
        while (!queue.isEmpty()) {
            res.add(0, queue.poll().word);
        }
        return res;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.url = args[0];
        main.keywordNumber = Integer.parseInt(args[1]);
        main.crawlURL();
        main.initStopWords();
        main.initMap();
        main.findKeywords();
    }
}
