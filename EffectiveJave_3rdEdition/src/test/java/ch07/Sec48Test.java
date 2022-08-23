package ch07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ch07_lambdaAndStream.sec48_BeCarefulParallel.UseParallelStream;

public class Sec48Test {
    @Test
    void 整数100を渡すと_要素数25が返却される() {
        assertEquals(25, new UseParallelStream().normalStream(100));
    }
}
