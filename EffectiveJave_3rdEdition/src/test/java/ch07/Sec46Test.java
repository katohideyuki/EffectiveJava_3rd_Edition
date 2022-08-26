package ch07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.junit.jupiter.api.Test;

import ch07_lambdaAndStream.sec46_sideEffects.NotSideEffect;

public class Sec46Test {
    // 期待値であるMapの値
    private static final Map<String, Long> EXPECXTED_MAP = Map.of(
            "a", 1L,
            "b", 2L,
            "c", 3L,
            "d", 4L,
            "e", 5L,
            "f", 6L,
            "g", 7L,
            "h", 8L,
            "i", 9L,
            "j", 10L);

    private static final Path FILE = Paths
            .get("src/main/resources/ch07_lambdaAndStream/notSideEffect.txt");

    @Test
    void 適切なテスト名が思いつかない_badExamplePrimesを実行するとEXPECXTED_MAPと同等のMapが返却される() {
        try {
            // 実行したいprivateメソッドが定義されていクラスをインスタンス化する
            NotSideEffect notSideEffect = new NotSideEffect();
            // badExamplePrimesメソッド取得
            Method method = NotSideEffect.class.getDeclaredMethod("badExamplePrimes", Path.class);
            // privateなbadExamplePrimesメソッドへアクセスできるようにする
            method.setAccessible(true);
            // badExamplePrimesメソッド実行
            @SuppressWarnings("unchecked") /* 総称型による致し方ない警告であり、キャストは問題ない */
            Map<String, Long> resultMap = (Map<String, Long>) method.invoke(notSideEffect, FILE);
            // テスト実行
            assertEquals(EXPECXTED_MAP, resultMap);
        } catch (NoSuchMethodException | SecurityException e) {
            System.out.println("NotSideEffectクラス読み込みに失敗しました。");
            e.printStackTrace();
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            System.out.println("メソッド実行に失敗しました。");
            e.printStackTrace();
        }
    }
}
