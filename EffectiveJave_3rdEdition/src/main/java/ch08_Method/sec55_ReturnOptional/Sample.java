package ch08_Method.sec55_ReturnOptional;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Sample {
    /**
     * ※1
     * コレクション中の最大値を返す。
     * @param <E>
     * @param c コレクション
     * @return  最大値
     * @throws  IllegalArgumentException 引数が空の場合
     */
    public static <E extends Comparable<E>> E maxBadEx(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Empty collection");

        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
            return result;
    }

    /**
     * ※2
     * コレクション中の最大値をOptional<E>として返す。
     * @param <E>
     * @param c コレクション
     * @return  Optionalで包んだ最大値
     */
    public static <E extends Comparable<E>> Optional<E> maxGoodEx(
            Collection<E> c) {
        if (c.isEmpty())
            return Optional.empty();

        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        return Optional.of(result);
    }

    /**
     * ※3
     * コレクション中の最大値をOptional<E>として返す - ストリームを使う
     * @param <E>
     * @param c コレクション
     * @return  Optionalで包んだ最大値
     */
    public static <E extends Comparable<E>> Optional<E> maxStream (
            Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

    /**
     * ※4
     * Optionalを利用する側の使用例
     */
    public static void useOptional() {
        List<String> wordList = List.of("Aapple", "banana", "peach");
        // パターン1 - 選択されたデフォルト値を提供するためにOptionalを使う
        String lastWordInLexion_1 = maxStream(wordList).orElse("No words");

        // パターン2 - 選択された例外をスローするためにOptionalを使う
        String lastWordInLexion_2 = maxStream(wordList).orElseThrow(NullPointerException::new);

        // パターン3 - 戻り値があると分かっている時にOptionalを使う
        // ※万が一、Optionalが空の場合はNoSuchElementExceptionをスローする
        String lastWordInLexion_3 = maxStream(wordList).get();
    }


}
/**
 * 結果を返せないかもしれないけど、何か返さないと使う側が特別な処理をせざるを得ないとき、
 * Optionalを使うべき。
 * ただし、Optionalを使う場合はパフォーマンスに影響が出ることを理解しておく。
 *  - パフォーマンス重視なら、nullか例外をスローすべき。
 *
 * 戻り値以外でOptionalを使うときは、ほとんどない。
 * また、以下の型はOptionalで包むべきではない
 *  - コレクション
 *  - ストリーム
 *  - マップ
 *  - 配列
 *  - Optionalを含むコンテナ型
 *
 * Optionalを使用することで、使う側は値が返されない可能性があると知らされるので、
 * 使う側はその場合の考慮を強制的に直面させられる。（良いこと）
 *
 * ※1
 * 例外が作成されるときに完全なスタックトレースが生成されるので、
 * 例外をスローするのはパフォーマンスが高くつく。
 *
 * ※2
 * 注意点として、optionalを返すメソッドでnullを決して返さないこと。
 * Optionalを使用する意味がなくなってしまう。
 */
