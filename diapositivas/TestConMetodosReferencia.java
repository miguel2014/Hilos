package diapositivas;

public class TestConMetodosReferencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Comienzo del programa");
		Thread hilo=new Thread(TestConMetodosReferencia::ejecuta);
		hilo.start();
		System.out.println("Fin del programa");
	}
	public static void ejecuta(){
		System.out.println("Hola desde el hilo");
	}
}
