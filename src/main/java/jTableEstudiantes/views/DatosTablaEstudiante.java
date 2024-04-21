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
	
	
	public static Object[][] getDatosDeTabla(){
		
		List<Estudiante> estudiantes = ControladorEstiduante.getInstance().findAll();
		Object[][] datos = new Object[estudiantes.size()][getTitulosColumnas().length];
		
		for (int i = 0; i < estudiantes.size(); i++) {
			
			Estudiante estudiante = estudiantes.get(i);
			
			datos[i][0] = estudiante.getId();
			datos[i][1] = estudiante.getNombre();
			datos[i][2] = estudiante.getApellido1();
			datos[i][3] = estudiante.getApellido2();
			datos[i][4] = estudiante.getDni();
			datos[i][5] = estudiante.getDireccion();
			datos[i][6] = estudiante.getEmail();
			datos[i][7] = estudiante.getTelefono();
			datos[i][8] = estudiante.getIdTipologiaSexo();
			datos[i][9] = estudiante.getImagen();
			datos[i][10] = estudiante.getColorFavorito();
		}	
		return datos;
	}

}
