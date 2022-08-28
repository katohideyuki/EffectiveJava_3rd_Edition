package ch08_Method.sec52_useOverLoadingJudiciously;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 不完全 - このプログラムは何を表示するか */
public class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> lst) {
        return "List";
    }

    public static String classify(Collection<?> c) {
        return "Unknown Collection";
    }

    /**
     * 3種類のコレクションを扱う配列を生成し、
     * それぞれのコレクションに対してオーバーロードされたclassifyメソッドを実行する。
     * @param args
     */
    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
                };

        for (Collection<?> c : collections)
            System.out.println(classify(c));  // すべて「Unknown Collection」が表示される
    }
}
/**
 * オーバーロードは、コンパイル時に呼び出すメソッドが決定される。
 *
 * classifyメソッドはオーバーロードされており、オーバーロードされたどのメソッドが呼び
 * 出されるかの選択はコンパイル時に行われる。
 * 3回のイテレーションに関しては、パラメータのコンパイル時の型は同一のCollection<?>。
 * 各イテレーションでは実行時の型は異なるが、オーバーロードされたメソッドの選択に影響さ
 * れない。
 * パラメータのコンパイル時の型はCollection<?>なので、適用可能な唯一のオーバーロード
 * されたメソッドは3つ目のclassify(Collection<?>)であり、
 * イテレーションの中では毎回このオーバーロードされたメソッドが呼び出される。
 */