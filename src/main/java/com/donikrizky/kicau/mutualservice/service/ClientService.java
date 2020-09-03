package com.donikrizky.kicau.mutualservice.service;

import java.util.List;

public interface ClientService {

	public List<Integer> findMutualByUserId(Integer userId);

	public Long findFavoriteCount(Integer itemId);

}
