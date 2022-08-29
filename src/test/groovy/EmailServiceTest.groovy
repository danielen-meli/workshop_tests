import EmailApi
import org.mockito.Mockito
import spock.lang.Specification

class EmailServiceTest extends Specification {

    // metodos para testar: save, update
    // save - nao pode ser null, tem que ter Id e email pra salvar
    def "Should save email - status ok"(){
        given:
        when:
        then:
    }


    // update
    def "Should update email - status ok"(){
        given:
        when:
        then:
    }


    def "should return ordered list"() {
        given:
            List<Email> mockedList = [
                    new Email(1L, 'dbc@mail.com'),
                    new Email(2L, 'abc@mail.com'),
                    new Email(3L, 'cbc@mail.com'),
                    new Email(4L, 'bbc@mail.com')
            ]

            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            Mockito.when(mockEmailApi.fetchList()).thenReturn(mockedList)

            EmailService emailService = new EmailService(mockEmailApi)
        when:
            def result = emailService.orderedList()
        then:
            result == [
                    new Email(2L, 'abc@mail.com'),
                    new Email(4L, 'bbc@mail.com'),
                    new Email(3L, 'cbc@mail.com'),
                    new Email(1L, 'dbc@mail.com')
            ]
    }
}
