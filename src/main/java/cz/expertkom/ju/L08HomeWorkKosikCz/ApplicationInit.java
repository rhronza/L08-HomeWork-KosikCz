package cz.expertkom.ju.L08HomeWorkKosikCz;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.expertkom.ju.L08HomeWorkKosikCz.interfaces.DownLoadPageService;
import cz.expertkom.ju.L08HomeWorkKosikCz.services.DownLoadPageServiceImpl;

@Service
public class ApplicationInit {
	
	@Autowired
	DownLoadPageService dwnlps;
	
	@PostConstruct
	public void initMethod(){
		System.out.println("\nStart inicializace...");
		dwnlps.start();
		System.out.println("\n...Konec inicializace");
	}

}
