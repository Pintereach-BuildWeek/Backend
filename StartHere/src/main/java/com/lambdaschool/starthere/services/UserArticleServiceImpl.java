package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.exceptions.ResourceNotFoundException;
import com.lambdaschool.starthere.models.UserArticles;
import com.lambdaschool.starthere.repository.UserArticleRepository;
import com.lambdaschool.starthere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "articleService")
public class UserArticleServiceImpl implements UserArticleService
{
    @Autowired
    UserArticleRepository userarticlerepos;

    @Autowired
    UserRepository userrepos;

    @Override
    public List<UserArticles> findAll() {
        List<UserArticles> articles = new ArrayList<>();
        userarticlerepos.findAll().iterator().forEachRemaining(articles::add);
        return articles;
    }

    @Override
    public UserArticles findArticleById(long id) {
        return userarticlerepos.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User Article id " + id + " not found!"));
    }

    @Transactional
    @Override
    public void delete(long id) {
        userarticlerepos.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("User Article id " + id + " not found!"));
        userarticlerepos.deleteById(id);
    }

    @Override
    public UserArticles save(UserArticles userarticle) {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        if (userarticle.getUser()
                .getUsername()
                .equalsIgnoreCase(authentication.getName()))
        {
            return userarticlerepos.save(userarticle);
        } else
        {
            throw new ResourceNotFoundException((authentication.getName() + "not authorized to make change"));
        }
    }

    @Override
    public UserArticles findByName(String name) {
        return null;
    }

    @Override
    public List<UserArticles> findByUserName(String username) {
        return userarticlerepos.findAllByUser_Username(username);
    }
}
