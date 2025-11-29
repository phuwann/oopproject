/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject.heroes;

import com.mycompany.oopproject.characters.skill;
import com.mycompany.oopproject.characters.hero;
import java.util.ArrayList;

/**
 *
 * @author Phuwan
 */
public class mage extends hero {
    
    public mage() {
        super("Mage", "/images/mage.png", 90, 100, 8);
        
        this.skills = new ArrayList<>();
        this.skills.add(new skill("NORMAL ATTACK", 0, 0, false,false));
        this.skills.add(new skill("MAGIC BEAM", 50, 20, false,false));
        this.skills.add(new skill("MAGIC BOMB", 40, 45, false,true));
        
    }
    
}
