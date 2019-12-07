package spaceinvaders;

import java.awt.EventQueue;

import spriteframework.AbstractBoard;
import spriteframework.MainFrame;

public class SpaceInvadersGame extends MainFrame {
	
	public SpaceInvadersGame () {
		super("Space Invaders");
	}
	
	protected  AbstractBoard createBoard() {
		setFrameHeight(CommonsSpaceInvader.BOARD_HEIGHT);
		setFrameWidth(CommonsSpaceInvader.BOARD_WIDTH);
		return new SpaceInvadersBoard();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new SpaceInvadersGame();
		});
	}
}
