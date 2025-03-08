package com.itcat.information.service;

import com.itcat.information.dao.CredentialsDao;
import com.itcat.information.model.СredentialsEntity;

public class СredentialsService
{
    private CredentialsDao credentialsDao;

    public СredentialsService() {
        this.credentialsDao = new CredentialsDao();
    }

    public void addСredentialsEntity(СredentialsEntity credentialsEntity) {
        credentialsDao.save(credentialsEntity);
    }

    public СredentialsEntity getСredentialsEntity(Long id) {
        return credentialsDao.findById(id);
    }

    public void updateСredentialsEntity(СredentialsEntity credentialsEntity) {
        credentialsDao.update(credentialsEntity);
    }

    public void deleteСredentialsEntity(СredentialsEntity credentialsEntity) {
        credentialsDao.delete(credentialsEntity);
    }
}
