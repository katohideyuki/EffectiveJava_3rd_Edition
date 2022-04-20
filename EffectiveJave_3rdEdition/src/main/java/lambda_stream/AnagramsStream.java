package lambda_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ストリームを乱用して実現
 * - 単語一覧を読み出して、指定した最小の閾値以上の大きさのアナグラムのグループをすべて表示する
 * - 二つのは、異なる順序で同じ文字から構成されていればアナグラム
 */
public class AnagramsStream {

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
            /* 意味不明 */
            words.collect(
                    Collectors.groupingBy(word -> word.chars().sorted() // 単語を1文字ずつASCIIコード(整数)に変換して、昇順にソートする　※1
                    .collect(StringBuilder::new,                        // 空の文字列オブジェクトを用意
                            (sb, c) -> sb.append((char) c),             // 文字列オブジェクトに１文字ずつchar型にキャストして追加
                            StringBuilder::append).toString()))         // それを文字列にする
            .values().stream()                                          // Mapのvalueのみのストリームを生成
            .filter(group -> group.size() >= minGroupSize)              // valueが2つ以上存在するものに絞り込む
            .map(group -> group.size() + ": " + group)                  // 出力するために文字列を整形
            .forEach(System.out::println);
        }
    }
}

/**
 * ※1 アルファベット順にソートしている。ことと同義
 * ※2 アルファベット順にソートされた文字列になる
 */
