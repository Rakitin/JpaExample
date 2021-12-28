package com.dimrakitin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String text;
    private Boolean isDone;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }
    
    public Boolean getIsDone() {
        return isDone;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        category.getTasks().add(this);
        this.category = category;
    }
}
