package com.fernando.investimento_simplificado.repository;

import com.fernando.investimento_simplificado.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
