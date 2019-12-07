package spriteframework;

import javax.swing.JFrame;

public abstract class MainFrame extends JFrame  {

	int boardWith;
	int boardHeight;
	
    protected abstract AbstractBoard createBoard();
    
    public MainFrame(String t) {
          
        add(createBoard());
		
		setTitle(t);
		setSize(boardWith, boardHeight);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
    } 
    
    public void setFrameWidth (int boardWidth) {
    	this.boardWith = boardWidth;
    }

    public void setFrameHeight (int boardHeight) {
    	this.boardHeight = boardHeight;
    }
}
