package ch06_enumAndAnotations.sec37_preferEnumMap;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** データとenumの相を関連付けるためにネストしたEnumMapを使用 */
public enum Phase {
    SOLID, LIQUID, GAS;

    /** 状態の変化を表すクラス */
    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS),   CONDENSE(GAS, LIQUID),
        SUBLINE(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final Phase from; // 転移元
        private final Phase to;   // 転移先

        /** コンストラクタ */
        private Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        // 相転移マップを初期化
        // （転移元）相から、（転移先）相から相転移へのマップ、へのマップを生成する（ややこしい）
        private static final Map<Phase, Map<Phase, Transition>> m =
                Stream.of(values()).collect(Collectors.groupingBy(t -> t.from,
                        Collectors.toMap(t -> t.to, t -> t,
                                (x, y) -> y, () -> new EnumMap<>(Phase.class))));

        /**
         * 一つの相から別の相への相転移を返す
         * @param from  相             変化前の状態
         * @param to    別の相          変化後の状態
         * @return      相転移のマップ   変化前、変化後の状態を表す二次元マップ
         */
        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }
    }
}
/**
 * 改善点
 *   - 各相転移は、相enumの組でインデックスされているので、一つのenum(fromの相)を、
 *     二番目のenum(toの相)から結果（相転移)へのマップへ、
 *     マップする関係を表現する方がよい。
 *
 * 改善の余地
 *   - 転移元(from)と転移先(to)が同じ状態の場合、nullを返却する。
 *     - 本来はnullを返却するのは良い方法ではない。
 *       しかし、null以外でクリーン且つ洗練された実装にするためには、
 *       驚くほど大変らしいので、割愛している。
 */