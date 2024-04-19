package jTableEstudiantes.views;

import java.util.List;

import jTableEstudiantes.controller.ControladorEstiduante;
import jTableEstudiantes.entities.Estudiante;

public class DatosTablaEstudiante {
	
	
	
	public static String[] getTitulosColumnas() {
		return new String[] {
				"Id",
				"Nombre",
				"Apellido1",
				"Apellido2",
				"DNI",
				"Direccion",
				"Email",
				"Telefono",
				"idTipologiaSexo",
				"Imagen",
				"ColorFavorito"};
	}
	
//	
//	public static Object[][] getDatosDeTabla(){
//		
//		List<Estudiante> estudiantes = ControladorEstiduante.getInstance().findAll();
//		
//		Object[][] datos = new Object[estudiantes.size()][getTitulosColumnas().length];
//		
//		for (int i )
//	}
	
	
	
	
	
	

}
