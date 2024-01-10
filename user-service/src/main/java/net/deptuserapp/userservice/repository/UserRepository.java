package net.deptuserapp.userservice.repository;

import net.deptuserapp.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
