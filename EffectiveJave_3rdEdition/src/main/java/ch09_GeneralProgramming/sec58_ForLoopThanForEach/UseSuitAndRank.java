package ch09_GeneralProgramming.sec58_ForLoopThanForEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class UseSuitAndRank {
    static Collection<Suit> suits = Arrays.asList(Suit.values());
    static Collection<Rank> ranks = Arrays.asList(Rank.values());

    class Card {
        private final Suit suit;
        private final Rank rank;

        /** インナークラスのコンストラクタ */
        Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }
    }

    /**
     * ※1
     * suitsの次の要素がなくなった時点でNpSuchElementExceptionを
     * スローする悪い例。
     */
    private static void badUse() {
        List<Card> deck = new ArrayList<>();
        for (Iterator<Suit> i = suits.iterator(); i.hasNext(); )
            for (Iterator<Rank> j = ranks.iterator(); j.hasNext(); )
                deck.add(new UseSuitAndRank().new Card(i.next(), j.next()));
    }

    /**
     * コレクションにと配列に対するネストしたイテレーションのための良い例
     */
    private static void goodUse() {
        List<Card> deck = new ArrayList<>();
        for (Suit suit : suits)
            for (Rank rank : ranks)
                deck.add(new UseSuitAndRank().new Card(suit, rank));
    }
}
/**
 * 利用できる場所ではどこでも、forループよりもfor-eachループを使うべき。
 *
 * ※1
 * 問題は、外側のコレクション(suits)に対するイテレーターに対して
 * nextメソッドが過剰に呼び出されること。
 *
 * for-eachが使えない例が3つある。
 *  1. 破壊的なフィルタリング
 *    - 繰り返しながら要素を削除するとき。
 *      - とは言いつつも、java8で追加されたCollection.removeIf()を使えば
 *        for-eachでも繰り返しながら要素を削除できる。
 *  2. 変換
 *    - リストや配列を繰り返して、要素の値の一部、あるいは全部を置換する場合、
 *      要素の値を置換するためのインデックスが必要になるとき。
 *  3. 並列イテレーション
 *    - イテレーターやインデックス変数に対する明示的な制御が必要。
 */
