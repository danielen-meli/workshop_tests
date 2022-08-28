import spock.lang.Specification
import spock.lang.Unroll
// testes devem: ser simples (funcoes basicas do sistema devem ser cobertas), cobrir as regras do negócio (visando situacoes limite)
// não fazer testes redundantes
// testes devem ser resilientes a mudança
// teste deve ser claro, auxiliar a leitura e até servir como documentacao da regra de negocio


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
            1.0f    | 1.0f    | 1f
            1.0f    | 0f      | 0f
    }
}
