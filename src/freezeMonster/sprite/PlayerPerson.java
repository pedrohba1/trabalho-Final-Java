package freezeMonster.sprite;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import freezeMonster.CommonsFreezeMonster;
import spaceinvaders.CommonsSpaceInvader;
import spaceinvaders.sprite.Shot;
import spriteframework.Utils;
import spriteframework.sprite.AbstractPlayer;
import spriteframework.sprite.BadSprite;
import spriteframework.sprite.Sprite;

public class PlayerPerson extends AbstractPlayer{

	public String facingDirection;
		
	public PlayerPerson() {
		initPlayerPerson(CommonsFreezeMonster.PLAYER_INIT_X, CommonsFreezeMonster.PLAYER_INIT_Y);
	}
	
	private void initPlayerPerson(int x, int y) {
    	super.x = x;
    	super.y = y;
        String playerImg = "freeze_monster_images/woody.png";
        ImageIcon ii = new ImageIcon(playerImg);
        Utils utils = new Utils();
        ii = utils.scaleImageIcon(ii, CommonsFreezeMonster.PLAYER_WIDTH, CommonsFreezeMonster.PLAYER_HEIGHT);
        setImage(ii.getImage());
	 }
	
	@Override
	protected void startLeftMovement() {
		dx = -3;
		this.facingDirection = "left";
	}

	@Override
	protected void startRightMovement() {
        dx = 3;
		this.facingDirection = "right";
	}

	@Override
	protected void startUpMovement() {
		dy = -3;
		this.facingDirection = "up";
	}

	@Override
	protected void startDownMovement() {
		dy = 3;
		this.facingDirection = "down";
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
		dy = 0;
	}

	@Override
	protected void stopDownMovement() {
		dy = 0;
	}

	
	
	@Override
	public BadSprite shoot() {
		playShotSound();
		return new FreezingShot(this.x, this.y ,this.facingDirection);
	}
	
	

	@Override
	protected void warpOnEdges() {
		 if (x <= 0) {
	        	x = CommonsFreezeMonster.BOARD_WIDTH - 25;
	        }
	        if (x >= CommonsFreezeMonster.BOARD_WIDTH - 23) {
	            x = 1 ;
	        }
	      if( y <=0) {
	    	  y = CommonsFreezeMonster.BOARD_HEIGHT-25;
	      }
	      if(y >= CommonsFreezeMonster.BOARD_HEIGHT-23) {
	    	  y = 1;
	      }
	}

	@Override
	protected void playShotSound() {
		try {
			playSound("sounds/effects/irru.wav");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doMovement() {
		x += dx;
		y += dy;
	}


}
