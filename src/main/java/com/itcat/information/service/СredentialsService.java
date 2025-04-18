package com.itcat.information.service;

import com.itcat.information.repository.ICredentialsRepository;
import com.itcat.information.repository.СredentialsEntity;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class СredentialsService
{
    @Autowired
    private ICredentialsRepository credentialsRepository;
    @Autowired
    private EntityManager entityManager;

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }
    public СredentialsEntity saveСredential(СredentialsEntity credential) {
        return credentialsRepository.save(credential);
    }

    public Iterable<СredentialsEntity> getAllСredentials() {
        return credentialsRepository.findAll();
    }

    public СredentialsEntity getСredentialById(Long id) {
        return credentialsRepository.findById(id).orElse(null);
    }

    public void deleteСredential(Long id) {
        credentialsRepository.deleteById(id);
    }

    public Iterable<СredentialsEntity> findByLogin(String login) {
        return credentialsRepository.findByLogin(login);
    }
}
