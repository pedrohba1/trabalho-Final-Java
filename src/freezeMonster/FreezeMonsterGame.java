package freezeMonster;

import java.awt.EventQueue;

import spaceinvaders.SpaceInvadersBoard;
import spaceinvaders.SpaceInvadersGame;
import spriteframework.AbstractBoard;
import spriteframework.MainFrame;

public class FreezeMonsterGame extends MainFrame {

	public FreezeMonsterGame () {
		super("Freeze Monster Game");
	}
	
	@Override
	protected  AbstractBoard createBoard() {
		setFrameHeight(CommonsFreezeMonster.BOARD_HEIGHT);
		setFrameWidth(CommonsFreezeMonster.BOARD_WIDTH);
		return new FreezeMonsterBoard();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			new FreezeMonsterGame();
		});

	}	
	
}
