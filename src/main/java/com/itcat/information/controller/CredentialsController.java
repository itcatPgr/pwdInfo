package com.itcat.information.controller;

import com.itcat.information.repository.OrganizationEntity;
import com.itcat.information.repository.СredentialsEntity;
import com.itcat.information.service.СredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CredentialsController
{
    @Autowired
    private СredentialsService credentialsService;

    @GetMapping("/items/{id}")
    public СredentialsEntity getCredById(@PathVariable Long id) {
        return credentialsService.getСredentialById(id);
    }

    @GetMapping("/items")
    public Iterable<СredentialsEntity> getAllСredentials() {
        return credentialsService.getAllСredentials();
    }

    @GetMapping("/items/login/{login}")
    public Iterable<СredentialsEntity> getAllСredentials(@PathVariable String login) {
        return credentialsService.findByLogin(login);
    }

    @GetMapping("/deleteitem/{id}")
    public void deleteСredential(@PathVariable Long id) {
        credentialsService.deleteСredential(id);
    }

    @GetMapping("/save")
    public ResponseEntity saveСredential() {
        try
        {
            СredentialsEntity cred = СredentialsEntity.builder()
                    .login("Mary").password("pwd2").description("myDescr22")
                    .organization(credentialsService.getSession().getReference(OrganizationEntity.class, 2L)).build();
            credentialsService.saveСredential(cred);
            return ResponseEntity.ok("bingo");
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while saving data");
        }
    }

    @GetMapping("/")
    public ResponseEntity main() {
        return ResponseEntity.ok("bingo");
    }
}
