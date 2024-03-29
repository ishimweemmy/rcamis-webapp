package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
import rw.ac.rca.webapp.dao.MarkDAO;
import rw.ac.rca.webapp.orm.Manager;
import rw.ac.rca.webapp.orm.Mark;

import java.util.List;

public class MarkDAOImpl extends DAO implements MarkDAO {

    private static  MarkDAOImpl instance;

    public static MarkDAOImpl getInstance(){
        if(instance == null){
            return new MarkDAOImpl();
        }
        return instance;
    }
    @Override
    public List<Mark> getAllMarks() {
        try{
            begin();
            Query query = getSession().createQuery("from Mark");
            List<Mark> marks = query.list();
            System.out.println("marks ================ : " + marks);
            commit();
            return marks;
        }catch (Exception exception){
            System.out.println("failed ro save the mark : " + exception.getMessage());
            rollback();
            return null;
        }
    }

    @Override
    public Mark saveOrUpdateMark(Mark mark) {
        try{
            begin();
            getSession().saveOrUpdate(mark);
            commit();
            return  mark;
        }catch (Exception exception){
            System.out.println("failed to save mark  : " + exception.getMessage());
            rollback();
            return null;
        }
    }

    @Override
    public void deleteMarkById(Mark mark) {
        try {
            begin();
            getSession().delete(mark);
            commit();
        }catch (Exception exception){
            System.out.println("Failed to delete mark : " + exception.getMessage());
        }
    }
    @Override
    public Mark getMarkById(int id) {
        try {
            begin();
            Query query = getSession().createQuery("from Mark where id = :idValue");
            query.setParameter("idValue", id);
            Mark mark = (Mark) query.uniqueResult();
            commit();
            return mark;
        }catch (Exception exception){
            System.out.println("Failed to get mark by id : " + exception.getMessage());
            rollback();
            return null;
        }
    }
}
