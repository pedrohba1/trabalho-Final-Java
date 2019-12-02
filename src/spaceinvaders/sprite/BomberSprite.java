package spaceinvaders.sprite;

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
        String alienImg = "images/alien.png";
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
}
