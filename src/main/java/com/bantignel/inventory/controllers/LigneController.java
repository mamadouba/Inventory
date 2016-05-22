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

import com.bantignel.inventory.modeles.Ligne;
import com.bantignel.inventory.services.ILigneService;





@Controller
public class LigneController {
	@Autowired
	private ILigneService service;
	
	@RequestMapping(value="/ligne/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addLigne");
		model.addObject("ligne", new Ligne());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/ligne/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("ligne") final Ligne ligne, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addLigne");
			model.addObject("msg","Ligne invalide");
			model.addObject("ligne",ligne);
			loadDefault(model);
			return model;
	   }
		service.create(ligne);
		ModelAndView model = new ModelAndView("ligne");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Ligne ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/ligne/{id}/update", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id")final int id){
		Ligne ligne = service.findById(id);
		ModelAndView model = new ModelAndView("updateLigne");
		loadDefault(model);
		model.addObject("ligne",ligne);
		return model;
	}
	
	@RequestMapping(value="/ligne/update", method=RequestMethod.POST)
	public ModelAndView update(@Valid @ModelAttribute("ligne") final Ligne ligne, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("updateLigne");
			model.addObject("msg","Ligne invalide");
			model.addObject("ligne",ligne);
			loadDefault(model);
			return model;
	   }
		service.update(ligne);
		ModelAndView model = new ModelAndView("ligne");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Ligne modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/ligne/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Ligne> listLigne = service.listAll();
		ModelAndView model = new ModelAndView("listLigne");
		model.addObject("listLigne", listLigne);
		return model;
	}
	
	@RequestMapping(value="/ligne/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/ligne/list");
	}
	
	@RequestMapping(value="/ligne/{id}", method=RequestMethod.GET)
	public ModelAndView findById(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("ligne");
		Ligne ligne = service.findById(id);
		if(ligne == null){
			model.addObject("ligne",ligne);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Ligne introuvable");
			return  model;
		}
		model.addObject("ligne",ligne);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Ligne trouvé avec succès");
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
