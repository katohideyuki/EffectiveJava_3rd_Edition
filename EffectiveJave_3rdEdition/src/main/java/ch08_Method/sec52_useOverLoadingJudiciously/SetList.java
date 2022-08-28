package ch08_Method.sec52_useOverLoadingJudiciously;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import dubug.Debug;

public class SetList {

    public static void main(String[] args) {
        badEx();
        goodEx();
    }

    /**
     * ※1
     * Set, Listそれぞれに対して、-3 ~ 2の値を追加する。
     * 0 ~ 2の値を削除し、要素を-3 ~ -1 のみにする。
     * 期待通りにならない。
     */
    private static void badEx() {
        Debug.log("badEx");
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        // [-3, -2, -1, 0, 1, 2]の値を追加していく
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        // [0, 1, 2]を削除して[-3, -2, -1]だけにする
        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
        }
        System.out.println(set + " " + list);   // [-3, -2, -1] [-2, 0, 2]
    }

    /**
     * ※2
     * Set, Listそれぞれに対して、-3 ~ 2の値を追加する。
     * 0 ~ 2の値を削除し、要素を-3 ~ -1 のみにする。
     * 期待通り。
     */
    private static void goodEx() {
        Debug.log("goodEx");
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        // [-3, -2, -1, 0, 1, 2]の値を追加していく
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        // [0, 1, 2]を削除して[-3, -2, -1]だけにする
        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(Integer.valueOf(i));
        }
        System.out.println(set + " " + list);   // [-3, -2, -1] [-2, 0, 2]
    }
}
/**
 * 同じ引数の数でメソッドをオーバーロードすることは避ける。
 *  - 同じ引数の数でオーバーロードする場合は、違うメソッド名でメソッドを作る。
 *  - コンストラクタの場合は不明。キャストできないような関係であれば良いらしい。
 *
 * ※1
 * 直感的には、[-3, -2, -1] [-3, -2, -1]の表示を期待しているが、
 * 実際は[-3, -2, -1] [-2, 0, 2]と異なる。
 * set.removeは期待通りになっているが、list.removeが期待通りではない。
 * list.removeはint型を引数に取るremoveメソッドがオーバーライドされていた。
 * つまり、Listインタフェースはremove(Object o)とremove(int index)の2つの
 * removeメソッドを持っていたことにより、setとlistで結果が異なってしまった。
 *
 * Set.remove(Object o)
 *   - 引数で渡した値がセットに存在すれば、削除してtrueを返却する。
 *   - 存在しない場合は、falseを返却する。
 *
 * List.remove(int index)
 *   - 引数で渡したインデックス番号の要素を削除する。
 *   - 存在しないインデックス番号の要素を渡した場合、IndexOutOfBoundsExceptionをスローする。
 *
 * ※2
 * 期待通りにするための修正案
 *  方法1. list.removeの引数をIntegerにキャストする
 *  方法2. 引数に対してInteget.valueOfを呼び出し、その結果をlist.removeに渡す。
 */