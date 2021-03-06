package freezeMonster.sprite;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.Random;

import javax.swing.ImageIcon;

import freezeMonster.CommonsFreezeMonster;
import spaceinvaders.sprite.Bomb;
import spriteframework.Utils;
import spriteframework.sprite.BadSprite;
import spriteframework.sprite.Sprite;

public class Monster extends BadSprite{
	
	public int monsterNumber;
	private MonsterGoo goo;
	
	public Monster (int x,int y, int monsterNumber) {
		initMonster(x,y, monsterNumber);
	}
	
	private void initMonster(int x, int y, int monsterNumber) {
			this.x = x;
	        this.y = y;
	        this.monsterNumber = monsterNumber;
	        this.goo = new MonsterGoo();
	        
	        String monsterImg = "freeze_monster_images/monster" + monsterNumber + ".png" ;
	        ImageIcon ii = new ImageIcon(monsterImg);	        
	        Utils utils = new Utils();
	        ii = utils.scaleImageIcon(ii, CommonsFreezeMonster.MONSTER_WIDTH, CommonsFreezeMonster.MONSTER_HEIGHT);
	        setImage(ii.getImage());
	        
	        	
	        //gera uma dire��o inicial aleat�ria:
	        Random random = new Random();
	        int direction = random.nextInt(4);
	        switch (direction) {
	        case 0:
	        	dy = 1;
	        	dx = 1;
	        	break;
	        case 1:
	        	dy = -1;
	        	dx = 1;
	        	break;
	        case 2:
	        	dx = 1;
	        	dy =-1;
	        	break;
	        case 3:
	        	dx = -1;
	        	dy= -1;
	        	break;
	        }
	        
	}
	

	public void setDyingImage() {
	     String monsterImg = "freeze_monster_images/monster" + monsterNumber + "bg.png" ;
	        ImageIcon ii = new ImageIcon(monsterImg);	        
	        Utils utils = new Utils();
	        ii = utils.scaleImageIcon(ii, CommonsFreezeMonster.MONSTER_WIDTH, CommonsFreezeMonster.MONSTER_HEIGHT);
	        this.setImage(ii.getImage());
	}
	
	
	
	@Override
	protected void doMovement() {
		//make some random movement if this random integer hits 
		randomMovement();
		
		String move = InEdges();
		if(move != null) {
			changeMoveDirection(move);
		}
		x += dx;
		y += dy;
	}

	private String InEdges() {
		if (x <= 0) 
			return "left";
        if (x >= CommonsFreezeMonster.BOARD_WIDTH - 60) 
        	return "right";
		if (y <= 0) 
			return "top";
	    if (y >= CommonsFreezeMonster.BOARD_HEIGHT - 90) 
	    	return "bottom";
		return null;
	}
	
	private void changeMoveDirection(String direction) {
		switch (direction){
        case "top":
        	dy = 1;
        	break;
        case "bottom":
        	dy = -1;
        	break;
        case "left":
        	dx = 1;
        	break;
        case "right":
        	dx = -1;
        	break;	
		}
	}
	private void changeMoveDirection(int direction) {
		switch (direction){
        case 0:
        	dy = 1;
        	break;
        case 1:
        	dy = -1;
        	break;
        case 2:
        	dx = 1;
        	break;
        case 3:
        	dx = -1;
        	break;	
		}
	}
	
	public void shoot() {
		if(!this.goo.isVisible() && this.isVisible()) {
		Random rand = new Random();
		String directions[] = {"up", "down","left","right"};
		this.goo = new MonsterGoo(this.x,this.y, directions[rand.nextInt(directions.length)]);
		}
	}
    
	
	private void randomMovement() {
		Random random = new Random();
		//if you want to increase frequency of movement chance just tick the right value;
		int randirect = random.nextInt(4);
		if(random.nextInt(1000) > 950) {
			changeMoveDirection(randirect);
		}
	}
	
	@Override
	public BadSprite getBad() {
		return this.goo;
	}

	@Override
	public void DyingAnimation() {
        this.setDyingImage();
        dx = 0;
        dy = 0;
	}

}
