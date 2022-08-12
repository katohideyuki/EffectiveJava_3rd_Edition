package ch04.sec28;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import ch04_classAndInterface.sec28_perferList.ChooserBadEx;
import ch04_classAndInterface.sec28_perferList.ChooserGoodEx;

@DisplayName("perferListクラスのテスト")
public class Sec28Test {

    private List<String> LIST = List.of("A", "B", "C");
    // 比較内容 - choiceメソッドの返却値が、リスト内のいずれかの要素に一致したらtrueを返却する。
    Predicate<String> hasListElement = s -> LIST.stream()
            .anyMatch(element -> element.equals(s));

    @Nested
    class ChooserBadExクラス {

        @Test
        void choiceメソッドのテスト_渡したリストからランダムな要素をひとつ返却する() {
            var cb = new ChooserBadEx(LIST);
            // choiceメソッドの仕様上、Object型からキャストしなければならない
            String result = (String) cb.choice();
            // テスト実施
            assertTrue(hasListElement.test(result), result);
        }
    }
    @Nested
    class ChooserGoodExクラス {
        @Test
        void choiceメソッドのテスト_渡したリストからランダムな要素をひとつ返却する() {
            var cg = new ChooserGoodEx<String>(LIST);
            String result = cg.choice();
            // テスト実施
            assertTrue(hasListElement.test(result), result);
        }
    }
}
