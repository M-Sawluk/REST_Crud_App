package com.michal.springboot.repository;

import com.michal.springboot.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mike on 2017-03-09.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long>{

}
