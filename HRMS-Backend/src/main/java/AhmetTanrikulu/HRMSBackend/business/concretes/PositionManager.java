package AhmetTanrikulu.HRMSBackend.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AhmetTanrikulu.HRMSBackend.business.abstracts.PositionService;
import AhmetTanrikulu.HRMSBackend.dataAccess.abstracts.PositionDao;
import AhmetTanrikulu.HRMSBackend.entities.concretes.Position;

@Service
public class PositionManager implements PositionService{
	private PositionDao positionDao;

	@Autowired
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public List<Position> getAll() {
		return this.positionDao.findAll();
	}

	@Override
	public Position getById(int id) {
		return this.positionDao.getById(id);
	}

	@Override
	public void add(Position position) {
		this.positionDao.save(position);
		
	}

	@Override
	public void update(Position position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Position position) {
		this.positionDao.delete(position);
		
	}

}
