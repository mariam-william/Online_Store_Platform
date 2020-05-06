package com.SWEII.Repositories.UsersRepositories;

import com.SWEII.Models.UsersModels.Administrator;
import com.SWEII.Models.UsersModels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAdministratorRepository  extends CrudRepository<User, Long>, JpaRepository<User,Long> {

    @Query(value = "SELECT users.id as ID, users.first_name,  users.last_name, username, email, password, type FROM online_store.users inner join online_store.administrator on administrator.id = users.id", nativeQuery = true)
    List<Administrator> findAllAdministrators();
}
