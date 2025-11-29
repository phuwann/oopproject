/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject.monsters;

import com.mycompany.oopproject.characters.skill;
import com.mycompany.oopproject.characters.monster;
import java.util.ArrayList;

/**
 *
 * @author Phuwan
 */
public class orc extends monster {
    
    public orc() {
        this(1);
    }

    public orc(int stage) {

        super(
            getMonsterNamePrefix(stage) + " (Lvl " + stage + ")",
            getMonsterImagePath(stage),                   
            50 + ((stage - 1) * 20),                 
            0,                            
            10 + ((stage - 1) * 3)                                
        );

        this.skills = new ArrayList<>();
        this.skills.add(new skill(" NORMAL ATTACK ", 0, 0, false, false));
        
        if (stage >= 5) {
             this.skills.add(new skill("CRITICAL BASH", 10, 0, false, false));
        }
    }
    
    private static String getMonsterNamePrefix(int stage) {
        int monsterGroup = (stage - 1) / 2;
        switch (monsterGroup) {
            case 0: return "ORC";
            case 1: return "GOLEM";
            case 2: return "GOBLIN"; 
            case 3: return "CYCLOPS";
            case 4: return "HELLHOUND";
            default: return "ORC";
        }
    }

    private static String getMonsterImagePath(int stage) {
        int monsterGroup = (stage - 1) / 2;
        switch (monsterGroup) {
            case 0: return "/images/orc.png";
            case 1: return "/images/golem.png";
            case 2: return "/images/goblin.png";
            case 3: return "/images/cyclops.png";
            case 4: return "/images/dog.png";
            default: return "/images/orc.png";
        }
    }
    
}
