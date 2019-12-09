package freezeMonster;

import java.util.Random;

public interface CommonsFreezeMonster extends spriteframework.Commons{

	Random random = new Random();
	
	
    int BOARD_WIDTH = 800;
    int BOARD_HEIGHT = 600;
    
    int PLAYER_INIT_X = 400;
    int PLAYER_INIT_Y = 300;
    
    int MONSTER_HEIGHT = 60;
    int MONSTER_WIDTH = 40;
    
    
    int PLAYER_WIDTH = 40;
    int PLAYER_HEIGHT = 60;
    
    int MONSTER_SPAWN_WIDTH = 300;
    int MONSTER_SPAWN_HEIGHT =  200;
        
}
