import org.mockito.Mockito
import spock.lang.Specification

class ListHelperTest extends Specification {
    def "should return minValue "() {
        given:
            ListApi mockedListApi = Mockito.mock(ListApi) // mocka a api
            ListHelper listHelper = new ListHelper(mockedListApi) // mock a lista

            List<Integer> list = [1, 5, 8, 0, 4, 6, 2, 7] // lista teste (é hard code? pode ficar assim?)

            Mockito.when(mockedListApi.fetchList()).thenReturn(list) // lê td pra poder retornar a lista

        when:
            Integer result = listHelper.minValue(); // encontra o min
        then:
            result == 0 // hard code, tem que ser 0.. mas só muda se mudar no teste, não no codigo... pode?)
    }

    def "should return maxValue "() {
        given:
            ListApi mockedListApi = Mockito.mock(ListApi) // mocka a api
            ListHelper listHelper = new ListHelper(mockedListApi) // mock a lista

            List<Integer> list = [1, 5, 8, 0, 4, 6, 2, 7] // lista teste (é hard code? pode ficar assim?)

            Mockito.when(mockedListApi.fetchList()).thenReturn(list) // lê td pra poder retornar a lista

        when:
            Integer result = listHelper.maxValue();
        then:
            result == 8
    }

    def "should return size of list "() {
        given:
        ListApi mockedListApi = Mockito.mock(ListApi) // mocka a api
        ListHelper listHelper = new ListHelper(mockedListApi) // mock a lista

        List<Integer> list = [1, 5, 8, 0, 4, 6, 2] // lista teste (é hard code? pode ficar assim?)

        Mockito.when(mockedListApi.fetchList()).thenReturn(list) // lê td pra poder retornar a lista

        when:
        Integer result = listHelper.size();
        then:
        result == 7
    }

    def "should return average "() {
        given:
        ListApi mockedListApi = Mockito.mock(ListApi) // mocka a api
        ListHelper listHelper = new ListHelper(mockedListApi) // mock a lista

        List<Integer> list = [1, 5, 6, 0] // lista teste (é hard code? pode ficar assim?)

        Mockito.when(mockedListApi.fetchList()).thenReturn(list) // lê td pra poder retornar a lista

        when:
          Double result = listHelper.average();
        then:
            result == 3 //
    }

}
