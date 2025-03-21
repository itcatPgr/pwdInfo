package com.itcat.information.service;

import com.itcat.information.dao.CredentialsDao;
import com.itcat.information.dao.CredentialsRepository;
import com.itcat.information.model.СredentialsEntity;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class СredentialsService
{
    @Autowired
    private CredentialsRepository credentialsRepository;
    @Autowired
    private EntityManager entityManager;

    public Session getSession() {
        // Получаем Hibernate Session из EntityManager
        return entityManager.unwrap(Session.class);
        // Теперь можно использовать session для выполнения операций на низком уровне
    }
    public СredentialsEntity saveСredential(СredentialsEntity credential) {
        return credentialsRepository.save(credential);
    }

    public Iterable<СredentialsEntity> getAllСredentials() {
        return credentialsRepository.findAll();
    }

    // Чтение сущности по id
    public СredentialsEntity getСredentialById(Long id) {
        return credentialsRepository.findById(id).orElse(null);
    }

    // Удаление сущности
    public void deleteСredential(Long id) {
        credentialsRepository.deleteById(id);
    }

//    public СredentialsService() {
//        this.credentialsDao = new CredentialsDao();
//    }
//
//    public void addСredentialsEntity(СredentialsEntity credentialsEntity) {
//        credentialsDao.save(credentialsEntity);
//    }

}
