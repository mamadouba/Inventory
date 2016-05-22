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

import com.bantignel.inventory.modeles.Commande;
import com.bantignel.inventory.services.ICommandeService;





@Controller
public class CommandeController {
	@Autowired
	private ICommandeService service;
	
	@RequestMapping(value="/commande/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addCommande");
		model.addObject("commande", new Commande());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/commande/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("commande") final Commande commande, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addCommande");
			model.addObject("msg","Commande invalide");
			model.addObject("commande",commande);
			loadDefault(model);
			return model;
	   }
		service.create(commande);
		ModelAndView model = new ModelAndView("commande");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Commande ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/commande/{id}/update", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id")final int id){
		Commande commande = service.findById(id);
		ModelAndView model = new ModelAndView("updateCommande");
		loadDefault(model);
		model.addObject("commande",commande);
		return model;
	}
	
	@RequestMapping(value="/commande/update", method=RequestMethod.POST)
	public ModelAndView update(@Valid @ModelAttribute("commande") final Commande commande, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("updateCommande");
			model.addObject("msg","Commande invalide");
			model.addObject("commande",commande);
			loadDefault(model);
			return model;
	   }
		service.update(commande);
		ModelAndView model = new ModelAndView("commande");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Commande modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/commande/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Commande> listCommande = service.listAll();
		ModelAndView model = new ModelAndView("listCommande");
		model.addObject("listCommande", listCommande);
		return model;
	}
	
	@RequestMapping(value="/commande/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/commande/list");
	}
	
	@RequestMapping(value="/commande/{id}", method=RequestMethod.GET)
	public ModelAndView findById(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("commande");
		Commande commande = service.findById(id);
		if(commande == null){
			model.addObject("commande",commande);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Commande introuvable");
			return  model;
		}
		model.addObject("commande",commande);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Commande trouvé avec succès");
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
