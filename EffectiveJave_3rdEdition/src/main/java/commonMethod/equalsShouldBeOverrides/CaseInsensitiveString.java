package commonMethod.equalsShouldBeOverrides;

import java.util.Objects;

/** equals をオーバーライトするときは一般契約に従う */
public final class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override /* 不完全 - 対称性を守っていない */
    public boolean equals(Object o) {
        // 同一の型であれば、文字列を比較
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
        // String型であれば、文字列を比較 - 一方向の相互作用 ※1
        if (o instanceof String)
            return s.equalsIgnoreCase((String) o);
        return false;
    }

    /** 正しい equals のオーバーライド - 本来はネストしたクラスにする必要なし ※2 */
    static class CorrectCis {
        private final String str;

        public CorrectCis(String str) {
            this.str = Objects.requireNonNull(str);
        }

        @Override /* equals メソッドから String とうまく機能させようとする必要はない
                     型および文字列の比較 */
        public boolean equals(Object o) {
            return o instanceof CorrectCis &&
                    ((CorrectCis) o).str.equalsIgnoreCase(str);
        }
    }
}

/**
 * <pre>
 * Objects.requireNonNull(引数)
 *   - 引数が null なら nullPointerException をスローする
 *
 * equalsIgnoreCase()
 *   - 大文字・小文字を区別せずに比較
 *
 * ※1
 * CaseInsensitiveString.equals(String s) のときは問題ないが、
 * s.equals(CaseInsensitiveString cis) のとき、大文字・小文字の区別がされない
 *
 * ※2
 * 一つのファイルに同じシグニチャの equals を二つ定義したかったから、ネストしたクラスを作成した
 *   - 間違ったオーバーライドと、正しいオーバーライドを定義したかったため
 *   - 本来は、正しい equals のオーバーライドを記述すればよいだけで、ネストしたクラスは必要ない　　
 * </pre>
 */