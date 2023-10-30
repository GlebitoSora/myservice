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
    public void addLinks(String long_link){
        Links links = new Links();
        links.setLongLink(long_link);
        links.setShortLink(long_link.substring(0,10));
        linksRepo.save(links);
    }
    public String getShortLink(String longlink){
        Links links = new Links();
        links.setShortLink(longlink.substring(0,10));
        return links.getShortLink();
    }
    public Links getLongLink(String shortlink){
        return linksRepo.findByShortLink(shortlink);
    }
    @Transactional
    public String deleteLink(String longLink){
       return linksRepo.deleteByLongLink(longLink);
    }

}
