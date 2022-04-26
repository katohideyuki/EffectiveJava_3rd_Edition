package lambda_stream.streamThanColleciton;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/* 入力リストのすべてのサブリストのストリームを返す */
public class SubLists {
    public static <E> Stream<List<E>> of(List<E> list) {
        return Stream.concat(Stream.of(Collections.emptyList()),
                prefixes(list).flatMap(SubLists::suffixes));
    }

    /* リストの最初の要素を含むサブリストのストリームを返却 */
    public static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size())
                .mapToObj(end -> list.subList(0, end));
    }

    /* リストの最後の要素を含むサブリストのストリームを返却 */
    public static <E> Stream<List<E>> suffixes(List<E> list) {
        return IntStream.range(0, list.size())
                .mapToObj(start -> list.subList(start, list.size()));
    }
}
/**
 * <pre>
 * IntStream.rangeClosed(開始値, 終了値)
 *   - 開始値以上、終了値以下の連続する整数を返却
 *     - rangeClosed(0, 10) // 0 ~ 10
 *
 * InsStream.range(開始値, 終了値)
 *   - 開始値以上、終了値未満の連続する整数を返却
 *     - range(0, 10)       // 0 ~ 9
 *
 * List.subList(こっからIndex, ここまでIndex)
 *   - リストから必要な範囲だけ取得して、新しいリストを生成する
 * </pre>
 */