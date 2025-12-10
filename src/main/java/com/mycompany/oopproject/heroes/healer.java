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

/* FINAL */

public class healer extends hero {
    
    public healer(){
        super("HEALER", "/images/healer.png", 110, 100, 6);
        
        this.skills = new ArrayList<>();
        this.skills.add(new skill(" NORMAL ATTACK ", 0, 0, false,false));
        this.skills.add(new skill(" HEALING LIGHT ", 25, 35, true,true));
        this.skills.add(new skill(" RENEW ", 60, 25, true,false));
        
    }
}