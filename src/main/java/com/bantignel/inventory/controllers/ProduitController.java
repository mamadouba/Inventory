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

import com.bantignel.inventory.modeles.Produit;
import com.bantignel.inventory.services.IProduitService;





@Controller
public class ProduitController {
	@Autowired
	private IProduitService service;
	
	@RequestMapping(value="/produit/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addProduit");
		model.addObject("produit", new Produit());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/produit/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("produit") final Produit produit, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addProduit");
			model.addObject("msg","Produit invalide");
			model.addObject("produit",produit);
			loadDefault(model);
			return model;
	   }
		service.create(produit);
		ModelAndView model = new ModelAndView("produit");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Produit ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/produit/{id}/update", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id")final int id){
		Produit produit = service.findById(id);
		ModelAndView model = new ModelAndView("updateProduit");
		loadDefault(model);
		model.addObject("produit",produit);
		return model;
	}
	
	@RequestMapping(value="/produit/update", method=RequestMethod.POST)
	public ModelAndView update(@Valid @ModelAttribute("produit") final Produit produit, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("updateProduit");
			model.addObject("msg","Produit invalide");
			model.addObject("produit",produit);
			loadDefault(model);
			return model;
	   }
		service.update(produit);
		ModelAndView model = new ModelAndView("produit");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Produit modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/produit/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Produit> listProduit = service.listAll();
		ModelAndView model = new ModelAndView("listProduit");
		model.addObject("listProduit", listProduit);
		return model;
	}
	
	@RequestMapping(value="/produit/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/produit/list");
	}
	
	@RequestMapping(value="/produit/{id}", method=RequestMethod.GET)
	public ModelAndView findById(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("produit");
		Produit produit = service.findById(id);
		if(produit == null){
			model.addObject("produit",produit);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Produit introuvable");
			return  model;
		}
		model.addObject("produit",produit);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Produit trouvé avec succès");
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
