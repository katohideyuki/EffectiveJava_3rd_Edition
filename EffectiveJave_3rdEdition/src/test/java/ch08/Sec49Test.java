package ch08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import ch08_Method.sec49_checkParameters.Sample;

@DisplayName("sec49_checkParametersパッケージのテスト")
public class Sec49Test {
    Sample s = new Sample();
    BigInteger val = new BigInteger("2");

    @Nested
    class modBadExメソッドのテスト {
        @Test
        void 渡した引数がそのまま返却される() {
            assertEquals(val, s.modBadEx(val));
        }
        @Test
        void nullを渡した場合NullPointerExceptionがスローされる() {
            assertThrows(NullPointerException.class, () -> s.modBadEx(null));
        }
        @Test
        void 負の値を渡した場合ArithmeticExceptionがスローされる() {
            // BigInteger.negate() 符号反転
            assertThrows(ArithmeticException.class, () -> s.modBadEx(val.negate()));
        }
    }

    @Nested
    class modGoodExメソッドのテスト {
        @Test
        void 渡した引数がそのまま返却される() {
            assertEquals(val, s.modGoodEx(val));
        }
        @Test
        void nullを渡した場合NullPointerExceptionがスローされる() {
            assertThrows(NullPointerException.class, () -> s.modGoodEx(null));
        }
        @Test
        void 負の値を渡した場合ArithmeticExceptionがスローされる() {
            // BigInteger.negate() 符号反転
            assertThrows(ArithmeticException.class, () -> s.modGoodEx(val.negate()));
        }
    }
}
