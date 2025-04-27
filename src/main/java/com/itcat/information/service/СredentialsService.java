package com.itcat.information.service;

import com.itcat.information.repository.ICredentialsRepository;
import com.itcat.information.repository.CredentialsEntity;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class СredentialsService
{
    @Autowired
    private ICredentialsRepository credentialsRepository;
    @Autowired
    private EntityManager entityManager;

    public Iterable<CredentialsEntity> findAll()
    {
        return credentialsRepository.findAll();
    }

    public Iterable<CredentialsEntity> findByDescription(String description)
    {
        return credentialsRepository.findByDescription(description);
    }

    public Iterable<CredentialsEntity> findByOrganization(String org)
    {
        return credentialsRepository.findByOrganization(org);
    }

    public CredentialsEntity findById(Long id)
    {
        return credentialsRepository.findById(id).orElse(null);
    }

    public CredentialsEntity create(CredentialsEntity credential) {
        return credentialsRepository.save(credential);
    }

    public void deleteCredential(Long id) {
        Optional<CredentialsEntity> optionalCredential = credentialsRepository.findById(id);
        if (optionalCredential.isEmpty())
        {
            throw new IllegalStateException("Credential not found");
        }
        credentialsRepository.deleteById(id);
    }

    @Transactional
    public void update(Long id, String password, String description, String organization)
    {
        Optional<CredentialsEntity> optionalCredential = credentialsRepository.findById(id);
        if (optionalCredential.isEmpty())
        {
            throw new IllegalStateException("Credential not found");
        }

        CredentialsEntity cred = optionalCredential.get();
        if (password != null && !password.equals(cred.getPassword()))
        {
            cred.setPassword(password);
        }
        if (description != null && !description.equals(cred.getDescription()))
        {
            cred.setDescription(description);
        }
        if (organization != null && !organization.equals(cred.getOrganization()))
        {
            // add logic if update organization
        }
    }

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

}
