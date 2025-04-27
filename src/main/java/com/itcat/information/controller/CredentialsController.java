package com.itcat.information.controller;

import com.itcat.information.repository.OrganizationEntity;
import com.itcat.information.repository.CredentialsEntity;
import com.itcat.information.service.СredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/credentials")
public class CredentialsController
{
    @Autowired
    private СredentialsService credentialsService;

    @GetMapping
    public Iterable<CredentialsEntity> findAll() {
        return credentialsService.findAll();
    }

    @GetMapping(path = "/description", params = {"descr"})
    public Iterable<CredentialsEntity> findByDescription(@RequestParam String descr) {
        return credentialsService.findByDescription(descr);
    }

    @GetMapping("/organization/{org}")
    public Iterable<CredentialsEntity> findByOrganization(@PathVariable String org) {
        return credentialsService.findByOrganization(org);
    }

    @GetMapping("/{id}")
    public CredentialsEntity findById(@PathVariable Long id) {
        return credentialsService.findById(id);
    }

    @GetMapping("/save")
    public ResponseEntity create() {
        try
        {
            CredentialsEntity cred = CredentialsEntity.builder()//.id(3L)
                    .login("Vanya").password("anyLetters").description("someText")
                    .organization(credentialsService.getSession().getReference(OrganizationEntity.class, 3L)).build();
            credentialsService.create(cred);
            return ResponseEntity.ok("bingo");
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while saving data");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCredential(@PathVariable Long id) {
        credentialsService.deleteCredential(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestParam (required = false) String password,
                       @RequestParam (required = false) String description,
                       @RequestParam (required = false) String organization)
    {
        credentialsService.update(id, password, description, organization);
    }

    @GetMapping("/bingo/")
    public ResponseEntity main() {
        return ResponseEntity.ok("bingo");
    }
}
