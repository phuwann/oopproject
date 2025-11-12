/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject.characters;

/**
 *
 * @author Phuwan
 */
public class skill {
    private String name;
    private int manaCost;
    private int basePower;
    private boolean isHealing;
    private boolean isAoE;

    public skill(String name, int basePower, int manaCost, boolean isHealing, boolean isAoE) {
        this.name = name;
        this.basePower = basePower;
        this.manaCost = manaCost;
        this.isHealing = isHealing;
        this.isAoE = isAoE;
        
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isHealing(){
        return isHealing;
    }

    public int getbasePower() {
        return basePower;
    }

    public int getManaCost() {
        return manaCost;
    }
    
    public boolean isAoE(){
        return isAoE;
    }
    
    public void upgradeBasePower(int amount) {
        if (!this.isHealing) {
             this.basePower += amount;
        }
    }
}
