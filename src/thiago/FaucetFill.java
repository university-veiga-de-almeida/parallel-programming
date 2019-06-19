package thiago;

public class FaucetFill extends Thread {
	private final TankWater tankWater;
	private boolean isOpen;
	private int literOfWater = 10;
	private long timer = 150;
	
	public FaucetFill(TankWater tw) {
		this.tankWater = tw;
		this.isOpen = false;
	}
	
	public synchronized void open() {
        this.isOpen = true;
    }
	
	public synchronized void close() {
        this.isOpen = false;
    }
	
    public synchronized boolean isOpen() {
        return this.isOpen;
    }
	
	@Override
	public void run() {
		while(!interrupted()) {
			if(this.isOpen)
				this.tankWater.fillWater(this.literOfWater);
			
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
