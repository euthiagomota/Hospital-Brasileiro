package br.com.hospitalBrasileiro.Users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    UserModel findOneAndUpdate(UUID id, UserModel userModel);
}
