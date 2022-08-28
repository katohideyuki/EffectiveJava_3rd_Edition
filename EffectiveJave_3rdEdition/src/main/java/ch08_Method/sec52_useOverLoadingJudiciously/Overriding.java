package ch08_Method.sec52_useOverLoadingJudiciously;

import java.util.List;

public class Overriding {

    /**  */
    class Wine {
        String name() { return "wine" ; }
    }

    class SparklingWine extends Wine {
        @Override
        String name() { return "sparkling wine" ; }
    }

    class Champagne extends SparklingWine {
        @Override
        String name() { return "champagne"; }
    }

    /**
     * 3種類のクラスを扱うリストを生成し、
     * それぞれのクラスでオーバーライドされたnameメソッドを実行する。
     * @param args
     */
    public static void main(String[] args) {
        var o = new Overriding();
        List<Wine> wineList = List.of(
                o.new Wine(),
                o.new SparklingWine(),
                o.new Champagne()
                );

        for (Wine wine : wineList)
            System.out.println(wine.name());  // 「wine、sparkling wine、champagne」が表示される
    }
}
/**
 * オーバーライドはコンパイル時ではなく、実行時に決定される。
 */