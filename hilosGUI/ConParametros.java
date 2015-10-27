package hilosGUI;


public class ConParametros {
	public static void main(String[] args) {
		System.out.println("Comienzo del programa principal");
		HilosconThread hilo=new HilosconThread();
		int tamaño=Integer.parseInt(args[0]);
		
		if (args.length>0) {
		hilo.start();
		}
		else{
			System.out.println("Has de introducir argumentos");
			System.exit(0);
		}
		System.out.println("Fin del programa principal");
	}	
}
class HilosconThread extends Thread{ 
	@Override
	public void run() {

	}
}