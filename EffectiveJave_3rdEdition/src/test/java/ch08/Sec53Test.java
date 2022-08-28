package ch08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import ch08_Method.sec53_useVarargsJudiciously.Sample;


public class Sec53Test {
    @Nested
    class sumメソッドのテスト {
        @Test
        void 整数を渡した合計値が返却される() {
            assertEquals(6, Sample.sum(1, 2, 3));
        }
        @Test
        void 何も値を渡さなかった場合0が返却される() {
            assertEquals(0, Sample.sum());
        }
    }

    @Nested
    class minメソッドのテスト {
        @Test
        void 一番小さい値が返却される() {
            assertEquals(1, Sample.minBadEx(3, 2, 1));
        }
        @Test
        void 何も値を渡さなかった場合IllegalArgumentExceptionがスローされる() {
            assertThrows(IllegalArgumentException.class, () -> {
                Sample.minBadEx();
            });
        }
    }
}
