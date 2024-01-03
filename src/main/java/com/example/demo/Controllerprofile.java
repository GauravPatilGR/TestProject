package com.example.demo;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Controllerprofile {
	
	@Autowired
	serviceprofile sp;
	
	@RequestMapping("/")
	public String name() {
		
		
		
		return "home";
	}
	
	@PostMapping("/ram")
	public String one(@ModelAttribute("c1") profile c1,@RequestParam("file") MultipartFile filename) throws IOException {
		
		String f=filename.getOriginalFilename();
		
		String path="C:\\Users\\gaura\\eclipse-workspace\\FileUpload_SpringBOOT\\src\\main\\resources\\static\\images";
		
		BufferedOutputStream b= new BufferedOutputStream(new FileOutputStream(path+"/"+f));
		
		
		byte bt [] =filename.getBytes();
		
	    b.write(bt);
	    b.close();
	    
	    c1.setProfilename(f);
		
		
		
		sp.dataentry(c1);
		
		return "redirect:/dash";
	}
	
	
	
	@RequestMapping("/dash")
	public String show(ModelMap mm) {
		
		
	List<profile> p=sp.showinfo();
	
	mm.addAttribute("kk",p);
		
		return "dash";
	}
	
	@GetMapping("/del/{id}")
	public String two(@PathVariable int id) {
		
		
		sp.delete(id);
		
		return "redirect:/dash";
		
	}
	
	
	@GetMapping("/edit{id}")
	public String three(@PathVariable int id,ModelMap mm) {
		
	profile p=	sp.editdata(id);
	
	mm.addAttribute("k",p);
		
		
		return "edit";
	}
	
	
	
	@PostMapping("/sham")
	public String four(@ModelAttribute("c1") profile c1,@RequestParam("file") MultipartFile filename) throws IOException {
		
        String f=filename.getOriginalFilename();
		
		String path="C:\\Users\\gaura\\eclipse-workspace\\FileUpload_SpringBOOT\\src\\main\\resources\\static\\images";
		
		BufferedOutputStream b= new BufferedOutputStream(new FileOutputStream(path+"/"+f));
		
		
		byte bt [] =filename.getBytes();
		
	    b.write(bt);
	    b.close();
	    
	    c1.setProfilename(f);
	    
	    
	    profile p= new profile();
	    p.setId(c1.getId());
	    p.setName(c1.getName());
	    p.setEmail(c1.getEmail());
	    p.setProfilename(c1.getProfilename());
	    
	    sp.dataentry(p);
		
		
		return "redirect:/dash";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
