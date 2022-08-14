package ch04_classAndInterface.sec23_preferClassHierarchies;

/** 長方形のクラス */
class Rectangle extends FigureGoodEx {
    final double length;
    final double width;

    /** 長方形のコンストラクタ */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override /** 長方形の面積を返却する */
    double area() {
        return length * width;
    }
}