package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long userId);

    Optional<User> findByUserName(String userName);
}
