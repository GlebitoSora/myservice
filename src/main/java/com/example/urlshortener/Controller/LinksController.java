package com.example.urlshortener.Controller;
import com.example.urlshortener.Service.LinksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
@Slf4j
public class LinksController {
    @Autowired
    private LinksService linksService;
    @PostMapping("/add")
    public ResponseEntity<?> addLinks(@RequestParam String long_link) {
        try{
            linksService.addLinks(long_link);
            return ResponseEntity.ok("Ссылка сохранена");
        }
        catch (Exception e){
            log.error("can't add",e);
            return ResponseEntity.badRequest().body(e);
        }
    }
    @GetMapping("/getshort")
    public ResponseEntity<?> getShortLink(@RequestParam String long_link){
        try{
            return ResponseEntity.ok(linksService.getShortLink(long_link));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ссылка не найдена");
        }

    }
    @GetMapping("/getlong")
    public ResponseEntity<?> getLongLink(@RequestParam String short_link){
        try{
            return ResponseEntity.ok(linksService.getLongLink(short_link));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ссылка не найдена");
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteLink(@RequestParam String long_link){
        log.info(linksService.deleteLink(long_link));
        try{
            if (linksService.deleteLink(long_link).equals("0")){
                return ResponseEntity.badRequest().body("Ccылка не найдена");
            }
            else{
                return ResponseEntity.ok("Ссылка удалена");
            }
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }
}
