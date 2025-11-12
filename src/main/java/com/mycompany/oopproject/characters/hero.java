/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject.characters;

import com.mycompany.oopproject.characters.character;
import java.util.ArrayList;
/**
 *
 * @author Phuwan
 */
public abstract class hero extends character {
    
    protected ArrayList<skill> skills;
    
    public hero(String name, String imagePath, int Maxhp, int Mana, int attack) {
        super(name, imagePath, Maxhp, Mana, attack);
        this.skills = new ArrayList<>();
    }
    
    
    public ArrayList<skill> getSkills() {
        return this.skills;
    }
    
    @Override
    public void takeDamage(int damageAmount) {
        this.currentHp -= damageAmount;
        
        if (this.currentHp < 0) {
            this.currentHp = 0;
        }
        
        System.out.println(this.name + " take " + damageAmount + " DMG! (left HP: " + this.currentHp + ")");
        
        if (this.currentHp == 0) {
            System.out.println(this.name + " dead!");
        }
    }
    
    public void upgradeAllSkills(int amount) {
        for (skill s : this.skills) {
            s.upgradeBasePower(amount);
        }
        System.out.println(this.name + " ALL SKILLS UPGRADED BY " + amount);
    }
    
}