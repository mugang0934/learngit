package com.itheima.base.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.itheima.category.domain.Category;
import com.itheima.category.service.CategoryService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext*.xml")
public class BaseServiceTest {
	
	@Resource
	private CategoryService bsi;
	
	//CategoryserviceImple测试baseservice连接性
	@Test
	public void CategoryServiceImplTest(){
		Category cg = new Category();
		cg.setType("床上用品");
		cg.setHot(true);
		bsi.save(cg);
	}
}
