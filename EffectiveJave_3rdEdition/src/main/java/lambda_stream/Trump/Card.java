package lambda_stream.Trump;

/* トランプ */
public class Card {

    private final Suit suit;  // マーク
    private final Rank rank;  // 数字

    /* コンストラクタ */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() { return rank; }
    public Suit getSuit() { return suit; }

    @Override
    public String toString() {
        return String.format("%n %s : %s", suit.getSuit(), rank.getRank());
    }
}
