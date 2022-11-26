package com.domainmodule.DAO;

import com.domainmodule.Bean.Domain;
import com.domainmodule.Bean.Student;

import java.util.List;

public interface DomainDAO {
    boolean addDomain(Domain domObj);
    boolean modifyDomain(int domId,Domain domObj);
    Domain getDomainById(int domId);
    List<Domain> getDomainList();
//    List<Student> studentListInDomain(int domId);
    boolean updateDomainProgram(int domainId,  String updatedName);
    boolean updateDomainCapacity(int domainId,  int updatedCapacity);
    boolean updateDomainQualification(int domainId,  String updatedQualification);
    boolean updateDomainBatch(int domainId,  String updatedBatch);
}
