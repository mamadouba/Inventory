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

import com.bantignel.inventory.modeles.Client;
import com.bantignel.inventory.services.IClientService;





@Controller
public class ClientController {
	@Autowired
	private IClientService service;
	
	@RequestMapping(value="/client/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addClient");
		model.addObject("client", new Client());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/client/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("client") final Client client, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addClient");
			model.addObject("msg","Client invalide");
			model.addObject("client",client);
			loadDefault(model);
			return model;
	   }
		service.create(client);
		ModelAndView model = new ModelAndView("client");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Client ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/client/{id}/update", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id")final int id){
		Client client = service.findById(id);
		ModelAndView model = new ModelAndView("updateClient");
		loadDefault(model);
		model.addObject("client",client);
		return model;
	}
	
	@RequestMapping(value="/client/update", method=RequestMethod.POST)
	public ModelAndView update(@Valid @ModelAttribute("client") final Client client, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("updateClient");
			model.addObject("msg","Client invalide");
			model.addObject("client",client);
			loadDefault(model);
			return model;
	   }
		service.update(client);
		ModelAndView model = new ModelAndView("client");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Client modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/client/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Client> listClient = service.listAll();
		ModelAndView model = new ModelAndView("listClient");
		model.addObject("listClient", listClient);
		return model;
	}
	
	@RequestMapping(value="/client/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/client/list");
	}
	
	@RequestMapping(value="/client/{id}", method=RequestMethod.GET)
	public ModelAndView findById(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("client");
		Client client = service.findById(id);
		if(client == null){
			model.addObject("client",client);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Client introuvable");
			return  model;
		}
		model.addObject("client",client);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Client trouvé avec succès");
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
