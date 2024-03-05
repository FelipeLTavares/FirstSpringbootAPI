package com.blog.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blog.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}