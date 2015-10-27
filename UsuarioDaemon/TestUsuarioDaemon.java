package UsuarioDaemon;

public class TestUsuarioDaemon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inciciado hilo: "+Thread.currentThread().getName());
		Thread hilo1=new Hilos();
		Thread hilo2=new Hilos();
		Thread hilo3=new Hilos();
		Thread hilo4=new Hilos();
		//Hilo 1 ,hilo 2 son de usuario
		//hilo 3,hilo 4 son daemon
		hilo3.setDaemon(true);
		hilo4.setDaemon(true);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finalizado hilo: "+Thread.currentThread().getName());

	}

}
class Hilos extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Inciciando hilo: "+Thread.currentThread().getName());
		try {
			Thread.sleep(15_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finalizando hilo: "+Thread.currentThread().getName());
	}
	
};