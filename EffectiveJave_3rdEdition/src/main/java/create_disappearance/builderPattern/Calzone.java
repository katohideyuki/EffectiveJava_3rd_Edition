package create_disappearance.builderPattern;

import java.util.Set;

/**
 * カルツォーネ風のピザを生成するクラス<br>
 * - ソースをかける箇所を決める<br>
 */
public class Calzone extends Pizza {
  private final boolean sourceInside; // tureであれば、ソースを中にかける

  public static class Builder extends Pizza.Builder<Builder> {
    private boolean sourceInside = false; // デフォルトは外

    public Builder sourceInside() { /* ソースを中にかける */
      sourceInside = true;
      return this;
    }

    @Override
    public Calzone build() {
      return new Calzone(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

  protected Calzone(Builder builder) {
    super(builder);
    sourceInside = builder.sourceInside;
  }

  @Override
  protected void outPrint(Set<Topping> toppings) {
    String source = sourceInside ? "中" : "外";
    System.out.printf("Calzoneの生成%nソース : %sにかける%n", source);
    toppings.stream().forEach(x -> System.out.printf("トッピング : %s%n", x));
  }
}