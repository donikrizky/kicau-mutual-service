package com.donikrizky.kicau.mutualservice.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donikrizky.kicau.mutualservice.repository.FavoriteRepository;
import com.donikrizky.kicau.mutualservice.repository.MutualRepository;
import com.donikrizky.kicau.mutualservice.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	private MutualRepository mutualRepository;
	private FavoriteRepository favoriteRepository;

	@Autowired
	ClientServiceImpl(MutualRepository mutualRepository, FavoriteRepository favoriteRepository) {
		this.mutualRepository = mutualRepository;
		this.favoriteRepository = favoriteRepository;
	}

	@Override
	public List<Integer> findMutualByUserId(Integer userId) {
		return mutualRepository.findUserByFollowerId(userId).orElse(Arrays.asList());
	}

	@Override
	public Long findFavoriteCount(Integer itemId) {
		return favoriteRepository.countByItemId(itemId);
	}

}
