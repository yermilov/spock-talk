import spock.lang.*
import spock.util.environment.RestoreSystemProperties

class X15_SystemProperties extends Specification {

    @RestoreSystemProperties
    def 'be careful with system properties'() {
        setup:
            println "Before - ${System.getProperty('spock')}"

        when:
            System.setProperty('spock', 'rocks')

        then:
            println "After - ${System.getProperty('spock')}"
    }
}
