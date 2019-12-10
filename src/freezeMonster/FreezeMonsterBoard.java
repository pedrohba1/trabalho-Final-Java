package freezeMonster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import freezeMonster.sprite.Monster;
import freezeMonster.sprite.PlayerPerson;
import spaceinvaders.CommonsSpaceInvader;
import spaceinvaders.sprite.BomberSprite;
import spriteframework.AbstractBoard;
import spriteframework.sprite.AbstractPlayer;
import spriteframework.sprite.BadSprite;

public class FreezeMonsterBoard extends AbstractBoard{

	@Override
	protected void createBadSprites() {
		int spawnX;
		int spawnY;
		for (int j = 1; j < 10; j++) {
	    		Random random= new Random();  
	    		

	    		//os primeiros 4 monstros são colocados na fileira decima enqunato os restantes na debaixo, ambos aleatoriamente
	    		if(j <5) {
	    			spawnX = CommonsFreezeMonster.BOARD_WIDTH - 700 + random.nextInt(30) + 130*j;
	    			spawnY = CommonsFreezeMonster.BOARD_HEIGHT - random.nextInt(40) - 500; 
	    		}
	    		else {
	    			spawnX = CommonsFreezeMonster.BOARD_WIDTH - 700 + random.nextInt(30) + 50*j;
	    			spawnY =  CommonsFreezeMonster.BOARD_HEIGHT - 50 - random.nextInt(40);
	    		}
	        	Monster monster = new Monster(spawnX,spawnY, j);
                badSprites.add(monster);
            }
	}

	@Override
	protected void createPlayerSprite() {
		PlayerPerson person = new PlayerPerson();
		players.add(person);
	}

	@Override
	protected void drawOtherSprites(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processOtherSprites(AbstractPlayer player, KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void update() {
		   // player movement
        for (AbstractPlayer player: players) {
        	player.act();
       	}
        
        
        //checks if the player collided with the monsters and also moves the monster if 
        //the player didn't
    	for (AbstractPlayer player: players) {              	
    		   for (BadSprite monster : badSprites) {
    	        	if(player.collided(monster)) {
    	                player.setDying(true);
    	        	};
        	        	monster.act();
    		   }
    		}
    	
    	//checks if the monster collide if each other. If they collide, change their movement direction
		   for (BadSprite monster1 : badSprites) {
			   for (BadSprite monster2 : badSprites) {
				   if(monster1.collided(monster2)) {
					   monster1.interchangeDirections(monster2);
				   }
			   }	
		   }
		   
		   
		   //TODO:
		   //checks if monster goo hit player, and if it hits the player dies.
		   
		   
		   //TODO:
		   //checks if player shot hits monster, and if it does kills the monster.
		   
        
        
	}

	@Override
	protected void createShotSprites() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setBoardHeight() {
		super.BOARD_HEIGHT = CommonsFreezeMonster.BOARD_WIDTH;
		
	}

	@Override
	protected void setBoardWidht() {
		super.BOARD_HEIGHT = CommonsFreezeMonster.BOARD_WIDTH;		
	}

	@Override
	protected void drawStaticSprites(Graphics g) {
		g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        super.setBackground(Color.black);
 	}

}
