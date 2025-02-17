public class SinglePlayer {
    private final Player player;
    private final AI ai;

    private SinglePlayer(Player player, AI ai) {
        this.player = player;
        this.ai = ai;
    }


    public static SinglePlayer CreteSinglePlayerGame() {
        Player player = Player.createPlayer();
        AI ai = AI.createAI(player);
        return new SinglePlayer(player, ai);
    }

    public void play() {

    }
}
