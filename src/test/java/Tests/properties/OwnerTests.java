package Tests.properties;

import config.Credentials;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

@Tag("properties")
public class OwnerTests {

    @Test
    void readCredentialsTest() {
        String login = Credentials.credentials.login ();
        String password = Credentials.credentials.password();

        System.out.println(login);
        System.out.println(password);

        String message = format("I try to login as %s with password %s", login, password);

        System.out.println(message);

    }

}

