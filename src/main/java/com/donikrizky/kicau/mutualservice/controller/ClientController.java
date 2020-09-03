package com.donikrizky.kicau.mutualservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donikrizky.kicau.mutualservice.service.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(value = "Mutual Client Management System")
@RestController
@Validated
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@ApiOperation(value = "Find Followed Id By User Id From Client Instance", response = ResponseEntity.class)
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer <access_token>")
	@GetMapping("/mutual/{userId}")
	public List<Integer> findById(@PathVariable("userId") Integer userId) {
		return clientService.findMutualByUserId(userId);

	}
	
	@ApiOperation(value = "Find The Favorite Count of Item Id From Client Instance", response = ResponseEntity.class)
    @ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer <access_token>")
	@GetMapping("/favorite/{itemId}")
	public Long findFavoriteCount(@PathVariable("itemId") Integer itemId) {
		return clientService.findFavoriteCount(itemId);

	}
}
