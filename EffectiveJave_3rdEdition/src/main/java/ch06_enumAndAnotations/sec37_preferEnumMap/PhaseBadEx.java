package ch06_enumAndAnotations.sec37_preferEnumMap;

/**
 * 配列の配列をインデックスするのにordinal()を使用 - これを行ってはいけない
 * 物質の状態を表すクラス
 */
public enum PhaseBadEx {
    SOLID, LIQUID, GAS;

    /** 状態の変化を表すクラス */
    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLINE, DEPOSIT;

        // fromの序数で行が、toの序数で列がインデックスされる
        private static final Transition[][] TRANSITIONS = {
                { null    /* 0,0 */, MELT     /* 0,1 */, SUBLINE /* 0,2 */ },
                { FREEZE  /* 1,0 */, null     /* 1,1 */, BOIL    /* 1,2 */ },
                { DEPOSIT /* 2,0 */, CONDENSE /* 2,1 */, null    /* 2,2 */ }
        };

        /**
         * 一つの相から別の相への相転移を返す
         * @param from  相          変化前の状態
         * @param to    別の相       変化後の状態
         * @return      相転移の配列  変化前、変化後の状態を表す二次元配列
         */
        public static Transition from(PhaseBadEx from, PhaseBadEx to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }
}
/**
 * 相転移
 *   - ある係の相が別の相へ変わることを指す。
 *     液体から個体、液体から気体...など。
 *
 * 問題点
 *   - 序数と配列のインデックスの関係をコンパイラは知らないため、
 *     転移表に誤った値を入れたり、PhaseBadEx enum型やPhase.Transition enum型を
 *     変更した際に転移表の更新を忘れたりすると、実行じ例外をスローする可能性がある。
 *     最悪、黙って誤った振る舞いになるかもしれない。
 */