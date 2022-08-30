import spock.lang.Specification
import spock.lang.Unroll

class RemoveDuplicatedTest extends Specification {

    def "should remove Duplicated"() {
        given: "A list with numbers"
            List<Integer> listWithRepeted = [1, 1, 2, 4, 4, 9, 9, 9, 11]
        and: "That list without the repeted numbers"
            List<Integer> listWithoutRepeted = [1, 2, 4, 9, 11]
        when:
            List<Integer> result = RemoveDuplicated.removeDuplicate(listWithRepeted)
        then:
            result == listWithoutRepeted

    }

    @Unroll
    def "should return a empty list and not a error"() {
        given: "A empty list or a null input"
            List<Integer> list = []
        when:
            List<Integer> result = RemoveDuplicated.removeDuplicate(list)
            List<Integer> result2 = RemoveDuplicated.removeDuplicate(null)
        then:
            result == []
        where:
        input      || expetecResult
        []         || []
        null       || []
    }

}
