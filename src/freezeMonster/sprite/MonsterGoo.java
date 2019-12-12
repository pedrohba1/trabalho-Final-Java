package freezeMonster.sprite;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import freezeMonster.CommonsFreezeMonster;
import spriteframework.Utils;
import spriteframework.sprite.BadSprite;

public class MonsterGoo extends BadSprite{

	private int moveSpeed;

	
    public MonsterGoo() {
    	this.setVisible(false);
    }
		
	public MonsterGoo(int x, int y, String facingDirection) {
		moveSpeed =3;

	      switch(facingDirection) {
	        case "up":
	        	dx = 0;
	        	dy = -moveSpeed;
	        break;
	        case "down":
	        	dx = 0;
	        	dy= moveSpeed;
	        break;	
	        case "left":
	        	dx = -moveSpeed;
	        	dy = 0;
	        break;
	        case "right":
	        	dx = moveSpeed;
	        	dy = 0;
	        break;
	        default:
	        	dx = 0;
	        	dy = 0;
	        break;
	      }
	   initMonsterGoo(x, y);      
  }
	
	private void initMonsterGoo(int x, int y) {
		String shotImg = "freeze_monster_images/gosma.png";
        ImageIcon ii = new ImageIcon(shotImg);
        
        Utils utils = new Utils();
        ii = utils.scaleImageIcon(ii, CommonsFreezeMonster.SHOT_WIDTH, CommonsFreezeMonster.SHOT_HEIGHT);

        setImage(ii.getImage());
	        int H_SPACE = 4;
	        setX(x + H_SPACE);
	        int V_SPACE = 1;
	        setY(y - V_SPACE);
	}
	

	
	@Override
	protected void doMovement() {
		x += dx;
		y += dy;
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


	@Override
	public BadSprite getBad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDyingImage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ImageIcon DyingAnimation(Graphics g) {
		// TODO Auto-generated method stub
		return null;
	}

}
