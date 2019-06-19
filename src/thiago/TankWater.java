package thiago;

public class TankWater {
	private final int maximumWaterVolume = 2000;
	private int currentWaterVolume = 0;
	
    public synchronized int getCurrentWaterVolume() {
    	return this.currentWaterVolume;
    }
	
	public synchronized void fillWater(int litersOfWater) {
		this.currentWaterVolume += litersOfWater;
	}
	
	public synchronized void removeWater(int litersOfWater) {
		if(this.currentWaterVolume >= litersOfWater)
			this.currentWaterVolume -= litersOfWater;
		else 
			this.currentWaterVolume = 0;
	}
}
