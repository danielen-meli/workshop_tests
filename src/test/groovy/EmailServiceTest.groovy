import org.mockito.Mockito
import spock.lang.Specification
import spock.lang.Unroll

class EmailServiceTest extends Specification {

    EmailApi  mockEmailApi
    EmailService mockEmailService

    def setup(){
         mockEmailApi = Mockito.mock(EmailApi)
         mockEmailService =  new EmailService(mockEmailApi)
    }

    def "Should NOT return saved email if MAIL null or empty" (){
        when:
            mockEmailService.save(mail)
        then:
            def error = thrown(planedexception)
            error.message == message

        where:
            mail | planedexception  | message
            null | RuntimeException | "Email should not be empty"
            ""   | RuntimeException | "Email should not be empty"
            ' '  | RuntimeException | "Email should not be empty"
    }


    def "Should return saved email if is valid" () {
        given: "A valid email"
            Email mockedMail = new Email(1, 'test@mail.com')
        when:
            def savedMail = mockEmailService.save('test@mail.com')

        then:
            savedMail.getEmail() == mockedMail.getEmail()
            savedMail.getId() != null
    }

    // UPDATE EMAIL
    def "Should return a UPDATED email when have a valid ID and a newEmail"(){
    given:
    Long mockedID = 1L
    String newEmail = 'newTest@mail.com'
    Email mockedMail = new Email(1, 'test@mail.com')
    Mockito.when(mockEmailApi.get(mockedID)).thenReturn(mockedMail)

    when:
        def updatedMail = mockEmailService.update(mockedID, newEmail)
    then:
        updatedMail.getId() == 1L
        updatedMail.getEmail() == newEmail
        updatedMail.getEmail() != mockedMail
    }

    @Unroll
    def "Should NOT return a Updated email because ID or newEmail is invalid"(){
        when:
        mockEmailService.update(id, newEmail)
        then:
        def error = thrown(planedexception)
        error.message == message

        where:
        id    |  newEmail          | planedexception | message
        null  | 'newTest@mail.com' | RuntimeException | "ID should not be empty"
        0L    | 'newTest@mail.com' | RuntimeException | "ID should not be empty"
        -8L   | 'mail@mail.com'    | RuntimeException | "ID should not be empty"
        1L    | null               | RuntimeException | "Email should not be empty"
        10L   | ''                 | RuntimeException | "Email should not be empty"

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
