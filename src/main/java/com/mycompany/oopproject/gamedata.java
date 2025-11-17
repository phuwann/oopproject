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
    
    public static int currentStage = 7;
    public static String playerName = "Player";
    public static final int BOSS_STAGE = 10;
    
    public static final List<Item> ITEM_POOL = List.of(

        new Item("Ring of Power", "+1 ATK, +1 Mana", 0, 1, 1),

        new Item("Amulet of Strength", "+1 ATK, +1 Mana", 0, 1, 1),

        new Item("Steel Armor", "+2 Max HP", 2, 0, 0),

        new Item("Iron Helmet", "+2 Max HP", 2, 0, 0),

        new Item("Leather Pants", "+1 HP, +1 Mana", 1, 1, 0),

        new Item("Sturdy Boots", "+1 HP, +1 Mana", 1, 1, 0),

        new Item("Gauntlets of Might", "+1 HP, +1 Mana, +1 ATK", 1, 1, 1)
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
