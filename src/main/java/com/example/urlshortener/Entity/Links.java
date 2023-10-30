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
    private String shortLink;
    @Column(name = "long_link")
    private String longLink;

}
