package ch07_lambdaAndStream.sec46_sideEffects;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

import dubug.Debug;

/**
 * ストリームで副作用のない関数を選ぶ
 * テキストファイル内の単語の頻度表を構築する。
 */
public class NotSideEffect {
    // 読み込むファイルパス
    static final Path FILE = Paths
            .get("src/main/resources/ch07_lambdaAndStream/notSideEffect.txt");

    public static void main(String[] args) throws IOException {
        Debug.log("badExamplePrimes");
        System.out.println(badExamplePrimes(FILE));

        Debug.log("goodExamplePrimes");
        System.out.println(goodExamplePrimes());

        Debug.log("top10");
        System.out.println(topTen(goodExamplePrimes()));
    }

    /**
     * ストリームを使っているがパラダイムは使っていない - 悪い例（特にforEachの使い方）
     * @return
     * @throws IOException
     */
    private static Map<String, Long> badExamplePrimes(Path path) throws IOException {
        // 処理を行ったMapを格納
        Map<String, Long> freq = new HashMap<>();

        // 区切り文字で区切られた文字を読み込む
        try (Scanner scanner = new Scanner(path)) {
            Stream<String> words = scanner.tokens();
            // 値があれば、+1した値で上書き
            words.forEach(word -> {
                freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
            return freq;
        }
    }

    /**
     * 頻度表を初期化するための正しいストリーム - 良い例 ※1
     * @return
     * @throws IOException
     */
    private static Map<String, Long> goodExamplePrimes() throws IOException {
        // 処理を行ったMapを格納
        Map<String, Long> freq;
        // 区切り文字で区切られた文字を読み込む
        try (Scanner scanner = new Scanner(FILE)) {
            Stream<String> words = scanner.tokens();
            // 値があれば要素数の結果で上書き
            freq = words.collect(groupingBy(String::toLowerCase, counting()));
        }
        return freq;
    }

    /**
     * 頻度表から単語のトップ10リストを返却するパイプライン
     * @param freq
     * @return
     */
    private static List<String> topTen(Map<String, Long> freq) {
        // 頻度表から文字の出現数を返却し、逆順にソート
        List<String> topTenList = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());
        return topTenList;
    }
}

/**
 * <pre>
 * Scanner.tokens()
 *   - 区切り文字で区切られたトークンのストリームを返す
 *
 * Map.merge(キー1, 存在しない場合に設定する値A, 存在している場合に行う処理B)
 *   - Map内にキー1が存在しなければ値Aを設定
 *   - 存在していれば、既に存在する値Cと値Aが引数で渡され、何らかの処理結果で既に存在する値を上書きする
 *     - 存在している場合に行う処理はBiFunction型
 *
 * ※1 本当は以下のようなコードを書きたいが、Scannerがcloseされないと警告がでるため、断念
 *   - try (Stream<String> words = new Scanner(FILE).tokens()){
 *          freq = words.collect(groupingBy(String::toLowerCase, counting()));
 *     }
 * Collectors.counting()
 *   - 要素数を返却
 * </pre>
 */
