import spock.lang.*
import spock.util.environment.RestoreSystemProperties

@Title('Spock system properties')
@Narrative('''
As JEEConf speaker
I want to show that Spock is careful with system properties
''')
// tag::sysPropStepwise[]
@Stepwise
class N48S_SystemProperties extends Specification {

    @RestoreSystemProperties
    def 'set spock version'() {
        expect: 'that spock.version is not set'
        System.getProperty('spock.version') == null

        when: 'spock version is set'
        System.setProperty('spock.version', '1.1')

        then: 'we can retrieve its value back'
        System.getProperty('spock.version') == '1.1'
    }

    def 'check spock version is not set'() {
        expect: 'that spock.version is not set'
        System.getProperty('spock.version') == null
    }
}
// end::sysPropStepwise[]
