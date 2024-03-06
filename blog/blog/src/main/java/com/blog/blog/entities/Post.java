package com.blog.blog.entities;

import com.blog.blog.dtos.Post.CreatePostDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;

@Entity(name = "posts")
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String body;

    @JoinColumn(name = "userId")
    private Integer userId;

    public Post(CreatePostDto postData) {
        this.title = postData.title();
        this.body = postData.body();
        this.userId = Integer.parseInt(postData.userId());
    }

}
