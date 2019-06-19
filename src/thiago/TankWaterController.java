package thiago;

public class TankWaterController extends Thread {
	private final TankWater tankWater;
	private final FaucetFill faucetFill;
	private final FaucetEmpty faucetEmpty;	
	private final Scene scene;
	
	public TankWaterController(TankWater tw, FaucetFill ff, FaucetEmpty fe) {
		this.tankWater = tw;
		this.faucetFill = ff;
		this.faucetEmpty = fe;
		this.scene = new Scene(this.tankWater, this.faucetFill, this.faucetEmpty);
	}
	
	public void init() {
		this.faucetFill.start();
		this.faucetEmpty.start();
		start();
	}
	
	public void finish() {
		this.faucetFill.interrupt();
		this.faucetEmpty.interrupt();
		interrupt();
		
		try {
			this.faucetFill.join();
			this.faucetEmpty.join();
			join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(!interrupted()) {
                        if(this.tankWater.getCurrentWaterVolume() <= 1000)
                            this.faucetFill.open();
                        if(this.tankWater.getCurrentWaterVolume() >= 2000) {
                            this.faucetFill.close();
                            this.faucetEmpty.open();
                        }
                        if(this.tankWater.getCurrentWaterVolume() <= 600)
			    this.faucetEmpty.close();
//			} else {
//				if(this.tankWater.getCurrentWaterVolume() >= 2000)
//					this.faucetEmpty.open();
//				if(this.tankWater.getCurrentWaterVolume() >= 2000) {
//	        		this.faucetFill.close();
//	        	} else {
//	            	if(this.tankWater.getCurrentWaterVolume() <= 1000)
//	            		this.faucetFill.open();
//	        	}
//	        }
	            
	            this.scene.updateTankWater();
	            this.scene.printScene();
//	        }
		}
	}
}
