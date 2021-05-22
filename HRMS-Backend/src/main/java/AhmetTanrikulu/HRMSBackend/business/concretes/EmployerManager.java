package AhmetTanrikulu.HRMSBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AhmetTanrikulu.HRMSBackend.business.abstracts.EmployerService;
import AhmetTanrikulu.HRMSBackend.dataAccess.abstracts.EmployerDao;
import AhmetTanrikulu.HRMSBackend.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

	@Override
	public Employer getById(int id) {
		return this.employerDao.getById(id);
	}

	@Override
	public void add(Employer employer) {
		this.employerDao.save(employer);
		
	}

	@Override
	public void update(Employer employer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employer employer) {
		this.employerDao.delete(employer);
		
	}
	
	

}
