/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oopproject;

import javax.sound.sampled.*;
import java.net.URL;

/**
 *
 * @author Phuwan
 */

/* FINAL */

public class SoundManager {
    
    private Clip bgmClip;
    private boolean isMuted = false;
    private long clipTimePosition = 0; 
    
    public void playBGM(String filePath) {
        if (isMuted) return;

        try {
            stop();

            URL soundURL = getClass().getResource(filePath);
            if (soundURL == null) {
                System.out.println("File not found: " + filePath);
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);
            bgmClip = AudioSystem.getClip();
            bgmClip.open(audioIn);
            
            bgmClip.loop(Clip.LOOP_CONTINUOUSLY); 
            bgmClip.start();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void playSFX(String filePath) {
        if (isMuted) return;

        try {
            URL soundURL = getClass().getResource(filePath);
            if (soundURL == null) return;

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);
            Clip sfxClip = AudioSystem.getClip();
            sfxClip.open(audioIn);
            sfxClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toggleMute() {
        isMuted = !isMuted;

        if (isMuted) {
            if (bgmClip != null && bgmClip.isRunning()) {
                clipTimePosition = bgmClip.getMicrosecondPosition();
                bgmClip.stop();
            }
        } else {
            if (bgmClip != null) {
                bgmClip.setMicrosecondPosition(clipTimePosition);
                bgmClip.start();
                bgmClip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        }
    }

    public void setVolume(float volumeScale) {
        if (bgmClip != null && bgmClip.isOpen()) {
            try {
                FloatControl gainControl = (FloatControl) bgmClip.getControl(FloatControl.Type.MASTER_GAIN);

                float dB;
                if (volumeScale <= 0.0f) {
                    dB = -80.0f;
                } else {
                    dB = (float) (Math.log(volumeScale) / Math.log(10.0) * 20.0);
                }
                
                gainControl.setValue(dB);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void stop() {
        if (bgmClip != null && bgmClip.isRunning()) {
            bgmClip.stop();
            bgmClip.close();
        }
    }

    public boolean isMuted() {
        return isMuted;
    }
}
