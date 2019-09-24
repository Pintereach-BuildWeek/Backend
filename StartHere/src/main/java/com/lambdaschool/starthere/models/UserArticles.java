package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "userarticles")
public class UserArticles extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long articleid;

    @Column(nullable = false,
            unique = true)
    private String link;

    @Column(nullable = false)
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",
            nullable = false)
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

    @Override
    public int hashCode()
    {
        return Objects.hash(getUser());
    }

    @Override
    public String toString() {
        return "UserArticles{" +
                "articleid=" + articleid +
                ", link='" + link + '\'' +
                ", category='" + category + '\'' +
                ", user=" + user +
                '}';
    }
}
