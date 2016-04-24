package es.everis.test.ejb;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.everis.library.dao.ArtMovementDao;
import es.everis.library.dao.ArtMovementDaoImpl;
import es.everis.library.ejb.ArtMovementService;
import es.everis.library.entity.business.ArtMovement;

//@RunWith(Arquillian.class)
public class JpaArtMovementTest {

	@Inject
	private ArtMovementService artMovementService;

	private static EJBContainer container;


	@BeforeClass
	public static void setUpClass() throws Exception {

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(EJBContainer.MODULES, new File("target/classes"));
		properties.put("org.glassfish.ejb.embedded.glassfish.installation.root", "C:/BMW/oracleGlassfish3/glassfish");
		container = EJBContainer.createEJBContainer(properties);

		System.out.println("Opening the container");

	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		container.close();
		System.out.println("Closing the container");
	}

	@Before
	public void setUp() throws NamingException {
		artMovementService = (ArtMovementService) container.getContext().lookup(
				"java:global/classes/ArtMovementServiceBean");
	}

	@Test
	public void testAddEntity() {
		
		ArtMovement artMovement = new ArtMovement();
//		artMovement.setArtMovementId(1);
		artMovement.setArtMovementName("Cubism");
		artMovement.setCentury(19);
		
		artMovementService.addEntity(artMovement);
	}
	
	@Test
	public void testGetAll() {
		List<ArtMovement> artMovements = artMovementService.getAll();
		printArtMovements(artMovements, "testSimple");
	}

//	public void testFilterEqual() {
//		List<Empleado> empleados = empleadoDao.findFilterEqual("FERNANDO");
//		printEmpleados(empleados, "testFilterEqual");
//	}
//
//	public void testFilterOr() {
//		List<Empleado> empleados = empleadoDao.findFilterOr("534", "ANTONIO");
//		printEmpleados(empleados, "testFilterOr");
//	}
//
//	public void testFilterLikeIgnoreCase() {
//		List<Empleado> empleados = empleadoDao.findFilterLikeIgnoreCase("a");
//		printEmpleados(empleados, "testFilterLikeIgnoreCase");
//	}
//
//	public void testFilterStandardUser() {
//		List<Empleado> empleados = empleadoDao.findFilterStandardUser("5", "a");
//		printEmpleados(empleados, "testFilterStandardUser");
//	}
//
//	public void testFilterJoin() {
//		List<Empleado> empleados = empleadoDao.findFilterJoin("MEDITERRANEA");
//		printEmpleados(empleados, "testFilterJoin");
//	}
//
//	public void testFilterSubQuery() {
//		List<Empleado> empleados = empleadoDao.findFilterSubQuery("MARKETING");
//		printEmpleados(empleados, "testFilterSubQuery");
//	}
//
//	public void testFilterSubQueryMax() {
//		List<Empleado> empleados = empleadoDao.findFilterSubQueryMax();
//		printEmpleados(empleados, "testFilterSubQueryMax");
//	}

	private void printArtMovements(List<ArtMovement> artMovements, String title) {
		System.out.println("** " + title + " **");
		if (artMovements.isEmpty()) {
			System.out.println("Empty.");
		} else {
			for (ArtMovement artMovement : artMovements) {
				System.out.println(artMovement.getArtMovementId() + " - "
						+ artMovement.getArtMovementName()			+ " - "
						+ artMovement.getCentury() + " - " 
						+ artMovement.getWorks()			+ " - "
						);
			}
		}
		System.out.println("--");
	}

}
