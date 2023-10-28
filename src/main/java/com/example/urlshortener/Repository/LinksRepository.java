package com.example.urlshortener.Repository;
import com.example.urlshortener.Entity.Links;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LinksRepository extends CrudRepository<Links, String> {
    Links findByShortLink(String shortLink);
    String deleteByLongLink(String longLink);
    String deleteLinksByLongLinkEquals(String longLink);

}
