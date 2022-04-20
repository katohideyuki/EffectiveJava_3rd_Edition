package lambda_stream.Trump;

/* トランプのマーク */
public enum Suit {
    CLUBS("♧"), DIAMONDS("♢"), HEARTS("♡"), SPADES("♤");

    private final String suit;  // マーク

    /* コンストラクタ */
    private Suit(String suit) { this.suit = suit; }

    public String getSuit() { return suit; }
}