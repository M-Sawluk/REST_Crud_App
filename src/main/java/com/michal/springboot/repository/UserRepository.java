package com.michal.springboot.repository;

import com.michal.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mike on 2017-03-09.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
