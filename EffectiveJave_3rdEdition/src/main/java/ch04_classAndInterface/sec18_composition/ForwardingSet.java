package ch04_classAndInterface.sec18_composition;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * 再利用可能な転送クラス
 * Setインタフェースを実装する。
 */
public class ForwardingSet<E> implements Set<E> {

    // Setインスタンス
    private final Set<E> s;

    /**
     * コンストラクタ
     * @param Setインスタンス
     */
    public ForwardingSet(Set<E> s) { this.s = s; }

    /** Setインタフェースの抽象メソッド */
    public void clear()                              { s.clear(); }
    public boolean contains(Object o)                { return s.contains(o); }
    public boolean isEmpty()                         { return s.isEmpty(); }
    public int size()                                { return s.size(); }
    public Iterator<E> iterator()                    { return s.iterator(); }
    public boolean add(E e)                          { return s.add(e); }
    public boolean remove(Object o)                  { return s.remove(o); }
    public boolean containsAll(Collection<?> c)      { return s.contains(c); }
    public boolean addAll(Collection<? extends E> c) { return false; }
    public boolean removeAll(Collection<?> c)        { return false; }
    public boolean retainAll(Collection<?> c)        { return false; }
    public Object[] toArray()                        { return null; }
    public <T> T[] toArray(T[] a)                    { return null; }

    @Override
    public boolean equals(Object o) { return s.equals(o); }
    @Override
    public int hashCode()           { return s.hashCode(); }
    @Override
    public String toString()        { return s.toString(); }
}

/**
 * 既存のクラスを継承するのではなく、いま現在の既存のクラスをprivateフィールドに保持する。
 * スーパークラスの拡張による悪影響を最小限に抑え、サブクラスで実装したメソッドを担保する。
 *  悪影響とは
 *  - スーパークラスの実装の詳細が変更されると、サブクラスで意図した振る舞いではなくなる。
 *  - スーパークラスで後から追加したメソッドのシグニチャが、サブクラスで実装したメソッドと
 *    競合を起こす可能性がある。
 *
 * 感想
 * インタフェースを模倣することで、期待通りの動きをサブクラスに提供していると理解している。
 * 確かに、スーパークラスの拡張による影響が、サブクラスには出にくくなるが、
 * インタフェースの良さも薄まっているとも感じる。
 * 例えば、インタフェースに修正が入り、その修正は絶対に修正すべき内容だった場合、
 * 模倣しているこの転送クラスにも、その修正を加える必要があるかもしれない。
 * 結果、メンテナンスするクラスが増える。
 * けど、インタフェースの拡張による、意図しない不具合を防げているから良いことなのかも。
 */
