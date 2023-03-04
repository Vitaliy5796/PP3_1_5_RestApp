package ru.sidorov.rest.RestApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sidorov.rest.RestApp.models.User;
import ru.sidorov.rest.RestApp.repositories.UserRepository;
import ru.sidorov.rest.RestApp.util.UserNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        return foundUser.orElseThrow(UserNotFoundException::new);
    }

    public boolean save(User user) {
        User userDB = userRepository.findByEmail(user.getEmail());

        if (userDB != null) {
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }


    public void update(Long id, User updateUser) {
        updateUser.setId(id);
        updateUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
        userRepository.save(updateUser);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
