package productorConsumidor;

public class TestConsumidorProductor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer2 buffer=new Buffer2();
		Consumidor2 consumidor=new Consumidor2(buffer);
		Productor2 productor=new Productor2(buffer);
		productor.start();
		consumidor.start();
	}

}
class Buffer2{
	private char contenido;
	private boolean disponible=false;
	
	public synchronized char recoger(){
		if (!disponible) {			
			try {
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}	
		}
		disponible=false;
		notify();
		return this.contenido;
	}
	public synchronized void  poner(char contenido){
		if(disponible){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.contenido=contenido;
		disponible=true;
		notify();
		
		
	}
}
class Productor2 extends Thread{
	private Buffer2 buffer;
	private final String letras="abcdefghijklmnopqrstuvwxyz";
	public Productor2(Buffer2 buffer) {
		this.buffer = buffer;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			char caracter=letras.charAt((int) (Math.random()*letras.length()));
			this.buffer.poner(caracter);
			System.out.println(i+" Productor:  "+caracter);
			try {
				Thread.sleep((long) (Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
}
class Consumidor2 extends Thread{
	private Buffer2 buffer;

	public Consumidor2(Buffer2 buffer) {
		
		this.buffer = buffer;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			char caracter=this.buffer.recoger();
			System.out.println(i+" Consumidor: "+caracter);
			try {
				Thread.sleep((long) (Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}