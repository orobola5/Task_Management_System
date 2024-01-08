package com.love.Task_Management_System.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="id")
    private Long id;

    private String title;
    private String type;
    private Date dueDate;
    private String description;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Embedded
    private CreateAndUpdateDetails createAndUpdateDetails;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CreateAndUpdateDetails getCreateAndUpdateDetails() {
        return createAndUpdateDetails;
    }

    public void setCreateAndUpdateDetails(CreateAndUpdateDetails createAndUpdateDetails) {
        this.createAndUpdateDetails = createAndUpdateDetails;
    }
}
