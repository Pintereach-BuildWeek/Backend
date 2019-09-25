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
                .add(new UserArticles("5 trending open source machine learning JavaScript frameworks", "https://opensource.com/article/18/5/machine-learning-javascript-frameworks", "Technology", u1));
        u1.getUserarticles()
                .add(new UserArticles("Don’t be a Junior Developer \uD83D\uDCBB\uD83D\uDE80","https://medium.com/zerotomastery/dont-be-a-junior-developer-608c255b3056", "Technology", u1));
        u1.getUserarticles()
                .add(new UserArticles("Python for Everybody, Everywhere", "https://blog.edx.org/python-everybody-everywhere?track=blog", "Technology", u1));
        u1.getUserarticles()
                .add(new UserArticles("Overtime Pay Eligibility Is Widened in New Federal Rule","https://www.nytimes.com/2019/09/24/business/economy/overtime-pay-rule-trump-administration.html", "Business", u1));
        u1.getUserarticles()
                .add(new UserArticles("Longstanding Tour Company Thomas Cook Collapses With Global Bookings Canceled","https://time.com/5683824/thomas-cook-collapsed-bookings-canceled/", "Business", u1));

        userService.save(u1);

        // user
        ArrayList<UserRoles> users2 = new ArrayList<>();
        users2.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567", users2);
        u2.getUserarticles()
                .add(new UserArticles("3-D printed ‘ghost guns’ pose new challenges for crime-scene investigators","https://www.sciencenews.org/article/3d-printed-guns-plastic-ballistics-crime", "Science", u2));
        u2.getUserarticles()
                .add(new UserArticles("WeWork C.E.O Adam Neumann Steps Down Under Pressure","https://www.nytimes.com/2019/09/24/business/dealbook/wework-ceo-adam-neumann.html", "Business", u2));
        u2.getUserarticles()
                .add(new UserArticles("Can time travel survive a theory of everything?","https://www.sciencenews.org/article/can-time-travel-survive-theory-of-everything", "Science", u2));
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("barnbarn", "ILuvM4th!", users);
        u3.getUserarticles()
                .add(new UserArticles("Autumn Anxiety: Why You May Feel More Stressed This Season","https://www.healthline.com/health-news/autumn-anxiety", "Health", u3));
        u3.getUserarticles()
                .add(new UserArticles("Disabling one protein might one day lead to a cure for the common cold","https://www.sciencenews.org/article/common-cold-virus-disable-protein", "Health", u3));
        u3.getUserarticles()
                .add(new UserArticles("Can Aspirin Help Tackle Some Cancers?","https://www.webmd.com/cancer/news/20190923/can-aspirin-help-tackle-some-cancers", "Health", u3));
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Bob", "password", users);
        u4.getUserarticles()
                .add(new UserArticles("ARTnews in Chicago: Collector Beth Rudin DeWoody and Artist Theaster Gates in Conversation, On the Ground at Expo Chicago, and More","http://www.artnews.com/2019/09/23/artnews-chicago-beth-rudin-dewoody-theaster-gates/", "Art", u4));
        u4.getUserarticles()
                .add(new UserArticles("Here’s the Exhibitor List for Independent New York 2020","http://www.artnews.com/2019/09/23/independent-new-york-2020-exhibitors/", "Art", u4));
        u4.getUserarticles()
                .add(new UserArticles("Transplanted brain stem cells survive without anti-rejection drugs in mice","https://www.sciencedaily.com/releases/2019/09/190916092109.htm", "Science", u4));
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("Jane", "password", users);
        u5.getUserarticles()
                .add(new UserArticles("React Dev Tools — Debug Like a Ninja","https://medium.com/the-thinkmill/react-dev-tools-debug-like-a-ninja-c3a5d09895c6", "Technology", u5));
        u5.getUserarticles()
                .add(new UserArticles("'Nerd', 'Nonsmoker', 'Wrongdoer': How Might A.I. Label You?","https://www.nytimes.com/2019/09/20/arts/design/imagenet-trevor-paglen-ai-facial-recognition.html", "Technology", u5));
        u5.getUserarticles()
                .add(new UserArticles("Machine learning could offer faster, more precise results for cardiac MRI scans","https://www.sciencedaily.com/releases/2019/09/190924080037.htm", "Science", u5));
        u5.getUserarticles()
                .add(new UserArticles("‘To have music back on this stage is a real thrill’: BSO, union ratify new contract, end bitter labor dispute","https://www.baltimoresun.com/entertainment/bs-fe-bso-contract-ratified-20190923-nw6ekzgtgrfwrot7lwvuhudai4-story.html", "Art", u5));

        userService.save(u5);
    }
}