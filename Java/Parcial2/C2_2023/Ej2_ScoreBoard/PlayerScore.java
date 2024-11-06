package Parcial2.C2_2023.Ej2_ScoreBoard;

public class PlayerScore<S extends Comparable<? super S>> implements Comparable<PlayerScore<S>> {
    private final String player;
    private final S score;

    public PlayerScore(String player, S score) {
        this.player = player;
        this.score = score;
    }

    @Override
    public int compareTo(PlayerScore<S> o) {
        int c = o.score.compareTo(score);
        if(c==0){
            c = player.compareTo(o.player);
        }
        return c;
    }

    @Override
    public String toString() {
        return "Player %s scored %s".formatted(player, score);
    }
}
