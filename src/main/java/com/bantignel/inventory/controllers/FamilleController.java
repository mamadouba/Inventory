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

import com.bantignel.inventory.modeles.Famille;
import com.bantignel.inventory.services.IFamilleService;





@Controller
public class FamilleController {
	@Autowired
	private IFamilleService service;
	
	@RequestMapping(value="/famille/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addFamille");
		model.addObject("famille", new Famille());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/famille/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("famille") final Famille famille, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addFamille");
			model.addObject("msg","Famille invalide");
			model.addObject("famille",famille);
			loadDefault(model);
			return model;
	   }
		service.create(famille);
		ModelAndView model = new ModelAndView("famille");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Famille ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/famille/{id}/update", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id")final int id){
		Famille famille = service.findById(id);
		ModelAndView model = new ModelAndView("updateFamille");
		loadDefault(model);
		model.addObject("famille",famille);
		return model;
	}
	
	@RequestMapping(value="/famille/update", method=RequestMethod.POST)
	public ModelAndView update(@Valid @ModelAttribute("famille") final Famille famille, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("updateFamille");
			model.addObject("msg","Famille invalide");
			model.addObject("famille",famille);
			loadDefault(model);
			return model;
	   }
		service.update(famille);
		ModelAndView model = new ModelAndView("famille");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Famille modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/famille/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Famille> listFamille = service.listAll();
		ModelAndView model = new ModelAndView("listFamille");
		model.addObject("listFamille", listFamille);
		return model;
	}
	
	@RequestMapping(value="/famille/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/famille/list");
	}
	
	@RequestMapping(value="/famille/{id}", method=RequestMethod.GET)
	public ModelAndView findById(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("famille");
		Famille famille = service.findById(id);
		if(famille == null){
			model.addObject("famille",famille);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Famille introuvable");
			return  model;
		}
		model.addObject("famille",famille);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Famille trouvé avec succès");
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
