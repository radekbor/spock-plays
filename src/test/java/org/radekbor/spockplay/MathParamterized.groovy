package org.radekbor.spockplay

import spock.lang.Specification


class MathParamterized extends Specification {
	def "shuld multiply two numbers"(
			int a, int b, int c)
	{

		given:
			MathService mathService = new MathService()

		expect:
			mathService.multiply(a, b) == c

		where:
			a | b | c
			1 | 3 | 3
			2 | 4 | 8
			0 | 0 | 0
			0 | 1 | 0
	}

}