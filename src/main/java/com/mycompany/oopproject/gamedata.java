/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject;

import com.mycompany.oopproject.heroes.tank;
import com.mycompany.oopproject.heroes.mage;
import com.mycompany.oopproject.heroes.healer;
import com.mycompany.oopproject.heroes.fighter;
import com.mycompany.oopproject.heroes.archer;
import com.mycompany.oopproject.characters.hero;

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
    
    public static void resetHeroes() {
        MAGE = new mage();
        TANK = new tank();
        ARCHER = new archer();
        FIGHTER = new fighter();
        HEALER = new healer();
        
        currentStage = 1;
        System.out.println("--- GAME DATA RESET ---");
    }
    
}
