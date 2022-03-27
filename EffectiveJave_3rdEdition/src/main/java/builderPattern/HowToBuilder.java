package builderPattern;

/**
 * Builderパターンの基本構造<br>
 * - HowToBuilderは栄養成分表のクラスとする<br>
 */
public class HowToBuilder {
  private final int servingSize; // 1食分の量
  private final int servings; //
  private final int calories; // カロリー
  private final int fat; // 脂質
  private final int sodium; // ナトリウム
  private final int carbohydrate; // 炭水化物

  public static class Builder { /* HowToBuilderと同じフィールドを持つ、ネストされたstaticなBuilderクラス */
    // 必須パラメータ
    private final int servingSize;
    private final int servings;

    // オプションパラメータ
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public Builder(int servingSize, int serving) {
      this.servingSize = servingSize;
      this.servings = serving;
    }

    public Builder calories(int val) { /* 値がセットされる度にbuilder自身を返す */
      calories = val;
      return this;
    }

    public Builder fat(int val) {
      fat = val;
      return this;
    }

    public Builder sodium(int val) {
      sodium = val;
      return this;
    }

    public Builder carbohydrare(int val) {
      carbohydrate = val;
      return this;
    }

    public HowToBuilder build() { /* 自分自身を引数にHowToBuilderのコンストラクタを呼ぶ */
      return new HowToBuilder(this);
    }
  }

  public HowToBuilder(Builder builder) { /* HowToBuilderのコンストラクタ */
    servingSize = builder.servingSize;
    servings = builder.servings;
    calories = builder.calories;
    fat = builder.fat;
    sodium = builder.sodium;
    carbohydrate = builder.carbohydrate;
  }

  @Override
  public String toString() { /* debug用 */
    return String.format(" servingSize : %d%n servings : %d%n calories : %d%n fat : %d%n sodium : %d%n",
        servingSize, servings, calories, fat, sodium, carbohydrate);
  }
}