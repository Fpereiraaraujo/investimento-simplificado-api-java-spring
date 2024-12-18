package com.fernando.investimento_simplificado.service;

import com.fernando.investimento_simplificado.dtos.CreateUserDto;
import com.fernando.investimento_simplificado.repository.UserRepository;
import jakarta.persistence.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fernando.investimento_simplificado.entity.User;
import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    //padrao triple A
    //    Arrange
    //Act
    //Assert

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @Nested
    class createUser {
        @Test
        @DisplayName("should create a user with successful")
        void shouldCreateAUser() {
            //arrange
            var user = new User(
                    UUID.randomUUID(),
                    "sername",
                    "email",
                    "password",
                    Instant.now(),
                    null
            );
            doReturn(user).when(repository).save(any());

            var input = new CreateUserDto("username", "email", "123");


            //Act
            var output  = service.createUser(input);

            //Assert
            assertNotNull(output);




        }
    }


}