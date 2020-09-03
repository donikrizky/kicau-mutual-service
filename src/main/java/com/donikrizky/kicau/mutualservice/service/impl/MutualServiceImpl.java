package com.donikrizky.kicau.mutualservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donikrizky.kicau.mutualservice.entity.Mutual;
import com.donikrizky.kicau.mutualservice.repository.MutualRepository;
import com.donikrizky.kicau.mutualservice.service.MutualService;

@Service
public class MutualServiceImpl implements MutualService {

	private MutualRepository mutualRepository;

	@Autowired
	MutualServiceImpl(MutualRepository mutualRepository) {
		this.mutualRepository = mutualRepository;
	}

	@Override
	public void follow(Integer userId, Integer followerId) {

		Mutual mutual = Mutual.builder().userId(userId).followerId(followerId).build();
		mutualRepository.save(mutual);
	}

}
