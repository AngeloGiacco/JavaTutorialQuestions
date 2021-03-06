package com.company.battlingFighters;

import java.util.Random;

public class luckyFighter {

    final Random rand = new Random();
    private final String name;
    private final String type;
    private final int skill = rand.nextInt(18)+1;
    private int stamina = rand.nextInt(24)+1;
    private int luck = rand.nextInt(18)+1;
    private int strategy = rand.nextInt(3);

    public luckyFighter(String name, String type){
        this.name = name;
        this.type = type;
    }

    public int getLuck() {
        return luck;
    }

    public String getStrategy(){
        return strategy == 1 ? "average" : strategy == 0 ? "aggressive" : "defensive";
    }

    public String getFighterInfo(){
        return name + " - " + type + " - skill: "+ skill + "; stamina: "+ stamina + "; " +
                "strategy: "+this.getStrategy()+"; luck: "+luck;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(int damage){
        if (stamina > 2) {
            stamina -= damage;
        } else {
            stamina = 0;
        }
    }

    private int rollDice() {
        Random rand = new Random();
        int upperbound = 6;
        return rand.nextInt(upperbound)+1;
    }

    public int rollDie(){
        return rollDice() + rollDice();
    }

    public int calculateAttackScore(){
        int roll1 = rollDice();
        int roll2 = rollDice();
        return roll1 + roll2 + skill;
    }

    public boolean isDead(){
        return stamina <= 0;
    }

    public void winner() {
        System.out.println("End of battle, "+name+" - "+type+" - " +
                "skill: "+skill+"; stamina: "+stamina+"; " +
                "strategy: "+this.getStrategy()+"; luck: "+luck+" wins!");
    }

    public Boolean testLuck(){
        int total = rollDie();
        int currLuck = luck;
        luck -= 1;
        return total <= currLuck ? true : false;
    }
}
