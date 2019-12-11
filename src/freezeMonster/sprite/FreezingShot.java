package freezeMonster.sprite;

import javax.swing.ImageIcon;

import freezeMonster.CommonsFreezeMonster;
import spriteframework.Utils;
import spriteframework.sprite.BadSprite;

public class FreezingShot extends BadSprite{

	public FreezingShot() {
		String shotImg = "freeze_monster_images/ray.png";
        ImageIcon ii = new ImageIcon(shotImg);
        
        Utils utils = new Utils();
        ii = utils.scaleImageIcon(ii, CommonsFreezeMonster.SHOT_WIDTH, CommonsFreezeMonster.SHOT_HEIGHT);

        setImage(ii.getImage());
	}
	
	   public FreezingShot(int x, int y, String facingDirection) {
	      
		      switch(facingDirection) {
		        case "up":
		        	dx = 0;
		        	dy = -5;
		        break;
		        case "down":
		        	dx = 0;
		        	dy= 5;
		        break;	
		        case "left":
		        	dx = -5;
		        	dy = 0;
		        break;
		        case "right":
		        	dx = 5;
		        	dy = 0;
		        break;
		        default:
		        	dx = 0;
		        	dy = 0;
		        break;
		      }
		   initFreezingShot(x, y);      
	    }

	private void initFreezingShot(int x, int y) {
		String shotImg = "freeze_monster_images/ray.png";
        ImageIcon ii = new ImageIcon(shotImg);
        
        Utils utils = new Utils();
        ii = utils.scaleImageIcon(ii, CommonsFreezeMonster.SHOT_WIDTH, CommonsFreezeMonster.SHOT_HEIGHT);

        setImage(ii.getImage());
	        int H_SPACE = 6;
	        setX(x + H_SPACE);
	        int V_SPACE = 1;
	        setY(y - V_SPACE);
	}
	
	@Override
	protected void doMovement() {
		x +=dx;
		y +=dy;
		dieOnEdges();
	}

	
	private void dieOnEdges() {
		 if (x <= 0) {
	        	this.die();
	        }
	        if (x >= CommonsFreezeMonster.BOARD_WIDTH - 23) {
	        	this.die();
	        }
	      if( y <=0) {
	    	  this.die();
	      }
	      if(y >= CommonsFreezeMonster.BOARD_HEIGHT-23) {
	    	  this.die();
	      }
	}
	
}
