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
public class tank extends hero {
    
    public tank() {
        super("TANK", "/images/tank.png", 10, 6, 1);

        
        this.skills = new ArrayList<>();
        this.skills.add(new skill(" NORMAL ATTACK ", 1, 0, false,false));
        this.skills.add(new skill(" SHIELD BASH ", 2, 2, false,false));
        this.skills.add(new skill(" SLASH HAMMER ", 5, 3, false,false));
        
    }
}
