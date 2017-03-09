package com.michal.springboot.repository;

import com.michal.springboot.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mike on 2017-03-09.
 */
@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {

    List<Address> findByUserId(long id);
}
