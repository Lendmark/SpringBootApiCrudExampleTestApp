package pl.lendemark.videoapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.lendemark.videoapp.dao.VideoCassettsRepo;
import pl.lendemark.videoapp.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassettsManager {

    private VideoCassettsRepo videoCassettsRepo;

    @Autowired
    public VideoCassettsManager(VideoCassettsRepo videoCassettsRepo) {
        this.videoCassettsRepo = videoCassettsRepo;
    }

    public Optional<VideoCassette> findById(Long id){
        return videoCassettsRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll(){
        return videoCassettsRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette){
        return videoCassettsRepo.save(videoCassette);
    }

    public void deleteById(Long id){
        videoCassettsRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class) // ta adnotacja wyłowywana jest kiedy uruchomimy aplikacje //dobre dla testow
    public void fillDB(){
      save(new VideoCassette(1L, "tytanic", LocalDate.of(1995,01,01)));
      save(new VideoCassette(2L, "pulp ficsion", LocalDate.of(1990,05,02)));
    }

}
