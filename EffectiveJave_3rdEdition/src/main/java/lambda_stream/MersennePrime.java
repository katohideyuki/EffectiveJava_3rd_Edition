package lambda_stream;

import java.math.BigInteger;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import java.util.stream.Stream;

/**
 * 最初の20個のメルセンヌ素数を表示するクラス
 */
public class MersennePrime {
    public static void main(String[] a) {
        exe();
    }

    /* 2^素数 - 1 を計算 */
    private static void exe() {
        int controlNum = 50; // 確率的な素数判定を制御
        int limitNum   = 20; // 20個の要素に制限

        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
        .filter(mersenne -> mersenne.isProbablePrime(controlNum))
        .limit(limitNum)
        .forEach(mp -> System.out.printf(" 2^%s - 1 = %s%n", mp.bitLength(), mp));
    }

    /* 2以上の素数を無限に返却する */
    private static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
/**
 * <pre>
 * BigInteger.nextProbablePrime
 *   - 自分より大きい最初の素数を返却
 * BigInteger.intValueExact
 *   - intに変換
 * BigInt.subtract(減算値)
 *   - 自分 - 減算値
 * BigInteger.bitLength
 * Stream.iterator(初期値, 初期値を使った関数)
 *   - 無限ストリーム
 *     - limitを定義しないと無限ループ
 * </pre>
 */
