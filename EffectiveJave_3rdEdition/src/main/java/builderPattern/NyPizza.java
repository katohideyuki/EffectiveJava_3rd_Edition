package builderPattern;

import java.util.Objects;
import java.util.Set;

/**
 * ニューヨーク風のピザを生成するクラス<br>
 * - サイズを決める<br>
 */
public class NyPizza extends Pizza {
  public enum Size {
    SMALL, MIDIUM, LARGE
  }

  private final Size size; // ピザのサイズ

  public static class Builder extends Pizza.Builder<Builder> {
    private final Size size;

    public Builder(Size size) {
      this.size = Objects.requireNonNull(size);
    }

    @Override
    public NyPizza build() {
      return new NyPizza(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  private NyPizza(Builder builder) {
    super(builder);
    size = builder.size;
  }

  @Override
  protected void outPrint(Set<Topping> toppings) {
    System.out.printf("NyPizzaの生成%nサイズ : %s%n", size);
    toppings.stream().forEach(x -> System.out.printf("トッピング : %s%n", x));
  }

//  public void outPrint(Set<Topping> toppings) { /* debug用 */
//    System.out.println("NyPizza.outPrint()");
//    toppings.stream().forEach(x -> System.out.println(x));
//    String.format("size : %s%n", size);
//  }

}