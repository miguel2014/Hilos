package diapositivas;

public class TestConInterfaceFuncional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Comienzo del programa principal");
		Runnable runnable=() ->System.out.println("Hola desde el hilo");
		Thread hilo=new Thread(runnable);
		hilo.start();
		System.out.println("Fin del programa principal");
	}
}
