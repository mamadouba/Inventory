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

import com.bantignel.inventory.modeles.Rayon;
import com.bantignel.inventory.services.IRayonService;





@Controller
public class RayonController {
	@Autowired
	private IRayonService service;
	
	@RequestMapping(value="/rayon/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addRayon");
		model.addObject("rayon", new Rayon());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/rayon/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("rayon") final Rayon rayon, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addRayon");
			model.addObject("msg","Rayon invalide");
			model.addObject("rayon",rayon);
			loadDefault(model);
			return model;
	   }
		service.create(rayon);
		ModelAndView model = new ModelAndView("rayon");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Rayon ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/rayon/{id}/update", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id")final int id){
		Rayon rayon = service.findById(id);
		ModelAndView model = new ModelAndView("updateRayon");
		loadDefault(model);
		model.addObject("rayon",rayon);
		return model;
	}
	
	@RequestMapping(value="/rayon/update", method=RequestMethod.POST)
	public ModelAndView update(@Valid @ModelAttribute("rayon") final Rayon rayon, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("updateRayon");
			model.addObject("msg","Rayon invalide");
			model.addObject("rayon",rayon);
			loadDefault(model);
			return model;
	   }
		service.update(rayon);
		ModelAndView model = new ModelAndView("rayon");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Rayon modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/rayon/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Rayon> listRayon = service.listAll();
		ModelAndView model = new ModelAndView("listRayon");
		model.addObject("listRayon", listRayon);
		return model;
	}
	
	@RequestMapping(value="/rayon/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/rayon/list");
	}
	
	@RequestMapping(value="/rayon/{id}", method=RequestMethod.GET)
	public ModelAndView findById(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("rayon");
		Rayon rayon = service.findById(id);
		if(rayon == null){
			model.addObject("rayon",rayon);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Rayon introuvable");
			return  model;
		}
		model.addObject("rayon",rayon);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Rayon trouvé avec succès");
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
