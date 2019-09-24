package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.UserArticles;

import java.util.List;

// Note role does not have an update. Changing the spelling of the role impacts resource access so is BIG DEAL!

public interface UserArticleService
{
    List<UserArticles> findAll();

    UserArticles findArticleById(long id);

    void delete(long id);

    UserArticles save(UserArticles userarticle);

    UserArticles findByName(String name);

    List<UserArticles> findByUserName(String username);

}