package commonMethod.equalsShouldBeOverrides;

import java.awt.Color;

import commonMethod.equalsShouldBeOverrides.CaseInsensitiveString.CorrectCis;
import commonMethod.equalsShouldBeOverrides.Point.ColorPoint;
import dubug.Debug;

/** equals をオーバーライトするときは一般契約に従う */
public class UseEqualsRelated {
    public static void main(String[] args) {
        useCaseInsensitiveString();
        usePoint();
        useEOBP();
    }

    /* CaseInsensitiveString と CorrectCis の使用例 */
    private static void useCaseInsensitiveString() {
        Debug.log("CaseInsensitiveString");
        CaseInsensitiveString cis = new CaseInsensitiveString("POLISH");
        String str = "polish";
        System.out.println(cis.equals(str));       // true  : 大文字・小文字を区別しないので OK
        System.out.println(str.equals(cis));       // false : 大文字・小文字を区別してしまうので NG

        Debug.log("CorrectCis");
        CorrectCis ccis_A = new CorrectCis("POLISH");
        CorrectCis ccis_B = new CorrectCis("polish");
        System.out.println(ccis_A.equals(ccis_B)); // true  : 大文字小文字を区別しないので OK
        System.out.println(ccis_A.equals(str));    // false : 同一の型じゃないので NG
    }

    /* Point の使用例 */
    private static void usePoint() {
        Debug.log("Point");
        Point p = new Point(1, 2);
        ColorPoint cp1 = p.new ColorPoint(1, 2, Color.RED);
        ColorPoint cp2 = p.new ColorPoint(1, 2, Color.BLUE);
        System.out.println(cp1.equals(p));         // true  : 色が違うのに、同一の型だから OK
        System.out.println(p.equals(cp2));         // true  : 色が違うのに、同一の型だから OK
        System.out.println(cp1.equals(cp2));       // false : 同一の型だけど、色が違うから NG
    }

    /* EqualsOverrideBestPractice の使用例 */
    private static void useEOBP() {
        Debug.log("EqualsOverrideBestPractice");
        var eobp_A = new EqualsOverrideBestPractice((short)012, 345, 6789); // ※1
        var eobp_B = new EqualsOverrideBestPractice((short)987, 654, 3210);
        var eobp_C = new EqualsOverrideBestPractice((short)012, 345, 6789);
        System.out.println(eobp_A.equals(eobp_C)); // true  : 同一の型で、保持している値も同じ OK
        System.out.println(eobp_A.equals(eobp_B)); // false : 同一の型で、保持している値が違う NG
    }
}

/**
 * <pre>
 * ※1
 * 暗黙的に int型になってしまうため、short型を引数に渡す場合、以下いずれかの対応が必要
 *   - short型にキャスト
 *   - short型を明示的に定義し、その変数を渡す
 * </pre>
 */
