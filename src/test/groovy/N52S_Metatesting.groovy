import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Title
import spock.util.mop.ConfineMetaClassChanges

@Title('Spock MetaProgramming testing')
@Narrative('''
As JEEConf speaker
I want to show that Spock works great for MetaProgramming testing
''')
@Stepwise
class N52S_Metatesting extends Specification {

    // tag::meta[]
    @ConfineMetaClassChanges([Integer])
    def 'sometimes 2 + 2 = 5'() {
        setup: 'very special Integer + Integer operation'
        Integer.metaClass.plus = { Integer other ->
            return 5
        }

        expect: '2 + 2 == 5'
        2 + 2 == 5
    }

    def 'usually 2 + 2 == 4'() {
        expect: '2 + 2 == 4'
        2 + 2 == 4
    }
    // end::meta[]
}
