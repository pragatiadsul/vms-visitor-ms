package com.visitor.vmsvisitorservice.service;

import java.util.HashSet;
import java.util.List;

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

	/* @Override
	public String addVisitor(VisitorDto visitorDto) {
		

		Visitor va = new Visitor();
		va.setAddress(visitorDto.getAddress());
		//va.setCity(visitorDto.getCity());
		va.setContactPersonEmail(visitorDto.getContactPersonEmail());
		va.setContactPersonName(visitorDto.getContactPersonName());
		//va.setCountry(visitorDto.getCountry());
		va.setEmail(visitorDto.getEmail());
		va.setId(visitorDto.getId());
		va.setIdProof(visitorDto.getIdProof());
		//va.setMobileNo(visitorDto.getMobileNo());
	va.setMobileNo(visitorDto.getMobileNo());
		
		va.setName(visitorDto.getName());
		va.setReasonForVisit(visitorDto.getReasonForVisit());
		va.setContactPersonMobileNo(visitorDto.getContactPersonMobileNo());
		//va.setReference(visitorDto.getReference());
		//va.setState(visitorDto.getState());
		visitorRepository.save(va);
		return "Recored Added successfully";

	}
	*/

	@Override
	public List<Visitor> visitorsList() {
		
		return visitorDao.visitorsList();
	}

	@Override
	public Visitor getByVisitorId(long id) {

		//return visitorDao.findById(id);
		
Visitor visitorData=visitorDao.findById(id);
		
		if(visitorData==null)
		{
			throw new VisitorNotFoundException("");
		}

		return visitorData;
		
		
		
	}

//	@Override
//	public User loginUser(String email, String password) {
//		User userData = userDao.loginUser(email, password);
//
//		if (userData == null) {
//			throw new UserNotFoundException("");
//		}
//		return userData;
//	}
	
	
	
	
	@Override
	public Visitor getVisitorByName(String name) {
	
		return visitorDao.findByName(name);
	}

//	@Override
//	public String updateVisitor(int id, Visitor visitor) {
//		Visitor employee = visitorDao.findById(id);
//		
//		return null;
//	}
//
//	
	@Override
	public void save(Visitor visitor) {
		visitor.setAddress(visitor.getAddress());
		visitor.setContactPersonEmail(visitor.getContactPersonEmail());
		visitor.setContactPersonMobileNo(visitor.getContactPersonMobileNo());
		visitor.setEmail(visitor.getEmail());
		visitor.setId(visitor.getId());
		visitor.setIdProof(visitor.getIdProof());
		visitor.setMobileNo(visitor.getMobileNo());
		visitor.setName(visitor.getName());
		visitor.setReasonForVisit(visitor.getReasonForVisit());
		visitor.setContactPersonName(visitor.getContactPersonName());
		visitorRepository.save(visitor);
		
	}
	/*
	 *  @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }
	 */

	@Override
	public String updateVisitor(int id, Visitor visitor) {
		// TODO Auto-generated method stub
		return null;
	}

/*
 * mployeeDto employee = employeeReo.findById(id);
try {
EmpSkillDto empSkillToBeUpdated = empSkillRepo.findBySkillNameAndEmployee(skillName, employee);
if (empSkillToBeUpdated != null) {
// update existing skill
empSkillToBeUpdated.setExperiance(skill.getExperiance());
empSkillRepo.save(empSkillToBeUpdated);

}

else {
SkillDto skillDto = skillsRepo.findBySkillName(skillName);
EmpSkillDto newEmpSkillDto = new EmpSkillDto();
newEmpSkillDto.setSkillid(skillDto.getSkillid());
newEmpSkillDto.setSkillName(skillDto.getSkillName());
newEmpSkillDto.setExperiance(skill.getExperiance());
newEmpSkillDto.setEmployee(employee);

empSkillRepo.save(newEmpSkillDto);

}

return "success";
}

catch (Exception e) {
e.printStackTrace();
return "failure";
}

}
 */
//Visitor visitorData1=visitorDao.findByName(name);
//		
//		if(visitorData1==null)
//		{
//			throw new VisitorNotFoundException(" ", " ");
//		}
//
//		return visitorData1;
//	}


	
}
