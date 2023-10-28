package com.example.urlshortener.Entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "links")
public class Links {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String shortLink;
    @Column(name = "long_link")
    private String longLink;
    public Links(String value){
        this.longLink = value;
        this.shortLink = value.substring(0,10);
    }

}
