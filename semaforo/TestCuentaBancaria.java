package semaforo;

import java.util.concurrent.Semaphore;

public class TestCuentaBancaria {
	public static void main(String[] args) {
		CuentaBancaria cuenta=new CuentaBancaria(1000);
		OperacionBancaria op;
		int cantidad;
		int signo=1;//Sirve para añadir o retirar dinero
		for (int i = 0; i < 15; i++) {
			cantidad=(int) (Math.random()*100);
			op=new OperacionBancaria(cuenta, cantidad*signo);
			op.start();
			signo*=-1;
		}
	}
}
class CuentaBancaria{
	private double saldo;
	Semaphore semaforo= new Semaphore(1);
	public CuentaBancaria(double saldo) {
		super();
		this.saldo = saldo;
	}
	public void variarCuenta(double cantidad){
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.saldo+=cantidad;
		System.out.println("Variando cuenta: "+cantidad + " saldo: "+this.saldo);
		semaforo.release();
	}
}
class OperacionBancaria extends Thread{
	private CuentaBancaria cuenta;
	private double cantidadaVariar;
	public OperacionBancaria(CuentaBancaria cuenta, double cantidadaVariar) {
		super();
		this.cuenta = cuenta;
		this.cantidadaVariar = cantidadaVariar;
	}
	@Override
	public void run() {
		this.cuenta.variarCuenta(this.cantidadaVariar);
	}
}