package create_disappearance.singleton;

/** enum シングルトン - 好ましい方法 */
public enum SingletonBestPractice {
    INSTANCE;

    /* メッセージ出力 */
    public void message() { System.out.println("Output message."); }
}

/**
 * <pre>
 * FinalField クラスと同じ方法だけど、enum の方がより単純で、シリアライズ機構を提供している
 *   - 複数のインスタンス生成を阻止できている
 * </pre>
 */
