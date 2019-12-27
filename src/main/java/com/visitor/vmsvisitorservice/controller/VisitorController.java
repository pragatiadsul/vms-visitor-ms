package com.visitor.vmsvisitorservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import com.visitor.vmsvisitorservice.dao.IVisitorDao;
import com.visitor.vmsvisitorservice.dto.VisitorDto;
import com.visitor.vmsvisitorservice.exception.VisitorNotFoundException;
import com.visitor.vmsvisitorservice.model.Visitor;
import com.visitor.vmsvisitorservice.service.IVisitorService;

@RestController
@RequestMapping("/visitor")
public class VisitorController {

	private static final Logger logger = LogManager.getLogger(VisitorController.class);
	@Autowired
	private IVisitorService visitorService;
	// private Object visitor;

	/**
	 * Method used for Visitor registration
	 * 
	 * @param Visitor Object
	 * @return status string
	 */
	@PostMapping("/addVisitor")
	public ResponseEntity<String> addVisitor(@RequestBody VisitorDto visitorDto) {
		return new ResponseEntity<String>(visitorService.addVisitor(visitorDto), HttpStatus.OK);
	}

	/**
	 * Method used to get registered Visitors list
	 * 
	 * @param No any parameter provided
	 * @return List of registered Visitors
	 */

	@GetMapping("/visitorslist")
	public List<Visitor> visitorsList() {
		return visitorService.visitorsList();
	}

	/**
	 * Method used to fetch specific Visitor by Id
	 * 
	 * @param Id
	 * @return Visitor object
	 */

	@GetMapping("/visitorslist/{id}")
	public Visitor getByVisitorId(@PathVariable long id) {

		logger.info("get visitors list by id ==" + id);
		// return visitorService.getByVisitorId(id);
		try {
			Visitor userData = visitorService.getByVisitorId(id);
			return userData;
		} catch (Exception e) {
			throw new VisitorNotFoundException("");
		}

	}

	/**
	 * Method used to fetch specific Visitor by Name
	 * 
	 * @param Name
	 * @return Visitor object
	 */

	@PostMapping("/visitorByName")
	public Visitor getVisitorByName(@RequestBody Visitor visitor) {
		String name = visitor.getName();

		return visitorService.getVisitorByName(name);
	}

	/**
	 * Method used to update the visitor
	 * 
	 * @param visitor object
	 * @return Visitor object
	 */

	@GetMapping("/updateVisitorById/{id}")
	public void updateVisitorById(@RequestBody Visitor visitor, @PathVariable long id) {
		visitorService.updateVisitorById(visitor, id);
	}

	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		return new ModelAndView("welcome");
	}

	/**
	 * Method used to display enroll form
	 * 
	 * @param Visitor ModelMap
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/enroll", method = RequestMethod.GET)
	public ModelAndView newRegistration(ModelMap model) {
		Visitor visitor = new Visitor();
		model.addAttribute("visitor", visitor);
		return new ModelAndView("enroll");
	}

	/**
	 * Method used to save Visitor
	 * 
	 * @param Visitorobject
	 * @return ModelAndView
	 */
	@PostMapping(value = "/save")
	public ModelAndView saveRegistration(@Valid VisitorDto visitorDto, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		visitorService.addVisitor(visitorDto);
		return new ModelAndView("viewstudents");
	}

	/**
	 * Method used to get registered Visitors list
	 * 
	 * @param No any parameter provided
	 * @return List of registered Visitors
	 */
	@GetMapping("/viewstudents")
	public ModelAndView viewstudents() {
		List<Visitor> list = visitorService.visitorsList();
		return new ModelAndView("viewstudents", "list", list);
	}

}