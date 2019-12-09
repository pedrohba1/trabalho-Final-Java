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
	    		
	    		//os primeiros 4 monstros são colocados na direita enquanto os restantes são colocados na esquerda
	    		if(j <5) {
	    			spawnX = CommonsFreezeMonster.BOARD_WIDTH - random.nextInt(CommonsFreezeMonster.MONSTER_SPAWN_WIDTH);
		    		spawnY = CommonsFreezeMonster.BOARD_HEIGHT- random.nextInt(CommonsFreezeMonster.MONSTER_SPAWN_HEIGHT);; 
	    		}
	    		else {
	    			spawnX = 	0 + random.nextInt(CommonsFreezeMonster.MONSTER_SPAWN_WIDTH);
		    		spawnY = 0 + random.nextInt(CommonsFreezeMonster.MONSTER_SPAWN_HEIGHT);; 
	    		}
	    	    int MONSTER_SPAWN_WIDTH = BOARD_WIDTH - random.nextInt(300);
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
        
        
    	for (AbstractPlayer player: players) {              	
    		   for (BadSprite monster : badSprites) {
    			  //the collision needs to be checked before the monster moves.
    	        	if(player.collided(monster)) {
    	                player.setDying(true);
    	        	};
        	        	monster.act();   
    		   }
    		}
        	//monster movement
        	 
        	//if the player collides 
        
        
        
        //monster colliding with each other?

        
        
        
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
