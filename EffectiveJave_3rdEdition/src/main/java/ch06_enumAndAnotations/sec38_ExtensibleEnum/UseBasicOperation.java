package ch06_enumAndAnotations.sec38_ExtensibleEnum;

import java.util.Collection;
import java.util.List;

/** BasicOperationの使用例 */
public class UseBasicOperation {
    public static void main(String[] args) {
        exe();
    }

    private static void exe() {
        double x = 5.0;
        double y = 2.0;
        test(List.of(BasicOperation.values()), x, y);
    }

    /**
     * BasicOperationクラスの列挙定数すべてのapplyメソッドを実行し、出力する。
     * 安全性も考慮し、インタフェース型(Operation型)で取得できるよう、境界ワイルドカードを使用する。
     * @param of リストでラップした列挙定数の配列
     * @param x  double値
     * @param y  double値
     */
    private static void test(Collection<? extends Operation> of,
            double x, double y) {
        for (Operation op : of)
            System.out.printf("%f %s %f = %f%n", x, op, y, Math.floor(op.apply(x, y)));
    }
}
