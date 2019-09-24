package com.lambdaschool.starthere;

import com.lambdaschool.starthere.models.*;
import com.lambdaschool.starthere.services.RoleService;
import com.lambdaschool.starthere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;


    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
//        Role r3 = new Role("data");

        roleService.save(r1);
        roleService.save(r2);
//        roleService.save(r3);

        // admin, data, user
        // Category -- Technology, Science, Health, Arts, Business
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
//        admins.add(new UserRoles(new User(), r3));
        User u1 = new User("admin", "password", admins);
        u1.getUserarticles()
                .add(new UserArticles("https://opensource.com/article/18/5/machine-learning-javascript-frameworks", "Technology", u1));
        u1.getUserarticles()
                .add(new UserArticles("https://medium.com/zerotomastery/dont-be-a-junior-developer-608c255b3056", "Technology", u1));
        u1.getUserarticles()
                .add(new UserArticles("https://blog.edx.org/python-everybody-everywhere?track=blog", "Technology", u1));
        u1.getUserarticles()
                .add(new UserArticles("https://www.nytimes.com/2019/09/24/business/economy/overtime-pay-rule-trump-administration.html", "Business", u1));
        u1.getUserarticles()
                .add(new UserArticles("https://time.com/5683824/thomas-cook-collapsed-bookings-canceled/", "Business", u1));

        userService.save(u1);

        // data, user
        ArrayList<UserRoles> users2 = new ArrayList<>();
//        datas.add(new UserRoles(new User(), r3));
        users2.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567", users2);
        u2.getUserarticles()
          .add(new UserArticles("http://link-2-1", "Java/Spring", u2));
        u2.getUserarticles()
          .add(new UserArticles("http://link-2-2", "postgreSQL", u2));
//        u2.getUseremails()
//          .add(new Useremail(u2, "bunny@email.local"));
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("barnbarn", "ILuvM4th!", users);
        u3.getUserarticles()
          .add(new UserArticles("http://link-3-1", "REACT", u3));
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Bob", "password", users);
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("Jane", "password", users);
        userService.save(u5);
    }
}