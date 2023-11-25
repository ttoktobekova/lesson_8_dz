package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static int getRoundNumber() {
        return roundNumber;
    }

    public static void startGame() {
        Boss boss = new Boss(2000, 50, "Tanos");
        Warrior warrior1 = new Warrior(280, 10, "Manas");
        Medic doc = new Medic(250, 5, 15, "Ahunbai");
        Warrior warrior2 = new Warrior(290, 15, "Semetei");
        Magic magic = new Magic(260, 20, "Potter");
        Berserk berserk = new Berserk(260, 10, "Viking");

        Medic assistant = new Medic(300, 5, 5, "Anna");
        Witcher witcher = new Witcher(300, 0, "Witch");
        Thor thor = new Thor(100, 10, "Halk");
        Hero[] heroes = {doc, warrior1, magic, berserk, assistant, warrior2, witcher, thor};

        showStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence( );
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0
                    && boss.getDefence() != heroes[i].getAbility()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        showStatistics(boss, heroes);
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -----------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }


}

