package com.fernando.investimento_simplificado.service;

import com.fernando.investimento_simplificado.dtos.CreateUserDto;
import com.fernando.investimento_simplificado.dtos.UpdateUserDto;
import com.fernando.investimento_simplificado.entity.User;
import com.fernando.investimento_simplificado.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {


    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    public UUID createUser(CreateUserDto createUserDto) {

        //DTO para Entity
        var entity = new User(); // Remove arguments
        entity.setUsername(createUserDto.username());
        entity.setEmail(createUserDto.email());
        entity.setPassword(createUserDto.password());
        entity.setCreationTimeStamp(Instant.now());

       var userSaved = repository.save(entity);

      return userSaved.getId();
    };


    public Optional<User> getUserById(String UserId) {
        return  repository.findById(UUID.fromString(UserId));


    }


    public List<User> listUsers() {
        return repository.findAll();
    }

    public void deleteUser(String UserId) {
        repository.deleteById(UUID.fromString(UserId));
    }

    public void updateUserById(String UserId, UpdateUserDto updateUserDto){
        var id = UUID.fromString(UserId);

        var userExistes = repository.findById(id);

        if(userExistes.isPresent()){
            var user = userExistes.get();
            if(updateUserDto.Username() != null){
                user.setUsername(updateUserDto.Username());

            }
            if(updateUserDto.Password() != null){
                user.setPassword(updateUserDto.Password());
            }

            repository.save(user);
        }



    }
}
