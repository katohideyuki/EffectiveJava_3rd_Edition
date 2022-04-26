package lambda_stream.streamThanColleciton;

import java.util.AbstractList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.commons.lang3.RandomStringUtils;

import dubug.Debug;

/** 戻り値型としてStreamよりもCollectionを選ぶ */
public class UsePowerSet_SubList {
    public static void main(String[] args) {
        usePowerSet();
        useSubList();
    }

    /* Setインスタンス生成用 - ランダムな文字を扱うSetを返却 */
    private static Set<Character> creCharSet(int num) {
        char[] charArray = RandomStringUtils.randomAlphabetic(num).toCharArray();
        Set<Character> charSet = new HashSet<>();
        for (char c : charArray)
            charSet.add(c);
        return charSet;
    }

    /* PowerSetクラスの使用例 */
    private static void usePowerSet() {
        Debug.log("PowerSet.of");
        PowerSet power = new PowerSet();

        Set<Character> setA = creCharSet(3);                   // サンプルA
        Set<Character> setB = creCharSet(3);                   // サンプルB
        Collection<Set<Character>> resultA = power.of(setA);   // サンプルAのべき集合
        Collection<Set<Character>> resultB = power.of(setB);   // サンプルBのべき集合
        AbstractList<Set<Character>> abstractListA =
                (AbstractList<Set<Character>>) power.of(setA); // サンプルAのべき集合(AbstractList型)

        // べき集合の中身
        System.out.printf("resutlA       : %s%n", resultA);
        System.out.printf("resutlB       : %s%n", resultB);
        System.out.printf("abstractListA : %s%n", abstractListA);

        // 特別なコレクションの比較"
        System.out.printf("resultAとresultBを比較 : %s%n", resultA.contains(resultB));

        // 特別なコレクションの要素数を取得
        System.out.printf("resutlA : %s%n", resultA.size());

        // 特別なコレクションから5番目の要素を取得
        System.out.printf("abstractListA (5) : %s%n", abstractListA.get(3));
    }

    /* SubListsクラスの使用例 */
    private static void useSubList() {
        Debug.log("SubLists.of");
        Stream<List<Integer>> resultStream = SubLists.of(List.of(1, 2, 3));
        resultStream.forEach(System.out::print);
    }
}
