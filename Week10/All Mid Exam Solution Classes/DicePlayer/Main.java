public class Main {
    public static void main(String[] args) {
        Player player = new Player("Sara", 2, 6);

        player.roll();
        System.out.println("Initial Total: " + player.getTotal());
        System.out.println(player);

        System.out.println();

        player.rollAgain(1);
        System.out.println("New Total: " + player.getTotal());
        System.out.println(player);

        player.cheatRoll();
        System.out.println("\nAfter Cheat Roll:");
        System.out.println(player);

        player.bonusRoll();
        System.out.println("\nAter Bonus Roll:");
        System.out.println(player);
    }
}
