package commonMethod.equalsShouldBeOverrides;

/** equals をオーバーライトするときは一般契約に従う
    電話番号を扱うクラス */
public final class EqualsOverrideBestPractice {
    private final short areaCode, prefix, lineNum;

    public EqualsOverrideBestPractice(short areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    /**
     * 受け取った番号が正常な値かどうか判断し、不正値であればエラーメッセージを出力
     * @param val  番号
     * @param max  最大値
     * @param args エラーメッセージ
     * @throws IllegalArgumentException 番号が不正の場合
     * @return 番号
     */
    private static short rangeCheck(int val, int max, String args) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(args + ": " + val);
        return (short) val;
    }

    @Override /* 正しく equals をオーバーライドする */
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EqualsOverrideBestPractice))
            return false;
        var eobp = (EqualsOverrideBestPractice) o;
        return eobp.lineNum == lineNum && eobp.prefix == prefix
                && eobp.areaCode == areaCode;
    }
}