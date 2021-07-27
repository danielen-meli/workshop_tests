import spock.lang.Specification
import spock.lang.Unroll

class CalculatorTest extends Specification {


    def "should sum"() {
        given:
            int valueA = 1
            int valueB = 2
        when:
            int result = Calculator.sum(valueA, valueB)
        then:
            result == (valueA + valueB)
    }

    @Unroll
    def "should divide"() {
        when:
            float result = Calculator.divide(valueA, valueB)
        then:
            result == expectedResult
        where:
            valueA | valueB | expectedResult
            1.0f   | 1.0f   | 1f
            1.0f   | 0f     | 0f
    }

    def "should absoluteSum"(){
        when:
            Integer result = Calculator.absoluteSum(valueA, valueB)
        then:
            result == expectedResult
        where:
            valueA  |   valueB  | expectedResult
            -2      |   2       | 4
            -2      |   -2      | 4
            -2      |   null    | null
            2       |   2       | 4
            2       |   -2      | 4
            2       |   null    | null
            null    |   -2      | null
            null    |   2       | null
            null    |   null    | null
    }
}
