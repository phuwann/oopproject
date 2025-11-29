/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject;

import com.mycompany.oopproject.characters.Item;
import com.mycompany.oopproject.heroes.tank;
import com.mycompany.oopproject.heroes.mage;
import com.mycompany.oopproject.heroes.healer;
import com.mycompany.oopproject.heroes.fighter;
import com.mycompany.oopproject.heroes.archer;
import com.mycompany.oopproject.characters.hero;
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List;

/**
 *
 * @author Phuwan
 */
public class gamedata {
    public static hero MAGE = new mage();
    public static hero TANK = new tank();
    public static hero ARCHER = new archer();
    public static hero FIGHTER = new fighter();
    public static hero HEALER = new healer();
    
    public static int currentStage = 1;
    public static String playerName = "Player";
    public static final int BOSS_STAGE = 10;

    
    public static final List<Item> NORMAL = List.of(
        new Item("Wooden Ring", "+3 ATK, +10 Mana", 0, 10, 3),
        new Item("Leather Armor", "+20 Max HP", 20, 0, 0),
        new Item("Old Boots", "+10 Max HP, +10 Mana", 10, 10, 0),
        new Item("Rusty Sword", "+4 ATK", 0, 0, 4),
        new Item("Apprentice Hat", "+20 Mana, +1 ATK", 0, 20, 1)
    );

    public static final List<Item> Rare = List.of(
        new Item("Ruby Ring", "+8 ATK, +20 Mana", 0, 20, 8),
        new Item("Chainmail", "+50 Max HP", 50, 0, 0),
        new Item("Swift Boots", "+20 Max HP, +20 Mana", 20, 20, 0),
        new Item("Vampire Fangs", "+12 ATK, -10 HP", -10, 0, 12),
        new Item("Magic Orb", "+40 Mana, +5 ATK", 0, 40, 5)
    );

    public static final List<Item> Legendary = List.of(
        new Item("Dragon Heart", "+120 Max HP, +5 ATK", 120, 0, 5),
        new Item("Archmage Hat", "+100 Max Mana, +10 ATK", 0, 100, 10),
        new Item("Excalibur", "+25 ATK, +30 HP", 30, 0, 25),
        new Item("Angel Wings", "+60 Max HP, +60 Max Mana", 60, 60, 0)
    );

    public static final List<Item> Mystical = List.of(
        new Item("Infinity Gem", "ALL STATS +30", 30, 30, 15),
        new Item("Void Essence", "+200 Mana, +30 ATK", 0, 200, 30),
        new Item("Titan's Will", "+300 Max HP", 300, 0, 0),
        new Item("Death Scythe", "+50 ATK", 0, 0, 50)
    );



    public static List<Item> getRandomItems(int amount) {
        List<Item> result = new ArrayList<>();
        java.util.Random rand = new java.util.Random();

        for (int i = 0; i < amount; i++) {

            int roll = rand.nextInt(100); 
            
            List<Item> selectedPool;


            int mysticalChance = 0;
            int legendaryChance = 0;
            int rareChance = 0;

            if (currentStage >= 6) { 

                mysticalChance = 15;  
                legendaryChance = 35; 
                rareChance = 30;     

            } else if (currentStage >= 4) { 
                mysticalChance = 1;   
                legendaryChance = 15; 
                rareChance = 50;      
            } else if (currentStage >= 2) { 
                mysticalChance = 1;  
                legendaryChance = 5; 
                rareChance = 25;      
            } else { 
                rareChance = 5;

            }

            if (roll < mysticalChance) {
                selectedPool = Mystical;
            } else if (roll < mysticalChance + legendaryChance) {
                selectedPool = Legendary;
            } else if (roll < mysticalChance + legendaryChance + rareChance) {
                selectedPool = Rare;
            } else {
                selectedPool = NORMAL;
            }

            Item pickedItem = selectedPool.get(rand.nextInt(selectedPool.size()));
            result.add(pickedItem);
        }
        
        return result;
    }

    
    public static void resetHeroes() {
        MAGE = new mage();
        TANK = new tank();
        ARCHER = new archer();
        FIGHTER = new fighter();
        HEALER = new healer();
        
        currentStage = 1;
        playerName = "Player";
        System.out.println("--- GAME DATA RESET ---");
    }
    
}
