package ro.siit.concedii.service;

import ro.siit.concedii.domain.Employee;
import ro.siit.concedii.domain.Leave;

import java.util.Collection;

public interface LeaveService {
    public Collection<Leave> listAll();

    public Collection<Leave> search( String query) ;

    public boolean delete(Long id) ;

    public Leave get(Long id) ;

    public void save(Leave leave);
}
