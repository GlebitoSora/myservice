package com.example.urlshortener.Controller;
import com.example.urlshortener.Entity.Links;
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
    @PostMapping("/add/{longlink}")
    public ResponseEntity AddLinks(@PathVariable String longlink) {
        try{
            linksService.addlinks(longlink);
            return ResponseEntity.ok("Ссылка сохранена");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e);
        }
    }
    @GetMapping("/getshort/{longlink}")
    public ResponseEntity GetShortLink(@PathVariable String longlink){
        try{
            return ResponseEntity.ok(linksService.getshortlink(longlink));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ссылка не найдена");
        }

    }
    @GetMapping("/getlong/{short_link}")
    public ResponseEntity GetLongLink(@PathVariable String short_link){
        try{
            return ResponseEntity.ok(linksService.getlonglink(short_link));
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Ссылка не найдена");
        }
    }
    @DeleteMapping("/delete/{longlink}")
    public ResponseEntity deleteLink(@PathVariable String longlink){
        try{
            linksService.deleteLink(longlink);
            return ResponseEntity.ok("Ссылка удалена");
        }
        catch (Exception e){
            log.error("Cant del", e);
            return ResponseEntity.badRequest().body("Ссылка не найдена, удалять нечего");
        }
    }
}
