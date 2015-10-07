import spock.lang.*

class N06_DataTables extends Specification {

    def "String.length() works O_O"() {
        when:
            def actual = (text1 + ' ' + text2).length()

        then:
            actual == expectedLength

        where:
            text1       | text2          || expectedLength
            'spock'     | 'rocks'        || 11
            'can junit' | 'do it?'       || 16
            'what if'   | 'test fails?'  || 28
    }

    def "String.isEmpty() works as well"() {
        when:
            def actual = text.isEmpty()

        then:
            actual == expected

        where:
            text << [ '', getClass().getName() ]
            expected << [ true, false ]
    }
}