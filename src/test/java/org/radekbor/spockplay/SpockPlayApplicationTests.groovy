package org.radekbor.spockplay

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class SpockPlayApplicationTests extends Specification {

	MathService mathService = new MathService()
	MathCtrl ctrl = new MathCtrl(mathService)
	MockMvc mockMvc = standaloneSetup(ctrl).build()

	def "should return multiplication result when call ctr"(int a, int b, int c) {
		expect:
			mockMvc.perform(get('/multiply/' + a + '/' + b))
					.andExpect(content().string(Integer.toString(c)))

		where:
			a | b | c
			1 | 3 | 3
			2 | 4 | 8

	}

}
