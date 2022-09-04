package ch09_GeneralProgramming.sec64_ReferenceByInterface;

import java.util.LinkedHashSet;
import java.util.Set;

public class Sample {
    // 良い - 型としてインタフェースを使用
    Set<String> set01 = new LinkedHashSet<>();

    // 悪い - 型としてクラスを使用
    LinkedHashSet<String> set02 = new LinkedHashSet<>();
}
/**
 * オブジェクトを参照する時は、可能な限りインタフェースや抽象クラス型で参照する
 *  - 柔軟性が高い
 *    - あとから実装クラスを差し替えることができる
 */
