package org.radekbor.spockplay

import spock.lang.Specification

class MathServiceTest extends Specification {
	def "Multiply"() {
		given:
			int a = 3
			int b = 4
			MathService converter = new MathService()

		when:
			int x = converter.multiply(a, b)

		then:
			x == 12
	}

	def "Divide and sqrt"() {
		given:
			SqrtService sqrtService = Mock(SqrtService)
			1 * sqrtService.sqrt(4) >> 2.0

			int a = 8
			int b = 2
			MathService converter = new MathService(sqrtService)

		when:
			double x = converter.divideAndSqrt(a, b)

		then:
			x == 2
	}

	def "Divide and sqrt any"() {
		given:
			SqrtService sqrtService = Mock(SqrtService)
			1 * sqrtService.sqrt(_) >> 1

			int a = 2
			int b = 2
			MathService converter = new MathService(sqrtService)

		when:
			double x = converter.divideAndSqrt(a, b)

		then:
			x == 1
	}

	def "Divide and sqrt when a/b = 2"() {
		given:
			SqrtService sqrtService = Mock(SqrtService)
			1 * sqrtService.sqrt({it == 2}) >> 1.4D

			int a = 4
			int b = 2
			MathService converter = new MathService(sqrtService)

		when:
			double x = converter.divideAndSqrt(a, b)

		then:
			x == 1.4D
	}
}
