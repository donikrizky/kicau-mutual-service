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
import com.donikrizky.kicau.mutualservice.service.FavoriteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Favorite Management System")
@RestController
@Validated
public class FavoriteController extends CommonResource {

	@Autowired
	private TokenProvider tokenProvider;

	@Autowired
	private FavoriteService favoriteService;

	@ApiOperation(value = "User favorite an item", response = ResponseEntity.class)
	@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Bearer <access_token>")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully favorite an item"),
			@ApiResponse(code = 401, message = "Full authentication is required to access this resource"), })
	@PostMapping(value = "/favorite")
	public ResponseEntity<ResponseBody> followUser(@RequestParam Integer itemId, HttpServletRequest request) {
		LOGGER.info("User favorite an item");

		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		Integer userId = tokenProvider.getUserIdFromToken(getToken(header));

		favoriteService.favorite(userId, itemId);
		return ResponseEntity.ok(getResponseBody(HttpStatus.OK.value(), "Successfully favorite an item : " + itemId,
				request.getRequestURI()));

	}
}
