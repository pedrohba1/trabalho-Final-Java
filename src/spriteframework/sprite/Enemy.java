package spriteframework.sprite;

import java.util.LinkedList;

public abstract  class Enemy extends BadSprite{
	
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
}
