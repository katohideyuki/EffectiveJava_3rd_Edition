package ch04_classAndInterface.sec19_constructors;

import java.time.Instant;

public class Sub extends Super {

    // コンストラクタにより設定されるブランクfinal
    private final Instant instant;

    /**
     * コンストラクタ
     * エポック時間を取得する。
     * 暗黙的にスーパークラスであるSuperクラスのコンストラクタを呼び出している。
     */
    Sub() {
        instant = Instant.now();
    }

    /**
     * スーパークラスのコンストラクタから呼び出される
     * オーバーライドしているメソッド。
     */
    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
/**
 * コンストラクタSubがinstantフィールドを初期化する前に、
 * オーバーライドしたoverrideメソッドが、Superクラスのコンストラクタから呼び出されている。
 * 結果、Superクラスからoverrideメソッドが呼び出され、nullが出力される。
 * そのあと、mainメソッドのoverrideメソッドから初期化されたinstantが出力される。
 *
 * 結論、サブクラスの必要性がないのであれば、基本的にクラスはfinalと宣言すべし。
 * 継承を目的としたクラスを設計するのは、大変である。
 */