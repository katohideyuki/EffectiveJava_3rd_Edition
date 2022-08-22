package ch07_lambdaAndStream.sec47_streamThanColleciton;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 戻り値型としてStreamよりもCollectionを選ぶ */
public class PowerSet {

    /**
     * 引数で受け取ったSetコレクションのべき集合を、特別なコレクションとして返す
     * @param  Set型オブジェクト<E>
     * @return Set型を扱う特別なコレクション - 匿名クラスAbstractList
     */
    public static final <E> Collection<Set<E>> of(Set<E> s) {
        // 引数のSet型をListに変換
        List<E> src = new ArrayList<>(s);

        // リストのサイズが30以上だったら例外
        if (src.size() > 30)
            throw new IllegalArgumentException("Set too big " + s);

        // 匿名クラスAbstractListを返却する
        return new AbstractList<Set<E>>() {
            /* 2のsrc.size()乗 左へビットシフト */
            @Override public int size() {
                return 1 << src.size();
            }
            /* 引数がSet型であり、srcリストと中身が同じであるか */
            @Override public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set)o);
            }
            /* リスト内の指定された位置にある要素を返却 */
            @Override public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1)
                    if ((index & 1) == 1)
                        result.add(src.get(i));
                return result;
            }
        };
    }
}
/**
 * 使用する側がループしたいかもしれないし、SubListsクラスのようにストリームとして処理
 * したいかもしれない。
 * ということで、両方に適応できるようコレクションを返せるなら、そうすべきである。
 */