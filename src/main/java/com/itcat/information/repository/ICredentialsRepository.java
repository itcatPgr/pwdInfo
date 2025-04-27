package com.itcat.information.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICredentialsRepository extends CrudRepository<CredentialsEntity, Long>
{
    @Query(value = "select c from CredentialsEntity c join c.organization o " +
            "where o.name like %:org%")
    List<CredentialsEntity> findByOrganization(@Param("org") String org);

    @Query(value = "select c from CredentialsEntity c where c.description like %:description%")
    List<CredentialsEntity> findByDescription(String description);

}
