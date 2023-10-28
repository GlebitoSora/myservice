package com.example.urlshortener.Service;

import com.example.urlshortener.Entity.Links;
import com.example.urlshortener.Repository.LinksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LinksService {
    private final LinksRepository linksRepo;
    public Links addlinks(String link){
        Links links = new Links();
        links.setLongLink(link);
        links.setShortLink(link.substring(0,10));
        return linksRepo.save(links);
    }
    public String getshortlink(String longlink){
        Links links = new Links();
        links.setShortLink(longlink.substring(0,15));
        return links.getShortLink();
    }
    public Links getlonglink(String shortlink){
        return linksRepo.findByShortLink(shortlink);
    }
    @Transactional
    public void deleteLink(String longLink){
        linksRepo.deleteByLongLink(longLink);
    }

}
