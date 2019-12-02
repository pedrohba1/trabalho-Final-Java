package spriteframework.sprite;


import spriteframework.AbstractBoard;
import spriteframework.Commons;

import java.awt.event.KeyEvent;

public abstract class AbstractPlayer extends Sprite {

    
    //TODO: Como o tiro é uma feature compartilhada entre ambos os jogos,
    ///faz sentido que ela seja definida na classe abstrata do jogador.
    
    
    //Dúvida:
    //vale mais a pena eu deixar essa classe act aqui ou criar ela como abstract e 
    //fazer ela nas concretas?
    
    //TODO:
    //essas classes abaixo precisam ser definidas na PlayerShip e posteriormente 
    //na classe Concreta que representa o player no freezeMonster.
    //Uma vez que ambos jogos possuem movimentações diferentes, o Space Invaders
    //Não precisa implementar o o upMovement() e nem o DownMovement() (ambos pode ficar vazios, ou nem serem declarados)
    
    protected abstract void startLeftMovement();
    protected abstract void startRightMovement();
    protected abstract void startUpMovement();
    protected abstract void startDownMovement();
    
    protected abstract void warpOnEdges();
    
    protected abstract void stopMovement();
    
    
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
}
