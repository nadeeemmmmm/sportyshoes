package com.example.shoes;

import java.sql.PseudoColumnUsage;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	ShipRepo srepo;
	
	@Autowired
	OrderRepo rep;
	
	@Autowired
	ProductRepo prepo;

	@Autowired
	Repo repo;
	
	Logger log=Logger.getAnonymousLogger();
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) 
	{
		ModelAndView mv=new ModelAndView();
		String email=req.getParameter("email");
		String password=req.getParameter("pwd");
		User name=repo.findbyemail(email);
		User pwd=repo.findbypassword(password);
		if(name!=null && name.equals(name)) 
		{
			if(pwd!=null && pwd.equals(pwd)) 
			{
				HttpSession session=req.getSession();
				session.setAttribute("user", email);
				mv.setViewName("login.jsp");
			}
			else 
			{
				mv.setViewName("fail.jsp");
			}
		}
		else 
		{
				mv.setViewName("fail.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("logout.jsp");
		return mv;
	}
	
	RestTemplate rest=new RestTemplate();
	
	@RequestMapping("/new")
	public ModelAndView new_register(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		String email=req.getParameter("email");
		String firstname=req.getParameter("fname");
		String lastname=req.getParameter("lname");
		String password=req.getParameter("pwd");
		
		String url="http://localhost:8082/register-user/"+email+"/"+firstname+"/"+lastname+"/"+password;
		rest.getForObject(url, String.class);
		if(true) {
			mv.setViewName("good.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/old")
	public ModelAndView update_register(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		String email=req.getParameter("email");
		String password=req.getParameter("pwd");
		String password1=req.getParameter("pd");
		
		if(password.equalsIgnoreCase(password1)) {
			String url="http://localhost:8082/update-user/"+email+"/"+password;
			rest.getForObject(url, String.class);
			if(true) {
				mv.setViewName("success.jsp");
			}
			else {
				mv.setViewName("password.jsp");
			}
			
		}
		else {
			mv.setViewName("password.jsp");
		}
		return mv;
	}
	
	@RequestMapping("category")
	public ModelAndView category(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession();
		List<Products> list=prepo.findbycat(req.getParameter("type"));
		if(list!=null) {
			session.setAttribute("list", list);
			mv.setViewName("category.jsp");
		}
		return mv;
	}
	
	@RequestMapping("cart")
	public ModelAndView cart(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession();
		List<Products> existingItems = session.getAttribute("cart") !=null ?(List<Products>) session.getAttribute("cart"):null;
		List<Products> list=prepo.findbyid(Integer.parseInt(req.getParameter("id")));
		if(list!=null) {
			if(null!=existingItems)
				existingItems.addAll(list);
			if(existingItems!=null)
				session.setAttribute("cart", existingItems);
			else
				session.setAttribute("cart", list);
			mv.setViewName("cart.jsp");
			//adding the price.
			List<Products> list1=(List<Products>) session.getAttribute("cart");
			int sum=0;
			for(Products pd:list1)
				sum+=pd.getPrice();
			session.setAttribute("sum", sum);
			//storing in cart.
			List<Products> list3=(List<Products>) session.getAttribute("cart");
			for(Products pr:list3) {
			Orders or=new Orders();
			or.setProductid(pr.getId());
			or.setName(pr.getName());
			or.setPrice(pr.getPrice());;
			rep.save(or);
		}
	}
		return mv;
}	
		
	
	    @RequestMapping("delete")
		public ModelAndView delete(HttpServletRequest req,HttpServletResponse res) {
			ModelAndView mv=new ModelAndView();
			rep.deleteById(Integer.parseInt(req.getParameter("id")));
			if(true) {
				mv.setViewName("cart.jsp");
			}
			return mv;
	}
	    
	    @RequestMapping("order")    
	    public ModelAndView ship(HttpServletRequest req,HttpServletResponse res) {
	    	ModelAndView mv=new ModelAndView();
	    	Ship ship=new Ship();
	        ship.setAddress(req.getParameter("line1"));
	    	ship.setZipcode(Long.parseLong(req.getParameter("zip")));
	    	ship.setContact(Long.parseLong(req.getParameter("num")));
	    	Ship sh=srepo.save(ship);
    	    if(sh!=null) {
	    		mv.setViewName("orders.jsp");
	    	}
    	    else {
	    		mv.setViewName("ship.jsp");
	    	}
      	    List<Ship> list2=srepo.findAll();
	    	if(list2!=null) {
	    		mv.addObject("list2", list2);
	    		mv.setViewName("orders.jsp");
    	}
	    	List<Orders> order=rep.findAll();
	    	if(order!=null) {
	    		mv.addObject("list1", order);
	    		mv.setViewName("orders.jsp");
	    	}
	    	return mv;
	  }
}
	    
	    
	    