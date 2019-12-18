package com.visitor.vmsvisitorservice.service;

import java.util.List;

import com.visitor.vmsvisitorservice.dto.VisitorDto;
import com.visitor.vmsvisitorservice.model.Visitor;

public interface IVisitorService {

	//String addVisitor(VisitorDto visitorDto);

	List<Visitor> visitorsList();

	Visitor getVisitorByName(String name);

	Visitor getByVisitorId(long id);

	String updateVisitor(int id, Visitor visitor);

	//void save(Visitor userForm);

	//void registrerVisitor(Visitor visitor);

	void save(Visitor visitor);

	//String updateVisitorDetails(int id, Visitor visitor);

	//String updateVisitor(Integer id, Visitor visitor);

	//String updatePerson(Integer id, Visitor visitor);

	
}
