package com.donikrizky.kicau.mutualservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donikrizky.kicau.mutualservice.entity.Favorite;
import com.donikrizky.kicau.mutualservice.repository.FavoriteRepository;
import com.donikrizky.kicau.mutualservice.service.FavoriteService;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	private FavoriteRepository favoriteRepository;

	@Autowired
	FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
		this.favoriteRepository = favoriteRepository;
	}

	@Override
	public void favorite(Integer userId, Integer itemId) {

		Favorite favorite = Favorite.builder().userId(userId).itemId(itemId).build();
		favoriteRepository.save(favorite);
	}

}
