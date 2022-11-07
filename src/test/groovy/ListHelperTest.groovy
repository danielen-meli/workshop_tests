import org.mockito.Mockito
import spock.lang.Specification
import spock.lang.Unroll

class ListHelperTest extends Specification {

    ListApi mockListApi
    ListHelper mockListHelper
//    List<Integer> list = [1, 5, 8, 0, 4, 6, 2, 7] nao precisa mais pq inclui o Where

    def setup(){
     mockListApi = Mockito.mock(ListApi) // mocka a api
     mockListHelper = new ListHelper(mockListApi) // mock a lista
    }

    @Unroll
    def "should return minValue "() {
        given:
            Mockito.when(mockListApi.fetchList()).thenReturn(list2) // lê td pra poder retornar a lista
        when:
            Integer result = mockListHelper.minValue(); // encontra o min
        then:
            result == result2 // hard code, tem que ser 0.. mas só muda se mudar no teste, não no codigo... pode?)
        where:
            list2           | result2
            [1,2,1,2,1,2]   | 2
            [1,2,1,2,1,2]   | 1
    }

    def "should return maxValue "() {
        given:
            Mockito.when(mockListApi.fetchList()).thenReturn(list) // lê td pra poder retornar a lista
        when:
            Integer result = mockListHelper.maxValue();
        then:
            result == 8
    }

    def "should return size of list "() {
        given:
        Mockito.when(mockListApi.fetchList()).thenReturn(list) // lê td pra poder retornar a lista
        when:
        Integer result = mockListHelper.size();
        then:
        result == 8
    }

    def "should return average "() {
        given:
            Mockito.when(mockListApi.fetchList()).thenReturn(list) // lê td pra poder retornar a lista
        when:
            Double result = mockListHelper.average();
        then:
            result == 4.125
    }

    def "should return validSequence"(){
        given:
        Mockito.when(mockListApi.fetchList()).thenReturn(list)
        // validar qtas vezes passa no metodo fetchList pq tem 2 metodos q usam o fetchList

        when:
        boolean result = mockListHelper.validSequence();

        then:
            result == false }

/*    def "should return validSequence_ where"(){

        when:
            result = mockListHelper.validSequence(input)

        where:
         input          | result
        [1,2,3,4, 5,6] | true

    }*/

}

