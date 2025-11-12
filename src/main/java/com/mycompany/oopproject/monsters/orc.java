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

        super("ORC (Lvl " + stage + ")",      // name
          "/images/orc.png",             // imagepath
          7 + ((stage - 1) * 2),         // Hp
          0,                             // Mana
          3 + (stage - 1));              //Atk

        this.skills = new ArrayList<>();
        this.skills.add(new skill(" NORMAL ATTACK ", 0, 0, false, false));
    }
}
