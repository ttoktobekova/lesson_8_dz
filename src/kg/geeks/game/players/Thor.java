package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

import java.util.Random;

public class Thor extends Hero {


    public Thor(int health, int damage, String name) {
        super(health, damage, SuperAbility.HALK, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random random = new Random();
        boolean stan=random.nextBoolean();
        if(stan){
            boss.setStan(true);
            boss.setDamage(0);
            System.out.println("Thor is stan Boss");
        }

    }
}

