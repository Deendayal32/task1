package com.employee.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.employee.entity.Employe;
import com.employee.repo.EmployeRepo;
import com.employee.service.FileUploadUtil;



@Controller
public class EmployeController {
	
	@Autowired
	EmployeRepo empRepo;
	@RequestMapping("/")
	public String heloo() 
	{
		return "index";
	}
	@PostMapping("/register")
	public String register(Employe employe , Model model , @RequestParam("image") MultipartFile file) throws IOException 
	{
		String uploadDir = "C:\\Users\\Deenu\\git\\task1\\employeeManagement\\src\\main\\webapp\\img" ;
		String fileName = file.getOriginalFilename();
		employe.setImageName(fileName);
	    FileUploadUtil.saveFile(uploadDir, fileName, file);
		empRepo.save(employe);
		model.addAttribute("employe", employe);
		model.addAttribute("message","successful registration");
		return "index";
		
	}
	@RequestMapping("/show")
	public ModelAndView viewEmploye() 
	{
		List<Employe> list=(List<Employe>) empRepo.findAll();
		ModelAndView map = new ModelAndView("view");
		map.addObject("lists", list);
		return  map;
	}
	@RequestMapping("/update/{id}")
	public ModelAndView updateEmp(@PathVariable("id") int ids, Model model) 
	{
		
		 Employe e=empRepo.findByEid(ids);
		 ModelAndView map = new ModelAndView("update");
		 model.addAttribute("e", e);
		 model.addAttribute("message", "record Updated Succesfully");
		 return  map;
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteEmp(@PathVariable("id") int ids,Model model) 
	{
		
		empRepo.deleteById(ids);
		List<Employe> list=(List<Employe>) empRepo.findAll();
		ModelAndView map = new ModelAndView("view");
		map.addObject("lists", list);
		model.addAttribute("message", "Record Deleted Succesfully");
		return  map;
	}
	@PostMapping("/edit")
	public String edit(Employe employe , Model model) 
	{
		
	   try {
		empRepo.save(employe);
		List<Employe> list=(List<Employe>) empRepo.findAll();
		model.addAttribute("lists", list);
	   }catch(Exception e) 
	   {
		   e.getStackTrace();
	   }
		return "view";
		
	}
	
}
