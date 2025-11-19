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
    
    public static final List<Item> ITEM_POOL = List.of(

        new Item("Normal Ring", "+1 ATK, +1 Mana", 0, 1, 1),
        new Item("Normal Amulet", "+1 ATK, +1 Mana", 0, 1, 1),
        new Item("Normal Armor", "+2 Max HP", 2, 0, 0),
        new Item("Normal Helmet", "+2 Max HP", 2, 0, 0),
        new Item("Normal Pants", "+2 Max HP", 1, 1, 0),
        new Item("Normal Boots", "+1 Max HP, +1 Mana", 1, 1, 0),
        new Item("Normal Gloves", "+1 Max HP, +1 Mana, +1 ATK", 1, 1, 1),

        new Item("Rare Ruby Ring", "+3 ATK, +2 Mana", 0, 2, 3),
        new Item("Rare Emerald Armor", "+5 Max HP", 5, 0, 0),
        new Item("Rare Swift Boots", "+3 Max HP, +3 Mana", 3, 3, 0),
        new Item("Rare Vampire Fangs", "+4 ATK, -1 HP", -1, 0, 4),

        new Item("Legendary Dragon Heart", "+15 Max HP, +5 ATK", 15, 0, 5),
        new Item("Legendary Wizard Hat", "+20 Max Mana, +5 ATK", 0, 20, 5),
        new Item("Legendary Excalibur", "+12 ATK, +5 HP", 5, 0, 12),
        new Item("Legendary Angel Wings", "+10 Max HP, +10 Max Mana", 10, 10, 0),

        new Item("Mystical Infinity Gem", "ALL STATS +20 (GOD TIER)", 20, 20, 20),
        new Item("Mystical Void Essence", "+50 Mana, +25 ATK (Glass Cannon)", 0, 50, 25),
        new Item("Mystical Titan's Will", "+100 Max HP (Immortal Tank)", 100, 0, 0),
        new Item("Mystical Death Scythe", "+40 ATK (One Hit Kill)", 0, 0, 40)
        );

    public static List<Item> getRandomItems(int amount) {
        ArrayList<Item> shuffledList = new ArrayList<>(ITEM_POOL);
        Collections.shuffle(shuffledList);
        return shuffledList.subList(0, amount);
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
