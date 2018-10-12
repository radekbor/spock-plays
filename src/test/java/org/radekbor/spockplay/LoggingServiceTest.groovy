package org.radekbor.spockplay

import spock.lang.Specification

class LoggingServiceTest extends Specification {

	def "should call all actions"(){

		given:
			LogAction logAction = Mock(LogAction)
			LoggingService loggingService = new LoggingService(logAction)

		when:
			loggingService.foo()

		then:
			1 * logAction.call()
	}
}
