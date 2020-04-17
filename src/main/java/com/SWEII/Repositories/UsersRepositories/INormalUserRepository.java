package com.SWEII.Repositories.UsersRepositories;

import com.SWEII.Models.UsersModels.NormalUser;
import com.SWEII.Models.UsersModels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INormalUserRepository  extends CrudRepository<User, Long>, JpaRepository<User,Long> {

    //@Query(value = "SELECT  users.id as ID, concat( first_name, ' ', last_name) as FullName, username as Username, email as Email, type as Type, normal_user.address as Address, normal_user.phone_number as PhoneNumber FROM online_store.users inner join online_store.normal_user on normal_user.id = users.id", nativeQuery = true)
    @Query(value = "SELECT  users.id as ID, users.first_name,  users.last_name, username, email, password, type, normal_user.address, normal_user.phone_number FROM online_store.users inner join online_store.normal_user on normal_user.id = users.id", nativeQuery = true)
    public List<NormalUser> findAllNormalUsers();
}
