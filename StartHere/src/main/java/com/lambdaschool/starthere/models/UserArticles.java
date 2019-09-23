package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userarticles")
public class UserArticles
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long articleid;

    @Column(nullable = false,
            unique = true)
    private String link;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String category;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("userarticles")
    private User user;

    public UserArticles() {
    }

    public UserArticles(String link, String category, User user) {
        this.link = link;
        this.category = category;
        this.user = user;
    }

    public long getArticleid() {
        return articleid;
    }

    public void setArticleid(long articleid) {
        this.articleid = articleid;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
