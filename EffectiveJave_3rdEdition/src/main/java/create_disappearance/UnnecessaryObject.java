package create_disappearance;

import java.util.regex.Pattern;

/** 不必要なオブジェクトの生成を避ける */
public class UnnecessaryObject {
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$"); // パターンはフィールドに定義

    /* 文字列が正当なローマ数字か判定 - 悪い例 */
    static boolean bad_isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    /* 文字列が正当なローマ数字か判定 - 良い例 */
    static boolean good_isRomanNumeral(String s) {
        return ROMAN.matcher(s).matches();
    }
}

/**
 * <pre>
 * bad_isRomanNumeral
 *   - isRomanNumeral が呼び出されるたびに、matches() に渡している Pattern インスタンスが生成される
 *     - そのインスタンスはその場だけ使われ、その後はガベージコレクションの対象になっている。
 *
 * good_isRomanNumeral
 *   - フィールドにパターンを定義することで、isRomanNumeral メソッドが呼び出されるたびに
 *     Pattern インスタンスが不必要に生成されるのを防ぐ
 *
 * </pre>
 */