package ch08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import ch08_Method.sec55_ReturnOptional.Sample;

public class Sec55Test {
    private static final List<Integer> NUM_LIST = List.of(1, 2, 3, 4, 5);
    private static final List<Integer> EMPTY_LIST = new ArrayList<>();
    private static final int EXPECTED_5 = 5;

    @Nested
    class maxBadExメソッドのテスト {
        @Test
        void NUM_LISTを渡すと_最大値である5が返却される() {
            assertEquals(EXPECTED_5, Sample.maxBadEx(NUM_LIST));
        }
        @Test
        void 空のリストを渡すと_IllegalArgumentExceptionをスローする() {
            assertThrows(IllegalArgumentException.class,
                    () -> Sample.maxBadEx(EMPTY_LIST));
        }
    }

    @Nested
    class maxGoodExメソッドのテスト {
        @Test
        void NUM_LISTを渡すと_最大値である5を持ったOptionalが返却される() {
            // ACTUALが空の場合のデフォルト値(その場合は、テスト失敗になる)
            int emptyNum = 0;

            Optional<Integer> ACTUAL = Sample.maxGoodEx(NUM_LIST);
            assertEquals(EXPECTED_5, ACTUAL.orElse(emptyNum));
        }
        @Test
        void 空のリストを渡すと_空のOptionalが返却される() {
            assertEquals(Optional.empty(), Sample.maxGoodEx(EMPTY_LIST));
        }
    }
}
