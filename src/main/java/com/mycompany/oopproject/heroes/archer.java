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
public class archer extends hero {
    
    public archer(){
        super("ARCHER", "/images/archer.png", 100, 70, 25);
        
        this.skills = new ArrayList<>();
        this.skills.add(new skill(" NORMAL ATTACK ", 0, 0, false,false));
        this.skills.add(new skill(" PIERCING ARROW ", 35, 20, false,false));
        this.skills.add(new skill(" RAPID VOLLEY ", 15, 30, false,true));
    }
}
