package com.casic.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sjzHistory.repository.StatisticsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringVueDemoApplicationTests {
	
	@Autowired
	StatisticsRepository statisticsRepository;

	
	@Test
	public void testStatistics() {
		
		long usersCount = statisticsRepository.countUsers();
		System.out.println("usersCount===="+usersCount);
		long articlesCount = statisticsRepository.countArticles();
		System.out.println("articlesCount===="+articlesCount);
		
	}
	
	

}
