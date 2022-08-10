package ch04_classAndInterface.sec23_perferClassHierarchies;

/** タグ付きクラスFigureBadExをクラス階層に置き換えたクラス */
abstract class FigureGoodEx {
    abstract double area();
}

/**
 * クラス階層の内容
 * 1. ルートクラスFigureGoodExの具象サブクラスを定義する。
 * 2. 各特性に特有のデータフィールドを書くサブクラスに持たせる。
 *    円であれば半径(radius)、長方形であれば長さ(length)と幅(width)にあたる。
 * 3. ルートクラスの抽象メソッドの適切な実装を書くサブクラスに含める。
 *
 * メリット
 * コードが簡潔で明瞭である。
 * 各特性を持った独自のクラスがあり、無関係なデータフィールドを持っていない。
 * すべてのフィールドがfinalである。
 */