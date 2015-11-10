package colecciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class EjercicioColecciones {
	public static void main(String[] args) {
		List <String> lista1=new ArrayList<String>();
		List <String> lista2=new ArrayList<String>();
		//Elemenos unicos y ordenados
		Set listatreeset1= new TreeSet<String>();
		Set listatreeset2= new TreeSet<String>();
		//Mantiene los elementos ordenados
		Map<String,String> listamap = new TreeMap<>();
		String[] campos;
		File archivo=new File("/home/matinal/diccionario.csv");
		try (Scanner in=new Scanner(archivo);){
			String textoleido;
			while (in.hasNextLine()){
				textoleido=in.nextLine();
				campos=textoleido.split("@");
				lista1.add(campos[0]);
				lista2.add(campos[1]);
				listatreeset1.add(campos[0]);
				listatreeset2.add(campos[1]);
				listamap.put(campos[0], campos[1]);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < lista1.size(); i++) {
			System.out.println("Ingles:"+lista1.get(i) +" .Español "+lista2.get(i));
		}
		
		System.out.println(listamap.get("battleground"));
	}
}
