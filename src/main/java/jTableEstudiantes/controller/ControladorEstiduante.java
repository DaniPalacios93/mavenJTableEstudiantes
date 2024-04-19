package jTableEstudiantes.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import jTableEstudiantes.entities.Estudiante;


public class ControladorEstiduante {

	private static ControladorEstiduante instance = null;
	private EntityManager em = null;
	
	
	/// CONTROLADOR
	
	public ControladorEstiduante() {
		super();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static ControladorEstiduante getInstance() {
		if(instance == null) {
			instance = new ControladorEstiduante();
		}
		return instance;
	}
	
	
	/**
	 * 
	 * @return
	 */
	protected EntityManager getEntityManager() {
		if (em == null) {
			em = Persistence.createEntityManagerFactory("jTableEstudiantes").createEntityManager();
		}
		return em;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public List<Estudiante> findAll (){
		return getEntityManager().createNativeQuery("SELECT * FROM estudiante", Estudiante.class).getResultList();
	}
	
	
	
	
}
