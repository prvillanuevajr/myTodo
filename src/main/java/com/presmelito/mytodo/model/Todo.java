package com.presmelito.mytodo.model;

import com.presmelito.mytodo.dao.TodoDao;

import java.time.LocalDateTime;

public class Todo {
    private Long id;
    private String title;
    private User user;
    private String description;
    private LocalDateTime targetDate;
    private LocalDateTime completedAt;

    public Todo() {
    }

    public Todo(Long id, String title, User user, String description, LocalDateTime targetDate, LocalDateTime completedAt) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.description = description;
        this.targetDate = targetDate;
        this.completedAt = completedAt;
    }

    public Todo(String title, User user, String description, LocalDateTime targetDate, LocalDateTime completedAt) {
        this.title = title;
        this.user = user;
        this.description = description;
        this.targetDate = targetDate;
        this.completedAt = completedAt;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDateTime targetDate) {
        this.targetDate = targetDate;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public boolean save() {
        return new TodoDao().persist(this);
    }
}
