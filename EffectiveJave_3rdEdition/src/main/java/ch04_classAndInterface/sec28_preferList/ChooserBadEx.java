package ch04_classAndInterface.sec28_preferList;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/** ジェネリックが必要なクラス */
public class ChooserBadEx {
    // オブジェクト型の配列
    private final Object[] choiceArray;

    /** コンストラクタ */
    public ChooserBadEx(Collection choices) {
        choiceArray = choices.toArray();
    }

    /**
     * 配列の要素をランダムにひとつ返却する。
     * Object型で返却するため、戻り値を受け取る際はキャストする必要がある。
     * @return ランダムな要素
     */
    public Object choice() {
        Random rnd = ThreadLocalRandom.current(); // ※1
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
/**
 * choiceメソッドの受け取り時に間違ったキャストを行うと、
 * 実行時にClassCastExceptionがスローされる。
 * ※1 スレッドでクラス変数を使う場合は、ThreadではなくThreadLocalクラスを使用する。
 *    ThreadLocalクラスを使用しているときに、乱数を使用する場合はThreadLocalRandomクラスを使用する。
 *    Math.Randomクラスを使用すると、極端に遅い可能性がある。
 */