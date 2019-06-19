package thiago;

public class Scene {
	private boolean tankMatrix[][];
	private final TankWater tankWater;
	private final FaucetFill faucetFill;
	private final FaucetEmpty faucetEmpty;
	
	public Scene(TankWater tw, FaucetFill ff, FaucetEmpty fe) {
		this.tankMatrix = new boolean[10][20];
		this.tankWater = tw;
		this.faucetFill = ff;
		this.faucetEmpty = fe;
	}
	
    public synchronized void updateTankWater() {
    	int volumeWater = this.tankWater.getCurrentWaterVolume() / 10;
    	
    	for(int line = 9; line >= 0; line--) {
    		for(int column = 0; column < 20; column++) {
    			if(volumeWater > 0) {
    				this.tankMatrix[line][column] = true;
    				volumeWater--;
                } else {
                	this.tankMatrix[line][column] = false;
                }
    		}
        }

        if(this.faucetFill.isOpen()) {
        	for(int line = 9; line >= 0; line--)
        		this.tankMatrix[line][8] = true;
        }
    }
    
    public synchronized void printScene() {
    	int line;
    	
        Console.clearScreen();
        System.out.println(this.tankWater.getCurrentWaterVolume());
        System.out.println("----------+");
        System.out.println("oooooooooo|");
        System.out.println("--------+o|");
        System.out.println("        |o|");
        
        if(this.faucetFill.isOpen()) {
        	System.out.println("        +o+");
            System.out.println("         o");
        } else {
        	System.out.println("        +-+");
            System.out.println();
        }
        
        for(line = 0; line < 5; line++) {
        	System.out.print("|");
    
        	for(int column = 0; column < 20; column++) {
        		System.out.print(this.tankMatrix[line][column] ? 'o' : ' ');
        	}
        	
            System.out.println("|");
        }

        System.out.print("|");
        
        for(int column = 0; column < 20; column++) {
        	System.out.print(this.tankMatrix[line][column] ? 'o' : ' ');
        }

        System.out.println("+------+");
        line++;
        System.out.print("|");
        
        for(int column = 0; column < 20; column++) {
        	System.out.print(this.tankMatrix[line][column] ? 'o' : ' ');
        }

        System.out.println(this.faucetEmpty.isOpen() ? "ooooooo|" : "|oooooo|");
        line++;
        System.out.print("|");
        
        for(int column = 0; column < 20; column++) {
        	System.out.print(this.tankMatrix[line][column] ? 'o' : ' ');
        }

        System.out.println("+----+o|");
        line++;
        System.out.print("|");
        
        for(int column = 0; column < 20; column++) {
        	System.out.print(this.tankMatrix[line][column] ? 'o' : ' ');
        }

        if (this.faucetEmpty.isOpen()) {
        	System.out.println("|    +o+");
        } else {
        	System.out.println("|    +-+");
        } 
        
        line++;
        System.out.print("|");
        
        for(int column = 0; column < 20; column++) {
        	System.out.print(this.tankMatrix[line][column] ? 'o' : ' ');
        }

        System.out.print('|');
        
        if(this.faucetEmpty.isOpen()) {
        	System.out.print("     o");
        }
        
        System.out.print("\n+--------------------+");
        
        if(this.faucetEmpty.isOpen()) {
        	System.out.println("     o");
        } else {
        	System.out.println();
        }
        
        System.out.println("\n\nPara parar a simulação aperte a tecla CTRL+C.");
    }


}
