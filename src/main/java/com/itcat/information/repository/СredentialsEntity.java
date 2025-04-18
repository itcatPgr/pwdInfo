package com.itcat.information.repository;

import com.itcat.information.repository.OrganizationEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credentials")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
@Builder
public class СredentialsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name="pwd")
    private String password;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private OrganizationEntity organization;
}
