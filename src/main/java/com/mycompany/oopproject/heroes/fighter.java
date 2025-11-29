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
public class fighter extends hero {
    
    public fighter() {
        super("FIGHTER", "/images/fighter.png", 150, 60, 15);
        
        this.skills = new ArrayList<>();
        this.skills.add(new skill(" NORMAL ATTACK ", 0, 0, false,false));
        this.skills.add(new skill(" BLADE RUSH ", 25, 15, false,false));
        this.skills.add(new skill(" BLADE REAVER ", 15, 25, false,true));
    }
}
