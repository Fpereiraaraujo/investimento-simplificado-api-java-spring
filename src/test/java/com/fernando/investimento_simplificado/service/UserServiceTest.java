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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    //padrao triple A
    //Arrange
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
            var input = new CreateUserDto("username", "email", "123")
            service.createUser(input);

        }
    }


}