package ch06_enumAndAnotations.sec34_useEnum;

/* 戦略enumパターン */
public enum PayrollDay {
    MONDAY(PayType.WEEKDAY),    TUESDAY(PayType.WEEKDAY),
    WEDNESDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY),
    FRIDAY(PayType.WEEKDAY),    SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    // 平日か休日かを表すインスタンスフィールド
    private final PayType payType;

    /** コンストラクタ - 共通処理を選択する */
    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    /**
     * PayTypeクラスのpayメソッドを呼び出し、日給を返却する。
     * @param minutesWorked 労働時間(単位:分)
     * @param payRate       賃金率
     * @return              日給
     */
    public int pay(int minutesWorked, int payRate) {
        return payType.pay(minutesWorked, payRate);
    }

    /**
     * 戦略enum型
     * 共通処理
     * このネストしたenumクラスは、エンクロージングクラスのコンストラクタから呼び出される。
     * 残業時間を算出するovertimePayメソッドを実装する。
     * Paytypeによって、overtimePayメソッド内容が違う。
     */
    private enum PayType {
        // 平日の処理
        WEEKDAY {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT
                        ? 0
                        : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        // 週末の処理
        WEEKEND {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);  // 残業時間を算出する抽象メソッド
        private static final int MINS_PER_SHIFT = 8 * 60; // 基本労働時間:480分

        /**
         * 労働者の基本賃金(時間単位)と労働時間が与えられた日に対する労働者の賃金を計算する。
         * このメソッドはエンクロージングクラスのpayメソッドから呼び出される。
         * 基本労働時間を超えた労働は残業手当を付与する。
         * また、週末の労働はすべて残業手当とする。
         * @param minutesWorked 労働時間(単位:分)
         * @param payRate       賃金率
         * @return              日給
         */
        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }
}

/**
 * 各定数ごとではなく、一部の定数で共通の振る舞いを持たせたいなら、戦略enumパターンを検討する。
 *   - 共通処理をprivateのネストしたenumとして定義する。
 *     - ネストしたenumの定数に共通処理を定義する。
 *     - ネストしたenumのインスタンスを、親enumのコンストラクタに渡す。
 */
