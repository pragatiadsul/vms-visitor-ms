
package com.visitor.vmsvisitorservice.servicetest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.visitor.vmsvisitorservice.dto.VisitorDto;
import com.visitor.vmsvisitorservice.model.Visitor;
import com.visitor.vmsvisitorservice.service.VisitorServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
class VisitorServiceTestCase {

	@Autowired
	private VisitorServiceImpl visitorService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Method used to get VisitorsList
	 */

	@Test
	void testVisitorsList() {
		Visitor visitor = new Visitor();
		visitor.setName("reshma");
		List<Visitor> member = visitorService.visitorsList();
		Visitor newMember = member.get(0);
		Assert.assertEquals(visitor.getName(), newMember.getName());

	}

	/**
	 * Method used to get Visitor by using VisitorById
	 */
	@Test
	void testGetByVisitorId() {
		Visitor visitor = visitorService.getByVisitorId(02);
		Assert.assertEquals("sameer", visitor.getName());
		Assert.assertEquals("p@gmail.com", visitor.getEmail());

	}

	/**
	 * Method used to add Visitor
	 */
	@Test
	public void testSaveVisitor() {
		VisitorDto v1 = new VisitorDto();
		v1.setName("sangam");
		v1.setAddress("wakad,pune");

		v1.setContactPersonEmail("Hr@gmail.com");
		v1.setContactPersonName("kishori");
		v1.setMobileNo("9658253641");

		v1.setEmail("sangam@gmail.com");
		v1.setIdProof("98TYNBYUTR");
		v1.setReasonForVisit("joining");
		v1.setContactPersonMobileNo("8798898974");
		visitorService.addVisitor(v1);
	}

	/**
	 * Method used get VisitorByName
	 */
	@Test
	public void testGetVisitorByName() {
		Visitor cat = visitorService.getVisitorByName("sameer");
		assertEquals("sameer", cat.getName());
	}
}
