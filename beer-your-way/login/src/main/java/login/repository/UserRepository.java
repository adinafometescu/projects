package login.repository;

import login.user.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface UserRepository extends CrudRepository<User, String> {

    User findByEmail(String email);

    User save(User user);

    @Transactional
    void deleteByEmail(String email);
}
