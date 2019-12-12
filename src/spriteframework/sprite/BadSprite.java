package spriteframework.sprite;

import java.util.LinkedList;

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
	
	

	
}
