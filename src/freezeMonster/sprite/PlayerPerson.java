package freezeMonster.sprite;

import javax.swing.ImageIcon;

import freezeMonster.CommonsFreezeMonster;
import spaceinvaders.CommonsSpaceInvader;
import spaceinvaders.sprite.Shot;
import spriteframework.Utils;
import spriteframework.sprite.AbstractPlayer;
import spriteframework.sprite.BadSprite;

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
	protected void stopHorizontalMovement() {
		dx = 0;		
	}

	protected void stopVerticalMovement() {
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

	@Override
	public boolean collided(BadSprite bad) {
		int playerPositionWidth = this.getX() + CommonsFreezeMonster.PLAYER_WIDTH ;
		int playerPositionHeight = this.getY() + CommonsFreezeMonster.PLAYER_HEIGHT;
		
		int monsterPositionWidth = bad.getX() + bad.getImageWidth();
		int monsterPositionHeight = bad.getY() + bad.getImageHeight();
//		  if (bombX >= (playerX)
//                  && bombX <= (playerX + CommonsSpaceInvader.PLAYER_WIDTH)
//                  && bombY >= (playerY)
//                  && bombY <= (playerY + CommonsSpaceInvader.PLAYER_HEIGHT)) {
//		
			  
		if(bad.isVisible()) {
			if(bad.getX() >= this.getX()
			   && monsterPositionWidth <= playerPositionWidth
			   && bad.getY() >= this.getY()
			   && bad.getY() <= playerPositionHeight
					) {
				return true;
			}
		}		
		return false;
	}

	

}
