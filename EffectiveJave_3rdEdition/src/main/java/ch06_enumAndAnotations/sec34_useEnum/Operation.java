package ch06_enumAndAnotations.sec34_useEnum;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* 値によって切り替えるenumクラス - 定数固有メソッドの実装 */
public enum Operation {
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    /**　コンストラクタ */
    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() { return symbol; }

    /* 定数内でオーバーライドしてもらうための抽象メソッド */
    public abstract double apply(double x, double y);

    /** Operation定数が生成された後に実行され、キーと値が同値のMapが生成される */
    public static final Map<String, Operation> STRING_TO_ENUM_MAP =
            Stream.of(values()).collect(
                    Collectors.toMap(Object::toString, Function.identity()));

    /**
     * 引数の値がMapに存在すれば、その文字列に対する値を返却する。
     * getterみたい?よくわからない。
     * @param  symbol Operationの値を表現した文字列
     * @return Operationの値
     */
    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(STRING_TO_ENUM_MAP.get(symbol));
    }
}

/**
 * 各定数ごとに固有の振る舞いを持たせたいなら、定数固有メソッドを検討する
 *   - enum型で抽象メソッドを宣言し、定数ごとにオーバーライドする
 *     新しく定数を追加した際に、メソッドの提供を忘れなくなる　
 *
 * enum型でtoStringをオーバーライドするなら、
 * カスタム文字列表現に対応するfromStringメソッドを書くのがよい
 */
