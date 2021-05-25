package AhmetTanrikulu.HRMSBackend.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AhmetTanrikulu.HRMSBackend.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	List<User> findAllByEmail(String email);
}
