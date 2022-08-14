package ch04_classAndInterface.sec23_preferClassHierarchies;

/**
 * タグ付きクラス - クラス階層よりも劣る
 * 円か長方形を表現するクラス。
 */
public class FigureBadEx {
    enum Shape { RECTANGLE, CIRCLE };

    // タグフィールド - この図の形
    final Shape shape;

    // shapeがRECTANGLEである場合にだけ、これらのフィールドは使われる
    double length;
    double width;

    // shapeがCIRCLEである場合にだけ、このフィールドは使われる
    double radius;

    /** 円のコンストラクタ */
    FigureBadEx(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    /** 長方形のコンストラクタ */
    FigureBadEx(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }


    /**
     * タグフィールドに併せて、値を返却する
     * @return 面積
     * @throws タグフィールドが想定外の場合
     */
    double area() {
        switch (shape) {
            case RECTANGLE -> { return length * width; }
            case CIRCLE    -> { return Math.PI * (radius * radius); }
            default        -> { throw new AssertionError(shape); }
        }
    }
}
/**
 * タグクラスとは
 * インスタンスが二つ以上の特性を持っていて、
 * その特性を示すためのタグ(tag)フィールドを持つクラスである。
 *
 * デメリット
 * enum宣言、タグフィールド、switch文と、決まりきったコードが散らかっていて
 * 可読性が損なわれている。
 * すなわち、タグクラスは作らない。
 */