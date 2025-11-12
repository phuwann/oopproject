/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject.characters;

import com.mycompany.oopproject.characters.hero;
import com.mycompany.oopproject.characters.character;
import java.util.ArrayList;
/**
 *
 * @author Phuwan
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Phuwan
 */
public abstract class monster extends character {

    protected ArrayList<skill> skills;
    
    public ArrayList<skill> getSkills() {
        return this.skills;
    }
    
    public monster(String name, String imagePath, int Maxhp, int Mana, int attack) {
        super(name, imagePath, Maxhp, Mana, attack);
        this.skills = new ArrayList<>();
    }
    
    
    @Override
    public void takeDamage(int damageAmount) {
        this.currentHp -= damageAmount;
        
        if (this.currentHp < 0) {
            this.currentHp = 0;
        }
        
        System.out.println(this.name +  " take " + damageAmount + " DMG! (left HP: " + this.currentHp + ")");
        
        if (this.currentHp == 0) {
            System.out.println(this.name + " Dead!");
        }
    }

    public void useSkill(skill skill, hero target) {
        
        int damage = (this.attack + skill.getbasePower());
           
        damage = Math.max(1, damage); 
            
        System.out.println(this.name + " Use " + skill.getName() + " to " + target.getName() + "!");
        target.takeDamage(damage);
            
        
    }
    
}