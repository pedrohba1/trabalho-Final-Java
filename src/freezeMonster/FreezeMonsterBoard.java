package freezeMonster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import spaceinvaders.CommonsSpaceInvader;
import spriteframework.AbstractBoard;
import spriteframework.sprite.AbstractPlayer;

public class FreezeMonsterBoard extends AbstractBoard{

	@Override
	protected void createBadSprites() {

	}

	@Override
	protected void createPlayerSprite() {
		PlayerPerson person = new PlayerPerson();
		players.add(person);
			// TODO Auto-generated method stu
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
		// TODO Auto-generated method stub
		
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
		g.setColor(Color.blue);
        g.fillRect(0, 0, d.width, d.height);
        super.setBackground(Color.cyan);
 	}

}
