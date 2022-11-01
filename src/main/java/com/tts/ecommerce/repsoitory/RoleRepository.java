package com.tts.ecommerce.repsoitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.ecommerce.model.Role;

@Repository
public interface RoleRepository extends CrudRepository <Role, Integer>{

}
