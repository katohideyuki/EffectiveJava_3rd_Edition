package ch08_Method.sec49_checkParameters;

import java.math.BigInteger;
import java.util.Objects;

public class Sample {

    /**
     * ※1
     * 値が(this mod m)であるBigIntegerを返します。
     * このメソッドは、remainderメソッドとは異なり、常に負でないBigIntegerを返します。
     * @param m 正でなければならないモジュラス
     * @return  thisに対するmod m
     * @throws  ArithmeticException m <= 0の場合
     */
    public BigInteger modBadEx(BigInteger m) {
        if (m.signum() <= 0)
            throw new ArithmeticException("Modulus <= 0:" + m);
        return m;
    }

    /**
     * ※2
     * nullチェックを追加したバージョン
     */
    public BigInteger modGoodEx(BigInteger m) {
        // nullチェック
        Objects.requireNonNull(m, "m");
        if (m.signum() <= 0)
            throw new ArithmeticException("Modulus <= 0:" + m);
        return m;
    }

    /**
     * ※3
     * アサーションによるパラメータ検査
     */
    private static void sort(long a[], int offset, int length) {
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
        /* do something */
    }
}
/**
 * メソッドやコンストラクタを書く場合、その都度、そのパラメータにどのような制約が
 * 存在するかを考えるべき。
 *
 * publicとprotectedのメソッドに対しては、
 * パラメータ値に関する制約が守られていない場合にスローする例外を
 * Javadocの@throwsタグを使って文書化すること。
 *
 * ※1
 * m.signum()の呼び出しの副作用として、
 * modメソッドがNullPointerExceptionをスローするにも関わらず、
 * ドキュメントには「mがnullならばmodはNullPointerExceptionをスローする」と述べていない。
 *
 * m.signum()
 *  - このBigIntegerの符号を返却する。
 *    - 負の場合  -1
 *    - ゼロの場合 0
 *    - 正の場合   1
 *
 * ※2
 * Java7で追加されたObjects.requireNonNullメソッドは柔軟かつ便利なので、
 * null検査を手作業で行う必要はありません。
 *
 * Objects.requireNonNull()
 *  - 指定されたオブジェクト参照がnullでないこと確認する。
 *  - メソッドとコンストラクタでパラメータを検証することを主な目的として設計されている。
 *
 * ※3
 * デフォルト修飾子やprivateのメソッドに対しては、アサーションを用いてパラメータを検査できる。
 * アサーションは条件が成り立たなければAssertErrorをスローする。
 * javaコマンドに-ea(あるいは、enableassertions)フラグを渡してアサーションを有効に
 * しない限り、アサーションは何の効果もない。
 */