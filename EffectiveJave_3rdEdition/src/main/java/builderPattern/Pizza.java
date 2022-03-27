package builderPattern;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * クラス階層に対するビルダーパターン<br>
 * - ピザを生成する抽象クラス<br>
 * - 任意のトッピングを乗せられる<br>
 */
public abstract class Pizza {
  public enum Topping { /* Pizzaのインナークラス */
    HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
  }

  final Set<Topping> toppings; // トッピングセット

  abstract static class Builder<T extends Builder<T>> { /* Bulderを継承しているクラスのみ使用可 */
    EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class); // 指定された要素型を使用して空のenumセットを作成

    public T addToppping(Topping topping) {
      toppings.add(Objects.requireNonNull(topping)); // 引数がnullならNullPointerExceptionを投げ、引数があるならそれを返す
      return self();
    }

    abstract Pizza build(); // 実装クラスのオブジェクトを返す想定

    protected abstract T self(); // 実装クラスで定義したBuilderクラスを返す想定
  }

  protected Pizza(Builder builder) {
    toppings = builder.toppings.clone();
  }

  protected abstract void outPrint(Set<Topping> toppings);  // 実装クラスでdebugを定義する想定
}