package test;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import owa.com.platform.entity.Customer;
import owa.com.platform.service.CustomService;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestMybatis{

	private static final Logger logger = Logger.getLogger(TestMybatis.class);
    @Autowired
	private CustomService customService;

	
	@Test
	public void test3() {
		
		Customer u = customService.getCustom((short) 1);
		
		System.out.println(u.getEmail());
		
		logger.info(u.getEmail());
	}

	
}
