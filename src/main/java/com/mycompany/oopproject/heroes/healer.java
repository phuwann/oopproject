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
public class healer extends hero {
    
    public healer(){
        super("HEALER", "/images/healer.png", 9, 6, 1);
        
        this.skills = new ArrayList<>();
        this.skills.add(new skill(" NORMAL ATTACK ", 1, 0, false,false));
        this.skills.add(new skill(" HEALING LIGHT ", 5, 6, true,true));
        this.skills.add(new skill(" RENEW ", 3, 3, true,false));
        
    }
}