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

import com.bantignel.inventory.modeles.Agent;
import com.bantignel.inventory.services.IAgentService;



@Controller
public class AgentController {
	@Autowired
	private IAgentService service;
	
	@RequestMapping(value="/agent/new",method=RequestMethod.GET)
	public ModelAndView add(){
		ModelAndView model = new ModelAndView("addAgent");
		model.addObject("agent", new Agent());
		loadDefault(model);
		return model;
	}
	
	@RequestMapping(value="/agent/add", method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("agent") final Agent agent, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("addAgent");
			model.addObject("msg","Agent invalide");
			model.addObject("agent",agent);
			loadDefault(model);
			return model;
	   }
		service.create(agent);
		ModelAndView model = new ModelAndView("agent");
		model.addObject("css","success");
		model.addObject("action","add");
		model.addObject("msg","Agent ajouté avec succès");
		return  model;
	}
	
	@RequestMapping(value="/agent/{id}/update", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id")final int id){
		Agent agent = service.findById(id);
		ModelAndView model = new ModelAndView("updateAgent");
		loadDefault(model);
		model.addObject("agent",agent);
		return model;
	}
	
	@RequestMapping(value="/agent/update", method=RequestMethod.POST)
	public ModelAndView update(@Valid @ModelAttribute("agent") final Agent agent, BindingResult result){
		if(result.hasErrors()){
			ModelAndView model = new ModelAndView("updateAgent");
			model.addObject("msg","Agent invalide");
			model.addObject("agent",agent);
			loadDefault(model);
			return model;
	   }
		service.update(agent);
		ModelAndView model = new ModelAndView("agent");
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Agent modifié avec succès");
		return  model;
	}
	
	@RequestMapping(value="/agent/list", method=RequestMethod.GET)
	public ModelAndView list(){
		final List<Agent> listAgent = service.listAll();
		ModelAndView model = new ModelAndView("listAgent");
		model.addObject("listAgent", listAgent);
		return model;
	}
	
	@RequestMapping(value="/agent/{id}/delete", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id")final int id){
		service.delete(id);
		return new ModelAndView("redirect:/agent/list");
	}
	
	@RequestMapping(value="/agent/{id}", method=RequestMethod.GET)
	public ModelAndView findById(@PathVariable("id")final int id){
		ModelAndView model = new ModelAndView("agent");
		Agent agent = service.findById(id);
		if(agent == null){
			model.addObject("agent",agent);
			model.addObject("css","danger");
			model.addObject("action","update");
			model.addObject("msg","Agent introuvable");
			return  model;
		}
		model.addObject("agent",agent);
		model.addObject("css","success");
		model.addObject("action","update");
		model.addObject("msg","Agent trouvé avec succès");
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
