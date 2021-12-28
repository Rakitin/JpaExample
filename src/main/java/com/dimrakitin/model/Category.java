package com.dimrakitin.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Category {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Set<Task> tasks = new HashSet<>();
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Set<Task> getTasks() {
        return tasks;
    }
}