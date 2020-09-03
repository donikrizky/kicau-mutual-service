package com.donikrizky.kicau.mutualservice.service;

import java.util.List;

public interface ClientService {

	List<Integer> findMutualByUserId(Integer userId);

	Long findFavoriteCount(Integer itemId);

}
