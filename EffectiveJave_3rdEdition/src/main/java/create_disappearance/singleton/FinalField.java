package create_disappearance.singleton;

import java.util.Objects;

/** public final のフィールドによるシングルトン */
public class FinalField {
    public static final FinalField INSTANCE = new FinalField();

    public static void main(String[] args) {
        INSTANCE.message();
        FinalField finalField = new FinalField(); // 例外発生
    }

    /* コンストラクタ */
    private FinalField() {
        // インスタンスが既に存在している場合、例外をスロー ※1
        if (Objects.nonNull(INSTANCE))
            throw new RuntimeException();
        System.out.println("FinalField was created.");
    }

    /* メッセージ出力 */
    public void message() { System.out.println("Output message."); }
}

/**
 * <pre>
 * private のコンストラクタは、public static final のフィールドである FinalField.INSTANCEを
 * 初期化するために、一度だけ呼ばれる
 * 一度 FinalField クラスが初期化されれば、それ以降、※1のケースを除いて生成されることはない
 *
 * ※1 二つ目のインスタンスが生成されようとしたとき、例外をスローする必要がある
 *   - リフレクションにより、private コンストラクタを呼び出すことができるため
 *     - AccessibleObject.setAccessible()
 * </pre>
 */
