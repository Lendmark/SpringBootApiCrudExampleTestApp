package pl.lendemark.videoapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lendemark.videoapp.dao.entity.VideoCassette;

@Repository
public interface VideoCassettsRepo extends CrudRepository<VideoCassette, Long> {

}
