package ch09_GeneralProgramming.sec63_StinrgConcatenation;

import dubug.Debug;

public class Sample {
    private static final int NUM_REPETITIONS = 50_000;  // 繰り返し上限数

    public static void main(String[] args) {
        statementBadEx();
        statementGoodEx();
    }

    /**
     * ※1
     * 文字列結合の不適切な使用 - ひどいパフォーマンス
     */
    private static void statementBadEx() {
        Debug.log("statementBadEx");
        long s = Debug.start();

        // 文字列結合
        String str = "";
        for (int i = 0; i < NUM_REPETITIONS; i++)
            str += String.valueOf(i);

        System.out.printf("length = %s%n", str.length());  // 処理時間:1469ms
        Debug.end(s);
    }

    /** 文字列ビルダー使用 */
    private static void statementGoodEx() {
        Debug.log("statementGoodEx");
        long s = Debug.start();

        // 文字列ビルダー
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < NUM_REPETITIONS; i++)
            b.append(String.valueOf(i));

        System.out.printf("length = %s%n", b.length()); // 処理時間:4ms
        Debug.end(s);
    }
}
/**
 * 繰り返し文字列結合を行う時は、StringBuilderを使用すること。
 * ※ StringBuilderはスレッドセーフではないので、注意する。
 *
 * ※1
 * Stringは不変なため、+で結合されるたびに新たなインスタンスが生成されている。
 */
