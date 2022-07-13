package com.example.shoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@Autowired
	Repo reppo;
	
	@Autowired
	ProductRepo repo;
	
	@Autowired
	CategoryRepo rep;

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		if(name.equalsIgnoreCase("admin") && pwd.equalsIgnoreCase("enter")) {
			HttpSession session=req.getSession();
			session.setAttribute("admin", name);
			mv.setViewName("login.jsp");
		}
		else {
			mv.setViewName("index.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession();
		session.removeAttribute("admin");
		session.invalidate();
		mv.setViewName("logout.jsp");
		return mv;
	}
	
	@RequestMapping("/product")
	public ModelAndView product(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		Products pd=new Products();
		pd.setId(Integer.parseInt(req.getParameter("id")));
		pd.setName(req.getParameter("name"));
		pd.setCategory(req.getParameter("cat"));
		pd.setPrice(Float.parseFloat(req.getParameter("price")));
		Products pr=repo.save(pd);
		if(pr!=null) {
			mv.setViewName("product.jsp");
		}
		else {
			mv.setViewName("add.jsp");
		}
		List<Products> list=repo.findAll();
		if(list!=null) {
			mv.setViewName("product.jsp");
			mv.addObject("list", list);
		}
		else {
			mv.setViewName("add.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/fetch")
	public ModelAndView fetch(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		List<Products> list=repo.findAll();
		if(list!=null) {
			mv.setViewName("fetch.jsp");
			mv.addObject("list", list);
		}
		return mv;
	}
	
	@RequestMapping("/cat")
	public ModelAndView category(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		Category ct=new Category();
		ct.setId(Integer.parseInt(req.getParameter("id")));
		ct.setName(req.getParameter("name"));
		Category cg=rep.save(ct);
		if(cg!=null) {
			List<Category> list=rep.findAll();
			if(list!=null) {
				mv.setViewName("in.jsp");
				mv.addObject("list", list);
			}
			else {
				mv.setViewName("out.jsp");
			}		
		}
		else {
			mv.setViewName("out.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/get")
	public ModelAndView get(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		List<Category> list=rep.findAll();
		if(list!=null) {
			mv.setViewName("in.jsp");
			mv.addObject("list", list);
		}
		else {
			mv.setViewName("out.jsp");
		}		
		return mv;
	}
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		Category ct=new Category();
		ct.setId(Integer.parseInt(req.getParameter("id")));
		rep.deleteById(ct.getId());
		if(true) {
			List<Category> list=rep.findAll();
			mv.setViewName("in.jsp");
			mv.addObject("list", list);
		}
		else {
			mv.setViewName("delete.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/edit")
	public ModelAndView update(HttpServletRequest req, HttpServletResponse res,Category ct) {
		ModelAndView mv=new ModelAndView();
		Category cy=rep.findById(ct.getId()).orElse(null);
		cy.setId(ct.getId());
		cy.setName(ct.getName());
		Category c=rep.save(cy);
		if(c!=null) {
			List<Category> list=rep.findAll();
			mv.setViewName("in.jsp");
			mv.addObject("list", list);
		}
		else {
			mv.setViewName("edit.jsp");
		}
		return mv;
	}
	
	RestTemplate rest=new RestTemplate();
	
	@RequestMapping("/check")
	public ModelAndView see(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession();
		List<User> list=reppo.findAll();
		if(list!=null) {
			session.setAttribute("list", list);
			mv.setViewName("users.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		HttpSession session=req.getSession();
		Object list=reppo.findById(req.getParameter("email"));
		if(list!=null) {
			session.setAttribute("list",list);
			mv.setViewName("optional.jsp");
		}
		return mv;
	}
}