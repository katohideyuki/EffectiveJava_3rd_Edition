package ch04_classAndInterface.sec18_composition;

import java.util.Collection;
import java.util.HashSet;

/**
 * 不完全 - 継承の不適切な使用。
 * プログラムのパフィーマンスをチューニングするため、
 * HashSetが生成されてからどれだけの数の要素が追加されたかを、HashSetに問い合わせる。
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

    // 行われた要素の挿入回数
    private int addCount = 0;

    /** コンストラクタ */
    public InstrumentedHashSet() {}

    /** コンストラクタ */
    public InstrumentedHashSet(int initCap, float loadFactory) {
        super(initCap, loadFactory);
    }

    @Override /** 挿入回数をインクリメントし、要素を追加する */
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override /** 要素数分、挿入回数をインクリメントし、複数の要素を追加する */
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    /** getter */
    public int getAddCount() {
        return addCount;
    }
}

/**
 * HashSetのaddAllメソッドは内部でaddメソッドを使って実装されているため、
 * InstrumentedHashSetのaddAllメソッドを実行すると、addCountに3を足して、
 * それからsuper.addAllメソッドを使って、HashSetのaddAllメソッドを呼び出す。
 * その呼び出しは、個々のInstrumentedHashSetでオーバーライドされたaddメソッド
 * を準に呼び出すため、さらにaddCountを計3回インクリメントする。
 * つまり、二重にカウントされていることになる。
 */