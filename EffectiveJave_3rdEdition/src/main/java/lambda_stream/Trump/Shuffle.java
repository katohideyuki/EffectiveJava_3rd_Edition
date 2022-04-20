package lambda_stream.Trump;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* トランプカードを初期化する処理、デカルト積 */
public class Shuffle {
    public static void main(String[] a) {
//        System.out.println(newDeck_Loop());  // 結果は同じなので、コメントアウト
        System.out.println(newDeck_Stream());
    }

    /* トランプのリストを返却 ※ループを使用 */
    public static List<Card> newDeck_Loop() {
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                result.add(new Card(suit, rank));
            }
        }
        return result;
    }

    /* トランプのリストを返却 ※ストリームを使用 */
    public static List<Card> newDeck_Stream() {
        return Stream.of(Suit.values())
                .flatMap(suit ->
                    Stream.of(Rank.values())
                       .map(rank -> new Card(suit, rank)))
                .collect(Collectors.toList());
    }
}
