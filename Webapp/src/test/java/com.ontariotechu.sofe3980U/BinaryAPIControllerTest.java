package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }
	@Test
    public void add_test() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }
    // test case 1 for json add function
    @Test
    public void add_test1() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","110").param("operand2","10"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(110))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(10))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1000))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }
    // test case 2 for json add function
    @Test
    public void add_test2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","1101").param("operand2","101"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }
    // test case 3 for json add function
    @Test
    public void add_test3() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","1111").param("operand2","1"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10000))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    @Test
    public void multiply() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("1000110"));
    }
    // test case 1 for json multiply function
	@Test
    public void multiply_test1() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1000110))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }
    // test case 2 for json multiply function
    @Test
    public void multiply_test2() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","1101").param("operand2","101"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1000001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }
    // test case 1 for json multiply function
    @Test
    public void multiply_test3() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","1111").param("operand2","1"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    @Test
    public void and() throws Exception {
        this.mvc.perform(get("/and").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10"));
    }
    // test case 1 for json and function
	@Test
    public void and_test1() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }
    // test case 2 for json and function
    @Test
    public void and_test2() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","1101").param("operand2","101"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }
    // test case 3 for json and function
    @Test
    public void and_test3() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","1111").param("operand2","1"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    @Test
    public void or() throws Exception {
        this.mvc.perform(get("/or").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("1111"));
    }
    // test case 1 for json or function
	@Test
    public void or_test1() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }
    // test case 2 for json or function
    @Test
    public void or_test2() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","1101").param("operand2","101"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }
    // test case 3 for json or function
    @Test
    public void or_test3() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","1111").param("operand2","1"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }
}
