package com.ciandt.DrinkStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.DrinkStore.constant.Message;
import com.ciandt.DrinkStore.entity.Response;
import com.ciandt.DrinkStore.exception.UnavailableException;
import com.ciandt.DrinkStore.service.HistoryService;

@RestController
@RequestMapping("/history")
public class HistoryController {
	@Autowired
	private HistoryService service;
	
	/**
	 * Executar o serviço.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return response a resposta
	 */
	private ResponseEntity execute() {
		Response response = new Response();
		
		try {
			response.setResponse(service.list());
		}
		catch (UnavailableException exception) {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(
				Message.UNAVAILABLE.getValue()
			);
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	/**
	 * Listar os usuários.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return response a resposta
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity list() {
		return execute();
	}
}
