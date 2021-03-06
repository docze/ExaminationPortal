package pl.woonkievitch.Authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.woonkievitch.Authentication.entity.Role;
import pl.woonkievitch.Authentication.entity.User;
import pl.woonkievitch.Authentication.repository.RoleRepository;
import pl.woonkievitch.Authentication.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActivate(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoleSet(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}
