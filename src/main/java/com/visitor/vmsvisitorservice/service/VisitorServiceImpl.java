package com.visitor.vmsvisitorservice.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visitor.vmsvisitorservice.dao.IVisitorDao;
import com.visitor.vmsvisitorservice.dto.VisitorDto;
import com.visitor.vmsvisitorservice.exception.VisitorNotFoundException;
import com.visitor.vmsvisitorservice.model.Visitor;
import com.visitor.vmsvisitorservice.repository.VisitorRepository;

@Service
public class VisitorServiceImpl implements IVisitorService {

	@Autowired
	private VisitorRepository visitorRepository;

	@Autowired
	private IVisitorDao visitorDao;

	/*
	 * @Override public String addVisitor(VisitorDto visitorDto) {
	 * 
	 * 
	 * Visitor va = new Visitor(); va.setAddress(visitorDto.getAddress());
	 * //va.setCity(visitorDto.getCity());
	 * va.setContactPersonEmail(visitorDto.getContactPersonEmail());
	 * va.setContactPersonName(visitorDto.getContactPersonName());
	 * //va.setCountry(visitorDto.getCountry()); va.setEmail(visitorDto.getEmail());
	 * va.setId(visitorDto.getId()); va.setIdProof(visitorDto.getIdProof());
	 * //va.setMobileNo(visitorDto.getMobileNo());
	 * va.setMobileNo(visitorDto.getMobileNo());
	 * 
	 * va.setName(visitorDto.getName());
	 * va.setReasonForVisit(visitorDto.getReasonForVisit());
	 * va.setContactPersonMobileNo(visitorDto.getContactPersonMobileNo());
	 * //va.setReference(visitorDto.getReference());
	 * //va.setState(visitorDto.getState()); visitorRepository.save(va); return
	 * "Recored Added successfully";
	 * 
	 * }
	 * 
	 */
	@Override
	public List<Visitor> visitorsList() {

		return visitorDao.visitorsList();
	}

	@Override
	public Visitor getByVisitorId(long id) {

		// return visitorDao.findById(id);

		Visitor visitorData = visitorDao.findById(id);

		if (visitorData == null) {
			throw new VisitorNotFoundException("");
		}

		return visitorData;

	}

	@Override
	public Visitor getVisitorByName(String name) {

		return visitorDao.findByName(name);
	}

	@Override
	public void save(@Valid VisitorDto visitorDto) {
		Visitor va = new Visitor();
		va.setAddress(visitorDto.getAddress());
		va.setContactPersonEmail(visitorDto.getContactPersonEmail());
		va.setContactPersonName(visitorDto.getContactPersonName());
		va.setEmail(visitorDto.getEmail());
		va.setId(visitorDto.getId());
		va.setIdProof(visitorDto.getIdProof());
		va.setMobileNo(visitorDto.getMobileNo());
		va.setName(visitorDto.getName());
		va.setReasonForVisit(visitorDto.getReasonForVisit());
		va.setContactPersonMobileNo(visitorDto.getContactPersonMobileNo());
		visitorRepository.save(va);

	}

	@Override
	public String addVisitor(@Valid VisitorDto visitorDto) {
		Visitor va = new Visitor();
		va.setAddress(visitorDto.getAddress());
		va.setContactPersonEmail(visitorDto.getContactPersonEmail());
		va.setContactPersonName(visitorDto.getContactPersonName());
		va.setEmail(visitorDto.getEmail());
		va.setId(visitorDto.getId());
		va.setIdProof(visitorDto.getIdProof());
		va.setMobileNo(visitorDto.getMobileNo());
		va.setName(visitorDto.getName());
		va.setReasonForVisit(visitorDto.getReasonForVisit());
		va.setContactPersonMobileNo(visitorDto.getContactPersonMobileNo());
		visitorRepository.save(va);
		return "Recored Added successfully";
	}

	@Override
	public void updateVisitorById(Visitor visitor, long id) {
		visitorDao.updateVisitorById(visitor, id);

	}

}
