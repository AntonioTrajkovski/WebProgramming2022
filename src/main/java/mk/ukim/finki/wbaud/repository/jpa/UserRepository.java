package mk.ukim.finki.wbaud.repository.jpa;

import mk.ukim.finki.wbaud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsernameAndPassword(String userName, String password);
    Optional<User> findByUsername(String userName);

}
