package cz.expertkom.ju.L08HomeWorkKosikCz;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.expertkom.ju.L08HomeWorkKosikCz.interfaces.DownLoadPageService;

@Service
public class ApplicationInit {
	
	@Autowired
	DownLoadPageService dwnlps;
	
	@PostConstruct
	public void initMethod(){
		//dwnlps.start();
	}

}