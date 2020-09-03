package com.donikrizky.kicau.mutualservice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donikrizky.kicau.mutualservice.common.CommonResource;
import com.donikrizky.kicau.mutualservice.common.ResponseBody;
import com.donikrizky.kicau.mutualservice.security.TokenProvider;
import com.donikrizky.kicau.mutualservice.service.MutualService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Mutual Management System")
@RestController
@Validated
public class MutualController extends CommonResource {

	@Autowired
	private TokenProvider tokenProvider;

	@Autowired
	private MutualService mutualService;

	@ApiOperation(value = "User follow other user", response = ResponseEntity.class)
	@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer <access_token>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully follow user"),
			@ApiResponse(code = 401, message = "Full authentication is required to access this resource"), })
	@PostMapping(value = "/follow")
	public ResponseEntity<ResponseBody> followUser(@RequestParam Integer userId, HttpServletRequest request) {
		LOGGER.info("User follow other user");

		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		Integer followerId = tokenProvider.getUserIdFromToken(getToken(header));

		mutualService.follow(userId, followerId);
		return ResponseEntity.ok(getResponseBody(HttpStatus.OK.value(), "Successfully follow userId : " + userId,
				request.getRequestURI()));

	}
}
