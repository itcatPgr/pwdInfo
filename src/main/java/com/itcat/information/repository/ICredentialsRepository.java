package com.itcat.information.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICredentialsRepository extends CrudRepository<СredentialsEntity, Long>
{
    List<СredentialsEntity> findByLogin(String login);

}
