package freezeMonster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import freezeMonster.sprite.FreezingShot;
import freezeMonster.sprite.Monster;
import freezeMonster.sprite.PlayerPerson;
import spaceinvaders.CommonsSpaceInvader;
import spaceinvaders.sprite.BomberSprite;
import spaceinvaders.sprite.Shot;
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
	    		//os primeiros 4 monstros s�o colocados na fileira decima enqunato os restantes na debaixo, ambos aleatoriamente
	    		if(j <5) {
	    			spawnX = CommonsFreezeMonster.BOARD_WIDTH - 700 + random.nextInt(30) + 130*j;
	    			spawnY = CommonsFreezeMonster.BOARD_HEIGHT - random.nextInt(40) - 500; 
	    		}
	    		else {
	    			spawnX = CommonsFreezeMonster.BOARD_WIDTH - 700 + random.nextInt(30) + 50*j;
	    			spawnY =  CommonsFreezeMonster.BOARD_HEIGHT - 50 - random.nextInt(40);
	    		}
	        	Monster monster = new Monster(spawnX,spawnY, j);
                enemies.add(monster);
            }
		
		
		
	}

	@Override
	protected void createPlayerSprite() {
		PlayerPerson person = new PlayerPerson();
		players.add(person);
	}

	@Override
	protected void createShotSprites() {
			playerShot = new FreezingShot();
	}
	
	  private void drawShot(Graphics g) {
	    	if (playerShot.isVisible()) {
	            g.drawImage(playerShot.getImage(), playerShot.getX(), playerShot.getY(), this);
	        }
	    }
	  
 	@Override
	protected void drawOtherSprites(Graphics g) {
        drawShot(g);		
	}

	@Override
	protected void processOtherSprites(AbstractPlayer player, KeyEvent e) {
		   //TODO:
		   //player shoots freezingShot.
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE) {
			if (inGame) {
					if(!playerShot.isVisible()) {
						playerShot = player.shoot();
					}
			}
		}				
	}

	@Override
	protected void update() {
		   // player movement
        for (AbstractPlayer player: players) {
        	player.act();
       	}
        
       
        //checks if the player collided with the monsters and moves the monsters
    	for (AbstractPlayer player: players) {              	
    		   for (BadSprite monster : enemies) {
    			   
    	        	if(player.collided(monster)) {
    	                player.setDying(true);
    	        	};
    	        	monster.act();
    		   }
    		}
    	
    	
    	
    	//checks if the monster collide if each other. If they collide, change their movement direction
		   for (BadSprite monster1 : enemies) {
			   for (BadSprite monster2 : enemies) {
				   if(monster1.collided(monster2)) {
					   monster1.interchangeDirectionsWith(monster2);
				   }
			   }	
		   }
		   
		   
		   //TODO:
		   //monsters shoot goos randomly, and each one has one shot.
			Random generator = new Random();
			for(BadSprite monster : enemies) {
			//monster.shoot(generator.nextInt(700));
			}
			
		
		   //TODO: if the shot is visible, it acts
			if(playerShot.isVisible()) {
				playerShot.act();
			}
			
			
			//TODO: if the playershot hits the monster, the monster dies:
			   for (BadSprite monster : enemies) {
				   if(playerShot.collided(monster)) {
					   monster.die();
					   playerShot.die();
				   }
			   }
		  
		   
			   
	
		   //TODO:
		   //checks if monster goo hit player, and if it hits the player dies.
		   

		   
		   //TODO:
		   //checks if player shot hits monster, and if it does kills the monster
		   //the image of the monster is changed to a static image.
			
		   
        
        
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
