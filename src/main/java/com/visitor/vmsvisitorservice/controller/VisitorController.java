package com.visitor.vmsvisitorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.visitor.vmsvisitorservice.dao.IVisitorDao;
import com.visitor.vmsvisitorservice.dto.VisitorDto;
import com.visitor.vmsvisitorservice.exception.VisitorNotFoundException;
import com.visitor.vmsvisitorservice.model.Visitor;
import com.visitor.vmsvisitorservice.service.IVisitorService;

@RestController
//@RequestMapping("/visitor")
public class VisitorController {

	@Autowired
	private IVisitorService visitorService;
	
	
	
//	@GetMapping("/registration")
//	public String showRegForm(Visitor c) {
//		
//		System.out.println("in show reg form "+c);
//			return "/visitor/registration"; 
//	}
//	
//	

	
	
	@GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("visitor", new Visitor());

        return "registration";
    }
	
	
	//@PostMapping("/registration")
	 @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration (@ModelAttribute("visitor") Visitor visitor, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
            return "registration";
        }

		visitorService.save(visitor);
		return "redirect:/welcome";
	}
	
	/* @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }*/
	
	
	
	
	
	
	
	
	
	

	/**
	 * Method used for Visitor registration
	 * 
	 * @param Visitor Object
	 * @return status string
	 */
	/* @PostMapping("/addVisitor")
	public ResponseEntity<String> addVisitor(@RequestBody VisitorDto visitorDto) {
		return new ResponseEntity<String>(visitorService.addVisitor(visitorDto), HttpStatus.OK);
	}
	*/

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
		//return visitorService.getByVisitorId(id);
		try {
			Visitor userData = visitorService.getByVisitorId(id);
			return userData;
		} catch (Exception e) {
			throw new VisitorNotFoundException("");
		}
		
		

	}
	
//	@GetMapping("/loginuser")
//	public User loginUser(@RequestBody User user) {
//		String email = user.getEmail();
//		String password = user.getPassword();
//		try {
//			User userData = userService.loginUser(email, password);
//			return userData;
//		} catch (Exception e) {
//			throw new UserNotFoundException("");
//		}
//	}
//	


	/**
	 * Method used to fetch specific Visitor by Name
	 * 
	 * @param Name
	 * @return Visitor object
	 */

	@PostMapping("/visitorByName")
	public Visitor getVisitorByName(@RequestBody Visitor visitor) {
		String name = visitor.getName();
		
//		try {
//			Visitor userData1 = visitorService.getVisitorByName(name);
//			return userData1;
//		} catch (Exception e) {
//			throw new VisitorNotFoundException(" ", " ");
//		}
		
		
		return visitorService.getVisitorByName(name);
	}
	
	
	@PutMapping("/update/empskill/{id}")
	public ResponseEntity<String> updateVisitor(@PathVariable(value = "id") int id,
	@RequestBody Visitor visitor) {

	String response = visitorService.updateVisitor(id,visitor);
	if (response.equalsIgnoreCase("success")) {
	return ResponseEntity.ok().body("skill updated successfully");
	} else {
	return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Failure while updating skill");
	}

}
}

