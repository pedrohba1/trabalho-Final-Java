package freezeMonster.sprite;

import javax.swing.ImageIcon;

import spriteframework.Utils;
import spriteframework.sprite.BadSprite;

public class FreezingShot extends BadSprite{

	public void FreezingShot() {
		
	}
	
	   public FreezingShot(int x, int y) {
	        initShot(x, y);
	    }

	private void initShot(int x, int y) {
		  String shotImg = "freeze_monster_images/ray.png";
	        ImageIcon ii = new ImageIcon(shotImg);

	        Utils utils = new Utils();
	        ii = utils.scaleImageIcon(ii, 20, 20);

	        
	        setImage(ii.getImage());
	        int H_SPACE = 6;
	        setX(x + H_SPACE);
	        int V_SPACE = 1;
	        setY(y - V_SPACE);
	}
	
	@Override
	protected void doMovement() {

		
	}

}
