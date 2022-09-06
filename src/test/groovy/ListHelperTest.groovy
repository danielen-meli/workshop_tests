import org.mockito.Mockito
import spock.lang.Specification

class ListHelperTest extends Specification {
    ListApi mockListApi
    ListHelper mockListHelper
    List<Integer> list = [1, 5, 8, 0, 4, 6, 2, 7]

    def setup(){
     mockListApi = Mockito.mock(ListApi) // mocka a api
     mockListHelper = new ListHelper(mockListApi) // mock a lista
    }


    def "should return minValue "() {
        given:
            Mockito.when(mockListApi.fetchList()).thenReturn(list) // lê td pra poder retornar a lista
        when:
            Integer result = mockListHelper.minValue(); // encontra o min
        then:
            result == 0 // hard code, tem que ser 0.. mas só muda se mudar no teste, não no codigo... pode?)
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

}
