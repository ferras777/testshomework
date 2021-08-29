package config;

import org.aeonbits.owner.ConfigFactory;

public class Credentials {
    public static CredentialsConfig credentials = (CredentialsConfig) ConfigFactory.create (CredentialsConfig.class);
}
