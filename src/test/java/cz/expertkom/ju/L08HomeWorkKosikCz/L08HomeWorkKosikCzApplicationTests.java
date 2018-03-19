package cz.expertkom.ju.L08HomeWorkKosikCz;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cz.expertkom.ju.L08HomeWorkKosikCz.interfaces.DownLoadPageService;
import cz.expertkom.ju.L08HomeWorkKosikCz.interfaces.ProductRepository;
import cz.expertkom.ju.L08HomeWorkKosikCz.services.PullWebpageParseJsoup;
import cz.expertkom.ju.L08HomeWorkKosikCz.services.SharingListBetweenBeans;
import cz.expertkom.ju.L08HomeWorkKosikCz.services.TestJsoup;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
public class L08HomeWorkKosikCzApplicationTests {

	@Autowired
	PullWebpageParseJsoup pullWebpageParseJsoup;

	@Autowired
	TestJsoup testJsoup;

	@Autowired
	DownLoadPageService dwnlps;

	@Autowired
	SharingListBetweenBeans sharingListBetweenBeans;
	
	@Autowired
	ProductRepository pRep;
	
	@Before
	public void init() {
		log.info("\n\n+----------------------------------------+\n|               start testu\n+----------------------------------------+\n");
	}

	@After
	public void after() {
		log.info("\n\n+-------------- konec -------------------+");
	}
	

	@Test
	@Ignore
	public void contextLoads() {
	}

	@Test
	@Ignore
	public void testPullWebpageParseJsoup() {
		log.info("testPullWebpageParseJsoup");
		try {
			pullWebpageParseJsoup.start();
		} catch (IOException e) {
			log.error("Problém se spuštěním metody start");
		}
	}

	@Test
	@Ignore
	public void testTestJsoup() {
		log.info("testTestJsoup");
		try {
			testJsoup.jsoupRHRproduct();
		} catch (IOException e) {
			log.error("Problém se spuštěním metody jsoupRHRproduct");
		}
	}

	@Test
	@Ignore
	public void testDownLoadPageService() {
		log.info("testDownLoadPageService");
		dwnlps.start();

	}

	@Test
	@Ignore
	public void testSharingListBetweenBeans() {
		System.out.println("\n");
		sharingListBetweenBeans.showAllPeoples();
		System.out.println("\n");
	}

	@Test
	//@Ignore
	public void testDoSelect() {
		System.out.println("testDoSelect\n");
		System.out.println(pRep.doSelect());
		System.out.println("\n");
	}

}
