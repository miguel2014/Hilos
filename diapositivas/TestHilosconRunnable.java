package diapositivas;

public class TestHilosconRunnable {
	public static void main(String[] args) {
		System.out.println("Comienzo del programa principal");
		Thread hilo=new Thread(new HilosconThread());
		hilo.start();
		System.out.println("Fin del programa principal");
	}
}
class HijosconRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hola desde el hilo");
	}
	
}