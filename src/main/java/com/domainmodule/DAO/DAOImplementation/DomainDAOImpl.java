package com.domainmodule.DAO.DAOImplementation;

import com.domainmodule.Bean.Domain;
import com.domainmodule.Bean.Student;
import com.domainmodule.DAO.DomainDAO;
import com.domainmodule.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

public class DomainDAOImpl implements DomainDAO {

    @Override
    public boolean addDomain(Domain domObj) {
        try(Session session = HibernateSessionUtil.getSession()){  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();  // transaction initiated
            session.save(domObj);                                 // using session object to save java object into MySQL
            transaction.commit();                                  // committing transaction
            return true;
        }
        catch (HibernateException exception) {
            // if Hibernate Exception occurs return false
            // for related exception we can maintain separate logger / Sysout messages for easy debugging
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
        catch (Exception e){
            //generalized exception class for any IO / Arithmetic Exception
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean modifyDomain(int domId, Domain domObj) {
        return false;
    }

    @Override
    public Domain getDomainById(int domId) {
        try (Session session = HibernateSessionUtil.getSession()) {
            return session.get(Domain.class, domId);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Domain> getDomainList() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Domain>  domainList = new ArrayList<>();
            for (final Object d : session.createQuery("from Domain ").list()) {
                domainList.add((Domain) d);
            }
            return domainList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public List<Student> studentListInDomain(int domId) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Domain domObj=session.get(Domain.class, domId);
            return domObj.getStudentList();
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

}
