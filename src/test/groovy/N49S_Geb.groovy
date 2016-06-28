import geb.spock.GebSpec
import spock.lang.Narrative
import spock.lang.Title

@Title('Geb example')
class N49S_Geb extends GebSpec {

    def 'search for wikipedia in google'() {
        when: 'go to google.com'
        go 'http://www.google.com'

        then: 'page title is Google'
        title == 'Google'

        when: 'enter wikipedia and click on search'
        $('input', name: 'q').value('wikipedia')
        $('input', name: 'btnG').click()

        then: 'title is wikipedia'
        waitFor { title.startsWith 'wikipedia - ' }

        expect: 'that search result contains link to ru.wikipedia.org'
        $('*', 0).text().contains('ru.wikipedia.org')
    }
}
