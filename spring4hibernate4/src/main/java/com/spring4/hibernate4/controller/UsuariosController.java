package com.spring4.hibernate4.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring4.hibernate4.hibernate.UsuariosHibernate;
import com.spring4.hibernate4.model.Usuario;

@Controller
public class UsuariosController {
	 
	
	 @RequestMapping("/altas")
	public ModelAndView darAltas(){
		Usuario usuario = new Usuario();
		ModelAndView mv = new ModelAndView("altas");
		mv.addObject("usuario", usuario);
		return mv;
	}
	 
	 @RequestMapping(value="/altas", method = RequestMethod.POST)
	 public String onSubmit(@ModelAttribute("usuario") Usuario usuario, BindingResult result){
		 UsuariosHibernate trans = new UsuariosHibernate();
		 trans.guardar(usuario);
		 System.out.println("submit sucess!");
		 return "altas";
	 }
	 
	 @RequestMapping("/listado")
		public ModelAndView hacerListado(){
		 UsuariosHibernate trans = new UsuariosHibernate();	
		 List ls = trans.listado();
			
			
			ModelAndView mv = new ModelAndView("listado");
			mv.addObject("usuarios", ls);
			return mv;
		}
}
