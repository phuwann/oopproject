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
        super("ARCHER", "/images/archer.png", 5, 7, 2);
        
        this.skills = new ArrayList<>();
        this.skills.add(new skill(" NORMAL ATTACK ", 2, 0, false,false));
        this.skills.add(new skill(" PIERCING ARROW ", 5, 6, false,true));
        this.skills.add(new skill(" RAPID VOLLEY ", 4, 2, false,true));
    }
}
