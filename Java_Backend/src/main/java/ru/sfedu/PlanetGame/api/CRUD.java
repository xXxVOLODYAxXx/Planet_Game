package ru.sfedu.PlanetGame.api;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.sfedu.PlanetGame.models.Base;
import ru.sfedu.PlanetGame.utils.HibernateUtil;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static ru.sfedu.PlanetGame.utils.Constants.GET_QUERY;

public class CRUD {

    private Session session;

    private void initSession() throws IOException {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    private void closeSession() {
        if (session != null) {
            session.close();
        }
        session = null;
    }

    public <T extends Base> T create(T record) throws IOException {
        this.initSession();
        Transaction tx = session.beginTransaction();
        session.persist(record);
        tx.commit();
        this.closeSession();
        return record;
    }

    public <T extends Base> List<T> getAll(Class<T> tClass) throws IOException {
        this.initSession();
        String query = String.format(GET_QUERY, tClass.getSimpleName());
        Transaction tx = session.beginTransaction();
        List<T> list = session.createQuery(query).list();
        tx.commit();
        this.closeSession();
        return list;
    }

    public <T extends Base> T getById(long id, Class<T> tClass) throws IOException {
        this.initSession();
        Transaction tx = session.beginTransaction();
        T result = (T)session.get(tClass, id);
        tx.commit();
        this.closeSession();
        return result;
    }

    public <T extends Base> void delete(T record) throws IOException {
        try {
            this.initSession();
            Transaction tx = session.beginTransaction();
            session.delete(record);
            tx.commit();
            this.closeSession();
        } catch (Exception e){
            System.out.println(e);

        }

    }

    public <T extends Base> T update(T record) throws IOException {
        try {
            this.initSession();
            Transaction tx = session.beginTransaction();
            //session.load(record, record.getId());
//        record.setDateUpdate(new Timestamp(new Date().getTime()));
            System.out.println("PIZDA 1");
            session.update(record);
            System.out.println("PIZDA 2");
            tx.commit();
            this.closeSession();
            return record;
        } catch (Exception e){
            System.out.println(e);
            return record;
        }

    }

}
