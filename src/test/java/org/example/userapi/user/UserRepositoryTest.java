package org.example.userapi.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void 유저를_저장하고_조회한다() {
        // Given
        User user = new User("김철수", "kim@example.com");

        // When
        User saved = userRepository.save(user);

        // Then
        assertNotNull(saved.getId());
        Optional<User> found = userRepository.findById(saved.getId());

        assertTrue(found.isPresent());
        assertEquals("김철수", found.get().getName());
    }

    @Test
    void 이메일로_조회할_수_있다() {
        // Given
        userRepository.save(new User("이영희", "lee@example.com"));
        userRepository.save(new User("박민수", "park@example.com"));

        // When
        Optional<User> found = userRepository.findByEmail("lee@example.com");

        // Then
        assertTrue(found.isPresent());
        assertEquals("이영희", found.get().getName());
    }
}