/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject.characters;

/**
 *
 * @author Phuwan
 */
public class Item {
    private String name;
    private String description;
    
    private int bonusHp;
    private int bonusMana;
    private int bonusAttack;
    
    public Item(String name, String description, int bonusHp, int bonusMana, int bonusAttack) {
        this.name = name;
        this.description = description;
        this.bonusHp = bonusHp;
        this.bonusMana = bonusMana;
        this.bonusAttack = bonusAttack;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    public int getBonusHp() {
        return bonusHp;
    }

    public int getBonusMana() {
        return bonusMana;
    }

    public int getBonusAttack() {
        return bonusAttack;
    }
    
}
