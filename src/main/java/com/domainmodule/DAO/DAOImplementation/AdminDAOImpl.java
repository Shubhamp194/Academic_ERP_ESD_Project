package com.domainmodule.DAO.DAOImplementation;

import com.domainmodule.Bean.Admin;
import com.domainmodule.Bean.Student;
import com.domainmodule.DAO.AdminDAO;
import com.domainmodule.Util.HibernateSessionUtil;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public boolean addAdmin(Admin admObj) {
        try(Session session = HibernateSessionUtil.getSession()){
            Transaction transaction = session.beginTransaction();
            session.save(admObj);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
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
    public Admin getAdminById(int admId) {
        try (Session session = HibernateSessionUtil.getSession()) {
            return session.get(Admin.class, admId);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }


   @Override
    public List<Admin> getAdminList() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Admin> adminList = new ArrayList<>();
            for (final Object d : session.createQuery("from Admin ").list()) {
                adminList.add((Admin) d);
            }
            return adminList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Admin login(Admin admin) {
        try (Session session = HibernateSessionUtil.getSession();){
            String adminEmail = admin.getEmail();
            String adminPassword = admin.getPassword();

            List<Object> result = new ArrayList<Object>(
                    session.createQuery("FROM Admin WHERE email = :adminEmail and password = :adminPassword")
                            .setParameter("adminEmail", adminEmail)
                            .setParameter("adminPassword", adminPassword)
                            .list()
            );

            // If no valid Student found, return null so that login failure is understood
            if (result.size() == 0)
                return null;
            else
                return (Admin) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }
}
