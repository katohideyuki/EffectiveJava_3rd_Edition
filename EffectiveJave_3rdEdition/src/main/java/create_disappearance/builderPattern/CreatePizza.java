package create_disappearance.builderPattern;

import create_disappearance.builderPattern.NyPizza.Size;
import create_disappearance.builderPattern.Pizza.Topping;

/**
 * クラス階層に対するビルダーパターンを使用<br>
 */
public class CreatePizza {
  public static void main(String[] args) {
    createNypizza();
    createCalzone();
  }

  private static void createNypizza() {
    NyPizza nyPizza = new NyPizza.Builder(Size.SMALL).addToppping(Topping.SAUSAGE).addToppping(Topping.ONION).build();
    nyPizza.outPrint(nyPizza.toppings);
  }

  private static void createCalzone() {
    Calzone calzone = new Calzone.Builder().addToppping(Topping.HAM).sourceInside().build();
    calzone.outPrint(calzone.toppings);
  }
}