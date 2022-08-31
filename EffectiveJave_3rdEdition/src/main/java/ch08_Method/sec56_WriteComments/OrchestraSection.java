package ch08_Method.sec56_WriteComments;

/**
 * ※1
 * 交響楽団の楽器セクション
 */
public enum OrchestraSection {
    /** フルート、クラリネット、オーボエなどの木管楽器 */
    WOODWUND,
    /** フレンチホルンやトランペットなどの金管楽器 */
    BRASS,
    /** ティンパニーやシンバルなどの打楽器 */
    PERCUSSION,
    /** ヴァイオリンやチェロなどの弦楽器 */
    STRING;
}
/**
 * Javadocは必ず書くべし
 * なるべく端的に、そして漏れなく書くことが大事。
 * また、Javadoc用のアノテーションは有効に活用すること。
 *  - {@code}
 *  - {@index}
 * などなど。(使い方はJavadocドキュメントを参照)
 *
 * ※1
 * enum型を文書化する際は、以下の情報もJavadocまたはコメントとして残すこと。
 *  - クラス
 *  - publicなメソッド
 *  - 定数
 *
 */