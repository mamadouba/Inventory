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

import com.bantignel.inventory.modeles.Fournisseur;
import com.bantignel.inventory.services.IFournisseurService;





@Controller
public class FournisseurController {
	@Autowired
	private IFournisseurService service;
	
	@RequestMapping(value="/fournisseur/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addFournisseur");
		model.addObject("fournisseur", new Fournisseur());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/fournisseur/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("fournisseur") final Fournisseur fournisseur, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addFournisseur");
			model.addObject("msg","Fournisseur invalide");
			model.addObject("fournisseur",fournisseur);
			loadDefault(model);
			return model;
	   }
		service.create(fournisseur);
		ModelAndView model = new ModelAndView("fournisseur");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Fournisseur ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/fournisseur/{id}/update", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id")final int id){
		Fournisseur fournisseur = service.findById(id);
		ModelAndView model = new ModelAndView("updateFournisseur");
		loadDefault(model);
		model.addObject("fournisseur",fournisseur);
		return model;
	}
	
	@RequestMapping(value="/fournisseur/update", method=RequestMethod.POST)
	public ModelAndView update(@Valid @ModelAttribute("fournisseur") final Fournisseur fournisseur, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("updateFournisseur");
			model.addObject("msg","Fournisseur invalide");
			model.addObject("fournisseur",fournisseur);
			loadDefault(model);
			return model;
	   }
		service.update(fournisseur);
		ModelAndView model = new ModelAndView("fournisseur");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Fournisseur modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/fournisseur/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Fournisseur> listFournisseur = service.listAll();
		ModelAndView model = new ModelAndView("listFournisseur");
		model.addObject("listFournisseur", listFournisseur);
		return model;
	}
	
	@RequestMapping(value="/fournisseur/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/fournisseur/list");
	}
	
	@RequestMapping(value="/fournisseur/{id}", method=RequestMethod.GET)
	public ModelAndView findById(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("fournisseur");
		Fournisseur fournisseur = service.findById(id);
		if(fournisseur == null){
			model.addObject("fournisseur",fournisseur);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Fournisseur introuvable");
			return  model;
		}
		model.addObject("fournisseur",fournisseur);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Fournisseur trouvé avec succès");
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
