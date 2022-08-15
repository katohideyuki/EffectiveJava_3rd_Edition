package ch06_enumAndAnotations.sec38_ExtensibleEnum;

/** インタフェースを使って模倣された拡張可能なenum - その1 */
public enum BasicOperation implements Operation {
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*"){
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/"){
        public double apply(double x, double y) { return x / y; }
    };

    private final String symbol;

    /** コンストラクタ */
    BasicOperation(String symbol) {
        this.symbol = symbol;
    }
    @Override
    public String toString() {
        return symbol;
    }
}
/**
 * enum型を拡張することはできない。（できたとしても、すべきではない)
 * 代わりに、インタフェースを実装し、擬似的にenumを拡張している風に見せる。
 * ※ enum型でもインタフェースを実装することができる。
 */