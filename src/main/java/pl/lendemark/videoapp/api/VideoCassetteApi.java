package pl.lendemark.videoapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.lendemark.videoapp.dao.entity.VideoCassette;
import pl.lendemark.videoapp.manager.VideoCassettsManager;

import java.util.Optional;

@RestController // jeśli łączymy się z nim po HTTP musi to być
@RequestMapping("/api/cassetts")
public class VideoCassetteApi {

    @Autowired
    private VideoCassettsManager videoCassettsManager;

    @GetMapping("/all")  // odpowiadna za pobieranie elementów
    public Iterable<VideoCassette> getAll(){
        return videoCassettsManager.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long index){  // param jest po to bo podaje parametr zapytania
        return videoCassettsManager.findById(index);
    }

    @PostMapping ()// oznaczenie na dodawanie przez api
    public VideoCassette addVideo (@RequestBody VideoCassette videoCassette){ // body jest bo to jest metoda webowa
        return videoCassettsManager.save(videoCassette);
    }

    @PutMapping // nadpisuje elementy
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette){
        return videoCassettsManager.save(videoCassette);
    }

    @DeleteMapping
    private void deleteVideo(@RequestParam Long index){
        videoCassettsManager.deleteById(index);
    }

}
