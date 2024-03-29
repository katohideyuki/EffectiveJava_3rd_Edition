package ch06_enumAndAnotations.sec34_preferEnum;

/**
 * データと振る舞いを持つenum型
 * 各惑星は、質量と半径をもち、それら二つの属性から表面重力を計算する
 * 定数を宣言する時に、すべてのフィールドに値がセットされる
 */
public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.975e+24, 6.378e6),
    MARS(6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN(5.685e+26, 6.027e7),
    URANUS(8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.447e7);

    private final double mass;                    // 質量 単位:kg
    private final double radius;                  // 半径 単位:m
    private final double surfaceGravity;          // 表面重力 単位:m / s^2
    private static final double G = 6.67300E-11;  // 万有引力定数、単位 : m^3 / kg s^2

    /* コンストラクタ */
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass()                     { return mass; }
    public double radius()                   { return radius; }
    public double surfaceGravity()           { return surfaceGravity; }
    public double surfaceWeight(double mass) { return mass * surfaceGravity; } // F = ma
}
/**
 * enumのメソッドはなるべく隠蔽すること。
 *   - enum定数と関連付けられたメソッドの場合が多く、他クラスから呼ぶ必要が少ないため。
 */