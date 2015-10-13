package diapositivas;

public class TestHilosConThread {
	public static void main(String[] args) {
		System.out.println("Comienzo del programa principal");
		HilosconThread hilo=new HilosconThread();
		hilo.start();
		/* 
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Fin del programa principal");

	}
}
class HilosconThread extends Thread{ 
	//el codigo que se ejecuta concurrentemente se implementa
	// en el metodo run que los aporta la clase Thread
	@Override
	public void run() {
		System.out.println("Hola desde el hilo");
	}
}