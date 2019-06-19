package thiago;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		TankWater tw = new TankWater();
		FaucetFill ff = new FaucetFill(tw);
		FaucetEmpty fe = new FaucetEmpty(tw);
		TankWaterController twc = new TankWaterController(tw, ff, fe);
		
		System.out.println("Para iniciar a simulação tecle ENTER ou CTRL+C para finalizar");
		input.nextLine();
		
		twc.init();
		input.nextLine();
		twc.finish();
	}

}
