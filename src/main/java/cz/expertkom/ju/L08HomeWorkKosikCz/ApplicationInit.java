package cz.expertkom.ju.L08HomeWorkKosikCz;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.expertkom.ju.L08HomeWorkKosikCz.services.PullWebpageParseJsoup;
import cz.expertkom.ju.L08HomeWorkKosikCz.services.TestJsoup;

@Service
public class ApplicationInit {
	
	//@Autowired
	//DownLoadPageService dwnlps;
	@Autowired
	 PullWebpageParseJsoup pullWebpageParseJsoup;
	
	@Autowired
	TestJsoup testJsoup;
	
	@PostConstruct
	public void initMethod(){
		//System.out.println("\nStart inicializace...");
		//dwnlps.start();
		//System.out.println("\n...Konec inicializace");
	/*
		try {
			testJsoup.jsoupRHR();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
	*/
		try {
			pullWebpageParseJsoup.start();
			//testJsoup.jsoupRHRproduct();
			//testJsoup.jsoupUries();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
