import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatedTest extends Specification {

    /* def "should remove Duplicated"() {
        given: "A list with numbers"
            List<Integer> listWithRepeted = [1, 1, 2, 4, 4, 9, 9, 9, 11]
        and: "That list without the repeted numbers"
            List<Integer> listWithoutRepeted = [1, 2, 4, 9, 11]
        when:
            List<Integer> result = RemoveDuplicated.removeDuplicate(listWithRepeted)
        then:
            result == listWithoutRepeted
    }
    TESTE 'A TOA' PORÉM É UM EXEMPLO DE COMO USA O END
    */

    @Unroll
    def "should remove Duplicated or do nothing when empty or null"() {
        when:
            List<Integer> result = RemoveDuplicated.removeDuplicate(input)

        then:
            expetecResult == result
        where:
        input      || expetecResult
        []         || []
        null       || []
        [1,1,2,3]  || [1,2,3]
        [1,2]      || [1,2]
    }

}
