package editor.service;

import editor.dao.BasicSession;
import editor.entity.Content;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ContentService {
    public static void savecontent(String content) {
        Content co=new Content();
        co.setN(content);
        BasicSession b=new BasicSession();
        SessionFactory sf= b.getSession();
        Session s=sf.openSession();

        s.save(co);
        b.close(s,sf);
    }

}
