package spaceinvaders.sprite;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import spriteframework.sprite.BadSprite;

public class Bomb extends BadSprite {

    private boolean destroyed;

    public Bomb(int x, int y) {

        initBomb(x, y);
    }

    private void initBomb(int x, int y) {

        setDestroyed(true);

        this.x = x;
        this.y = y;

        String bombImg = "space_invaders_images/bomb.png";
        ImageIcon ii = new ImageIcon(bombImg);
        setImage(ii.getImage());
    }

    public void setDestroyed(boolean destroyed) {

        this.destroyed = destroyed;
    }

    public boolean isDestroyed() {

        return destroyed;
    }

	@Override
	protected void doMovement() {
		// TODO Auto-generated method stub
		
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
