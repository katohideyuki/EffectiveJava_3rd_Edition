package dubug;

/**
 * debug用クラス
 * 受け取った文字列を出力するだけ
 */
public class Debug {
    /* メソッド名 出力用 */
    public static void log(String methodName) {
        System.out.println("""
                %n------------------------------------------
                  %sの使用例
                ------------------------------------------ """.formatted(methodName));
    }
}
