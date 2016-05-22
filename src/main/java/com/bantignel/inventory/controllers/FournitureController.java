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

import com.bantignel.inventory.modeles.Fourniture;
import com.bantignel.inventory.services.IFournitureService;





@Controller
public class FournitureController {
	@Autowired
	private IFournitureService service;
	
	@RequestMapping(value="/fourniture/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addFourniture");
		model.addObject("fourniture", new Fourniture());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/fourniture/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("fourniture") final Fourniture fourniture, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addFourniture");
			model.addObject("msg","Fourniture invalide");
			model.addObject("fourniture",fourniture);
			loadDefault(model);
			return model;
	   }
		service.create(fourniture);
		ModelAndView model = new ModelAndView("fourniture");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Fourniture ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/fourniture/{id}/update", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id")final int id){
		Fourniture fourniture = service.findById(id);
		ModelAndView model = new ModelAndView("updateFourniture");
		loadDefault(model);
		model.addObject("fourniture",fourniture);
		return model;
	}
	
	@RequestMapping(value="/fourniture/update", method=RequestMethod.POST)
	public ModelAndView update(@Valid @ModelAttribute("fourniture") final Fourniture fourniture, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("updateFourniture");
			model.addObject("msg","Fourniture invalide");
			model.addObject("fourniture",fourniture);
			loadDefault(model);
			return model;
	   }
		service.update(fourniture);
		ModelAndView model = new ModelAndView("fourniture");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Fourniture modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/fourniture/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Fourniture> listFourniture = service.listAll();
		ModelAndView model = new ModelAndView("listFourniture");
		model.addObject("listFourniture", listFourniture);
		return model;
	}
	
	@RequestMapping(value="/fourniture/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/fourniture/list");
	}
	
	@RequestMapping(value="/fourniture/{id}", method=RequestMethod.GET)
	public ModelAndView findById(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("fourniture");
		Fourniture fourniture = service.findById(id);
		if(fourniture == null){
			model.addObject("fourniture",fourniture);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Fourniture introuvable");
			return  model;
		}
		model.addObject("fourniture",fourniture);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Fourniture trouvé avec succès");
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
