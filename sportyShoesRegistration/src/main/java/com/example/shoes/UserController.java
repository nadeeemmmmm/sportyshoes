package com.example.shoes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Autowired
	Repo repo;
	
	@ResponseBody
	@RequestMapping("/register-user/{email}/{firstname}/{lastname}/{password}")
	public String insert(HttpServletRequest req, HttpServletResponse res,@PathVariable("email")String email,@PathVariable("firstname")String firstname,@PathVariable("lastname")String lastname,@PathVariable("password")String password) {
		User reg=new User();
		reg.setEmail(email);
		reg.setFirstname(firstname);
		reg.setLastname(lastname);
		reg.setPassword(password);
		repo.save(reg);
		return "User registered";
	}
	
	@ResponseBody
	@RequestMapping("/update-user/{email}/{password}")
	public String update(HttpServletRequest req,HttpServletResponse res,@PathVariable("email")String email,@PathVariable("password") String password,User reg) {
		User rg=repo.findById(reg.getEmail()).orElse(null);
		rg.setEmail(email);
		rg.setPassword(password);
		repo.save(rg);
		return "Password Updated";
	}
}
