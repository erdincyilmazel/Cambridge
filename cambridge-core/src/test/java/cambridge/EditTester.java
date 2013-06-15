package cambridge;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Erdinc Yilmazel
 * Date: Oct 13, 2009
 * Time: 11:48:01 AM
 */
public class EditTester {

    static class Member {
        Long id;
        String name;

        Member(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setMemberId(Long memberId) {
            this.id = memberId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Model {
        Map<Long, Member> members;

        Model(Map<Long, Member> members) {
            this.members = members;
        }

        public Map<Long, Member> getMembers() {
            return members;
        }

        public void setMembers(Map<Long, Member> members) {
            this.members = members;
        }
    }

    public static class Auth {
        Member me;

        public Auth(Member me) {
            this.me = me;
        }

        public Member getMe() {
            return me;
        }

        public void setMe(Member me) {
            this.me = me;
        }
    }

    public static void main(String[] args) {
        try {
            final DirectoryTemplateLoader loader = new DirectoryTemplateLoader(new File("."));
            loader.parseTemplate("kitchensink.html", Expressions.cambridgeExpressionLanguage);
            final TemplateFactory f = loader.newTemplateFactory("kitchensink.html", Expressions.cambridgeExpressionLanguage);

            Template template = f.createTemplate();

            HashMap<Long, Member> members = new HashMap<Long, Member>();

            members.put(1l, new Member(1l, "Member 1"));
            members.put(2l, new Member(2l, "Member 2"));
            members.put(3l, new Member(3l, "Member 3"));
            members.put(4l, new Member(4l, "Member 4"));

            Model model = new Model(members);

            Auth auth = new Auth(members.get(2l));

            template.setProperty("model", model);
            template.setProperty("auth", auth);

            Writer writer = new OutputStreamWriter(System.out);
            template.printTo(writer);
            writer.flush();
            System.out.flush();

        } catch (TemplateLoadingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
