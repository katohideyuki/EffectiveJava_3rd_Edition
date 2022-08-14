package ch06_enumAndAnotations.sec37_preferEnumMap;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ch06_enumAndAnotations.sec37_preferEnumMap.Plant.LifeCycle;
import static java.util.stream.Collectors.*;

/** Plantクラスの使用例 */
public class UsePlant {

    // 庭園を表す植物の配列
    private static final Plant[] garden = {
            new Plant("Geranium",    LifeCycle.PERENNIAL),
            new Plant("Akebonoso",   LifeCycle.BIENNIAL),
            new Plant("Nanohana",    LifeCycle.ANNUAL),
            new Plant("OnitaPirako", LifeCycle.BIENNIAL)};

    public static void main(String[] args) {
        badEx();
        goodEx();
        goodExUsingStream();
    }

    /**
     * 配列をインデックスするのにordinalメソッドを使用 - これをやってはいけない
     * 植物の配列の寿命でまとめて一覧して出力する。
     * 問題点
     *   - 配列はジェネリックスと互換性がなく無検査キャストを必要とするため、警告される。
     *   - enum定数の序数でインデックスされている配列へアクセスする際に、正しいint値を
     *     使わなければならない。
     *     - 誤った値を使った場合、実行時にArrayIndexOutOfBoundsExceptionをスロー
     *       する可能性がある。
     */
    public static void badEx() {
        // LifeCycleの要素数分を規定値とした、セット型の配列を初期化 : 3
        // 配列はジェネリックスと互換性がないため警告
        @SuppressWarnings("unchecked")
        Set<Plant>[] plantsByLifeCycle =
                (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];

        // セット配列に、ハッシュセットを代入する
        for (int i = 0; i < plantsByLifeCycle.length; i++)
            plantsByLifeCycle[i] = new HashSet<>();
        // 寿命ごとに植物を振り分ける
        for (Plant p : garden)
            plantsByLifeCycle[p.getLifeCycle().ordinal()].add(p);
        // 出力
        for (int i = 0; i < plantsByLifeCycle.length; i++)
            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
    }

    /**
     * データをenumと関連付けるためにEnumMapを使う
     * enumをキー、植物を値とする。
     * 改善点
     *   - 配列のインデックスを計算する際の誤りがない。
     */
    public static void goodEx() {
        // EnumMapのコンストラクタは、キー型のClassオブジェクトを受け取る
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);
        // 寿命をキーとしたMapを追加する
        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());
        // 寿命ごとに植物を振り分ける
        for (Plant p : garden)
            plantsByLifeCycle.get(p.getLifeCycle()).add(p);
        System.out.println(plantsByLifeCycle);
    }

    /** データをenumと関連付けるためにEnumMapを使う - Streamを使用した例 */
    public static void goodExUsingStream() {
        System.out.println(Arrays.stream(garden)
                .collect(groupingBy(p -> p.getLifeCycle(),
                        () -> new EnumMap<>(LifeCycle.class), toSet())));
    }
}
