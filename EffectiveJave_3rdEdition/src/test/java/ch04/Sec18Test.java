package ch04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.TreeSet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import ch04_classAndInterface.sec18_composition.*;

@DisplayName("InstrumentedHashSetTestクラスは、要素を追加した分だけ挿入回数をインクリメントする")
public class Sec18Test {

    @Nested
    class InstrumentedHashSetクラスのテスト{
      @Test /** 二重にカウントされており、6を返却し失敗する */
      void _3つの要素を追加するため_挿入回数は3を返却する筈が失敗する() {
          InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
          s.addAll(List.of("Snap", "Crackle", "Pop"));
          assertEquals(3, s.getAddCount());
      }
    }

    @Nested
    class InstrumentedSetクラスのテスト{
      @Test
      void _3つの要素を追加するため_挿入回数は3を返却する() {
          InstrumentedSet<String> s = new InstrumentedSet<>(new TreeSet<>());
          s.addAll(List.of("Snap", "Crackle", "Pop"));
          assertEquals(3, s.getAddCount());
      }
    }
}
