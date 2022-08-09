package ch04_classAndInterface.sec19_constructors;


/**
 * 不完全
 * コンストラクタがオーバーライド可能なメソッドを呼び出している
 */
public class Super {

    /** コンストラクタ */
    public Super() {
        overrideMe();
    }

    public void overrideMe() { }
}
