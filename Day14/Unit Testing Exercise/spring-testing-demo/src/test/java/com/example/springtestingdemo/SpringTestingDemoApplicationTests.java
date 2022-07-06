package com.example.springtestingdemo;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(value = RestAPI.class)
class SpringTestingDemoApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private MyService service;
	
	@Test
	public void testGreetings() throws Exception {
		BDDMockito.given(service.welcome("Raj")).willReturn("Welcome Raj");
		mvc.perform(get("/api/Raj")).andExpect(content().string("WELCOME RAJ"));
	}

}
