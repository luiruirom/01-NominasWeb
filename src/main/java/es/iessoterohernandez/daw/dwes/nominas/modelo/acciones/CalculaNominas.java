package es.iessoterohernandez.daw.dwes.nominas.modelo.acciones;
//import java.io.BufferedOutputStream;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.OutputStreamWriter;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.ListIterator;
import java.util.Scanner;

import es.iessoterohernandez.daw.dwes.nominas.modelo.DatosNoCorrectosException;
import es.iessoterohernandez.daw.dwes.nominas.modelo.Empleado;
import es.iessoterohernandez.daw.dwes.nominas.modelo.EmpleadosDAO;

/**
 * Hello Nóminas!
 *
 */
public class CalculaNominas 
{
    /**
     * Método main correspondiente a la parte 1 del ejercicio
     * @param args
     */
//	public static void main( String[] args )
//    {
//        try {
//        	//cambio el dni del enunciado de ambos empleados por uno correcto porque estoy hacendo la validación del mismo
//	    	Empleado e1=new Empleado("James Coslng","48811600B",'M',4,7); 
//	        Empleado e2=new Empleado("Ada Lovelace", "48814047C", 'F');
//	        escribe(e1, e2);
//	        
//	        e2.incrAnyo();
//	        e1.setCategoria(9);
//	        escribe(e1, e2);
//        }catch (DatosNoCorrectosException e) {
//        	System.out.println(e.getMessage());
//        }
//    }
//	
//    private static void escribe(Empleado e1, Empleado e2) {
//    	System.out.println(e1.imprime() +  " - Sueldo="+ Nomina.sueldo(e1));
//    	System.out.println(e2.imprime() + " - Sueldo="+ Nomina.sueldo(e2));
//    }
	
    /**
     * Método main correspondiente a la parte 2 del ejercicio leyendo y escribiendo en ficheros
     * @param args
     */
//	public static void main( String[] args )
//    {
//        try {
//        	//Fichero de entrada
//        	File fentrada = new File("empleados.txt");
//	        FileReader fr = new FileReader(fentrada);
//	        BufferedReader br = new BufferedReader(fr);
//	        
//	        //Fichero de texto de salida para actualizar el de entrada
//        	File fentradaActualizada = new File("empleadosActualizados.txt");
//	        FileWriter fw = new FileWriter(fentradaActualizada);
//	        BufferedWriter bw = new BufferedWriter(fw);
//	        
//	        //Fichero binario de salida
//	        File fsalida = new File("salarios.dat");
//	        FileOutputStream fos = new FileOutputStream(fsalida);
//	        BufferedOutputStream bos = new BufferedOutputStream(fos);
////	        OutputStreamWriter bos = new OutputStreamWriter(fos);
//	        
//	        //Variables
//	        String line;;
//	        Empleado e;
//	        String []datosEmp;
//	        
//	        while (br.ready()) {
//	        	//Leemos línea por línea el fichero de entrada
//	        	line = br.readLine();
//	        	datosEmp = line.split(";");
//	        	if (datosEmp.length == 3) //en el caso de que en la línea solo haya 3 datos del empleado
//	        		e = new Empleado(datosEmp[0], datosEmp[1], datosEmp[2].toCharArray()[0]);
//	        	else //en el caso de que vayan todos los datos
//	        		e = new Empleado(datosEmp[0], datosEmp[1], datosEmp[2].toCharArray()[0], Integer.parseInt(datosEmp[3]), Integer.parseInt(datosEmp[4]));
//
//	        	escribeEmp(e);
//	        	
//	        	//Escribimos en el fichero binario
//	        	bos.write((e.dni + ";" + Nomina.sueldo(e)+'\n').getBytes());
////	        	bos.write(e.dni + ";" + Nomina.sueldo(e)+'\n');
//	        	
//	        	if (e.nombre.equalsIgnoreCase("James Cosling")) {
//	        		e.setCategoria(9);
//	        	}else if (e.nombre.equalsIgnoreCase("Ada Lovealace")) {
//	        		e.incrAnyo();
//	        	}
//
//	        	//Actualizamos el fichero de entrada
//	        	bw.write(e.nombre+";"+e.dni+";"+e.sexo+";"+e.getCategoria()+";"+e.anyos+'\n');
//	        }
//	        
//	        //Cerramos todos los búferes
//	        br.close();
//	        bos.close();
//	        bw.close();
//	        
//	        //renombramos para dejar el mismo fichero de entrada
//	        fentrada.delete();
//	        fentradaActualizada.renameTo(fentrada);
//	                
//	      }catch (FileNotFoundException e){
//	    	  e.printStackTrace();
//	      }catch (IOException e) {
//	    	  e.printStackTrace();
//	      }catch (DatosNoCorrectosException e) {
//			e.printStackTrace();
//	      }
//		}
//    }
//    
//    private static void escribeEmp(Empleado e1) {
//    	System.out.println(e1.imprime() +  " - Sueldo="+ Nomina.sueldo(e1));
//    }
	
//	/**
//     * Método main correspondiente a la parte 2 del ejercicio leyendo y escribiendo de base de datos
//     * @param args
//     */
//	public static void main( String[] args )
//    {
//        //Conexón a la base de datos
//        Connection con = ConexionBD.getConnection();
//        ArrayList<Empleado> lista_empleados = new ArrayList<Empleado>();
//        Empleado e;
//	        
//        try {    
//	        Statement st=con.createStatement();
//	        ResultSet rs=st.executeQuery("select nombre, dni, sexo, categoria, anyos from empleados");
//	        
//			while (rs.next()) {
//				e = new Empleado(rs.getString(1), rs.getString(2),  rs.getString(3).toCharArray()[0], rs.getInt(4), rs.getInt(5));
//				lista_empleados.add(e);
//			}
//			
////			System.out.println(lista_empleados.toString());
//			//Actualizamos los datos de los empleados
//				
//			Iterator<Empleado> it = lista_empleados.iterator();
//			while (it.hasNext()) {
//				e=it.next();
//				if (e.nombre.equalsIgnoreCase("James Cosling")) {
//	        		e.setCategoria(9);
//	        		st.execute("update empleados e set e.categoria="+e.getCategoria()+" where e.nombre='James Cosling'");
//	        	}else if (e.nombre.equalsIgnoreCase("Ada Lovealace")) {
//	        		e.incrAnyo();
//	    			st.execute("update empleados e set e.anyos="+e.anyos+" where e.nombre='Ada Lovealace'");
//	        	}
////				//Insertamos el sueldo del empleado
//				st.execute("insert into nominas(dni, sueldo) values ('"+e.dni+"','"+Nomina.sueldo(e)+"')");
//			}
//	        
//
//	          
//	      }catch (SQLException ex) {
//	    	  ex.printStackTrace();
//	      }catch (DatosNoCorrectosException ex) {
//	    	  ex.printStackTrace();
//
//	      }
//    }
//    
//    private static void escribeEmp(Empleado e1) {
//    	System.out.println(e1.imprime() +  " - Sueldo="+ Nomina.sueldo(e1));
//    }
	
	/**
	  * Método main correspondiente a la parte 2 del ejercicio: Métodos "altaEmpleados" 
	  * @param args
	  */
//	public static void main( String[] args )
//    {
//        EmpleadosDAO.altaEmpleado("empleadosNuevos.txt");
//    }
	
	/**
	  * Método main correspondiente a la parte 2 del ejercicio: Menú de opciones 
	  * @param args
	  */
	public static void main( String[] args )
   {
		boolean salir = false;		
		
		Scanner numeros = new Scanner(System.in);
		Scanner letras = new Scanner(System.in);
		String dni;
				
		while (!salir) {
		
			System.out.println("1. Ver todos los empleados \n"
					+ "2. Ver salario de un empleado especifico \n"
					+ "3. Submenu de edicion \n"
					+ "4. Recalcular y actualizar sueldo de un empleado \n"
					+ "5. Recalcular y actualizar sueldos de todos los empleados \n"
					+ "6. Realizar copia de seguridad de la BBDD en fichero \n"
					+ "7. Alta de nuevos empleados \n"
					+ "8. Dar de baja empleado \n"
					+ "9. Cargar backup-empleados.txt a la base de datos \n"
					+ "0. Salir ");
			String menuprincipal = letras.nextLine();
		
			switch (menuprincipal) {
			case "1": 
				for(Empleado e : EmpleadosDAO.getEmpleados()) {
					System.out.println(e.imprime());
				}
				break;
			
			case "2":
				System.out.println("Introduce el DNI del empleado del que quieres ver el sueldo");
				dni = letras.nextLine();
				int sueldo=EmpleadosDAO.getSueldo(dni);
				
				if( sueldo > 0) {
					System.out.println("El salario del empleado con DNI: "+dni+" es de "+sueldo+"€.");
				}else{
					System.out.println("El empleado con ese DNI no existe");
				}
				break;
				
			case "3":
				System.out.println("Introduce el DNI del empleado a editar");
				dni = letras.nextLine().toUpperCase();
				
				if(EmpleadosDAO.exists(dni)) {
					System.out.println("Que campos deseas editar? \n"
							+ "1. Nombre \n"
							+ "2. Sexo \n"
							+ "3. Categoria \n"
							+ "4. Anyos \n"
							+ "5. Todos los campos \n"
							+ "Introduce cualquier otra tecla para salir.");
					String opcioneditar = letras.nextLine();
					
					Empleado e = EmpleadosDAO.getEmpleado(dni);
					
					switch (opcioneditar) {
					case "1":
						System.out.println("Introduce el nuevo nombre");
						e.nombre = letras.nextLine();
						EmpleadosDAO.updateEmpleado(e);
						break;
					case "2":
						System.out.println("Introduce el nuevo sexo F/M");
						e.sexo = letras.nextLine().charAt(0);
						EmpleadosDAO.updateEmpleado(e);
						break;
					case "3":
						System.out.println("Introduce la nueva categoria");
						try {
							e.setCategoria(numeros.nextInt());
							EmpleadosDAO.updateEmpleado(e);
						}catch (DatosNoCorrectosException ex) {
							ex.printStackTrace();
						}
						break;
					case "4":
						System.out.println("Introduce el nuevo anyo");
						e.anyos = numeros.nextInt();
						EmpleadosDAO.updateEmpleado(e);
						break;
					case "5":
						System.out.println("Introduce el nuevo nombre");
						e.nombre = letras.nextLine();
						System.out.println("Introduce el nuevo sexo F/M");
						e.sexo = letras.nextLine().charAt(0);
						System.out.println("Introduce la nueva categoria");
						try {
							e.setCategoria(numeros.nextInt());
						}catch (DatosNoCorrectosException ex) {
							ex.printStackTrace();
						}						
						System.out.println("Introduce el nuevo anyo");
						e.anyos = numeros.nextInt();
						EmpleadosDAO.updateEmpleado(e);
						break;
					default:
						System.out.println("OK");
						break;
					}
					
				}
				
				break;
				
			case "4":
				
				System.out.println("Introduce el DNI del empleado a recalcular el sueldo");
				dni = letras.nextLine();
				
				if(EmpleadosDAO.exists(dni)) {
					EmpleadosDAO.updateSueldo(dni);
					System.out.println("Consulta enviada");
				}else {
					System.out.println("Empleado inexistente");
				}
								
				break;
				
			case "5":
				
				for(Empleado e : EmpleadosDAO.getEmpleados()) {
					EmpleadosDAO.updateSueldo(e.dni);
				}
				System.out.println("Consulta enviada");
				
				break;
				
			case "6":
				
				for(Empleado e : EmpleadosDAO.getEmpleados()) {
					EmpleadosDAO.backup(e);
				}
				System.out.println("Hecho :)");
				
				break;
				
			case "7":
				System.out.println("Alta manual o mediante fichero empleadosNuevos.txt? \n"
						+ "1. Manual \n"
						+ "2. Fichero \n");
				String opcionesalta = letras.nextLine();
				String nombre, dnie;
				char sexo;
				int categoria, anyos;
				
				switch (opcionesalta) {
				case "1":
					System.out.println("Introduce el nombre del empleado");
					nombre = letras.nextLine();
					System.out.println("Introduce el DNI del empleado");
					dnie = letras.nextLine().trim().toUpperCase();
					System.out.println("Introduce el Sexo del empelado F/M");
					sexo = letras.nextLine().charAt(0);
					System.out.println("Introduce la categoria del empleado");
					categoria=numeros.nextInt();
					System.out.println("Introduce los anyos trabajados del empleado");
					anyos = numeros.nextInt();
					
					EmpleadosDAO.altaEmpleado(nombre, dnie, sexo, categoria, anyos);
					System.out.println("Consulta Enviada");
									
					break;
				
				case "2":
					System.out.println("Introduce el nombre del fichero con la información de los empleados");
					EmpleadosDAO.altaEmpleado(letras.nextLine());
					System.out.println("Consulta Enviada");
					break;

				default:
					System.out.println("Operación cancelada");
					break;
				}
				
				break;
				
			case "8":
				
				System.out.println("Introduce el DNI del empleado a dar de baja");
				dni = letras.nextLine();
				EmpleadosDAO.bajaEmpleado(dni);
				System.out.println("Consulta enviada");
				
				break;
				
			case "9":
				
				EmpleadosDAO.altaEmpleado("backup-empleados.txt");
				System.out.println("Hecho :)");
				
				break;
				
			case "0":
				
				System.out.println("Hasta otra :)");
				EmpleadosDAO.cerrarConexion();
				salir=true;
				break;
			}
		
		};
			
		letras.close();
		numeros.close();
	}
   
}
