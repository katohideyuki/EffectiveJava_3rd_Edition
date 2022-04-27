package create_disappearance.builderPattern;

/**
 * HowToBuilderを使用<br>
 */
public class HowToBuilderExe {
  public static void main(String[] a) {
    HowToBuilder cocacola = new HowToBuilder.Builder(240, 8).calories(100).sodium(35).carbohydrare(27).build();
    System.out.println(cocacola);
  }
}