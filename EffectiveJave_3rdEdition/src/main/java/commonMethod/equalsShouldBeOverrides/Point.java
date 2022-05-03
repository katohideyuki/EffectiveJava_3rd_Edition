package commonMethod.equalsShouldBeOverrides;

import java.awt.Color;

/** equals をオーバーライトするときは一般契約に従う */
public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point p = (Point)o;
        return p.x == x && p.y == y;
    }

    /* 色の概念 */
    public class ColorPoint extends Point {
        private final Color color;
        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }
        @Override /* 不完全 - 推移性を守っていない */
        public boolean equals(Object o) {
            if (!(o instanceof Point))
                return false;
            // o が普通のポイントなら、色を無視した比較をする ※1
            if (!(o instanceof ColorPoint))
                return o.equals(this);
            // o は、ColorPoint。完全な比較を行う
            return super.equals(o) && ((ColorPoint) o).color == color;
        }
    }
}

/**
 * <pre>
 * ※1
 * A == B かつ、C == B であれば、A == C が成り立つはずが、成り立たなくなる
 * </pre>
 */