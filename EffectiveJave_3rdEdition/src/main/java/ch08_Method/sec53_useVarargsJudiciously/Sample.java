package ch08_Method.sec53_useVarargsJudiciously;

public class Sample {

    /**
     * int引数のシーケンスを受け取り、合計を返す。
     * @param args
     * @return 合計値
     */
    public static int sum(int... args) {
        int sum = 0;
        for (int arg : args)
            sum += arg;
        return sum;
    }

    /**
     * ※1
     * 1個以上の引数を渡すために可変長引数を利用する誤った方法
     * @param args
     * @return 最小値
     * @throws IllegalArgumentException 引数が0個の場合
     */
    public static int minBadEx(int... args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Too few arguments");
        int min = args[0];
        for (int i = 1; i < args.length; i++)
            if (args[i] < min)
                min = args[i];
        return min;
    }

    /**
     * ※2
     * 1個以上の引数を渡すための正しい可変長引数の利用方法
     * @param firstArg      必須パラメータ
     * @param remainingArgs オプションパラメータ
     * @return 最小値
     */
    public static int minGoodEx(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }
}
/**
 * 可変長引数は、呼び出し時点で渡された引数の数と同じ大きさの配列を最初に生成し、
 * その配列に引数の値を入れ、最後にその配列をメソッドに渡すことで行われている。
 *
 * パフォーマンスが重要な状況で可変長引数を使う場合は注意する。
 * 可変長引数メソッドの呼び出しは、毎回配列を割り当てて初期化する。
 *
 * 可変長引数を使用する目安
 *  - 95%の確率で、そのメソッド呼び出されるとき引数が3つ以下である。
 *  - 5%の確率で引数4つ以上である。
 *    - その場合は、可変長引数を含む5つのオーバーロードを用意する
 *      - public void foo() {}                                    // 引数なし
 *      - public void foo(int a1) {}                              // 引数1つ
 *      - public void foo(int a1, int a2) {}                      // 引数2つ
 *      - public void foo(int a1, int a2, int a3) {}              // 引数3つ
 *      - public void foo(int a1, int a2, int a3, int... rest) {} // 可変長引数
 *
 * ※1
 * 問題点
 *  - 引数なしでこのメソッドを実行した場合、コンパイル時ではなく実行時に失敗する
 *    こと。
 *  - minをInteger.MAX_VALUEへ初期化しなければ、for-eachループが使えない。
 *
 * ※2
 * 指定された型の通常のパラメータを1つと、その型の可変長引数のパラメータを1つ受け
 * 取るようにメソッドを宣言する。
 */