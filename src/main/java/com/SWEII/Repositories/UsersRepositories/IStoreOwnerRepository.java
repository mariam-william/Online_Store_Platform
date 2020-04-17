package com.SWEII.Repositories.UsersRepositories;

import com.SWEII.Models.UsersModels.StoreOwner;
import com.SWEII.Models.UsersModels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStoreOwnerRepository  extends CrudRepository<User, Long>, JpaRepository<User,Long> {

    //@Query(value = "SELECT users.id as ID, concat( first_name, ' ', last_name) as FullName, username as Username, email as Email, type as Type FROM online_store.users inner join online_store.store_owner on store_owner.id = users.id", nativeQuery = true)
    @Query(value = "SELECT users.id as ID, users.first_name,  users.last_name, username, email, password, type FROM online_store.users inner join online_store.store_owner on store_owner.id = users.id", nativeQuery = true)
    public List<StoreOwner> findAllStoreOwners();
}
