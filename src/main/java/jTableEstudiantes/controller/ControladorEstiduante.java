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
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Estudiante findById(int id) {
		
		Estudiante estudiante = (Estudiante) getEntityManager().createNativeQuery("SELECT * FROM estudiante WHERE id=" + id, Estudiante.class).getSingleResult();
		return estudiante;
	}
	
	
	/**
	 * 
	 * @param e
	 */
	public void updateEstudiante (Estudiante e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	
	
}
