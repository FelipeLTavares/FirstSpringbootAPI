package com.blog.blog.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blog.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

   public Page<Post> findByTitleContainingIgnoreCase(String title, Pageable pageable);

}
