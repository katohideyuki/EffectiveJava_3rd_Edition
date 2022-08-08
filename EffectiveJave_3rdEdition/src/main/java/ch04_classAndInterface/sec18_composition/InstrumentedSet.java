package ch04_classAndInterface.sec18_composition;

import java.util.Collection;
import java.util.Set;

/**
 * ラッパークラス
 * 継承の代わりに、コンポジションを使っている。
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {

    // 行われた要素の挿入回数
    private int addCount = 0;

    /**
     * コンストラクタ
     * @param Setインスタンス
     */
    public InstrumentedSet(Set<E> s) {
        super(s);
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
 * 継承の指針
 * サブラクスB, スーパークラスAがあった場合
 * クラスBは、クラスAとの間に「is-A」関係が存在している場合にだけ、クラスAを拡張すべきである。
 * クラスBにクラスAを拡張させたいならば、「すべてのBはAであるか」を自問する。
 * 答えが「No」なら、BはAを拡張すべきではない。
 * その場合は、BはAのインスタンスをprivateとして保持して、異なるAPIを外部に公開すべきである。
 */
