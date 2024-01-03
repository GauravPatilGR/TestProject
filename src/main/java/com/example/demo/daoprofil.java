package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class daoprofil implements serviceprofile
{
	
	@Autowired
	Repoprofile rd;

	@Override
	public void dataentry(profile p1) {
		
		rd.save(p1);
		
	}

	@Override
	public List<profile> showinfo() {
		
	return	rd.findAll();
		
	}

	@Override
	public void delete(int id) {
		
		 rd.deleteById(id);
	}

	@Override
	public profile editdata(int id) {
	
		return rd.getById(id);
	}
	
	
	
	
	
	
	

}
