import edu.stanford.nlp.simple.Sentence;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

/**
 * Created by xiaol on 2017/7/13.
 */
public class WordParser {
    private HashSet<String> stopWords;

    public WordParser() {
        stopWords = new HashSet<String>();
    }

    public boolean isStopWord(String s){
        return stopWords.contains(s.toLowerCase());
    }

    public void parseStopWords() {
        try {
            FileReader in = new FileReader("src/main/stopwords.txt");
            BufferedReader br = new BufferedReader(in);
            try {
                String str = br.readLine();
                while (str != null) {
                    stopWords.add(str);
                    str = br.readLine();
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> lemmatize(String text) {
        Sentence sentence = new Sentence(text);
        return sentence.lemmas();
    }
}
