package create_disappearance.singleton;

import java.util.Objects;

import dubug.Debug;

/** private のコンストラクタか enum 型でシングルトン特性を強制する */
public class UseSinglton {
    public static void main(String[] a) {
        useStaticFactory();
        useSingletonBestPractice();
    }

    /* FinalField クラスの使用例 */
    private static void useFinalField() { } // 外部からはアクセスできない

    /* StaticFactory クラスの使用例 */
    private static void useStaticFactory() {
        Debug.log("useStaticFactory");
        var sfInstance_A = StaticFactory.getInstance();
        var sfInstance_B = StaticFactory.getInstance();
        // 比較
        if (Objects.equals(sfInstance_A, sfInstance_B)) {
            System.out.println("sfInstance_A and sfInstance_B are the same instance.");
        }
        sfInstance_B.message();
    }

    /* SingletonBestPractice クラスの使用例 */
    private static void useSingletonBestPractice() {
        Debug.log("SingletonBestPractice");
        SingletonBestPractice.INSTANCE.message();
    }
}
