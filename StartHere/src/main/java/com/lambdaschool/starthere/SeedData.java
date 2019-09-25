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
        // for add UserArticles ("title", "summary", "link", "category", userId)
        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        User u1 = new User("admin", "password", admins);
        u1.getUserarticles()
                .add(new UserArticles("5 trending open source machine learning JavaScript frameworks", "Whether you're a JavaScript developer who wants to dive into machine learning or a machine learning expert who plans to use JavaScript, these open source frameworks may intrigue you.","https://opensource.com/article/18/5/machine-learning-javascript-frameworks", "Technology", u1));
        u1.getUserarticles()
                .add(new UserArticles("Don’t be a Junior Developer \uD83D\uDCBB\uD83D\uDE80", "Don’t overestimate the world and underestimate yourself. You are better than you think.","https://medium.com/zerotomastery/dont-be-a-junior-developer-608c255b3056", "Technology", u1));
        u1.getUserarticles()
                .add(new UserArticles("Python for Everybody, Everywhere", "Python for Everybody (PY4E) MOOC is coming to millions of learners on edX, who are welcome additions to this growing community of Python learners and practitioners.", "https://blog.edx.org/python-everybody-everywhere?track=blog", "Technology", u1));
        u1.getUserarticles()
                .add(new UserArticles("Overtime Pay Eligibility Is Widened in New Federal Rule", "For the first time since 2004, the Labor Department raised the threshold below which workers are eligible for overtime. “This rule brings a common-sense approach,” said Patrick Pizzella, the acting labor secretary.","https://www.nytimes.com/2019/09/24/business/economy/overtime-pay-rule-trump-administration.html", "Business", u1));
        u1.getUserarticles()
                .add(new UserArticles("Longstanding Tour Company Thomas Cook Collapses With Global Bookings Canceled", "Longtime British tour company Thomas Cook collapsed after failing to secure rescue funding, and travel bookings for its more than 600,000 global vacationers were canceled.","https://time.com/5683824/thomas-cook-collapsed-bookings-canceled/", "Business", u1));

        userService.save(u1);

        // user
        ArrayList<UserRoles> users2 = new ArrayList<>();
        users2.add(new UserRoles(new User(), r2));
        User u2 = new User("cinnamon", "1234567", users2);
        u2.getUserarticles()
                .add(new UserArticles("3-D printed ‘ghost guns’ pose new challenges for crime-scene investigators", "New methods are needed to do ballistics on plastic guns — before the weapons gain popularity","https://www.sciencenews.org/article/3d-printed-guns-plastic-ballistics-crime", "Science", u2));
        u2.getUserarticles()
                .add(new UserArticles("Behind WeWork Leader’s Rise and Fall: A Wall St. Bank Playing Many Angles", "JPMorgan Chase, an ardent backer of the start-up and Adam Neumann, was as well placed as any investor to see his conflicts of interest.","https://www.nytimes.com/2019/09/25/business/wework-jpmorgan.html", "Business", u2));
        u2.getUserarticles()
                .add(new UserArticles("Can time travel survive a theory of everything?", "It’s complicated. But studying ways to visit the past could help us understand the cosmos","https://www.sciencenews.org/article/can-time-travel-survive-theory-of-everything", "Science", u2));
        userService.save(u2);

        // user
        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u3 = new User("barnbarn", "ILuvM4th!", users);
        u3.getUserarticles()
                .add(new UserArticles("Autumn Anxiety: Why You May Feel More Stressed This Season", "Autumn anxiety is an annual increase in anxiety some people begin to feel during the autumn months. Changes in diet, daily exercise, and increased exposure to daylight are all ways people can minimize the effects of autumn anxiety.","https://www.healthline.com/health-news/autumn-anxiety", "Health", u3));
        u3.getUserarticles()
                .add(new UserArticles("Disabling one protein might one day lead to a cure for the common cold", "Rhinoviruses which are responsible for most cases of the common cold couldn’t replicate in mice and human cells engineered to lack SETD3","https://www.sciencenews.org/article/common-cold-virus-disable-protein", "Health", u3));
        u3.getUserarticles()
                .add(new UserArticles("Can Aspirin Help Tackle Some Cancers?", "Low-dose aspirin may improve survival odds for patients battling head/neck and lung cancer, two new studies suggest.","https://www.webmd.com/cancer/news/20190923/can-aspirin-help-tackle-some-cancers", "Health", u3));
        userService.save(u3);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u4 = new User("Bob", "password", users);
        u4.getUserarticles()
                .add(new UserArticles("ARTnews in Chicago: Collector Beth Rudin DeWoody and Artist Theaster Gates in Conversation, On the Ground at Expo Chicago, and More", "ARTnews organized various events around Chicago, including a preview for a Theaster Gates–organized exhibition at the Stony Island Arts Bank and a talk with Gates and collector Beth Rudin DeWoody about that show.","http://www.artnews.com/2019/09/23/artnews-chicago-beth-rudin-dewoody-theaster-gates/", "Art", u4));
        u4.getUserarticles()
                .add(new UserArticles("Here’s the Exhibitor List for Independent New York 2020", "The Independent art fair, which is held annually in New York and previously staged presentations in Brussels, has revealed the 63 galleries that will show work in its 2020 edition at Spring Studios in Tribeca.","http://www.artnews.com/2019/09/23/independent-new-york-2020-exhibitors/", "Art", u4));
        u4.getUserarticles()
                .add(new UserArticles("Transplanted brain stem cells survive without anti-rejection drugs in mice", "In experiments in mice, researchers say they have developed a way to successfully transplant certain protective brain cells without the need for lifelong anti-rejection drugs.", "https://www.sciencedaily.com/releases/2019/09/190916092109.htm", "Science", u4));
        userService.save(u4);

        users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));
        User u5 = new User("Jane", "password", users);
        u5.getUserarticles()
                .add(new UserArticles("React Dev Tools — Debug Like a Ninja", "React team launched a new version of the React Dev Tools (v4) and it gives you debugging superpowers to navigate through your tree, trace data flow, spot weak links and optimise for perf.","https://medium.com/the-thinkmill/react-dev-tools-debug-like-a-ninja-c3a5d09895c6", "Technology", u5));
        u5.getUserarticles()
                .add(new UserArticles("'Nerd', 'Nonsmoker', 'Wrongdoer': How Might A.I. Label You?", "ImageNet Roulette, a digital art project and viral selfie app, exposes how biases have crept into the artificial-intelligence technologies changing our lives.","https://www.nytimes.com/2019/09/20/arts/design/imagenet-trevor-paglen-ai-facial-recognition.html", "Technology", u5));
        u5.getUserarticles()
                .add(new UserArticles("Machine learning could offer faster, more precise results for cardiac MRI scans", "Cardiac MRI scans can be read by AI 186 times faster than humans, with comparable precision. Because the greatest source of measurement errors are human factors, AI has the potential to improve future clinical decision making.","https://www.sciencedaily.com/releases/2019/09/190924080037.htm", "Science", u5));
        u5.getUserarticles()
                .add(new UserArticles("Italy to Lend Leonardo da Vinci Works to France in a Masterpiece Swap", "The pieces will appear in an exhibition at the Louvre marking the 500th anniversary of the Renaissance master’s death, and Italy will borrow works by Raphael.","https://www.nytimes.com/2019/09/24/arts/design/da-vinci-vitruvian-man.html?rref=collection%2Ftimestopic%2FArt", "Art", u5));

        userService.save(u5);
    }
}