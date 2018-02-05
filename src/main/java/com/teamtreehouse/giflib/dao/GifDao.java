package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Gif;

import java.util.List;

public interface GifDao {
    List<Gif> findAll();
    List<Gif> search(String q);
    Gif findById(Long id);
    void save(Gif gif);
    void delete(Gif gif);
    void update(Gif gif);
}
