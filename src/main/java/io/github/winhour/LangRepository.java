package io.github.winhour;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LangRepository {

    private List<Lang> languages;

    LangRepository(){
        languages = new ArrayList<>();
        languages.add(new Lang(1L, "Hello", "en"));
        languages.add(new Lang(2L, "Witaj", "pl"));
    }

    Optional<Lang> findbyId(long id){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        Lang result = session.get(Lang.class, id);

        transaction.commit();
        session.close();

        return languages.stream().filter(l -> l.getId().equals(id)).findFirst();
    }

}
