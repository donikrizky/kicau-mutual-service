package com.donikrizky.kicau.mutualservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.donikrizky.kicau.mutualservice.entity.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

	Long countByItemId(Integer itemId);
}
