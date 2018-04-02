package com.atsistemas.polaris.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.atsistemas.orion.polaris.generated.api.PingApi;
import com.atsistemas.orion.polaris.generated.model.PingResponse;

import io.swagger.annotations.Api;

@Controller
@Api
public class PingController implements PingApi{

	@Override
	public ResponseEntity<PingResponse> pingGet(@Valid String message) {

		PingResponse pingResponse = new PingResponse();
		pingResponse.setId(UUID.randomUUID().toString());
		pingResponse.setResponseMessage("Hello from Polaris");
		return new ResponseEntity<PingResponse>(pingResponse,HttpStatus.OK);
	}

}
