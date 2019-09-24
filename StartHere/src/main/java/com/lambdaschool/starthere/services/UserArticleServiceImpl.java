package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.exceptions.ResourceNotFoundException;
import com.lambdaschool.starthere.models.User;
import com.lambdaschool.starthere.models.UserArticles;
import com.lambdaschool.starthere.models.UserRoles;
import com.lambdaschool.starthere.repository.RoleRepository;
import com.lambdaschool.starthere.repository.UserArticleRepository;
import com.lambdaschool.starthere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
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


    //    @Override
//    public List<Role> findAll()
//    {
//        List<Role> list = new ArrayList<>();
//        userarticlerepos.findAll()
//                 .iterator()
//                 .forEachRemaining(list::add);
//        return list;
//    }
//
//
//    @Override
//    public Role findRoleById(long id)
//    {
//        return userarticlerepos.findById(id)
//                        .orElseThrow(() -> new ResourceNotFoundException("Role id " + id + " not found!"));
//    }
//
//    @Override
//    public Role findByName(String name)
//    {
//        Role rr = userarticlerepos.findByNameIgnoreCase(name);
//
//        if (rr != null)
//        {
//            return rr;
//        } else
//        {
//            throw new ResourceNotFoundException(name);
//        }
//    }
//
//    @Transactional
//    @Override
//    public void delete(long id)
//    {
//        userarticlerepos.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Role id " + id + " not found!"));
//        userarticlerepos.deleteById(id);
//    }
//
//
//
//    @Transactional
//    @Override
//    public UserArticles save(UserArticles userarticle)
//    {
//        UserArticles newArticle = new UserArticles();
//        newArticle.setLink(userarticle.getLink());
//
//
////        ArrayList<UserRoles> newUsers = new ArrayList<>();
////        for (UserRoles ur : role.getUserroles())
////        {
////            long id = ur.getUser()
////                        .getUserid();
////            User user = userrepos.findById(id)
////                                 .orElseThrow(() -> new ResourceNotFoundException("User id " + id + " not found!"));
////            newUsers.add(new UserRoles(ur.getUser(), newRole));
////        }
////        newRole.setUserroles(newUsers);
////
////        return userarticlerepos.save(role);
//    }
}
