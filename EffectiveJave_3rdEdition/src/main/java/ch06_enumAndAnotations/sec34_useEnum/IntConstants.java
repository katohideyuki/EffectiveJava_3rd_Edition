package ch06_enumAndAnotations.sec34_useEnum;

/** int enumパターン　- 不完全 */
public class IntConstants {
    public static final int APPLE_FUJI         = 0;
    public static final int APPLE_PIPPIN       = 1;
    public static final int APPLE_GRANNY_SMITH = 2;

    public static final int ORANGE_NAVEL  = 0;
    public static final int ORANGE_TEMPLE = 1;
    public static final int ORANGE_BLOOD  = 2;
}
/**
 * int enumパターン
 *   - 型安全ではない。
 *   - 表現力がない。
 *   - オレンジを期待しているメソッドにアップルを渡したり、
 *     オレンジとアップルを==演算子で比較したりしても、コンパイルエラーにならない。
 */