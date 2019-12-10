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
	}

	@Override
	protected void startRightMovement() {
        dx = 3;
	}

	@Override
	protected void startUpMovement() {
		dy = -3;
	}

	@Override
	protected void startDownMovement() {
		dy = 3;
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
	public Shot shoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void warpOnEdges() {
	}

	@Override
	protected void playShotSound() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doMovement() {
		x += dx;
		y += dy;
	}


}
