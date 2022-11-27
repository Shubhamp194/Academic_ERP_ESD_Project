package com.domainmodule.DAO;

import com.domainmodule.Bean.Admin;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;

import java.util.List;

public interface AdminDAO {
    boolean addAdmin(Admin admObj);
    Admin getAdminById(int admId);
    List<Admin> getAdminList();
    Admin login(Admin admin);

}
