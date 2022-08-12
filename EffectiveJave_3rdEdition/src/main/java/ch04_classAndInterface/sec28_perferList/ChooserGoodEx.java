package ch04_classAndInterface.sec28_perferList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/** リストに基づくChooser - 安全性 */
public class ChooserGoodEx<T> {
    // 総称型のリスト
    private final List<T> choiceList;

    /** コンストラクタ */
    public ChooserGoodEx(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    /**
     * リストの要素をランダムにひとつ返却する。
     * @return ランダムな要素
     */
    public T choice() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
/**
 * ChooserBadExクラスに比べて、ClassCastExceptionがスローされる可能性がない。
 * 配列とジェネリックスが混在していて、コンパイルエラーや警告が出る場合は、
 * まず配列をリストに置換してみるのがよい手段である。
 */
