package com.blog.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blog.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

   public List<Post> findByTitleContainingIgnoreCase(String title);

}
