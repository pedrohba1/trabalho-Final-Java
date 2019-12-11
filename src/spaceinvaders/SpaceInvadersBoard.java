package spaceinvaders;


import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;

import spaceinvaders.CommonsSpaceInvader;

import spriteframework.AbstractBoard;
import spriteframework.Commons;
import spriteframework.sprite.BadSprite;
import spriteframework.sprite.AbstractPlayer;

import spaceinvaders.sprite.*;

public class SpaceInvadersBoard extends AbstractBoard{  

  
	private int direction = -1;
    private int deaths = 0;
    private String explImg = "space_invaders_images/explosion.png";
    
    protected void createPlayerSprite() {
    	PlayerShip player = new PlayerShip();
    	players.add(player);
    };

    protected void createBadSprites() { 
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                BomberSprite alien = new BomberSprite(CommonsSpaceInvader.ALIEN_INIT_X + 18 * j,
                        CommonsSpaceInvader.ALIEN_INIT_Y + 18 * i);
                enemies.add(alien);
            }
        }
    }
    
    @Override
	protected void createShotSprites() {
		playerShot = new Shot();
	}
    
    private void drawShot(Graphics g) {
    	if (playerShot.isVisible()) {
            g.drawImage(playerShot.getImage(), playerShot.getX(), playerShot.getY(), this);
        }
    }

    // Override
    protected void drawOtherSprites(Graphics g) {
        drawShot(g);
    }
        
    @Override
	protected void processOtherSprites(AbstractPlayer player, KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE) {
			if (inGame) {
				if (!playerShot.isVisible()) {
					playerShot = player.shoot();
				}
			}
		}		
	}    
    
    
    protected void update() {

        if (deaths == CommonsSpaceInvader.NUMBER_OF_ALIENS_TO_DESTROY) {

            inGame = false;
            timer.stop();
            message = "Game won!";
        }

        // player
        for (AbstractPlayer player: players) 
        	player.act();

        // shot
        if (playerShot.isVisible()) {

            int shotX = playerShot.getX();
            int shotY = playerShot.getY();

            for (BadSprite alien : enemies) {

                int alienX = alien.getX();
                int alienY = alien.getY();

                if (alien.isVisible() && playerShot.isVisible()) {
                    if (shotX >= (alienX)
                            && shotX <= (alienX + CommonsSpaceInvader.ALIEN_WIDTH)
                            && shotY >= (alienY)
                            && shotY <= (alienY + CommonsSpaceInvader.ALIEN_HEIGHT)) {

                        ImageIcon ii = new ImageIcon(explImg);
                        alien.setImage(ii.getImage());
                        alien.setDying(true);
                        deaths++;
                        playerShot.die();
                    }
                }
            }

            int y = playerShot.getY();
            y -= 4;

            if (y < 0) {
                playerShot.die();
            } else {
                playerShot.setY(y);
            }
        }

        // aliens

        for (BadSprite alien : enemies) {
            int x = alien.getX();
            if (x >= CommonsSpaceInvader.BOARD_WIDTH - CommonsSpaceInvader.BORDER_RIGHT && direction != -1) {
                direction = -1;
                Iterator<BadSprite> i1 = enemies.iterator();
                while (i1.hasNext()) {
                    BadSprite a2 = i1.next();
                    a2.setY(a2.getY() + CommonsSpaceInvader.GO_DOWN);
                }
            }

            if (x <= Commons.BORDER_LEFT && direction != 1) {
                direction = 1;
                Iterator<BadSprite> i2 = enemies.iterator();
                while (i2.hasNext()) {
                    BadSprite a = i2.next();
                    a.setY(a.getY() + CommonsSpaceInvader.GO_DOWN);
                }
            }
        }

        Iterator<BadSprite> it = enemies.iterator();
        while (it.hasNext()) {
            BadSprite alien = it.next();
            if (alien.isVisible()) {
                int y = alien.getY();
                if (y > CommonsSpaceInvader.GROUND - CommonsSpaceInvader.ALIEN_HEIGHT) {
                    inGame = false;
                    message = "Invasion!";
                }
                alien.moveX(direction);
            }
        }

        // bombs
        updateOtherSprites();
    }

	

    
    protected void updateOtherSprites() {
		Random generator = new Random();

        for (BadSprite alien : enemies) { 
            int shot = generator.nextInt(15);
            Bomb bomb = ((BomberSprite)alien).getBomb();

            if (shot == CommonsSpaceInvader.CHANCE && alien.isVisible() && bomb.isDestroyed()) {

                bomb.setDestroyed(false);
                bomb.setX(alien.getX());
                bomb.setY(alien.getY());
            }

            int bombX = bomb.getX();
            int bombY = bomb.getY();
            int playerX = players.get(0).getX();
            int playerY = players.get(0).getY();

            if (players.get(0).isVisible() && !bomb.isDestroyed()) {
                if (bombX >= (playerX)
                        && bombX <= (playerX + CommonsSpaceInvader.PLAYER_WIDTH)
                        && bombY >= (playerY)
                        && bombY <= (playerY + CommonsSpaceInvader.PLAYER_HEIGHT)) {

                    ImageIcon ii = new ImageIcon(explImg);
                    players.get(0).setImage(ii.getImage());
                    players.get(0).setDying(true);
                    bomb.setDestroyed(true);
                }
            }

            if (!bomb.isDestroyed()) {
                bomb.setY(bomb.getY() + 1);
                if (bomb.getY() >= CommonsSpaceInvader.GROUND - CommonsSpaceInvader.BOMB_HEIGHT) {
                    bomb.setDestroyed(true);
                }
            }
        }
	}

	

	@Override
	protected void setBoardHeight() {
		super.BOARD_HEIGHT = CommonsSpaceInvader.BOARD_HEIGHT;
	}

	@Override
	protected void setBoardWidht() {
		super.BOARD_WIDTH = CommonsSpaceInvader.BOARD_WIDTH;
	}

	@Override
	protected void drawStaticSprites(Graphics g) {
		g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.green);
    	g.drawLine(0, CommonsSpaceInvader.GROUND,CommonsSpaceInvader.BOARD_WIDTH, CommonsSpaceInvader.GROUND);
        super.setBackground(Color.black);
	}
}

