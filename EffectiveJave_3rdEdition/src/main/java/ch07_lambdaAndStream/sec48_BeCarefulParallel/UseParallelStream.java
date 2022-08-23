package ch07_lambdaAndStream.sec48_BeCarefulParallel;

import java.math.BigInteger;
import java.util.stream.LongStream;

/** ストリームでの並列化 */
public class UseParallelStream {

    /**
     * 素数を数えるストリームパイプライン
     * 2 ~ 上限値の間で素数である数字が何個あるかカウントした結果を返却する
     * @param   上限値
     * @return　素数が出現した回数
     */
    public long normalStream(long n) {
        return LongStream.rangeClosed(2, n)
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }
}
/**
 * BigInteger.isProbablePrime()
 *   - 素数である確率が高い場合に「true」を返却する。
 *
 * ストリームで並列処理を行うときは、パフォーマンスを向上できる且つコードの正しさを維持できる
 * 絶対的な自信がある時のみ実装すること。
 * また、パフォーマンス向上されていることを証明できる測定を必ず行うこと。
 * これらを守れない場合、並列処理を行うべきではない。
 *
 * 極論、並列ストリームは使わない方が良さそう。
 */