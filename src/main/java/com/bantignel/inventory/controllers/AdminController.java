package com.bantignel.inventory.controllers;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bantignel.inventory.modeles.Admin;
import com.bantignel.inventory.services.IAdminService;


@Controller
public class AdminController {
	@Autowired
	private IAdminService service;
	
	@RequestMapping(value="/admin/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addAdmin");
		model.addObject("admin", new Admin());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/admin/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("admin") final Admin admin, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addAdmin");
			model.addObject("msg","Admin invalide");
			model.addObject("admin",admin);
			loadDefault(model);
			return model;
	   }
		service.create(admin);
		ModelAndView model = new ModelAndView("admin");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Admin ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/admin/{id}/update", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id")final int id){
		Admin admin = service.findById(id);
		ModelAndView model = new ModelAndView("updateAdmin");
		loadDefault(model);
		model.addObject("admin",admin);
		return model;
	}
	
	@RequestMapping(value="/admin/update", method=RequestMethod.POST)
	public ModelAndView update(@Valid @ModelAttribute("admin") final Admin admin, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("updateAdmin");
			model.addObject("msg","Admin invalide");
			model.addObject("admin",admin);
			loadDefault(model);
			return model;
	   }
		service.update(admin);
		ModelAndView model = new ModelAndView("admin");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Admin modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/admin/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Admin> listAdmin = service.listAll();
		ModelAndView model = new ModelAndView("listAdmin");
		model.addObject("listAdmin", listAdmin);
		return model;
	}
	
	@RequestMapping(value="/admin/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/admin/list");
	}
	
	@RequestMapping(value="/admin/{id}", method=RequestMethod.GET)
	public ModelAndView findById(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("admin");
		Admin admin = service.findById(id);
		if(admin == null){
			model.addObject("admin",admin);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Admin introuvable");
			return  model;
		}
		model.addObject("admin",admin);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Admin trouvé avec succès");
		return  model;
	}
	
	public void loadDefault(ModelAndView model){
		List<String> categories = new ArrayList<String>();
		categories.add("Gold");
		categories.add("Premium");
		categories.add("Silver");
		model.addObject("categories",categories);
	}
}
