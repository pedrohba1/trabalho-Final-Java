package spaceinvaders.sprite;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import spriteframework.sprite.BadSprite;


public class BomberSprite extends BadSprite {

    private Bomb bomb;
    LinkedList<BadSprite>  badnesses = new LinkedList<BadSprite>();

    public BomberSprite(int x, int y) {
        initBomber(x, y);
    }

    private void initBomber(int x, int y) {
        this.x = x;
        this.y = y;
        bomb = new Bomb(x, y);
        String alienImg = "space_invaders_images/alien.png";
        ImageIcon ii = new ImageIcon(alienImg);
        setImage(ii.getImage());
    }

    public Bomb getBomb() {
        return bomb;
    }

    void add(BadSprite b) {
   	 badnesses.add(b);
    }
	@Override
	public LinkedList<BadSprite> getBadnesses() {
		LinkedList<BadSprite> aBomb = new LinkedList<BadSprite>();
		aBomb.add(bomb);
		return aBomb;
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
