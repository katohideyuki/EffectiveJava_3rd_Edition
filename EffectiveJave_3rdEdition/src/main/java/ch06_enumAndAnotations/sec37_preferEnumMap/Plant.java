package ch06_enumAndAnotations.sec37_preferEnumMap;

/** 植物を表すクラス */
public class Plant {

    /** 植物の寿命 */
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL; }

    private final String name;          // 名前
    private final LifeCycle lifeCycle;  // 寿命

    /** コンストラクタ */
    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    /** 各getter */
    public String getName()         { return name; }
    public LifeCycle getLifeCycle() { return lifeCycle; }

    @Override /** 植物の名前を返却する */
    public String toString() { return name; }
}
