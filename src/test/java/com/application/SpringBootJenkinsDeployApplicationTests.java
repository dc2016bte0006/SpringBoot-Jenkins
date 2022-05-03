package com.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringBootJenkinsDeployApplicationTests {

	@Autowired
	private MockMvc mock;

	@Test
	public void addRide() throws Exception {

		mock.perform(MockMvcRequestBuilders.post("/ride/add")
		.contentType(MediaType.APPLICATION_JSON)
		.content("{\"id\": 4, \"description\": \"dddd\",\"name\": \"qaaa\"}")
		.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getAllRides() throws Exception{

		mock.perform(MockMvcRequestBuilders.get("/ride")
		.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getRide() throws Exception{

		mock.perform(MockMvcRequestBuilders.get("/ride/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void NotFoundRide() throws Exception{

		mock.perform(MockMvcRequestBuilders.get("/ride/5")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound())
				.andReturn();
	}


}
