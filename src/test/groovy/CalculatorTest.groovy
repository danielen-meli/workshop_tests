import spock.lang.Specification
import spock.lang.Unroll
// testes devem: ser simples (funcoes basicas do sistema devem ser cobertas), cobrir as regras do negócio (visando situacoes limite)
// não fazer testes redundantes
// testes devem ser resilientes a mudança
// teste deve ser claro, auxiliar a leitura e até servir como documentacao da regra de negocio


class CalculatorTest extends Specification {
// toda classe de testes extendes de Specifications que é a base do teste
    def "should sum"() {
        given: 
        // dados os valores do input ou estado do sistema
        // given não é obrigatorio, porém fica fácil a leitura do teste
            int valueA = 1
            int valueB = 2
        when: 
        // quando ele executa o metodo 
            int result = Calculator.sum(valueA, valueB)
        then: 
        // resultado esperado - valida a regra do negocio.
            result == (valueA + valueB)
    }

    @Unroll //  qdo usa o where, pra facilitar a leitura do log
    def "should divide"() {
        when:
            float result = Calculator.divide(valueA, valueB)
        then:
            result == expectedResult
        where: // valida q o dividendo é diferente de 0 e depois = 0, logo testa ambos os casos do metodo
            valueA | valueB | expectedResult
            1.0f   | 1.0f   | 1f
            1.0f   | 0f     | 0f
    }

    @Unroll
    def "should absolut sum"() {
        when:
        Integer result = Calculator.absoluteSum(valueA, valueB)

        then:
        result == expectedResult

        where:
        valueA | valueB | expectedResult
        null   | 23     | null
        6      | null   | null
        3      | 2      | 5
        -2     | 5      | 7
        -1     | -1     | 2
        10     | -9     | 19
    } // tem que levar mais ao limite?
    // fiz testes demais?

}
