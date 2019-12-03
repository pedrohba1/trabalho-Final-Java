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

	
    
    //TODO: Como o tiro é uma feature compartilhada entre ambos os jogos,
    ///faz sentido que ela seja definida na classe abstrata do jogador.
    protected LinkedList<AbstractPlayer> players;	
	
    
    //Dúvida:
    //vale mais a pena eu deixar essa classe act aqui ou criar ela como abstract e 
    //fazer ela nas concretas?
    
    //TODO:
    //essas classes abaixo precisam ser definidas na PlayerShip e posteriormente 
    //na classe Concreta que representa o player no freezeMonster.
    //Uma vez que ambos jogos possuem movimentações diferentes, o Space Invaders
    //Não precisa implementar o o upMovement() e nem o DownMovement() (ambos pode ficar vazios, ou nem serem declarados)
    
	//métodos relacionados a comandos:
	protected abstract void startLeftMovement();
    protected abstract void startRightMovement();
    protected abstract void startUpMovement();
    protected abstract void startDownMovement();
    public abstract Shot shoot();
    
    //outros métodos:
    protected abstract void warpOnEdges();
    
    protected abstract void stopMovement();
    
    protected abstract void playShotSound();
    
    
    public void act() { 	
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
//        case KeyEvent.VK_SPACE:
//        	shoot();
//        	break;
    	}
    }

    public void keyReleased(KeyEvent e) {
    	int key = e.getKeyCode();
        
    	switch (key){
        case KeyEvent.VK_LEFT:
        	stopMovement();
        	break;
        case KeyEvent.VK_RIGHT:
        	stopMovement();
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
