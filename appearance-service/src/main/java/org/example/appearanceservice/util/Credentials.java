package org.example.appearanceservice.util;

import com.amazonaws.auth.AWSCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Credentials implements AWSCredentials {

    @Value("${aws_access_key_id}")
    private String access_key;
    @Value("${aws_secret_access_key}")
    private String secret_key;

    @Override
    public String getAWSAccessKeyId() {
        return access_key;
    }

    @Override
    public String getAWSSecretKey() {
        return secret_key;
    }
}
