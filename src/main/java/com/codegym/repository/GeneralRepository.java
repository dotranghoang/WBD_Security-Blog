package com.codegym.repository;

import java.util.List;

public interface GeneralRepository<E> {
    List<E> finAll();

    void save(E e);

    void remove(Long e);
}
