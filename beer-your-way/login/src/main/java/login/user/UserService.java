package login.user;

import java.util.Optional;

public interface UserService {
    /**
     * @param email is considered to be unique
     * @return the user registered with the {@param email} or {@link Optional#empty()} if the user is not found
     */
    Optional<User> getUser(String email);

    void saveUser(User user);
}
