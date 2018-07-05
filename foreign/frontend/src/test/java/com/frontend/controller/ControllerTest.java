package com.frontend.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.foreign.frontend.wdzj.controller.WdzjController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
public class ControllerTest {

	@Autowired
	private WdzjController wdzjController;

	@Test
	public void testFind() {
		String borrowList = wdzjController.getBorrowList("2018-04-19", 0, 10);
		System.out.println("=================" + borrowList);
	}
}
