package com.michal.springboot.repository;

import com.michal.springboot.domain.File;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mike on 2017-07-24.
 */
@Repository
public interface FileRepo extends CrudRepository<File,Long>{
}
