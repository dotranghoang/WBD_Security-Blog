package com.codegym.repository;

import com.codegym.model.Blog;

public interface BlogRepository extends GeneralRepository<Blog> {
    Blog findById(Long id);
}
