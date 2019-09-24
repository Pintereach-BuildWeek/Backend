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

        roleService.save(r1);
        roleService.save(r2);

        // admin, user
        // Category -- Technology, Science, Health, Art, Business
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
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

        // user
        ArrayList<UserRoles> users2 = new ArrayList<>();
        users2.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567", users2);
        u2.getUserarticles()
                .add(new UserArticles("https://www.sciencenews.org/article/3d-printed-guns-plastic-ballistics-crime", "Science", u2));
        u2.getUserarticles()
                .add(new UserArticles("https://www.nytimes.com/2019/09/24/business/dealbook/wework-ceo-adam-neumann.html", "Business", u2));
        u2.getUserarticles()
                .add(new UserArticles("https://www.sciencenews.org/article/can-time-travel-survive-theory-of-everything", "Science", u2));
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("barnbarn", "ILuvM4th!", users);
        u3.getUserarticles()
                .add(new UserArticles("https://www.healthline.com/health-news/autumn-anxiety", "Health", u3));
        u3.getUserarticles()
                .add(new UserArticles("https://www.sciencenews.org/article/common-cold-virus-disable-protein", "Health", u3));
        u3.getUserarticles()
                .add(new UserArticles("https://www.webmd.com/cancer/news/20190923/can-aspirin-help-tackle-some-cancers", "Health", u3));
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Bob", "password", users);
        u4.getUserarticles()
                .add(new UserArticles("http://www.artnews.com/2019/09/23/artnews-chicago-beth-rudin-dewoody-theaster-gates/", "Art", u4));
        u4.getUserarticles()
                .add(new UserArticles("http://www.artnews.com/2019/09/23/independent-new-york-2020-exhibitors/", "Art", u4));
        u4.getUserarticles()
                .add(new UserArticles("https://www.sciencedaily.com/releases/2019/09/190916092109.htm", "Science", u4));
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("Jane", "password", users);
        u5.getUserarticles()
                .add(new UserArticles("https://medium.com/the-thinkmill/react-dev-tools-debug-like-a-ninja-c3a5d09895c6", "Technology", u5));
        u5.getUserarticles()
                .add(new UserArticles("https://www.nytimes.com/2019/09/20/arts/design/imagenet-trevor-paglen-ai-facial-recognition.html", "Technology", u5));
        u5.getUserarticles()
                .add(new UserArticles("https://www.sciencedaily.com/releases/2019/09/190924080037.htm", "Science", u5));
        u5.getUserarticles()
                .add(new UserArticles("https://www.baltimoresun.com/entertainment/bs-fe-bso-contract-ratified-20190923-nw6ekzgtgrfwrot7lwvuhudai4-story.html", "Art", u5));

        userService.save(u5);
    }
}