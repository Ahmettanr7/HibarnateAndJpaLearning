package AhmetTanrikulu.HRMSBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AhmetTanrikulu.HRMSBackend.business.abstracts.UserService;
import AhmetTanrikulu.HRMSBackend.dataAccess.abstracts.UserDao;
import AhmetTanrikulu.HRMSBackend.entities.concretes.User;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<User> getAll() {
		return this.userDao.findAll();
	}

	@Override
	public User getById(int id) {
		return this.userDao.getById(id);
	}

	@Override
	public void add(User user) {
		this.userDao.save(user);
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);
		
	}

}