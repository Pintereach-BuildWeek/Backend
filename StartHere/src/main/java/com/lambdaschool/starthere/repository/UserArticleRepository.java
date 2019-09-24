package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.UserArticles;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserArticleRepository extends CrudRepository<UserArticles, Long>
{
    List<UserArticles> findAllByUser_Username(String name);
}
