package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.UserArticles;
import com.lambdaschool.starthere.models.Useremail;
import com.lambdaschool.starthere.services.UserArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class UserArticleController
{
    private static final Logger logger = LoggerFactory.getLogger(UseremailController.class);

    @Autowired
    UserArticleService articleService;


    // GET -- /articles/articles
    @GetMapping(value = "/articles",
            produces = {"application/json"})
    public ResponseEntity<?> listAllArticles(HttpServletRequest request)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<UserArticles> allArticles = articleService.findAll();
        return new ResponseEntity<>(allArticles, HttpStatus.OK);
    }

    // GET -- /article/{articleId}
    @GetMapping(value = "/article/{articleId}",
            produces = {"application/json"})
    public ResponseEntity<?> getArticleById(HttpServletRequest request,
                                              @PathVariable
                                                      Long articleId)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        UserArticles ue = articleService.findArticleById(articleId);
        return new ResponseEntity<>(ue, HttpStatus.OK);
    }

    // GET -- /user/{username}
    @GetMapping(value = "/user/{username}",
            produces = {"application/json"})
    public ResponseEntity<?> findArticleByUserName(HttpServletRequest request,
                                            @PathVariable
                                                    String username)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<UserArticles> ua = articleService.findByUserName(username);
        return new ResponseEntity<>(ua, HttpStatus.OK);
    }
}
