package com.SWEII.Repositories.UsersRepositories;

import com.SWEII.Models.UsersModels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends CrudRepository<User, Long>, JpaRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
