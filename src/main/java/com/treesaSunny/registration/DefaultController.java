 package com.treesaSunny.registration;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * All the Url mapping requests are handled by the controller annotated class
 */
@Controller
public class DefaultController {
	
	@Autowired
	SpringRootConfigRespository userRepository;	
	
	//Redirects to home page
    @RequestMapping("/")
    public String home1(Model model) {
    	model.addAttribute("UserDetails", new UserDetails());
        return "/home2";
    }
    
    @RequestMapping("/Welcome")
    public String Welcome(Model model) {
    	
        return "/Welcome";
    }

    //Shows the user Registration form
    @RequestMapping("/home")
    public String home(Model model) {
       model.addAttribute("UserDetails", new UserDetails());
       return "home2";
    }
    
    //The user registration post request handled by this method
    @PostMapping("/home")
    public String RegisterUser(@Valid UserDetails UserDetails, BindingResult bindingResult, Model model) {
    	 if (!bindingResult.hasErrors()) {
             model.addAttribute("noErrors", true);
         }
    	 else
    	 {
    		 return "error";
    	 }
    	 
    	  model.addAttribute("UserDetails", UserDetails);
    	  
    	  UserDetails newUser=new UserDetails();
    	  String currentEmail=UserDetails.getEmailID();
    	  newUser=userRepository.RetrieveAllUsersWithEmailID(currentEmail);
    	 // userRepository.RetrieveAllUsers();
    	  if(newUser.getEmailID().equals(UserDetails.getEmailID())) {
    		  return "alert";
    	  }
    	  
    	  else
    	  {
	         String info = String.format("User details: firstname = %s, lastName = %s, Email Address= %s",
	        		 UserDetails.getFirstname(), UserDetails.getLastName(), UserDetails.getEmailID());
	         System.out.println(info);
	         
	        
	         
	 
			  userRepository.saveUserDetails(UserDetails);
	         return "userRegistered";
    	  }
    }
   /*
    * Retrieves all users stored in the database
    */
    @RequestMapping(value = "allUsers", method = RequestMethod.GET)
    public String taskList(Map<String, Object> model) {
    	
    	//userRepository.RetrieveAllUsers();
    	 
         model.put("allUsers", userRepository.RetrieveAllUsers());
          return "allUsers";
      }
   
}
