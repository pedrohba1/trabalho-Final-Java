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
	        for (int j = 1; j < 10; j++) {
	    		Random random= new Random();
	        	Monster monster = new Monster(random.nextInt(800),random.nextInt(600), j);
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
        for (AbstractPlayer player: players) 
        	player.act();
        
        for (BadSprite monster : badSprites) {
        	monster.act();
        	
        }
        
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
