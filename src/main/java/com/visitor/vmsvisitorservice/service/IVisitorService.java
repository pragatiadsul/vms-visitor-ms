package com.visitor.vmsvisitorservice.service;

import java.util.List;

import javax.validation.Valid;

import com.visitor.vmsvisitorservice.dto.VisitorDto;
import com.visitor.vmsvisitorservice.model.Visitor;

public interface IVisitorService {

	List<Visitor> visitorsList();

	Visitor getVisitorByName(String name);

	Visitor getByVisitorId(long id);

	void save(@Valid VisitorDto visitorDto);

	String addVisitor(@Valid VisitorDto visitorDto);

	void updateVisitorById(Visitor visitor, long id);

}
