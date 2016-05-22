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

import com.bantignel.inventory.modeles.Facture;
import com.bantignel.inventory.services.IFactureService;





@Controller
public class FactureController {
	@Autowired
	private IFactureService service;
	
	@RequestMapping(value="/facture/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addFacture");
		model.addObject("facture", new Facture());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/facture/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("facture") final Facture facture, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addFacture");
			model.addObject("msg","Facture invalide");
			model.addObject("facture",facture);
			loadDefault(model);
			return model;
	   }
		service.create(facture);
		ModelAndView model = new ModelAndView("facture");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Facture ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/facture/{id}/update", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id")final int id){
		Facture facture = service.findById(id);
		ModelAndView model = new ModelAndView("updateFacture");
		loadDefault(model);
		model.addObject("facture",facture);
		return model;
	}
	
	@RequestMapping(value="/facture/update", method=RequestMethod.POST)
	public ModelAndView update(@Valid @ModelAttribute("facture") final Facture facture, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("updateFacture");
			model.addObject("msg","Facture invalide");
			model.addObject("facture",facture);
			loadDefault(model);
			return model;
	   }
		service.update(facture);
		ModelAndView model = new ModelAndView("facture");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Facture modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/facture/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Facture> listFacture = service.listAll();
		ModelAndView model = new ModelAndView("listFacture");
		model.addObject("listFacture", listFacture);
		return model;
	}
	
	@RequestMapping(value="/facture/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/facture/list");
	}
	
	@RequestMapping(value="/facture/{id}", method=RequestMethod.GET)
	public ModelAndView findById(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("facture");
		Facture facture = service.findById(id);
		if(facture == null){
			model.addObject("facture",facture);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Facture introuvable");
			return  model;
		}
		model.addObject("facture",facture);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Facture trouvé avec succès");
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
