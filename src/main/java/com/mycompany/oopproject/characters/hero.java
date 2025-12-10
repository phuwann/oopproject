/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject.characters;

import com.mycompany.oopproject.characters.character;
import com.mycompany.oopproject.characters.Item;
import java.util.ArrayList;

/**
 *
 * @author Phuwan
 */

/* FINAL */

public abstract class hero extends character {
    
    protected ArrayList<skill> skills;
    
    public hero(String name, String imagePath, int Maxhp, int Mana, int attack) {
        super(name, imagePath, Maxhp, Mana, attack);
        this.skills = new ArrayList<>();
    }
    
    
    public ArrayList<skill> getSkills() {
        return this.skills;
    }
    
    public void upgradeAllSkills(int amount) {
        for (skill s : this.skills) {
            s.upgradeBasePower(amount);
        }
        System.out.println(this.name + " ALL SKILLS UPGRADED BY " + amount);
    }
    
    public void applyItemStats(Item item) {
        if (item.getBonusHp() > 0) {
            this.upgradeMaxHp(item.getBonusHp());
        }
        if (item.getBonusMana() > 0) {
            this.upgradeMaxMana(item.getBonusMana());
        }
        if (item.getBonusAttack() > 0) {
            this.upgradeBaseAttack(item.getBonusAttack());
        }
    }
    
}