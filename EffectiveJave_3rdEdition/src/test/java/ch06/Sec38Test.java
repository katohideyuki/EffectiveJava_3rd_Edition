package ch06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import ch06_enumAndAnotations.sec38_ExtensibleEnum.BasicOperation;
import ch06_enumAndAnotations.sec38_ExtensibleEnum.ExtendOperation;

@DisplayName("ExtensibleEnumパッケージのテスト")
public class Sec38Test {
    private static final double X = 5.0;
    private static final double Y = 2.0;

    @Nested
    class BasicOperationクラス {
        @Test
        void PLUSの列挙定数にXとYを渡すと_7が返却される() {
            assertEquals(7.00_000, BasicOperation.PLUS.apply(X, Y));
        }
    }

    @Nested
    class ExtendOperationクラス {
        @Test
        void EXPの列挙定数にXとYを渡すと_25が返却される() {
            assertEquals(25.00_000, ExtendOperation.EXP.apply(X, Y));
        }
    }
}
