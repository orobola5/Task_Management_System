package com.love.Task_Management_System.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "name", nullable = false, unique = true)
    private RoleName name;

    @Embedded
    private CreateAndUpdateDetails createAndUpdateDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    public CreateAndUpdateDetails getCreateAndUpdateDetails() {
        return createAndUpdateDetails;
    }

    public void setCreateAndUpdateDetails(CreateAndUpdateDetails createAndUpdateDetails) {
        this.createAndUpdateDetails = createAndUpdateDetails;
    }
}
