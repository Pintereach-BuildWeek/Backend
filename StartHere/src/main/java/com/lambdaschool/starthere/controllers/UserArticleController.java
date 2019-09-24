package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.UserArticles;
import com.lambdaschool.starthere.services.UserArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/userarticles")
public class UserArticleController
{
//    private static final Logger logger = LoggerFactory.getLogger(UseremailController.class);

    @Autowired
    UserArticleService articleService;

    @GetMapping(value = "/articles",
            produces = {"application/json"})
    public ResponseEntity<?> listAllArticles(HttpServletRequest request)
    {
//        logger.trace(request.getMethod()
//                .toUpperCase() + " " + request.getRequestURI() + " accessed");

        List<UserArticles> allArticles = articleService.findAll();
        return new ResponseEntity<>(allArticles, HttpStatus.OK);
    }
}
