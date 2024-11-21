package com.multicasa.multicasabackend.Repositories;

import com.multicasa.multicasabackend.Dtos.UserDto;
import com.multicasa.multicasabackend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPass(String username, String password);
    List<User> findByUsername(String username);
    void deleteById(int id);
    @Query("UPDATE User u SET u.username = :#{#userDto.username}, u.pass = :#{#userDto.password} WHERE u.id = :#{#userDto.id}")
    int updateUser(UserDto userDto);
}
