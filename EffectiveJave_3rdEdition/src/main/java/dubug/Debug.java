package dubug;

/** debug用クラス */
public class Debug {

    /* メソッド名 出力用 */
    public static void log(String methodName) {
        System.out.println("""
                %n------------------------------------------
                  %sの使用例
                ------------------------------------------ """.formatted(methodName));
    }

    /**
     * 処理計測用 - 開始
     * @return メソッド処理開始時刻
     */
    public static long start() {
        return System.currentTimeMillis();
    }

    /**
     * 処理計測用 - 終了
     * メソッド処理にかかった時間を出力する。
     * @param startTime メソッド処理開始時刻
     */
    public static void end(long startTime) {
        long endTime = System.currentTimeMillis();
        System.out.printf("%sms %n", (endTime - startTime));
    }
}
