package ch09_GeneralProgramming.sec57_MinimizeScope;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.element.Element;

public class Sample {
    private static List<Element> c = new ArrayList<>();
    private static List<Element> c2 = new ArrayList<>();

    /**
     * ※1
     * whlieループよりもforループが良いと思える。
     */
    private static void sample_02() {
        // 1つ目のwhile文
        Iterator<Element> i = c.iterator();
        while (i.hasNext())
            doSomething(i.next());

        // 1つ目のwhile文をコピペして作った、2つ目のwhile文(そのままコピペした場合、バグ発生)
        Iterator<Element> i2 = c2.iterator();
        while (i.hasNext())
            doSomethingElse(i2.next());
    }

    /** 何かするメソッド */
    private static void doSomething(Element next)     { /* do something */ }
    private static void doSomethingElse(Element next) { /* do something */ }

}
/**
 * ローカル変数のスコープを最小限にすることで、コードの可読性と保守性が向上する
 *
 * 宣言すべきタイミング
 *  - ローカル変数が初めて使われたとき。(使う直前ではなく、使うとき)
 *
 * 宣言すべきではないタイミング
 *  - ローカル変数をブロックの先頭で宣言すること。
 *  - 使う直前で宣言すること。
 *
 * ループが終了した後にループ変数を使う必要がないなら、whileではなくforループを使うこと。
 *
 * ※1
 * コピペを想定した誤った例
 * 新しいループ変数i2を初期化しているが、誤ってスコープ内にある変数iを使っている。
 * 結果、コンパイルは何も知らせず、そのまま誤った処理をする。
 *  - c2のループをするつもりだったが、実行した結果2つ目のループは即終了し、
 *    c2が空だという誤った結果になる。
 *
 * これが、for-eachかforループを使っていれば、2つ目の繰り返し文でコンパイルエラーになるので
 * すぐ気づける。
 */