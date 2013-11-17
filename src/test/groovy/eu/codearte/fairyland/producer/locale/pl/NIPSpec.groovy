/*
 * Copyright (c) 2013 Codearte and authors
 */

package eu.codearte.fairyland.producer.locale.pl

import eu.codearte.fairyland.producer.BaseProducer
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author mariuszs
 * @since 02.11.13.
 */
class NIPSpec extends Specification {

	def baseProducer = Mock(BaseProducer)
	def generator = new NIP(baseProducer)

	@Unroll
	def "Should validate #nip as #valid"() {

		expect:
		generator.isValid(nip) == valid

		where:
		nip          | valid
		"2684494529" | true
		"1234567890" | false
		"0000000000" | true
	}

	def "Should generate good NIP"() {

		when:
		def nip = generator.generate()
		then:
		nip == "1010000002"
		generator.isValid(nip)

	}

}
