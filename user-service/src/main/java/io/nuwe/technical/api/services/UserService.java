package io.nuwe.technical.api.services;

import io.nuwe.technical.api.entities.*;
import io.nuwe.technical.api.repositories.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
	this.userRepository= userRepository;
    }

    public List<User> getAllUsers(){
		return userRepository.findAll();
    }

    public Optional<User> getUserById(long id){
		return userRepository.findById(id);
    }

	public Optional<User> getUserByEmail(String email){
		return userRepository.findByEmail(email);
	}

    public User createUser(User u){
	userRepository.save(u);
	return u;
    }

    public void saveUser(User t){
	userRepository.save(t);
    }

    public User deleteUser(User user){
	userRepository.delete(user);
	return user;
    }

    public void deleteAll(){
	userRepository.deleteAll();
    }
}
