package com.mycompany.oopproject.monsters;

import com.mycompany.oopproject.characters.skill;
import com.mycompany.oopproject.characters.monster;
import java.util.ArrayList;

public class dragon extends monster {


    public dragon() {
        super("ANCIENT DRAGON", "/images/Dragon.png", 1200, 200, 35);

        this.skills = new ArrayList<>();
        this.skills.add(new skill("CLAW ATTACK", 15, 0, false, false));
        this.skills.add(new skill("FIRE BREATH", 25, 50, false, true));
    }
}