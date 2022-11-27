package com.domainmodule.DAO.DAOImplementation;

import com.domainmodule.Bean.Domain;
import com.domainmodule.Bean.Student;
import com.domainmodule.DAO.DomainDAO;
import com.domainmodule.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DomainDAOImpl implements DomainDAO {

    @Override
    public boolean addDomain(Domain domObj) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.save(domObj);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
        catch (Exception e){
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean modifyDomain(int domId, Domain domObj) {
        return false;
    }

    @Override
    public boolean updateDomainProgram(int domainId, String updatedName) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();

            Query q = session.createQuery("from Domain where domain_id=:ID");
            q.setParameter("ID", domainId);

            Domain result = (Domain)q.list().get(0);
            result.setProgram(updatedName);
            session.update(result);
            t.commit();
            return true;

        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }


    @Override
    public boolean updateDomainCapacity(int domainId, int updatedCapacity) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();

            Query q = session.createQuery("from Domain where domain_id=:ID");
            q.setParameter("ID", domainId);

            Domain result = (Domain)q.list().get(0);
            result.setCapacity(updatedCapacity);
            session.update(result);
            t.commit();
            return true;

        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean updateDomainQualification(int domainId, String updatedQualification) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();

            Query q = session.createQuery("from Domain where domain_id=:ID");
            q.setParameter("ID", domainId);

            Domain result = (Domain)q.list().get(0);
            result.setQualification(updatedQualification);
            session.update(result);
            t.commit();
            return true;

        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public boolean updateDomainBatch(int domainId, String updatedBatch) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction t = session.beginTransaction();

            Query q = session.createQuery("from Domain where domain_id=:ID");
            q.setParameter("ID", domainId);

            Domain result = (Domain)q.list().get(0);
            result.setBatch(updatedBatch);
            session.update(result);
            t.commit();
            return true;

        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
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

//    @Override
//    public List<Student> studentListInDomain(int domId) {
//        try (Session session = HibernateSessionUtil.getSession()) {
//            Domain domObj=session.get(Domain.class, domId);
////            return domObj.getStudentList();
//        } catch (HibernateException exception) {
//            System.out.print(exception.getLocalizedMessage());
//        }
//        return null;
//    }

}
