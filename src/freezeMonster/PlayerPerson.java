package freezeMonster;

import javax.swing.ImageIcon;

import spaceinvaders.sprite.Shot;
import spriteframework.Utils;
import spriteframework.sprite.AbstractPlayer;

public class PlayerPerson extends AbstractPlayer{

	
	public PlayerPerson() {
		initPlayerPerson(30,30);
	}
	
	   private void initPlayerPerson(int x, int y) {
	    	super.x = x;
	    	super.y = y;
	        String playerImg = "freeze_monster_images/woody.png";
	        ImageIcon ii = new ImageIcon(playerImg);
	        
	        Utils utils = new Utils();
	        ii = utils.scaleImageIcon(ii, 40, 60);
	        
	        setImage(ii.getImage());
	    }
	@Override
	protected void startLeftMovement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void startRightMovement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void startUpMovement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void startDownMovement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void stopMovement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shot shoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void warpOnEdges() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void playShotSound() {
		// TODO Auto-generated method stub
		
	}

}
