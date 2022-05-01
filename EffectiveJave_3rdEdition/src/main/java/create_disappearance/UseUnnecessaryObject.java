package create_disappearance;

import dubug.Debug;

/** 不必要なオブジェクトの生成を避ける */
public class UseUnnecessaryObject {
    static final String OK_MESSAGE = "This is Roman numeral!";     // ローマ数字の時に出力する文字列
    static final String NO_MESSAGE = "This is not Roman numeral!"; // ローマ数字じゃない時に出力する文字列

    public static void main(String[] args) {
        use_bad_isRomanNumeral();
        use_good_isRomanNumeral();
    }

    /* bad_isRomanNumeralメソッドの使用例 */
    private static void use_bad_isRomanNumeral() {
        Debug.log("UnnecessaryObject.bad_isRomanNumeral");
        var start = System.currentTimeMillis();              // 処理開始時刻

        // ローマ数字を判定
        for (var val : RomanNumeral.values()) {
            if (UnnecessaryObject.bad_isRomanNumeral(val.romanNum))
                System.out.printf(" %s : %s %n", val, OK_MESSAGE);
            else
                System.out.printf(" %s : %s %n", val, NO_MESSAGE);
        }

        var end = System.currentTimeMillis();                // 処理終了時刻
        System.out.printf(" 実行時間 : %d秒 %n", end - start); // 約4秒
    }

    /* good_isRomanNumeralメソッドの使用例 */
    private static void use_good_isRomanNumeral() {
        Debug.log("UnnecessaryObject.good_isRomanNumeral");
        var start = System.currentTimeMillis();              // 処理開始時刻

        // ローマ数字を判定
        for (var val : RomanNumeral.values()) {
            if (UnnecessaryObject.good_isRomanNumeral(val.romanNum))
                System.out.printf(" %s : %s %n", val, OK_MESSAGE);
            else
                System.out.printf(" %s : %s %n", val, NO_MESSAGE);
        }

        var end = System.currentTimeMillis();                // 処理終了時刻
        System.out.printf(" 実行時間 : %d秒 %n", end - start); // 約1秒
    }

    /** ローマ数字を扱う static なネストした Enum クラス - 検証用 */
    static enum RomanNumeral {
        I("I"), V("V"), Y("Dummy"), X("X"),
        C("C"), D("D"), P("Dummy"), M("M");                // Y と P はローマ数字ではない

        private final String romanNum;
        RomanNumeral(String str) { this.romanNum = str; }  // コンストラクタ
        private String romanNum() { return romanNum; }
    }
}
