package spriteframework.sprite;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Sprite {

    private boolean visible;
    protected Image image;
    private boolean dying;

    protected int x;
    protected int y;
    protected int imageWidth;
    protected int imageHeight;
    protected int dx;
    protected int dy;

    
    public boolean collided(Sprite sprite) {
    
    	Rectangle Rec1 = this.getRect();
		Rectangle Rec2 = sprite.getRect();
		if(Rec1.intersects(Rec2) && this.isVisible() && sprite.isVisible()) {
			return true;
		}
		else {
		return false;
		}
    }

    public void interchangeDirectionsWith(Sprite sprite) {
    	int sprite1Dx = this.dx;
    	int sprite1Dy = this.dy;
    	int sprite2Dx = sprite.dx;
    	int sprite2Dy = sprite.dy;
    	
    	this.dx = sprite2Dx;
    	this.dy = sprite2Dy;
    	
    	sprite.dx = sprite1Dx;
    	sprite.dy = sprite1Dy;
    }
    
    public Sprite() {

        visible = true;
    }

    public void die() {

        visible = false;
    }

    public boolean isVisible() {

        return visible;
    }

    protected void setVisible(boolean visible) {

        this.visible = visible;
    }
    

    public void setImage(Image image) {

        this.image = image;
    }

    protected void loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }
    
    public Image getImage() {

        return image;
    }

    public void setX(int x) {

        this.x = x;
    }

    public void setY(int y) {

        this.y = y;
    }

    public int getY() {

        return y;
    }

    public int getX() {

        return x;
    }

    public int getImageWidth() {

        return imageWidth;
    }

    public int getImageHeight() {

        return imageHeight;
    }
    
    public Rectangle getRect() {
        return new Rectangle(x, y,
                image.getWidth(null), image.getHeight(null));
    }

    public void getImageDimensions() {
        imageWidth = image.getWidth(null);
        imageHeight = image.getHeight(null);
    }
    public void setDying(boolean dying) {

        this.dying = dying;
    }

    public boolean isDying() {

        return this.dying;
    }
    
    public void moveX(int direction) {

        this.x += direction;
    }
    
    public void moveY(int direction) {

        this.y += direction;
    }
    
}
