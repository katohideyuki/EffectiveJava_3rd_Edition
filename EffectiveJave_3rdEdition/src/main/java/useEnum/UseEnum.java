package useEnum;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiConsumer;

/* int定数の代わりにenumを使う */
public class UseEnum {
    private static final int WEIGHT = 50;       // 地球上での重さ:単位 kg
    private static final int NUM_1 = 2;         // 整数
    private static final int NUM_2 = 4;         // 整数
    private static final int MINS_WORKED = 600; // 労働時間:単位 分
    private static final int PAY_RATE = 15;      // 賃金率
    private static final BiConsumer<String, String> DEBUG = (enumName, methodName) -> {
        System.out.println("""
                -----------------------------
                 ▼ enumクラス%sの使用例
                   %sメソッド
                ----------------------------- """.formatted(enumName, methodName)); }; // debug用


    public static void main(String[] a) {
        usePlanet(WEIGHT);
        useOperation(NUM_1, NUM_2);
        usePayrollDay(MINS_WORKED, PAY_RATE);
    }

    /**
     * enumクラスPlanetの使用例
     *   とある物体の地球上での重さ（任意の単位）を受け取り、8個全ての惑星上でのその物体の重さ（同じ単位）を表示する
     *   重力の違いによる、地球上の重さと惑星上の重さの違いを確認
     * @param earthWeight 地球上での重さ
     */
    private static void usePlanet(double earthWeight) {
        DEBUG.accept("Planet", "usePlanet");
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        Arrays.stream(Planet.values()).forEach(p -> System.out
                .printf("Weight on %s is %f%n", p, p.surfaceWeight(mass)));
    }

    /**
     * enumクラスOperationの使用例
     *   整数を受け取り、enumクラスOperationに定義された算術式が表示される
     * @param x 整数値
     * @param y 整数値
     */
    private static void useOperation(double x, double y) {
        DEBUG.accept("Operation", "useOperation");
        Arrays.stream(Operation.values()).forEach(op -> System.out
                .printf("%f %s %f = %f%n", x, op, y, op.apply(x, y)));

        /* fromStringを使ってみる */
        Optional<Operation> op = Operation.fromString("+");
        if (op.isPresent())
            System.out.println(op.get()); // +
    }

    private static void usePayrollDay(int minsWorked, int payRate) {
        DEBUG.accept("PayrollDay", "usePayrollDay");
        final int dayPay = PayrollDay.MONDAY.pay(minsWorked, payRate);
        System.out.printf("%s分働いたとき、賃金率が%sだったら、もらえるお金は%sです"
                ,minsWorked,payRate, dayPay);
    }
}
