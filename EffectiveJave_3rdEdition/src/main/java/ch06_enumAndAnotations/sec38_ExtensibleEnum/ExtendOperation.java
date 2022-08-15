package ch06_enumAndAnotations.sec38_ExtensibleEnum;

/** インタフェースを使って模倣された拡張可能なenum - その2 */
public enum ExtendOperation implements Operation {
    EXP("^") {
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    /** コンストラクタ */
    ExtendOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
