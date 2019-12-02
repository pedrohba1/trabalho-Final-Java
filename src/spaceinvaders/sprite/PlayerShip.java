package spaceinvaders.sprite;

import java.util.LinkedList;

import javax.swing.ImageIcon;

import spriteframework.sprite.BadSprite;
import spriteframework.sprite.AbstractPlayer;


import spaceinvaders.Commons;

public class PlayerShip extends AbstractPlayer{
	
	
	
	//isso precisa pra acessar os players;
    protected LinkedList<AbstractPlayer> players;	
	private Boolean health;
    public PlayerShip() {
        initPlayerShip(Commons.PLAYER_INIT_X, Commons.PLAYER_INIT_Y);
    }

    //isso para adicionar o PlayerShip como abstractPlayer no AbstractBoard
    protected void add (AbstractPlayer p) {
    	players.add(p);
    }

   private void initPlayerShip(int x, int y) {
    	super.x = x;
    	super.y = y;
        String playerImg = "images/player.png";
        ImageIcon ii = new ImageIcon(playerImg);
        setImage(ii.getImage());
        this.health = true;
    }
    	
	public Boolean gethealth () {
		return this.health;
	}
	
	@Override
	protected void startLeftMovement() {
        dx = -2;
	}

	@Override
	protected void startRightMovement() {
        dx = 2;	
	}
	
	@Override
	protected void stopMovement() {
		dx = 0;
	}
	
	@Override
	protected void warpOnEdges() {
		x += dx;     
        if (x <= 0) {
        	x = Commons.BOARD_WIDTH - 25;
        }
        if (x >= Commons.BOARD_WIDTH - 23) {
            x = 1 ;
        }		
	}
		
	@Override
	protected void startUpMovement() {
		// sem moviemnto pra cima nesse jogo
	}

	@Override
	protected void startDownMovement() {
		//sem movimento para baixo nesse jogo
	}

}
