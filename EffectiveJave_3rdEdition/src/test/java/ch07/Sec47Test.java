package ch07;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.AbstractList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import ch07_lambdaAndStream.sec47_streamThanColleciton.PowerSet;
import ch07_lambdaAndStream.sec47_streamThanColleciton.SubLists;

@DisplayName("sec47_streamThanCollecitonパッケージのテスト")
public class Sec47Test {
    @Nested
    class PowerSetクラス {
        // サンプルA
        private static final Set<Character> SET_A = creCharSetHelper(3);
        // サンプルB
        private static final Set<Character> SET_B = creCharSetHelper(3);
        // サンプルAのべき集合
        private static final Collection<Set<Character>> RESULT_A = PowerSet.of(SET_A);
        // サンプルBのべき集合
        private static final Collection<Set<Character>> RESULT_B = PowerSet.of(SET_B);

        // 特別なコレクション
        private static final AbstractList<Set<Character>> ABSTRACT_LIST =
                (AbstractList<Set<Character>>) PowerSet.of(SET_A);
        @Test
        void サンプルAとサンプルBは異なる値を保持している() {
            assertTrue(!RESULT_A.contains(RESULT_B));
        }

        @Test
        void サンプルAのべき集合の要素数は4または8である() {
            Predicate<Collection<Set<Character>>> isSizeFour  = e -> e.size() == 4;
            Predicate<Collection<Set<Character>>> isSizeEight = e -> e.size() == 8;
            assertTrue(isSizeFour.or(isSizeEight).test(RESULT_A));
        }

        @Test
        void 特別なコレクションから5番目のセットの要素を取得すると_アルファベットの文字が2つ返却される() {
            // アルファベットを表す正規表現
            Pattern p = Pattern.compile("^[a-zA-Z]");

            // 要素がアルファベットであればインクリメントされる
            int trueCount = 0;
            for (Character c : ABSTRACT_LIST.get(5)) {
                Matcher m = p.matcher(Character.toString(c));
                // 取得した要素がアルファベットである
                if (m.find())
                    trueCount++;
            }
            assertEquals(2, trueCount);
        }
    }

    @Nested
    class SubListクラス {
        Stream<List<Integer>> stream = SubLists.of(List.of(1, 2, 3));
        @Test
        void テストの仕方がわからなかったので_とりあえず出力だけする() {
            stream.forEach(System.out::print);
        }
    }

    /**
     * Setインスタンス生成用
     *
     * @param num
     * @return ランダムな文字を扱うSet
     */
    private static Set<Character> creCharSetHelper(int num) {
        char[] charArray = RandomStringUtils.randomAlphabetic(num).toCharArray();
        Set<Character> charSet = new HashSet<>();
        for (char c : charArray)
            charSet.add(c);
        return charSet;
    }
}
