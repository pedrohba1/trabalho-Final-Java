package freezeMonster.sprite;

import javax.swing.ImageIcon;

import spaceinvaders.sprite.Bomb;
import spriteframework.Utils;
import spriteframework.sprite.BadSprite;

public class Monster extends BadSprite{
	
	public int monsterNumber;
	
	public Monster (int x,int y, int monsterNumber) {
		initMonster(x,y, monsterNumber);
	}
	
	private void initMonster(int x, int y, int monsterNumber) {
			this.x = x;
	        this.y = y;
	        this.monsterNumber = monsterNumber;
	        
	        String monsterImg = "freeze_monster_images/monster" + monsterNumber + ".png" ;
	        System.out.println(monsterImg);
	        ImageIcon ii = new ImageIcon(monsterImg);	        
	        Utils utils = new Utils();
	        ii = utils.scaleImageIcon(ii, 40, 60);
	        setImage(ii.getImage());
	}
	
}
