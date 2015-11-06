package productorConsumidor;

public class TestConsumidorProductor1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer1 buffer=new Buffer1();
		Consumidor1 consumidor=new Consumidor1(buffer);
		Productor productor=new Productor(buffer);
		productor.start();
		consumidor.start();
	}

}
class Buffer1{
	private char contenido;
	private boolean disponible=false;
	
	public char recoger(){
		if(disponible){
			this.disponible=false;
			return this.contenido;
		}
		return '\b';
	}
	public void poner(char contenido){
		this.contenido=contenido;
		this.disponible=true;
	}
}
class Productor extends Thread{
	private Buffer1 buffer;
	private final String letras="abcdefghijklmnopqrstuvwxyz";
	public Productor(Buffer1 buffer) {
		this.buffer = buffer;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			char caracter=letras.charAt((int) (Math.random()*letras.length()));
			this.buffer.poner(caracter);
			System.out.println("Productor:  "+caracter);
			try {
				Thread.sleep((long) (Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
}
class Consumidor1 extends Thread{
	private Buffer1 buffer;

	public Consumidor1(Buffer1 buffer) {
		
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