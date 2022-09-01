package ch09_GeneralProgramming.sec58_ForLoopThanForEach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.lang.model.element.Element;

public class Sample {

    private static void hoge() {
        // コレクションをイテレートする悪い例
        List<Element> c = new ArrayList<>();
        for (Iterator<Element> i = c.iterator(); i.hasNext(); ) {
            Element e = i.next();
            // eで何か行う
        }

        // 配列をイテレートする悪い例
        String[] a = {};
        for (int i = 0; i < a.length; i++) {
            // a[i]で何か行う
        }

        // コレクションまたは配列をイテレートする良い例
        List<Element> elementList = new ArrayList<>();
        for (Element e : elementList) {
            // eで何か行う
        }
    }
}
/**
 *
 */