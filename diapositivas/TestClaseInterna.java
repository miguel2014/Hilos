package diapositivas;

public class TestClaseInterna {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Comienzo del programa principal");
		Thread hilo=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Hola desde el hilo");
			}
		});
		hilo.start();
		System.out.println("Fin del programa principal");
	}

}
