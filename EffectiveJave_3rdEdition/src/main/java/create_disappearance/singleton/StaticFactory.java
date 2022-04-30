package create_disappearance.singleton;

import java.io.Serializable;

/** static ファクトリメソッドによるシングルトン */
public class StaticFactory implements Serializable {
    private static final StaticFactory INSTANCE = new StaticFactory();

    /* コンストラクタ */
    private StaticFactory() {
        System.out.println("StaticFactory was created.");
    }

    /* StaticFactory インスタンスを生成して返却 */
    public static StaticFactory getInstance() { return INSTANCE; }

    /* メッセージ出力 */
    public void message() { System.out.println("Output message."); }

    /* シングルトン特性を保持するためのメソッド ※1
         本物の StaticFactory を返却して、偽物をガベージコレクタに始末 */
    private Object readResolve() { return INSTANCE; }
}

/**
 * <pre>
 * getInstance のすべての呼び出しは、同じオブジェクト参照を返却し
 * 他の StaticFactory インスタンスが生成されることはない
 *　
 * 長所
 *   - API を変更せず、シングルトンにするか否かを変更できる
 *   - ジェネリックのシングルトンファクトリを書ける
 *   - メソッド参照を使えるところ (StaticFactory::getInstance)
 *
 * ※1 ディシリアライズするごとに、新たなインスタンスが生成されるのを防ぐため、
 *    readResolve()を追加する
 *    ディシリアライズ時に自動的に呼び出される
 * </pre>
 */