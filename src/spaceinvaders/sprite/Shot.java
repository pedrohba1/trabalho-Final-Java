package spaceinvaders.sprite;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import spriteframework.sprite.BadSprite;


public class Shot extends BadSprite {

    public Shot() {
    	
    }

    public Shot(int x, int y) {
        initShot(x, y);
    }

    private void initShot(int x, int y) {

        String shotImg = "space_invaders_images/shot.png";
        ImageIcon ii = new ImageIcon(shotImg);
        setImage(ii.getImage());

        int H_SPACE = 6;
        setX(x + H_SPACE);

        int V_SPACE = 1;
        setY(y - V_SPACE);
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
	public void DyingAnimation() {
		// TODO Auto-generated method stub
		
	}

	
}
