package dubug;

/**
 * debug用クラス
 * 受け取った文字列を出力するだけ
 */
public class Debug {
    public static void log(String methodName) {
        System.out.println("""
                -----------------------------
                 ▼ %sの使用例
                ----------------------------- """.formatted(methodName));
    }
}
