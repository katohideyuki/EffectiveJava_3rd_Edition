package ch04_classAndInterface.sec23_perferClassHierarchies;

/** 円のクラス */
class Circle extends FigureGoodEx {
    final double radius;

    /** 円のコンストラクタ */
    Circle(double radius) {
        this.radius = radius;
    }

    @Override /** 円の面積を返却する */
    double area() {
        return Math.PI * (radius * radius);
    }
}
