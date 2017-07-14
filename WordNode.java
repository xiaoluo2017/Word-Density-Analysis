/**
 * Created by xiaol on 2017/7/13.
 */
public class WordNode implements Comparable<WordNode>{
    String word;
    int cnt;
    public WordNode(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }

    public int compareTo(WordNode w) {
        return this.cnt - w.cnt;
    }
}
