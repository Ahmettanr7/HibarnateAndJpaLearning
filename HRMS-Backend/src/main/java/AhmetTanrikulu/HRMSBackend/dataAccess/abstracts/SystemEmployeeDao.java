package AhmetTanrikulu.HRMSBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AhmetTanrikulu.HRMSBackend.entities.concretes.SystemEmployee;
import AhmetTanrikulu.HRMSBackend.entities.concretes.User;

public interface SystemEmployeeDao extends JpaRepository<SystemEmployee, Integer> {
	List<User> findAllByEmail(String email);

}