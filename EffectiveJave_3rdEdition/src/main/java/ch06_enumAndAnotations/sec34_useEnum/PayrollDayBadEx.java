package ch06_enumAndAnotations.sec34_useEnum;


/** コードを共有するために値でswitchするenum - 問題が多い */
public enum PayrollDayBadEx {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY, SUNDAY;

    private static final int MINS_PER_SHIFT = 8 * 60; // 基本労働時間:480分

    /**
     * 労働者の基本賃金(時間単位)と労働時間が与えられた日に対する労働者の賃金を計算する。
     * 基本労働時間を超えた労働は残業手当を付与する。
     * また、週末の労働はすべて残業手当とする。
     * @param minutesWorked 労働時間(単位:分)
     * @param payRate       賃金率
     * @return              日給
     */
    public int pay(int minutesWorked, int payRate) {
        int basePay = minutesWorked * payRate;

        int overtimePay;  // 残業時間
        switch (this) {
            // 週末
            case SATURDAY : case SUNDAY:
                overtimePay = basePay / 2;
                break;
            // 平日
            default:
                overtimePay = minutesWorked <= MINS_PER_SHIFT ?
                        0: (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
        }

        return basePay + overtimePay;
    }
}
/**
 * 問題点
 *   - enumに新たな要素を追加した場合(例えば休暇を表す特別な値など)、
 *     switch文へ対応するcase文の追加を忘れる可能性がある。
 *   - switch文へ対応するcase文の追加を忘れた場合でも、
 */