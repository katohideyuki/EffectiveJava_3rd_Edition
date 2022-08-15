package ch06;

import static ch06_enumAndAnotations.sec34_preferEnum.IntConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import ch06_enumAndAnotations.sec34_preferEnum.*;

@DisplayName("preferEnumパッケージのテスト")
public class Sec34Test {

    @Nested
    class IntConstantsクラス {
        @Test /** APPLEとORANGEの関係性がメチャクチャな使い方 */
        void うまいオレンジ風味のアップルソースを表現しようとしてマイナス1が返却される() {
            int i = (APPLE_FUJI - ORANGE_TEMPLE) / APPLE_PIPPIN;
            assertEquals(-1, i);
        }
    }

    @Nested
    class Planetクラス {
        double mass = 50 / Planet.EARTH.surfaceGravity(); // 地球上での重さ50kgある物体A
        @Test
        void 物体Aを渡し_地球上での重さを計算した結果_50kgが返却される() {
            assertEquals(50, Planet.EARTH.surfaceWeight(mass));
        }
        @Test
        void 物体Aを渡し_木星上で重さを計算した結果_約126kgが返却される() {
            assertEquals(126.48397193149368, Planet.JUPITER.surfaceWeight(mass));
        }
    }

    @Nested
    class Operationクラス {
        @Test
        void OperationクラスのPLUSの値を取得する() {
            String symbol = "+";
            assertEquals(Operation.fromString(symbol).orElseThrow(), Operation.PLUS);
        }
    }

    @Nested
    class PayrollDayBadExクラス {
        @Test /** 残業代は、残業時間 x 分給/2 の金額が付与される */
        void 分給16円の労働者が_月曜日に540分働くと_その日の日給9120円が返却される() {
            int minutesWorked = 540;
            int payRate       = 16;
            assertEquals(9120, PayrollDayBadEx.MONDAY.pay(minutesWorked, payRate));
        }
    }

    @Nested
    class PayrollDayクラス {
        @Test
        void 分給16円の労働者が_月曜日に540分働くと_その日の日給9120円が返却される() {
            int minutesWorked = 540;
            int payRate       = 16;
            assertEquals(9120, PayrollDay.MONDAY.pay(minutesWorked, payRate));
        }
    }
}
