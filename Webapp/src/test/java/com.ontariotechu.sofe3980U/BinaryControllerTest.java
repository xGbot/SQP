package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
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
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", ""))
			.andExpect(model().attribute("operand1Focused", false));
    }
	
	    @Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1","111"))
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", "111"))
			.andExpect(model().attribute("operand1Focused", true));
    }
	@Test
	    public void postParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator","+").param("operand2","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "1110"))
			.andExpect(model().attribute("operand1", "111"));
    }

    // test case 1 for add function
    @Test
	    public void postParameterAdd1() throws Exception {
        this.mvc.perform(post("/").param("operand1","1110").param("operator","+").param("operand2","1011"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "11001"))
			.andExpect(model().attribute("operand1", "1110"));
    }
    // test case 2 for add function
    @Test
	    public void postParameterAdd2() throws Exception {
        this.mvc.perform(post("/").param("operand1","110").param("operator","+").param("operand2","10"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "1000"))
			.andExpect(model().attribute("operand1", "110"));
    }
    // test case 3 for add function
    @Test
	    public void postParameterAdd3() throws Exception {
        this.mvc.perform(post("/").param("operand1","1101").param("operator","+").param("operand2","101"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "10010"))
			.andExpect(model().attribute("operand1", "1101"));
    }
    // test case 4 for add function
    @Test
	    public void postParameterAdd4() throws Exception {
        this.mvc.perform(post("/").param("operand1","1111").param("operator","+").param("operand2","1"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "10000"))
			.andExpect(model().attribute("operand1", "1111"));
    }

    // test case 1 for or function
    @Test
	    public void postParameterOr1() throws Exception {
        this.mvc.perform(post("/").param("operand1","11010").param("operator","|").param("operand2","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "11111"))
			.andExpect(model().attribute("operand1", "11010"));
    }
    // test case 2 for or function
    @Test
	    public void postParameterOr2() throws Exception {
        this.mvc.perform(post("/").param("operand1","1101").param("operator","|").param("operand2","101"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "1101"))
			.andExpect(model().attribute("operand1", "1101"));
    }
    // test case 3 for or function
    @Test
	    public void postParameterOr3() throws Exception {
        this.mvc.perform(post("/").param("operand1","1111").param("operator","|").param("operand2","1"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "1111"))
			.andExpect(model().attribute("operand1", "1111"));
    }

    // test case 1 for multiplication function
    @Test
	    public void postParameterMult1() throws Exception {
        this.mvc.perform(post("/").param("operand1","101").param("operator","*").param("operand2","11101"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "10010001"))
			.andExpect(model().attribute("operand1", "101"));
    }
    // test case 2 for multiplication function
     @Test
	    public void postParameterMult2() throws Exception {
        this.mvc.perform(post("/").param("operand1","1101").param("operator","*").param("operand2","101"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "1000001"))
			.andExpect(model().attribute("operand1", "1101"));
    }
    // test case 3 for multiplication function
     @Test
	    public void postParameterMult3() throws Exception {
        this.mvc.perform(post("/").param("operand1","1111").param("operator","*").param("operand2","1"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "1111"))
			.andExpect(model().attribute("operand1", "1111"));
    }

    // test case 1 for and function
    @Test
	    public void postParameterAnd1() throws Exception {
        this.mvc.perform(post("/").param("operand1","1101").param("operator","&").param("operand2","101"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "101"))
			.andExpect(model().attribute("operand1", "1101"));
    }
    // test case 2 for and function
    @Test
	    public void postParameterAnd2() throws Exception {
        this.mvc.perform(post("/").param("operand1","1111").param("operator","&").param("operand2","1"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "1"))
			.andExpect(model().attribute("operand1", "1111"));
    }
    // test case 3 for and function
    @Test
	    public void postParameterAnd3() throws Exception {
        this.mvc.perform(post("/").param("operand1","110").param("operator","&").param("operand2","10"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "10"))
			.andExpect(model().attribute("operand1", "110"));
    }

}
