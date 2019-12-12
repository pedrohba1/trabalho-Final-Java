package spriteframework.sprite;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public abstract class BadSprite extends Sprite {
	
	protected abstract void doMovement();
	
	public LinkedList<BadSprite>  getBadnesses() {
		return null;
	}	
	public boolean isDestroyed() {
		return false;
	}
	public void act() {
		doMovement();
	}
	
	public abstract BadSprite getBad();

	public abstract void shoot();

	public abstract void setDyingImage();
	
	public abstract ImageIcon DyingAnimation(Graphics g);
	

	
}
