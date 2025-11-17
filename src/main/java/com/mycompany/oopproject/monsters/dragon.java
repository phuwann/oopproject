package com.mycompany.oopproject.monsters;

import com.mycompany.oopproject.characters.skill;
import com.mycompany.oopproject.characters.monster;
import java.util.ArrayList;

public class dragon extends monster {


    public dragon() {
        super("DRAGON", "/images/Dragon.png", 50, 20, 5);

        this.skills = new ArrayList<>();
        this.skills.add(new skill("CLAW ATTACK", 2, 0, false, false));
        this.skills.add(new skill("FIRE BREATH", 8, 10, false, true));
    }
}