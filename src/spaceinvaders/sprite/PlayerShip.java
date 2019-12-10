package spaceinvaders.sprite;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import spriteframework.sprite.BadSprite;
import spriteframework.Utils;
import spriteframework.sprite.AbstractPlayer;
import spaceinvaders.CommonsSpaceInvader;

public class PlayerShip extends AbstractPlayer{
		    
	private Boolean health;
    public PlayerShip() {
        initPlayerShip(CommonsSpaceInvader.PLAYER_INIT_X, CommonsSpaceInvader.PLAYER_INIT_Y);
    }

  
   private void initPlayerShip(int x, int y) {
    	super.x = x;
    	super.y = y;
        String playerImg = "space_invaders_images/player.png";
        ImageIcon ii = new ImageIcon(playerImg);
        setImage(ii.getImage());
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
	protected void startUpMovement() {

	}

	@Override
	protected void startDownMovement() {
		
	}

	@Override
	protected void stopLeftMovement() {
		dx = 0;	
	}


	@Override
	protected void stopRightMovement() {
		dx = 0;
	}


	@Override
	protected void stopUpMovement() {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void stopDownMovement() {
		
	}
	
	@Override
	protected void playShotSound() {
	try {
		playSound("sounds/effects/laser.wav");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}



	@Override
	protected void doMovement() {
		x += dx;
	}




	@Override
	public Shot shoot() {
	  	int x = this.getX();
		int y = this.getY();
		playShotSound();
		return new Shot(x, y);
	}
	
	@Override
	protected void warpOnEdges() {
        if (x <= 0) {
        	x = CommonsSpaceInvader.BOARD_WIDTH - 25;
        }
        if (x >= CommonsSpaceInvader.BOARD_WIDTH - 23) {
            x = 1 ;
        }		
	}
	
	
	
	
}
