/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject.characters;

/**
 *
 * @author Phuwan
 */
public abstract class character {
    protected String name;
    protected String imagePath; 
    protected int    Maxhp;
    protected int currentHp;
    protected int MaxMana;
    protected int    Mana;
    protected int    attack;

    
    public character(String name, String imagePath, int Maxhp, int Mana, int attack) {
        this.name = name;
        this.imagePath = imagePath;
        this.Maxhp = Maxhp;
        this.currentHp = Maxhp;
        this.Mana = Mana;
        this.MaxMana = Mana;
        this.attack = attack;
    }
    
    public abstract void takeDamage(int damageAmount);
    
    public void resetHp() {
        this.currentHp = this.Maxhp;
        System.out.println(this.name + " HP reset to full: " + this.currentHp);
    }
    
    public void resetMana() {
        this.Mana = this.MaxMana;
        System.out.println(this.name + " MANA reset to full: " + this.Mana);
    }

    public String getName() {
        return this.name;
    }
    
    public int getMaxhp() {
        return this.Maxhp;
    }
    
    public int getcurrentHp() {
        return this.currentHp;
    }
    
    public int getmana() {
        return this.Mana;
    }
    
    public int getMaxMana() {
        return this.MaxMana;
    }
    
    public int getAttack() {
        return this.attack;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    
    public void regenerateMana(int amount) {
        if (this.currentHp > 0) { 
            this.Mana += amount;
            if (this.Mana > this.MaxMana) {
                this.Mana = this.MaxMana;
            }
            System.out.println(this.name + " REGENERATES " + amount + " MANA! (NOW: " + this.Mana + "/" + this.MaxMana + ")");
        }
    }
    
    public void heal(int amount) {
        this.currentHp += amount;
        if (this.currentHp > this.Maxhp) {
            this.currentHp = this.Maxhp;
        }
        System.out.println(this.name + " HEAL " + amount + " (NOW HP: " + this.currentHp + ")");
    }

    public void useSkill(skill skill, character target) {
    
        if (skill.isHealing()) {
            target.heal(skill.getbasePower());
            System.out.println(this.name + " USE " + skill.getName() + " HEAL HP FOR " + target.getName());
        } else {
            int damage = (this.attack + skill.getbasePower());
            damage = Math.max(1, damage);
            System.out.println(this.name + " USE " + skill.getName() + " ATTACK " + target.getName());
            target.takeDamage(damage);
        }
    }
    
    public void deductMana(int amount) {
        this.Mana -= amount;
        if (this.Mana < 0) {
            this.Mana = 0;
        }
    }
    
    public void upgradeMaxHp(int amount) {
        this.Maxhp += amount;
        this.currentHp += amount;
        System.out.println(this.name + " MAX HP INCREASED TO " + this.Maxhp);
    }

    public void upgradeMaxMana(int amount) {
        this.MaxMana += amount; 
        this.Mana += amount; 
        System.out.println(this.name + " MAX MANA INCREASED TO " + this.MaxMana);
    }
    
    public void upgradeBaseAttack(int amount) {
        this.attack += amount;
        System.out.println(this.name + " ATTACK INCREASED TO " + this.attack);
    }
    
}
