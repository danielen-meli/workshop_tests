
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class EmailService {

    private final EmailApi emailApi;


    public EmailService(EmailApi emailApi) {
        this.emailApi = emailApi;
    }

    public Email save(String mail) {
        if(mail == null || mail.isEmpty()){
            throw new RuntimeException("Email should not be empty");
        }

        Email email = new Email();
        email.setId(new Random().nextLong());
        email.setEmail(mail);
        emailApi.save(email);

        return email;
    }

    public Email update(Long id, String newEmail) {
        if(newEmail == null || newEmail.isEmpty()){
            throw new RuntimeException("Email should not be empty");
        }

        if(id == null || id <= 0){
            throw new RuntimeException("ID should not be empty");
        }

        Email email = emailApi.get(id);
        email.setEmail(newEmail);
        emailApi.update(email);

        return email;
    }

    private List<Email> list() {
        return emailApi.fetchList();
    }

    public List<Email> orderedList() {
        List<Email> emails = list();

        if(emails == null) {
            return Collections.emptyList();
        }

        return emails.stream()
                .sorted(Comparator.comparing(Email::getEmail))
                .collect(Collectors.toList());
    }


}

class Email {
    private Long id;
    private String email;

    public Email() {
    }

    public Email(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        Email otherEmail = (Email) o;
        return otherEmail != null
                && id.equals(otherEmail.id)
                && email.equals(otherEmail.email);
    }
}

class EmailApi {

    public Email get(Long id) {
        throw new RuntimeException("DON'T IMPLEMENT NOR REMOVE IT");
    }

    public void save(Email email) {
        throw new RuntimeException("DON'T IMPLEMENT NOR REMOVE IT");
    }

    public void update(Email email) {
        throw new RuntimeException("DON'T IMPLEMENT NOR REMOVE IT");
    }

    public List<Email> fetchList() {
        throw new RuntimeException("DON'T IMPLEMENT NOR REMOVE IT");
    }
}