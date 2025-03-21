package com.itcat.information.dao;

import com.itcat.information.model.СredentialsEntity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
public interface CredentialsRepository extends CrudRepository<СredentialsEntity, Long>
{

}
