package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IMissionService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MissionServiceImplTest {

	@Autowired
	IMissionService ms; 

	/*@Test
	@Order(1)
	public void testRetrieveAllMissions() {
		List <Mission> lm = ms.retrieveAllMissions();
		Assert.assertEquals(12, lm.size());
	}*/
	
	
	@Test
	@Order(2)
	public void testAddMission() throws ParseException {
		Mission m = new Mission("Consultant", "Consultant SAP");
		Mission ma = ms.addMission(m);
		Assert.assertEquals(m.getName(), ma.getName());
	}
 
	@Test
	@Order(3)
	public void testModifyMission() throws ParseException   {
		
		Mission m = new Mission(2L, "Auditor", "Compliance"); 
		Mission mUpdated  = ms.updateMission(m); 
		Assert.assertEquals(m.getName(), mUpdated.getName());
		
	}

	@Test
	@Order(4)
	public void testRetrieveMission() {
		Mission mRetrieved = ms.retrieveMission("1"); 
		Assert.assertEquals(1, mRetrieved.getId().longValue());
	}
	
	/*@Test
	@Order(5)
	public void testDeleteMission() {
		ms.deleteMission("14");		
	}*/
	
}
