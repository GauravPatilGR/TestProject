package com.example.demo;

import java.util.List;

public interface serviceprofile {
	
	void dataentry(profile p1);
	
	List<profile> showinfo();
	
   void delete(int id);
   
   profile editdata(int id);

}
