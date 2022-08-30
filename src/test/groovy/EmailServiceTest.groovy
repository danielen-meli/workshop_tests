import EmailApi
import org.mockito.Mockito
import spock.lang.Specification

class EmailServiceTest extends Specification {
    // metodos para testar: save, update

    def "Should NOT return saved email if MAIL null or empty" (){
        given:
            EmailApi mockEmailApi = Mockito.mock(EmailApi)
            EmailService mockEmailService = new EmailService(mockEmailApi)
        when:
            mockEmailService.save(mail)

        then:
            def error = thrown(planedexception)
            error.message == message

        where:
            mail | planedexception  | message
            null | RuntimeException | "Email should not be empty"
            ""   | RuntimeException | "Email should not be empty"
    } // se testa mail como " " o teste não passa pq não lança a exceção - não tem validação do tamanho do email, logo ele deve tá aceitando um espaço como válido.

    def "Should return saved email if is valid" () {
        given: "A valid email"
            Email mockedMail = new Email(1, 'test@mail.com')

        EmailApi mockEmailApi = Mockito.mock(EmailApi)
        EmailService mockEmailService = new EmailService(mockEmailApi)
        //Mockito.when(mockEmailApi.save()).thenAnswer(mockedMail)
        // terminar o mock - mock do retorno do mock - tipo isso:
        // save é void, como faz o return dele no mock?

        when:
            def savedMail = mockEmailService.save('test@mail.com')

        then:
            savedMail.getEmail() == mockedMail.getEmail()
            savedMail.getId() != null
        // pode fazer o teste final assim??
        // consegui testar o ID como existente, mas não pelo mock

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
