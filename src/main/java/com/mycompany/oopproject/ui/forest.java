/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.oopproject.ui;

import com.mycompany.oopproject.SoundManager;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import com.mycompany.oopproject.characters.character;
import com.mycompany.oopproject.heroes.fighter;
import com.mycompany.oopproject.gamedata;
import com.mycompany.oopproject.characters.hero;
import com.mycompany.oopproject.heroes.mage;
import com.mycompany.oopproject.characters.monster;
import com.mycompany.oopproject.monsters.orc;
import com.mycompany.oopproject.characters.skill;
import com.mycompany.oopproject.heroes.tank;
import com.mycompany.oopproject.monsters.dragon;
import com.mycompany.oopproject.monsters.EmptyMonster;


/* FINAL */

public class forest extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(forest.class.getName());
    
    
    private hero characterToDisplay1;
    private hero characterToDisplay2;
    private hero characterToDisplay3;
    private monster characterToDisplay4;
    private monster characterToDisplay5;
    private monster characterToDisplay6;
    private java.util.ArrayList<hero> heroes;
    private java.util.ArrayList<monster> monsters;
    private hero currentHero;
    private int heroTurnIndex = 0; 
    private skill selectedSkill = null; 
    private boolean isHeroTurn = true;
    private int monsterAttackIndex = 0;
    private boolean isTankTaunting = false;
    private hero theTank = null;
    private SoundManager soundManager = new SoundManager();
    

    
    public forest(hero h1, hero h2, hero h3, monster m1, monster m2, monster m3)    {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        
        soundManager.playBGM("/sounds/forest_bmg.wav");
        float startVolume = 0.2f; 
        soundManager.setVolume(startVolume);
        sliderVolume.setValue((int)(startVolume * 100));
        
        setDynamicBackground();
        
        lblStageInfo.setText("STAGE " + gamedata.currentStage);
        lblPlayerName.setText(gamedata.playerName);
        
        this.characterToDisplay1 = h1;
        this.characterToDisplay2 = h2;
        this.characterToDisplay3 = h3;
        this.characterToDisplay4 = m1;
        this.characterToDisplay5 = m2;
        this.characterToDisplay6 = m3;
        this.heroes = new java.util.ArrayList<>(java.util.Arrays.asList(h1, h2, h3));
        
        for (hero h : this.heroes) {
            if (h instanceof tank) {
                this.theTank = h;
                break;
            }
        }
        
        this.monsters = new java.util.ArrayList<>();
        if (m1 != null && !(m1 instanceof EmptyMonster)) this.monsters.add(m1);
        if (m2 != null && !(m2 instanceof EmptyMonster)) this.monsters.add(m2);
        if (m3 != null && !(m3 instanceof EmptyMonster)) this.monsters.add(m3);

        txtGamelog.setEditable(false);
        txtGamelog.setText("--- GAME START! ---\n");
        
        hero1.setIcon(createScaledImageIcon(
            characterToDisplay1.getImagePath(), 
            270, 
            300 
        ));

        hero2.setIcon(createScaledImageIcon(
            characterToDisplay2.getImagePath(),
            270,
            300
        ));

        hero3.setIcon(createScaledImageIcon(
            characterToDisplay3.getImagePath(),
            270,
            300
        ));
        

        if (m1 != null && !(m1 instanceof EmptyMonster)) {
            txtMonster1.setText(m1.getName());
            monster1.setIcon(createScaledImageIcon(m1.getImagePath(), 230, 270));
        } else {

            monster1.setVisible(false);
            txtMonster1.setVisible(false);
            hpMonster1.setVisible(false);
        }

        if (m2 != null && !(m2 instanceof EmptyMonster)) {
            txtMonster2.setText(m2.getName());
            monster2.setIcon(createScaledImageIcon(m2.getImagePath(), 230, 270));
        } else {

            monster2.setVisible(false);
            txtMonster2.setVisible(false);
            hpMonster2.setVisible(false);
        }

        if (m3 != null && !(m3 instanceof EmptyMonster)) {
            
            txtMonster3.setText(m3.getName());
            
            if (m3 instanceof dragon) {
                monster3.setIcon(createScaledImageIcon(m3.getImagePath(), 350, 400)); 
            } else {
                monster3.setIcon(createScaledImageIcon(m3.getImagePath(), 230, 270));
            }
            
        } else {
            monster3.setVisible(false);
            txtMonster3.setVisible(false);
            hpMonster3.setVisible(false);
        }

        setupBars();
        updateBars();

        txtHero1.setText(h1.getName());
        txtHero2.setText(h2.getName());
        txtHero3.setText(h3.getName());

        btnSkill1.addActionListener(evt -> selectSkill(0));
        btnSkill2.addActionListener(evt -> selectSkill(1));
        btnSkill3.addActionListener(evt -> selectSkill(2));
        
        btnSkill1.setEnabled(true);
        btnSkill2.setEnabled(true);
        btnSkill3.setEnabled(true);
        
        selectedSkill = null;
        isHeroTurn = true;
        
        monster1.addMouseListener(new java.awt.event.MouseAdapter() { 
        public void mouseClicked(java.awt.event.MouseEvent evt) { targetClicked(characterToDisplay4); } 
        });
        monster2.addMouseListener(new java.awt.event.MouseAdapter() { 
            public void mouseClicked(java.awt.event.MouseEvent evt) { targetClicked(characterToDisplay5); } 
        });
        monster3.addMouseListener(new java.awt.event.MouseAdapter() { 
            public void mouseClicked(java.awt.event.MouseEvent evt) { targetClicked(characterToDisplay6); } 
        });

        hero1.addMouseListener(new java.awt.event.MouseAdapter() { 
            public void mouseClicked(java.awt.event.MouseEvent evt) { targetClicked(characterToDisplay1); } 
        });
        hero2.addMouseListener(new java.awt.event.MouseAdapter() { 
            public void mouseClicked(java.awt.event.MouseEvent evt) { targetClicked(characterToDisplay2); } 
        });
        hero3.addMouseListener(new java.awt.event.MouseAdapter() { 
            public void mouseClicked(java.awt.event.MouseEvent evt) { targetClicked(characterToDisplay3); } 
        });

        startGame();
        
    }
    
    private void startGame() {
        heroTurnIndex = 0;
        currentHero = heroes.get(heroTurnIndex);
        isHeroTurn = true;
        
        updateTurnUI();
    }   
    
    private void selectSkill(int skillIndex) {
        if (!isHeroTurn) return;

        selectedSkill = currentHero.getSkills().get(skillIndex);
        
        if (currentHero.getmana() < selectedSkill.getManaCost()) {
            txtGamelog.append(currentHero.getName() + " tried to use " + selectedSkill.getName() + ", but not enough mana!\n");
            txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());
            selectedSkill = null; 
            return;
        }

        if (selectedSkill.getName().equals("IRON DEFENSE")) {
            
            currentHero.deductMana(selectedSkill.getManaCost());
            isTankTaunting = true; 

            txtGamelog.append(currentHero.getName() + " USE IRON DEFENSE!\n(PROTECT TEAMMATES)\n");
            txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());
            updateBars();

            heroTurnIndex = (heroTurnIndex + 1) % heroes.size(); 
            startMonsterTurn();
            return;
        }
        
        if (selectedSkill.isAoE()) {
            
            currentHero.deductMana(selectedSkill.getManaCost());

            if (selectedSkill.isHealing()) {

                txtGamelog.append(currentHero.getName() + " USE " + selectedSkill.getName() + "\n (HEAL ALL)!\n");
                txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());

                for (hero h : heroes) {
                    if (h.getcurrentHp() > 0) { 
                        soundManager.playSFX("/sounds/heal.wav");
                        
                        playHealEffect(getLabelForCharacter(h));
                        
                        String result = currentHero.useSkill(selectedSkill, h); 
                        txtGamelog.append("   " + h.getName() + result + "\n");
                        
                        showDamageEffect(result, getLabelForCharacter(h));
                    }
                }
            } else {
                txtGamelog.append(currentHero.getName() + " USE " + selectedSkill.getName() + "\n (ATTACK ALL)!\n");
                txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());

                for (monster m : monsters) {
                    if (m.getcurrentHp() > 0) {
                        soundManager.playSFX("/sounds/hit.wav");
                       
                        playHitEffect(getLabelForCharacter(m));
                        
                        String result = currentHero.useSkill(selectedSkill, m);
                        txtGamelog.append("   " + m.getName() + result + "\n");
                        
                        showDamageEffect(result, getLabelForCharacter(m));
                    }
                }
            }
            
            updateBars();

            heroTurnIndex = (heroTurnIndex + 1) % heroes.size(); 
            startMonsterTurn();

        } else {
            if (selectedSkill.isHealing()) { 
                txtGamelog.append(currentHero.getName() + " SELECT " + selectedSkill.getName() + ".\n (Choose a hero to Heal)\n");
            } else {
                txtGamelog.append(currentHero.getName() + " SELECT " + selectedSkill.getName() + ".\n (Choose a monster to Attack)\n");
            }
            txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());
        }
    }
    
    private void targetClicked(character target) {
    if (!isHeroTurn || selectedSkill == null) {
            return; 
        }

    
        if (selectedSkill.isHealing() && (target instanceof monster)) {
            txtGamelog.append("Wrong! " + selectedSkill.getName() + " Can only be used on Hero.\n");
            txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());
            return;
        }
        if (!selectedSkill.isHealing() && (target instanceof hero)) {
            txtGamelog.append("Wrong! " + selectedSkill.getName() + " Can only be used on Monster\n");
            txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());
            return;
        }
        if (target.getcurrentHp() == 0) {
            txtGamelog.append(target.getName() + " DEAD!\n");
            txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());
            return;
        }

        if (currentHero.getmana() < selectedSkill.getManaCost()) {
            txtGamelog.append(currentHero.getName() + " tried to use " + selectedSkill.getName() + ", but not enough mana!\n");
            txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());
            selectedSkill = null;
            return; 
        }

        JLabel targetLabel = getLabelForCharacter(target);
        
        if (selectedSkill.isHealing()) {
            soundManager.playSFX("/sounds/heal.wav");
            playHealEffect(targetLabel);
        } else {
            soundManager.playSFX("/sounds/hit.wav");
            playHitEffect(targetLabel);
        }
        
        currentHero.deductMana(selectedSkill.getManaCost());

        txtGamelog.append(currentHero.getName() + " USE " + selectedSkill.getName() + " ON " + target.getName());
        String result = currentHero.useSkill(selectedSkill, target);
        txtGamelog.append(result + "\n");
        
        showDamageEffect(result, targetLabel);
        
        txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());

        updateBars(); 
        
        heroTurnIndex = (heroTurnIndex + 1) % heroes.size();
        
        startMonsterTurn();
    }
   
    private boolean checkGameOver() {
            boolean allMonstersDead = monsters.stream().allMatch(m -> m.getcurrentHp() == 0);
            boolean allHeroesDead = heroes.stream().allMatch(h -> h.getcurrentHp() == 0);

            java.awt.Font popupFont = new java.awt.Font("Book Antiqua", 1, 18);
            java.awt.Font loseFont = new java.awt.Font("Chiller", 1, 48);

            if (allMonstersDead) {
                
                soundManager.stop();
                
                if (gamedata.currentStage == gamedata.BOSS_STAGE) {

                    txtGamelog.append("\n🏆 === YOU BEAT THE GAME! === 🏆\n");
                    txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());

                    String msg = "<html><center>Congratulations, " + gamedata.playerName + "!<br>You have defeated the final boss and saved the realm!</center></html>";
                    javax.swing.JLabel lblMsg = new javax.swing.JLabel(msg);
                    lblMsg.setFont(popupFont);

                    javax.swing.JOptionPane.showMessageDialog(this, 
                        lblMsg,
                        "VICTORY!", 
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);

                    gamedata.resetHeroes(); 
                    new GUIMain().setVisible(true);
                    this.dispose();

                } else {

                    if (gamedata.currentStage % 2 == 0) {
                        ItemRewardScreen itemDialog = new ItemRewardScreen(this, true, this.heroes);
                        itemDialog.setVisible(true);

                    gamedata.currentStage++; 
                    int nextStage = gamedata.currentStage;

                    monster m1_next, m2_next, m3_next;

                    }else{
                        RewardScreen rewardDialog = new RewardScreen(this, true, this.heroes);
                        rewardDialog.setVisible(true);
                    }

                    gamedata.currentStage++; 
                    int nextStage = gamedata.currentStage;

                    monster m1_next, m2_next, m3_next;

                    if (nextStage == gamedata.BOSS_STAGE) {
                          m1_next = new EmptyMonster();
                          m2_next = new EmptyMonster();
                          m3_next = new dragon();
                    } else {
                          m1_next = new orc(nextStage);
                          m2_next = new orc(nextStage);
                          m3_next = new orc(nextStage);
                    }

                    hero h1 = this.heroes.get(0);
                    hero h2 = this.heroes.get(1);
                    hero h3 = this.heroes.get(2);
                    h1.resetHp();
                    h1.resetMana();
                    h2.resetHp();
                    h2.resetMana();
                    h3.resetHp();
                    h3.resetMana();
                    new forest(h1, h2, h3, m1_next, m2_next, m3_next).setVisible(true);
                    this.dispose(); 
                }
                return true;
            }

            if (allHeroesDead) {
                lblTurnInfo.setFont(loseFont); 
                lblTurnInfo.setForeground(java.awt.Color.RED); 
                lblTurnInfo.setText("YOU LOSE!"); 


                txtGamelog.append("\n💀 === YOU LOSE! === 💀\n");
                txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());
                isHeroTurn = false;
                
                soundManager.stop();
                
                javax.swing.JLabel lblLose = new javax.swing.JLabel("GAME OVER!");
                lblLose.setFont(popupFont);
                javax.swing.JOptionPane.showMessageDialog(this, lblLose, "Defeat", javax.swing.JOptionPane.ERROR_MESSAGE);

                gamedata.resetHeroes();

                new GUIMain().setVisible(true);
                this.dispose();
                return true;
            }

            return false;
        }

    private void setupBars() {
        hpHero1.setMaximum(characterToDisplay1.getMaxhp());
        hpHero1.setValue(characterToDisplay1.getcurrentHp());
        hpHero1.setStringPainted(true);
        hpHero1.setString("HP " + characterToDisplay1.getcurrentHp() + "/" + characterToDisplay1.getMaxhp());
        
        ManaBar1.setMaximum(characterToDisplay1.getMaxMana()); 
        ManaBar1.setValue(characterToDisplay1.getmana());
        ManaBar1.setStringPainted(true);
        ManaBar1.setString("MANA " + characterToDisplay1.getmana() + "/" + characterToDisplay1.getMaxMana());


        hpHero2.setMaximum(characterToDisplay2.getMaxhp());
        hpHero2.setValue(characterToDisplay2.getcurrentHp());
        hpHero2.setStringPainted(true);
        hpHero2.setString("HP " + characterToDisplay2.getcurrentHp() + "/" + characterToDisplay2.getMaxhp()); 
        
        ManaBar2.setMaximum(characterToDisplay2.getMaxMana()); 
        ManaBar2.setValue(characterToDisplay2.getmana());
        ManaBar2.setStringPainted(true);
        ManaBar2.setString("MANA " + characterToDisplay2.getmana() + "/" + characterToDisplay2.getMaxMana());



        hpHero3.setMaximum(characterToDisplay3.getMaxhp());
        hpHero3.setValue(characterToDisplay3.getcurrentHp());
        hpHero3.setStringPainted(true);
        hpHero3.setString("HP" + characterToDisplay3.getcurrentHp() + "/" + characterToDisplay3.getMaxhp());
        
        ManaBar3.setMaximum(characterToDisplay3.getMaxMana()); 
        ManaBar3.setValue(characterToDisplay3.getmana());
        ManaBar3.setStringPainted(true);
        ManaBar3.setString("MANA " + characterToDisplay3.getmana() + "/" + characterToDisplay3.getMaxMana());

    
        hpMonster1.setMaximum(characterToDisplay4.getMaxhp());
        hpMonster1.setValue(characterToDisplay4.getcurrentHp());
        hpMonster1.setStringPainted(true);
        hpMonster1.setString("HP " + characterToDisplay4.getcurrentHp() + "/" + characterToDisplay4.getMaxhp());


        hpMonster2.setMaximum(characterToDisplay5.getMaxhp());
        hpMonster2.setValue(characterToDisplay5.getcurrentHp());
        hpMonster2.setStringPainted(true);
        hpMonster2.setString("HP " + characterToDisplay5.getcurrentHp() + "/" + characterToDisplay5.getMaxhp());


        hpMonster3.setMaximum(characterToDisplay6.getMaxhp());
        hpMonster3.setValue(characterToDisplay6.getcurrentHp());
        hpMonster3.setStringPainted(true);
        hpMonster3.setString("HP " + characterToDisplay6.getcurrentHp() + "/" + characterToDisplay6.getMaxhp());


    }

    public void updateBars() {
        hpHero1.setValue(characterToDisplay1.getcurrentHp());
        hpHero1.setString("HP " + characterToDisplay1.getcurrentHp() + "/" + characterToDisplay1.getMaxhp());
        ManaBar1.setValue(characterToDisplay1.getmana());
        ManaBar1.setString("MANA " + characterToDisplay1.getmana() + "/" + characterToDisplay1.getMaxMana());
        if (characterToDisplay1.getcurrentHp() == 0) {
            hero1.setVisible(false);
        }
        
        hpHero2.setValue(characterToDisplay2.getcurrentHp());
        hpHero2.setString("HP " + characterToDisplay2.getcurrentHp() + "/" + characterToDisplay2.getMaxhp());
        ManaBar2.setValue(characterToDisplay2.getmana());
        ManaBar2.setString("MANA " + characterToDisplay2.getmana() + "/" + characterToDisplay2.getMaxMana());
        if (characterToDisplay2.getcurrentHp() == 0) {
            hero2.setVisible(false);
        }
        
        hpHero3.setValue(characterToDisplay3.getcurrentHp());
        hpHero3.setString("HP " + characterToDisplay3.getcurrentHp() + "/" + characterToDisplay3.getMaxhp());
        ManaBar3.setValue(characterToDisplay3.getmana());
        ManaBar3.setString("MANA " + characterToDisplay3.getmana() + "/" + characterToDisplay3.getMaxMana());
        if (characterToDisplay3.getcurrentHp() == 0) {
            hero3.setVisible(false);
        }
        
        hpMonster1.setValue(characterToDisplay4.getcurrentHp());
        hpMonster1.setString("HP " + characterToDisplay4.getcurrentHp() + "/" + characterToDisplay4.getMaxhp());
        if (characterToDisplay4.getcurrentHp() == 0) {
            monster1.setVisible(false);
        }
        
        hpMonster2.setValue(characterToDisplay5.getcurrentHp());
        hpMonster2.setString("HP " + characterToDisplay5.getcurrentHp() + "/" + characterToDisplay5.getMaxhp());
        if (characterToDisplay5.getcurrentHp() == 0) {
            monster2.setVisible(false);
        }
        
        hpMonster3.setValue(characterToDisplay6.getcurrentHp());
        hpMonster3.setString("HP " + characterToDisplay6.getcurrentHp() + "/" + characterToDisplay6.getMaxhp());
        if (characterToDisplay6.getcurrentHp() == 0) {
            monster3.setVisible(false);
        }
        
    }
    
    private void updateTurnUI() {
        lblTurnInfo.setText("Now Turn " + currentHero.getName());
        txtGamelog.append("\n--- Turn " + currentHero.getName() + " ---\n");

        java.util.ArrayList<skill> skills = currentHero.getSkills(); 
        btnSkill1.setText(skills.get(0).getName());
        btnSkill1.setToolTipText(createSkillTooltip(skills.get(0)));
        
        btnSkill2.setText(skills.get(1).getName()); 
        btnSkill2.setToolTipText(createSkillTooltip(skills.get(1)));
        
        btnSkill3.setText(skills.get(2).getName()); 
        btnSkill3.setToolTipText(createSkillTooltip(skills.get(2)));

        btnSkill1.setEnabled(true);
        btnSkill2.setEnabled(true);
        btnSkill3.setEnabled(true);

        selectedSkill = null;
        isHeroTurn = true;
    }

    private void startMonsterTurn() {
        
        
        if (checkGameOver()) return; 

        boolean allMonstersDead = monsters.stream().allMatch(m -> m.getcurrentHp() == 0);
        if (allMonstersDead) {

            startHeroTurn();
            return;
        }

        while (monsters.get(monsterAttackIndex).getcurrentHp() == 0) {
            monsterAttackIndex = (monsterAttackIndex + 1) % monsters.size();
        }

        monster m = monsters.get(monsterAttackIndex);
        monsterAttackIndex = (monsterAttackIndex + 1) % monsters.size();

        isHeroTurn = false;
        lblTurnInfo.setText("Monster Turn");
        txtGamelog.append("\n--- Monster Turn (" + m.getName() + ") ---\n");
        txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());
        btnSkill1.setEnabled(false);
        btnSkill2.setEnabled(false);
        btnSkill3.setEnabled(false);

        javax.swing.Timer monsterTimer = new javax.swing.Timer(1600, e -> {

            java.util.ArrayList<hero> livingHeroes = new java.util.ArrayList<>();
            for (hero h : heroes) {
                if (h.getcurrentHp() > 0) {
                    livingHeroes.add(h);
                }
            }
            
            if (!livingHeroes.isEmpty()) {
                hero target;
                
                if (isTankTaunting && theTank != null && theTank.getcurrentHp() > 0) {
                    target = theTank;
                    txtGamelog.append("(Tank protects friends!)\n");
                } else {
                    target = livingHeroes.get(new java.util.Random().nextInt(livingHeroes.size()));
                }
                
                skill skillToUse;
                
                if (m.getSkills().size() > 1 && new java.util.Random().nextInt(3) == 0) { 
                    skillToUse = m.getSkills().get(1);
               } else {
                    skillToUse = m.getSkills().get(0);
               }
                
                playHitEffect(getLabelForCharacter(target));
                
                txtGamelog.append(m.getName() + " USE " + skillToUse.getName() + " TO " + target.getName() + "!\n");
                txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());
                m.useSkill(skillToUse, target);
                
                String result = m.useSkill(skillToUse, target);
                
                showDamageEffect(result, getLabelForCharacter(target));
                
                soundManager.playSFX("/sounds/Oof.wav");
                
                updateBars();
            }

            javax.swing.Timer cooldownTimer = new javax.swing.Timer(1600, e_cooldown -> {
                startHeroTurn(); 
            });
            cooldownTimer.setRepeats(false);
            cooldownTimer.start();
        });
        monsterTimer.setRepeats(false);
        monsterTimer.start();
    }

    private void startHeroTurn() {
        if (checkGameOver()) return;

        boolean allHeroesDead = heroes.stream().allMatch(h -> h.getcurrentHp() == 0);
        if (allHeroesDead) {
            checkGameOver(); 
            return;
        }
        
        boolean isNewRound = (heroTurnIndex == 0);
        
        while (heroes.get(heroTurnIndex).getcurrentHp() == 0) {
            heroTurnIndex = (heroTurnIndex + 1) % heroes.size();
            
            if (heroTurnIndex == 0) {
            isNewRound = true;
            }         
        }
        
        if (isNewRound) {
            txtGamelog.append("\n--- ALL HEROES REGENERATE MANA --- \n");
            txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());

            for (hero h : heroes) {
                h.regenerateMana(20);
            }

            updateBars();
            
            txtGamelog.append("--- The environment changes... ---\n");
            txtGamelog.setCaretPosition(txtGamelog.getDocument().getLength());
        }

        currentHero = heroes.get(heroTurnIndex);
        
        if (currentHero instanceof tank) {
            if (isTankTaunting) {
                isTankTaunting = false;
                txtGamelog.append("Tank's Iron Defense faded.\n");
            }
        }
        
        isHeroTurn = true;
        updateTurnUI();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sliderVolume = new javax.swing.JSlider();
        btnSkill1 = new javax.swing.JButton();
        btnSkill2 = new javax.swing.JButton();
        btnSkill3 = new javax.swing.JButton();
        monster3 = new RotatedLabel();
        monster2 = new RotatedLabel();
        hero3 = new RotatedLabel();
        hero1 = new RotatedLabel();
        hero2 = new RotatedLabel();
        hpHero1 = new javax.swing.JProgressBar();
        hpHero2 = new javax.swing.JProgressBar();
        monster1 = new RotatedLabel();
        hpHero3 = new javax.swing.JProgressBar();
        txtHero1 = new javax.swing.JLabel();
        txtHero2 = new javax.swing.JLabel();
        txtMonster1 = new javax.swing.JLabel();
        hpMonster3 = new javax.swing.JProgressBar();
        hpMonster2 = new javax.swing.JProgressBar();
        hpMonster1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGamelog = new javax.swing.JTextArea();
        lblTurnInfo = new javax.swing.JLabel();
        txtHero3 = new javax.swing.JLabel();
        txtMonster2 = new javax.swing.JLabel();
        txtMonster3 = new javax.swing.JLabel();
        ManaBar3 = new javax.swing.JProgressBar();
        ManaBar2 = new javax.swing.JProgressBar();
        ManaBar1 = new javax.swing.JProgressBar();
        lblStageInfo = new javax.swing.JLabel();
        lblPlayerName = new javax.swing.JLabel();
        bgLobby = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sliderVolume.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderVolumeStateChanged(evt);
            }
        });
        getContentPane().add(sliderVolume, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 120, -1));

        btnSkill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkill1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnSkill1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 160, 40));
        getContentPane().add(btnSkill2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 160, 40));
        getContentPane().add(btnSkill3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, 160, 40));
        getContentPane().add(monster3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 340, 320));
        getContentPane().add(monster2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 320, 290, 280));
        getContentPane().add(hero3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 260, 270));
        getContentPane().add(hero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 280, 260));
        getContentPane().add(hero2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 290, 280));
        getContentPane().add(hpHero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 170, 20));
        getContentPane().add(hpHero2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 20));
        getContentPane().add(monster1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 290, 280));
        getContentPane().add(hpHero3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 170, 20));

        txtHero1.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        txtHero1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtHero1.setText("jLabel1");
        getContentPane().add(txtHero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        txtHero2.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        txtHero2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtHero2.setText("jLabel2");
        getContentPane().add(txtHero2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        txtMonster1.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        txtMonster1.setText("jLabel3");
        getContentPane().add(txtMonster1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, -1, -1));
        getContentPane().add(hpMonster3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 180, 20));
        getContentPane().add(hpMonster2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 180, 20));
        getContentPane().add(hpMonster1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 180, 20));

        txtGamelog.setColumns(20);
        txtGamelog.setRows(5);
        jScrollPane1.setViewportView(txtGamelog);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 390, 120));

        lblTurnInfo.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        lblTurnInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblTurnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 100, 30));

        txtHero3.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        txtHero3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtHero3.setText("jLabel3");
        getContentPane().add(txtHero3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, -1, -1));

        txtMonster2.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        txtMonster2.setText("jLabel3");
        getContentPane().add(txtMonster2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 90, -1, -1));

        txtMonster3.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        txtMonster3.setText("jLabel3");
        getContentPane().add(txtMonster3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, -1));
        getContentPane().add(ManaBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 170, 20));
        getContentPane().add(ManaBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, 20));
        getContentPane().add(ManaBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 170, 20));

        lblStageInfo.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        lblStageInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStageInfo.setText("jLabel1");
        getContentPane().add(lblStageInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 110, 20));

        lblPlayerName.setFont(new java.awt.Font("Book Antiqua", 1, 14)); // NOI18N
        lblPlayerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblPlayerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 70, 20));

        bgLobby.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forest.png"))); // NOI18N
        getContentPane().add(bgLobby, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSkill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkill1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSkill1ActionPerformed

    private void sliderVolumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderVolumeStateChanged
        // TODO add your handling code here:                                       
        int sliderValue = sliderVolume.getValue();
        float volumeScale = sliderValue / 100.0f;

        soundManager.setVolume(volumeScale);
    }//GEN-LAST:event_sliderVolumeStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        hero t1 = new mage();
        hero t2 = new tank();
        hero t3 = new fighter();
        monster m1 = new orc();
        monster m2 = new orc();
        monster m3 = new orc();
        
        java.awt.EventQueue.invokeLater(() -> new forest(t1,t2,t3,m1,m2,m3).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ManaBar1;
    private javax.swing.JProgressBar ManaBar2;
    private javax.swing.JProgressBar ManaBar3;
    private javax.swing.JLabel bgLobby;
    private javax.swing.JButton btnSkill1;
    private javax.swing.JButton btnSkill2;
    private javax.swing.JButton btnSkill3;
    private javax.swing.JLabel hero1;
    private javax.swing.JLabel hero2;
    private javax.swing.JLabel hero3;
    private javax.swing.JProgressBar hpHero1;
    private javax.swing.JProgressBar hpHero2;
    private javax.swing.JProgressBar hpHero3;
    private javax.swing.JProgressBar hpMonster1;
    private javax.swing.JProgressBar hpMonster2;
    private javax.swing.JProgressBar hpMonster3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblStageInfo;
    private javax.swing.JLabel lblTurnInfo;
    private javax.swing.JLabel monster1;
    private javax.swing.JLabel monster2;
    private javax.swing.JLabel monster3;
    private javax.swing.JSlider sliderVolume;
    private javax.swing.JTextArea txtGamelog;
    private javax.swing.JLabel txtHero1;
    private javax.swing.JLabel txtHero2;
    private javax.swing.JLabel txtHero3;
    private javax.swing.JLabel txtMonster1;
    private javax.swing.JLabel txtMonster2;
    private javax.swing.JLabel txtMonster3;
    // End of variables declaration//GEN-END:variables

    class RotatedLabel extends javax.swing.JLabel {
        private final double rotationAngle = Math.toRadians(-2); 

        @Override
        protected void paintComponent(java.awt.Graphics g) {

            java.awt.Graphics2D g2d = (java.awt.Graphics2D) g.create(); 

            double anchorX = getWidth() / 2.0;
            double anchorY = getHeight() / 2.0;


            g2d.rotate(rotationAngle, anchorX, anchorY);

            super.paintComponent(g2d);
            

            g2d.dispose();
        }
    }
    
    private javax.swing.ImageIcon createScaledImageIcon(String path, int width, int height) {
        try {
            java.net.URL imgURL = getClass().getResource(path);
            if (imgURL != null) {
                java.awt.Image image = new javax.swing.ImageIcon(imgURL).getImage();
                java.awt.Image scaledImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
                return new javax.swing.ImageIcon(scaledImage);
            } else {
                logger.log(java.util.logging.Level.SEVERE, "Resource not found: " + path);
                return null;
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, "Error loading or scaling image: " + path, ex);
            return null;
        }
    }
    
    /**
     * 
     * @param 
     * @return 
     */
    private String createSkillTooltip(skill s) {
        String powerLabel = s.isHealing() ? "Heal:" : "DMG:";
        

        String aoeLabel = s.isAoE() ? "Yes" : "No";
              return "<html>" +
               powerLabel + " " + s.getbasePower() + "<br>" + //
               "Mana: " + s.getManaCost() + "<br>" + //
               "AoE: " + aoeLabel +
               "</html>";
    }  
    
    private void setDynamicBackground() {
        String bgPath;

        int bgIndex = (gamedata.currentStage - 1) / 2;

        switch (bgIndex) {
            case 0: 
                bgPath = "/images/forest.png";
                break;
            case 1: 
                bgPath = "/images/cave.png"; 
                break;
            case 2: 
                bgPath = "/images/map3.png";
                break;
            case 3: 
                bgPath = "/images/map4.png";
                break;
            case 4: 
                bgPath = "/images/map5.png";
                break;
            default:
                bgPath = "/images/forest.png";
                break;
        }

        try {
            java.net.URL imgURL = getClass().getResource(bgPath);
            if (imgURL != null) {
                bgLobby.setIcon(new javax.swing.ImageIcon(imgURL));
            } else {

                logger.log(java.util.logging.Level.SEVERE, "Background resource not found: " + bgPath);

                bgLobby.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/forest.png")));
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, "Error loading background image: " + bgPath, ex);
        }
    }
    
    private void playHitEffect(JLabel targetLabel) {
        if (targetLabel == null || targetLabel.getIcon() == null) return;

        final javax.swing.Icon originalIcon = targetLabel.getIcon();
        final java.awt.Point originalLocation = targetLabel.getLocation();

        javax.swing.ImageIcon redIcon = createRedTintedIcon((javax.swing.ImageIcon) originalIcon);

        targetLabel.setIcon(redIcon);

        final int shakePower = 5;   
        int shakeDelay = 40;         
        final int totalDuration = 500; 

        final long startTime = System.currentTimeMillis();
        final java.util.Random rand = new java.util.Random();

        javax.swing.Timer effectTimer = new javax.swing.Timer(shakeDelay, null);

        effectTimer.addActionListener(e -> {
            long elapsed = System.currentTimeMillis() - startTime;

            if (elapsed < totalDuration) {
                int offsetX = rand.nextInt(shakePower * 2 + 1) - shakePower;
                int offsetY = rand.nextInt(shakePower * 2 + 1) - shakePower;

                targetLabel.setLocation(originalLocation.x + offsetX, originalLocation.y + offsetY);

            } else {
                effectTimer.stop();

                targetLabel.setIcon(originalIcon);

                targetLabel.setLocation(originalLocation);
            }
        });

        effectTimer.setInitialDelay(0);
        effectTimer.start();
    }
    
    private void playHealEffect(JLabel targetLabel) {
        if (targetLabel == null || targetLabel.getIcon() == null) return;

        Icon originalIcon = targetLabel.getIcon();

        ImageIcon greenIcon = createGreenTintedIcon((ImageIcon) originalIcon);

        targetLabel.setIcon(greenIcon);

        Timer hitTimer = new Timer(300, e -> {
            targetLabel.setIcon(originalIcon); 
            ((Timer)e.getSource()).stop();    
        });

        hitTimer.setRepeats(false); 
        hitTimer.start();
    }

    private ImageIcon createRedTintedIcon(ImageIcon original) {
        int w = original.getIconWidth();
        int h = original.getIconHeight();

        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();

        g.drawImage(original.getImage(), 0, 0, null);

        g.setComposite(AlphaComposite.SrcAtop);

        g.setColor(new java.awt.Color(255, 0, 0, 180)); 
        g.fillRect(0, 0, w, h);

        g.dispose();
        return new ImageIcon(bi);
    }
    
    private ImageIcon createGreenTintedIcon(ImageIcon original) {
        int w = original.getIconWidth();
        int h = original.getIconHeight();

        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();

        g.drawImage(original.getImage(), 0, 0, null);

        g.setComposite(AlphaComposite.SrcAtop);

        g.setColor(new java.awt.Color(0, 255, 0, 150)); 
        g.fillRect(0, 0, w, h);

        g.dispose();
        return new ImageIcon(bi);
    }
    
    private JLabel getLabelForCharacter(character c) {
        if (c == characterToDisplay1) return hero1;
        if (c == characterToDisplay2) return hero2;
        if (c == characterToDisplay3) return hero3;
        if (c == characterToDisplay4) return monster1;
        if (c == characterToDisplay5) return monster2;
        if (c == characterToDisplay6) return monster3;
        return null;
    }

    private void showDamageEffect(String resultMsg, javax.swing.JLabel targetLabel) {
        if (targetLabel == null) return;
    
        try {
            String textToShow = "";
            java.awt.Color color = java.awt.Color.WHITE;
            int fontSize = 28;

            if (resultMsg.contains("DODGED")) {
                textToShow = "MISS";
                color = java.awt.Color.GRAY;
                fontSize = 24;
            } else if (resultMsg.contains("HEAL")) {
                textToShow = "+" + resultMsg.replaceAll("[^0-9]", ""); 
                color = java.awt.Color.GREEN;
            } else {
                textToShow = resultMsg.replaceAll("[^0-9]", ""); 
                if (textToShow.isEmpty()) textToShow = "0";

                color = java.awt.Color.RED;
                if (resultMsg.contains("CRITICAL")) {
                    color = java.awt.Color.ORANGE;
                    textToShow += "!";
                    fontSize = 36;
                }
            }

            int x = targetLabel.getX() + (targetLabel.getWidth() / 2) - 30; 
            int y = targetLabel.getY(); 

            new FloatingText(this.getLayeredPane(), textToShow, x, y, color, fontSize);

        } catch (Exception e) {
            System.out.println("Error in FloatingText: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
