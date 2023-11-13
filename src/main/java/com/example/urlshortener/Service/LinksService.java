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
    public String getShortLink(String long_link){
        Links links = new Links();
        links.setShortLink(long_link.substring(0,10));
        return links.getShortLink();
    }
    public Links getLongLink(String short_link){
        return linksRepo.findByShortLink(short_link);
    }
    @Transactional
    public String deleteLink(String long_link){
       return linksRepo.deleteByLongLink(long_link);
    }

}
