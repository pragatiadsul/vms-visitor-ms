package com.visitor.vmsvisitorservice.servicetest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.visitor.vmsvisitorservice.dao.IVisitorDao;
import com.visitor.vmsvisitorservice.dto.VisitorDto;
import com.visitor.vmsvisitorservice.model.Visitor;
import com.visitor.vmsvisitorservice.repository.VisitorRepository;
import com.visitor.vmsvisitorservice.service.VisitorServiceImpl;

class MockitoVisitorServiceTest {

	@InjectMocks
	private VisitorServiceImpl visitorService;

	@Mock
	private VisitorRepository visitorRepository;

	@Mock
	private IVisitorDao visitorDao;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void letsMockListSize() {
		List list = mock(List.class);
		when(list.size()).thenReturn(10);
		assertEquals(10, list.size());

	}

	/**
	 * Method used to get Visitor by using VisitorById
	 */
	@Test
	void testGetByVisitorId() {

		Visitor visitor = new Visitor();
		visitor.setName("ashwini");

		when(visitorDao.findById(5)).thenReturn(visitor);

		Visitor visitordata = visitorService.getByVisitorId(5);
		assertNotNull(visitordata);
		System.out.print(visitordata.getName());
		assertEquals("ashwini", visitordata.getName());

	}

	/**
	 * Method used to get VisitorsList
	 */

	@Test
	void testVisitorsList() {
		List<Visitor> list = new ArrayList<Visitor>();
		Visitor visitorOne = new Visitor(1, "John", "pune", "howtodoinjava@gmail.com", "ekta", "9898989898",
				"e@gmail.com", "9656457825", "4654352432", 0, "joining");
		Visitor visitorTwo = new Visitor(2, "Alex", "mumbai", "alexk@yahoo.com", "ekta", "9898989898", "e@gmail.com",
				"9685457825", "34TREB2431", 0, "joining");
		Visitor visitorThree = new Visitor(3, "Steve", "benglore", "swaugh@gmail.com", "ekta", "9898989898",
				"e@gmail.com", "9798652541", "4787651432", 0, "joining");

		list.add(visitorOne);
		list.add(visitorTwo);
		list.add(visitorThree);

		when(visitorDao.visitorsList()).thenReturn(list);

		// test
		List<Visitor> visitorList = visitorService.visitorsList();

		assertEquals(3, visitorList.size());
		verify(visitorDao, times(1)).visitorsList();
	}

	/**
	 * Method used to add Visitor
	 */

	@Test
	void testAddVisitor() {
		VisitorDto v1 = new VisitorDto();
		v1.setName("priyanka");
		v1.setAddress("wakad,pune");
		v1.setContactPersonEmail("Hr@gmail.com");
		v1.setContactPersonName("kishori");
		v1.setMobileNo("9342253641");
		v1.setEmail("piyu@gmail.com");
		v1.setIdProof("90TYNBYUTR");
		v1.setReasonForVisit("joining");
		v1.setContactPersonMobileNo("8798898974");

		visitorService.addVisitor(v1);
		visitorRepository.save(v1);

	}

	/**
	 * Method used to get Visitor by using VisitorById
	 */
	@Disabled
	@Test
	public void getVisitorByIdTest() {
		when(visitorDao.findById(1)).thenReturn(new Visitor(1, "John", "pune", "John@gmail.com", "ekta", "9898989898",
				"e@gmail.com", "9656457825", "4654352432", 0, "joining"));

		Visitor visitor = visitorService.getByVisitorId(1);

		assertEquals("John", visitor.getName());
		assertEquals("pune", visitor.getAddress());
		assertEquals("John@gmail.com", visitor.getEmail());
		assertEquals("ekta", visitor.getContactPersonName());
		assertEquals("9898989898", visitor.getContactPersonMobileNo());
		assertEquals("e@gmail.com", visitor.getContactPersonEmail());
		assertEquals("9656457825", visitor.getMobileNo());
		assertEquals("4654352432", visitor.getIdProof());
		assertEquals("joining", visitor.getReasonForVisit());
		assertEquals(0, visitor.getStatus());
	}

}
