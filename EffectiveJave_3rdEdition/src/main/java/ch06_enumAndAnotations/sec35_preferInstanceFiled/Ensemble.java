package ch06_enumAndAnotations.sec35_preferInstanceFiled;

/**
 * インスタンスフィールドを使用する
 * 2人以上で同時に演奏する人数を扱うクラス
 */
public enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), DOUBLE_QUARTET(8),
    NONET(9), DECTET(10), TRIPLE_QUARTET(12);

    // 演者の人数
    private final int numberOfMusicians;

    /** コンストラクタ */
    private Ensemble(int size) {
        this.numberOfMusicians = size;
    }

    /** getter */
    public int numberOfMusicians() {
        return numberOfMusicians;
    }
}
