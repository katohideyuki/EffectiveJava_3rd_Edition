package ch06.sec34;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import ch06_enumAndAnotations.sec35_preferInstanceFiled.Ensemble;
import ch06_enumAndAnotations.sec35_preferInstanceFiled.EnsembleBadEx;

@DisplayName("preferInstanceFiledパッケージのテスト")
public class Sec35Test {

    @Nested
    class EnsembleBadExクラス {
        @Test
        void 定数DUETの演者の人数は2が返却される() {
            assertEquals(2, EnsembleBadEx.DUET.numberOfMusicians());
        }
    }

    @Nested
    class Ensembleクラス {
        @Test
        void 定数DUETの演者の人数は2が返却される() {
            assertEquals(2, Ensemble.DUET.numberOfMusicians());
        }
    }
}
