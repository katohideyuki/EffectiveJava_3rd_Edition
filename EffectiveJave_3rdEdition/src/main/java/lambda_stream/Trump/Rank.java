package lambda_stream.Trump;

/* トランプの数字 */
public enum Rank {
    ACE(1),   TWO(2),   THREE(3), Four(4), FIVE(5),    SIX(6), SEVEN(7),
    EIGHT(8), NINE(9),  TEN(10), JACK(11), QUEEN(12), KING(13);

    private final int rank;  // 数字

    /* コンストラクタ */
    private Rank(int rank) { this.rank = rank; }

    public int getRank() { return rank; }

}

