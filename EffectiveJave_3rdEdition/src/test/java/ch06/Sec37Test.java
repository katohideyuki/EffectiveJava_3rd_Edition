package ch06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import ch06_enumAndAnotations.sec37_preferEnumMap.Phase;
import ch06_enumAndAnotations.sec37_preferEnumMap.PhaseBadEx;

@DisplayName("preferEnumMapパッケージのテスト")
public class Sec37Test {

    @Nested
    class PhaseBadExクラス {
        @Test
        void 液体から個体へ相転移をした場合_状態の変化である凍結が返却される() {
            // 相転移
            PhaseBadEx.Transition result =
                    PhaseBadEx.Transition.from(PhaseBadEx.LIQUID, PhaseBadEx.SOLID);
            assertEquals(PhaseBadEx.Transition.FREEZE, result);
        }
    }

    @Nested
    class Phaseクラス {
        @Test
        void 液体から個体へ相転移をした場合_状態の変化である凍結が返却される() {
            // 相転移
            Phase.Transition result =
                    Phase.Transition.from(Phase.LIQUID, Phase.SOLID);
            assertEquals(Phase.Transition.FREEZE, result);
        }
        @Test
        void 転移元と転移先が同じ状態の場合_nullが返却されるが_本来はそうすべきではない() {
            // 相転移
            Phase.Transition result =
                    Phase.Transition.from(Phase.LIQUID, Phase.LIQUID);
            assertEquals(null, result);
        }
    }
}
