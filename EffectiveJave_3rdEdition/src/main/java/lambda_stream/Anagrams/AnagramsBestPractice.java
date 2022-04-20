package lambda_stream.Anagrams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ストリームの感じの良い使い方で実現
 * - 単語一覧を読み出して、指定した最小の閾値以上の大きさのアナグラムのグループをすべて表示する
 * - 二つのは、異なる順序で同じ文字から構成されていればアナグラム
 */
public class AnagramsBestPractice {

    /* 単語一覧のファイルパス, 出力条件の閾値 */
    static final String[] SAMPLE = {"src/main/resources/anagrams.txt", "2"};

    public static void main(String[] args) throws IOException {
        exe(SAMPLE);
    }

    /* アナグラムのグループをすべて繰り返し表示する */
    private static void exe(String[] sample) throws IOException {
        Path dictionary = Paths.get(sample[0]);         // ファイルパス取得
        int minGroupSize = Integer.parseInt(sample[1]); // 要素数の閾値

        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(Collectors.groupingBy(word -> alphaebetize(word)))  // ※1 グルーピング
            .values().stream()                                                // Mapのvalueのみのストリームを生成
            .filter(group -> group.size() >= minGroupSize)                    // valueが2つ以上存在するものに絞り込む
            .forEach(g -> System.out.println(g.size() + ": " + g));
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
 * groupingByメソッド
 * - Map<String,List<String> こういうイメージのMapが返却される
 *
 * ※1 グルーピングのロジック
 *   - アルファベット順にソートされたキーがあれば、受け取った文字列をvalueであるlistに追加
 *   - アルファベット順にソートされたキーがなければ、それをキーとして新しくvalueであるlistに追加する
 */
