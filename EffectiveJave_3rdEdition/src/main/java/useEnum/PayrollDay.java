package useEnum;

/* 戦略enumパターン */
public enum PayrollDay {
    MONDAY(PayType.WEEKDAY),    TUESDAY(PayType.WEEKDAY),
    WEDNESDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType) { this.payType = payType; } // コンストラクタ　共通処理を選択する

    int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    /* 戦略enum型 共通処理 */
    private enum PayType {
        WEEKDAY { /* 平日の処理 */
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT
                        ? 0
                        : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND { /* 週末の処理 */
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);
        private static final int MINS_PER_SHIFT = 8 * 60; // 1日の労働時間

        /* 労働者の基本賃金と労働時間が与えられた日に対する労働者の賃金を計算 */
        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate; // 基本給(労働時間 * 賃金率)
            return basePay + overtimePay(minsWorked, payRate);
        }
    }
}

/**<pre>
 * memo
 * - 各定数ごとではなく、一部の定数で共通の振る舞いを持たせたいなら、戦略enumパターンを検討する
 *   - 共通処理をprivateのネストしたenumとして定義する
 *     1. ネストしたenumの定数に共通処理を定義する
 *     2. ネストしたenumのインスタンスを、親enumのコンストラクタに渡す
 * </pre>
 */
