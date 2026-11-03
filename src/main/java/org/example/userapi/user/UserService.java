package org.example.userapi.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EmailClient emailClient;

    public UserService(UserRepository userRepository, EmailClient emailClient) {
        this.userRepository = userRepository;
        this.emailClient = emailClient;
    }

    public User register(User user) {
        User saved = userRepository.save(user);
        emailClient.sendWelcomeEmail(user.getEmail());
        return saved;
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
