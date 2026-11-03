package org.example.userapi.user;

import org.springframework.stereotype.Component;

@Component
public class EmailClient {
    public void sendWelcomeEmail(String email) {
        System.out.println("이메일 발송: " + email);
    }
}
