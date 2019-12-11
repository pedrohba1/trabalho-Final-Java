package spriteframework.sprite;


import spriteframework.AbstractBoard;
import spriteframework.Commons;

import java.awt.event.KeyEvent;
import java.io.File;
import java.util.LinkedList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import spaceinvaders.sprite.Shot;

public abstract class AbstractPlayer extends Sprite {

   
	protected abstract void startLeftMovement();
    protected abstract void startRightMovement();
    protected abstract void startUpMovement();
    protected abstract void startDownMovement();
    
    protected abstract void stopLeftMovement();
    protected abstract void stopRightMovement();
    protected abstract void stopUpMovement();
    protected abstract void stopDownMovement();

    protected abstract void doMovement();
    public abstract BadSprite shoot();
    
    //outros métodos:
    protected abstract void warpOnEdges();
    protected abstract void playShotSound();
    
    public void act() {
    	doMovement();
    	warpOnEdges();
    }

    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
        
    	switch (key){
        case KeyEvent.VK_LEFT:
        	startLeftMovement();
        	break;
        case KeyEvent.VK_RIGHT:
        	startRightMovement();
        	break;
        case KeyEvent.VK_UP:
        	startUpMovement();
        	break;
        case KeyEvent.VK_DOWN:
        	startDownMovement();
        	break;
    	}
    }

    public void keyReleased(KeyEvent e) {
    	int key = e.getKeyCode();
        
    	switch (key){
        case KeyEvent.VK_LEFT:
        	stopLeftMovement();
        	break;
        case KeyEvent.VK_RIGHT:
        	stopRightMovement();
        	break;
        case KeyEvent.VK_UP:
        	stopUpMovement();
        	break;
        case KeyEvent.VK_DOWN:
        	stopDownMovement();
        	break;
        	
    	}
    }
    
    public void playSound(String soundFile) throws Exception {
        File f = new File("./" + soundFile);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }
}
