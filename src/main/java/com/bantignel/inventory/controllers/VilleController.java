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

import com.bantignel.inventory.modeles.Ville;
import com.bantignel.inventory.services.IVilleService;





@Controller
public class VilleController {
	@Autowired
	private IVilleService service;
	
	@RequestMapping(value="/ville/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addVille");
		model.addObject("ville", new Ville());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/ville/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("ville") final Ville ville, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addVille");
			model.addObject("msg","Ville invalide");
			model.addObject("ville",ville);
			loadDefault(model);
			return model;
	   }
		service.create(ville);
		ModelAndView model = new ModelAndView("ville");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Ville ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/ville/{id}/update", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id")final int id){
		Ville ville = service.findById(id);
		ModelAndView model = new ModelAndView("updateVille");
		loadDefault(model);
		model.addObject("ville",ville);
		return model;
	}
	
	@RequestMapping(value="/ville/update", method=RequestMethod.POST)
	public ModelAndView update(@Valid @ModelAttribute("ville") final Ville ville, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("updateVille");
			model.addObject("msg","Ville invalide");
			model.addObject("ville",ville);
			loadDefault(model);
			return model;
	   }
		service.update(ville);
		ModelAndView model = new ModelAndView("ville");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Ville modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/ville/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Ville> listVille = service.listAll();
		ModelAndView model = new ModelAndView("listVille");
		model.addObject("listVille", listVille);
		return model;
	}
	
	@RequestMapping(value="/ville/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/ville/list");
	}
	
	@RequestMapping(value="/ville/{id}", method=RequestMethod.GET)
	public ModelAndView findById(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("ville");
		Ville ville = service.findById(id);
		if(ville == null){
			model.addObject("ville",ville);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Ville introuvable");
			return  model;
		}
		model.addObject("ville",ville);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Ville trouvé avec succès");
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
