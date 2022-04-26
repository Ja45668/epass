package com.wipro.Epassport.Repository;

import com.wipro.Epassport.Entity.Epassport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpassportRepository extends CrudRepository<Epassport,Integer> {
    Epassport findByEmail(String email);
}
