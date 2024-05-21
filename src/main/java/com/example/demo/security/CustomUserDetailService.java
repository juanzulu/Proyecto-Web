package com.example.demo.security;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.Usuario;
import com.example.demo.entity.Veterinario;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Role;
import java.util.Collection;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userDB = userRepository.findByUsername(username).orElseThrow(

                () -> new UsernameNotFoundException("User not found"));

        UserDetails userDetails = new User(userDB.getUsername(), userDB.getPassword(),
                mapToGrantedAuthorities(userDB.getRoles()));

        return userDetails;
    }

    private Collection<GrantedAuthority> mapToGrantedAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public UserEntity DuenoToUser(Usuario usuario) {
        UserEntity user = new UserEntity();
        user.setUsername(usuario.getNombre());
        user.setPassword(passwordEncoder.encode("123"));
        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(List.of(roles));
        return user;
    }

    public UserEntity VeterinarioToUser(Veterinario veterinario) {
        UserEntity user = new UserEntity();
        user.setUsername(veterinario.getCorreo());
        user.setPassword(passwordEncoder.encode(veterinario.getPassword()));
        Role roles = roleRepository.findByName("VETERINARIO").get();
        user.setRoles(List.of(roles));
        return user;
    }

    public UserEntity AdminToUser(Admin admin) {
        UserEntity user = new UserEntity();
        user.setUsername(admin.getUsername());
        user.setPassword(passwordEncoder.encode("123"));
        Role roles = roleRepository.findByName("ADMIN").get();
        user.setRoles(List.of(roles));
        return user;
    }

}
