package ch06_enumAndAnotations.sec35_preferInstanceFiled;

/**
 * 関連付けられた値を導き出すためにordinalを乱用 - これをやってはいけない
 * 2人以上で同時に演奏する人数を扱うクラス
 */
public enum EnsembleBadEx {
    SOLO,   DUET,   TRIO,  QUARTET, QUINTET,
    SEXTET, SEPTET, OCTET, NONET,   DECTET;

    /**
     * 序数を活用し、演者の人数を返却する。
     * @return 演者の人数
     */
    public int numberOfMusicians() {
        return ordinal() + 1;
    }
}
/**
 * 動作するが保守性が皆無である。
 *   - numberOfMusiciansメソッドは、定数を並び替えらてしまったら、正常に動作しなくなる。
 *   - さらに定数を細分化した場合(double quartet)、この仕様を守ることができない。
 *   - 12人から構成されるtriple quartetを表す定数を追加する場合、
 *     本来不要な11人から構成される定数も追加せざるおえない。
 *     この仕様を守るために。
 */