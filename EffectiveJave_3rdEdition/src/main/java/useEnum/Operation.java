package useEnum;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 値によって切り替えるenumクラス - 定数固有メソッドの実装 */
public enum Operation {
    PLUS("+")   { public double apply(double x, double y) { return x + y; } },
    MINUS("-")  { public double apply(double x, double y) { return x - y; } },
    TIMES("*")  { public double apply(double x, double y) { return x * y; } },
    DIVIDE("/") { public double apply(double x, double y) { return x / y; } };

    private final String symbol;

    Operation(String symbol) { this.symbol = symbol; } // コンストラクタ

    @Override
    public String toString() { return symbol; }

    /* 定数内でオーバーライドしてもらうための抽象メソッド */
    public abstract double apply(double x, double y);

    /* Operation定数が生成された後に実行され、定数がSTRING_TO_ENUM_MAPへ入れられる */
    private static final Map<String, Operation> STRING_TO_ENUM_MAP =
            Stream.of(values()).collect(Collectors.toMap(Object::toString, e -> e));

    /* 存在すれば、文字列に対するOperationを返す */
    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(STRING_TO_ENUM_MAP.get(symbol));
    }
}

/**
 * <pre>
 * memo
 * - 各定数ごとに固有の振る舞いを持たせたいなら、定数固有メソッドを検討する
 *   - enum型で抽象メソッドを宣言し、定数ごとにオーバーライドする
 *     新しく定数を追加した際に、メソッドの提供を忘れなくなる　
 * - enum型でtoStringをオーバーライドするなら、カスタム文字列表現に対応するfromStringメソッドを書くのがよい
 * </pre>
 */
