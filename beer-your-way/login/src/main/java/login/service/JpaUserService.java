package login.service;

import login.exception.DuplicateAccountException;
import login.repository.UserRepository;
import login.user.User;
import login.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;

@Service
public class JpaUserService implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> getUser(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    @Override
    public void saveUser(User user) {
        Assert.notNull(user, "Undefined user");
        Assert.notNull(user.getEmail(), "Email cannot be null");
        Assert.notNull(user.getPassword(), "Password is missing");
        userRepository.save(user);
    }

    @Override
    public void registerUser(User user) throws DuplicateAccountException {
        Assert.notNull(user, "Undefined user");
        Assert.notNull(user.getEmail(), "Email cannot be null");
        Optional<User> registeredUser = getUser(user.getEmail());
        if (registeredUser.isPresent()) {
            throw new DuplicateAccountException();
        }
        saveUser(user);
    }

    @Override
    public void deleteUser(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = getUser(email);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(String.format("Email {} was not found!", email));
        }
        List<GrantedAuthority> authorities = createAuthorityList("ROLE_USER");
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), authorities);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void addTestUser() {
        User user = new User();
        user.setEmail("adina.fometescu@gmail.com");
        user.setPassword(passwordEncoder.encode("123456"));
        saveUser(user);
    }
}
