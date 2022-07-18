package classAndInterface.MinimizeAccess;

/**
 * 不変な複素数クラス ※3
 * 4つの基本的な算術操作である、足し算、引き算、掛け算、割り算を提供する。
 * インスタンスを変更するのではなく、新たなインスタンスを生成して、関数を適用した結果を返却する。
 */
public class Complex {
    private final double re;
    private final double im;

    // 頻繁に使われる値に対しては、定数を提供する
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE  = new Complex(1, 0);
    public static final Complex I    = new Complex(0, 1);

    /* private コンストラクタ */
    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /* コンストラクタの代わりに static ファクトリメソッドを持つ ※2 */
    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    /* 各 getter */
    public double realPart()      { return re; }
    public double imaginaryPart() { return im; }

    /* 足し算 */
    public Complex plux(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    /* 引き算 */
    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }

    /* 掛け算 */
    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im,
                           re * c.im + im * c.re);
    }

    /* 割り算 */
    public Complex divideBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                           (im * c.re - re * c.im) / tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Complex))
            return false;
        Complex c = (Complex) o;

        // float, double とかは非数(NaN)があるので、「==」ではなく compare を使用する　※1
        return Double.compare(c.re, re) == 0
            && Double.compare(c.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return String.format("( %s + %s %i )", re, im);
    }
}

/**
 *<pre>
 * クラスを不変にする5つの規則
 * 1. オブジェクトの状態を変更するためのメソッドを提供しない
 *      - set メソッドはなるべく提供しない。
 * 2. クラスを拡張できないようにする
 * 3. すべてのフィールドを final にする
 * 4. すでてのフィールドを private にする
 * 5. 可変コンポーネントに対する独占的アクセスを保証する
 *      - 何かを返却するときは copy を使う
 *
 * ※1 +0.0 と -0.0 は、Java では同値と見なされるが、equals メソッドでは false となる
 *     ハッシュ値が関係しているようで、Double オブジェクトでは同値とならない仕様。
 *
 * ※2 不変性を保証するために、クラスはサブクラス化を許してはいけない。
 *    クラスを final にすることで行えるが、以下のような柔軟な方法をとる。
 *      - クラスは final にせず、コンストラクタを private にする。
 *      - public コンストラクタの代わりに、public の static ファクトリメソッドを追加する。
 *
 * ※3 例として作成したComplex クラスは、不変性を示すだけのものである。
 *    複素数の乗算と除算に対して、標準の式を使っており、正確な丸めは行ってなく、複素数の NaN や
 *    無限大に対する十分なセマンティックスを提供していない。
 *
 * メリット
 *  - インスタンス生成時に分かりやすい名前をつけることができる
 *      - シグニチャの違うコンストラクタが複数ある場合に役立つ
 *  - 不要なインスタンスが生成されるのを防ぐ
 *      - super();など
 *
 * デメリット
 *  - 利用する側が、static ファクトリメソッドを見つけづらい
 *      - Javadoc でコンストラクタは別のセクションで表示されているから見つけやすいが、
 *        static ファクトリメソッドは、メソッド一覧に埋もれてしまう
 *</pre>
 */