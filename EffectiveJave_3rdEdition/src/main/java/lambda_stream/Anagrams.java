package lambda_stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * ストリームを使用せず実現
 * - 単語一覧を読み出して、指定した最小の閾値以上の大きさのアナグラムのグループをすべて表示する
 * - 二つのは、異なる順序で同じ文字から構成されていればアナグラム
 */
public class Anagrams {

    /* 単語一覧のファイルパス, 出力条件の閾値 */
    static final String[] SAMPLE = {"src/main/resources/anagrams.txt", "2"};

    public static void main(String[] args) throws FileNotFoundException {
        exe(SAMPLE);
    }

    /* アナグラムのグループをすべて繰り返し表示する */
    private static void exe(String[] sample) throws FileNotFoundException {
        File dictionary = new File(sample[0]);          // ファイルパス取得
        int minGroupSize = Integer.parseInt(sample[1]); // 要素数の閾値

        /* アナグラムがあるかどうか調べ、あればvalue */
        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();                         // 単語取得
                groups.computeIfAbsent(alphaebetize(word),      // アルファベット順にソートされた文字列のキーがあれば、受け取った文字列をvalueに追加 ※1
                        (unused) -> new TreeSet<>()).add(word); // アルファベット順にソートされた文字列のキーがなければ、それをキーとして新しくmapに追加する ※2
            }
        }

        /* キーに紐づくvalueが2以上存在すれば、そのvalueを出力 */
        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize) {
                System.out.println(groups.size() + ": " + group);
            }
        }
    }

    /* keyである単語を、アルファベット順にソートし返却する */
    private static String alphaebetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}

/**
 * ※1 キーがあったら、そのままmapに追加
 *    - (key, value, 追加されるvalue)
 *      - (ソート後の文字列,元々追加されていたソート前の文字列1, 今回追加されたソート前の文字列2)
 *
 * ※2 キーがなかった場合、こんな感じで新しくmapに追加される
 *    - (key, value)
 *      - (ソート後の文字列, ソート前の文字列)
 */
