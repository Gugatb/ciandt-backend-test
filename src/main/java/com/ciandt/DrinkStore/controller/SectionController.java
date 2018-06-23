package com.ciandt.DrinkStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.DrinkStore.constant.Message;
import com.ciandt.DrinkStore.entity.Response;
import com.ciandt.DrinkStore.exception.AlreadyExistingNameException;
import com.ciandt.DrinkStore.exception.NameNotFoundException;
import com.ciandt.DrinkStore.exception.UnavailableException;
import com.ciandt.DrinkStore.service.SectionService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
@RequestMapping("/section")
public class SectionController {
	@Autowired
	private SectionService service;
	
	/**
	 * Executar o serviço.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParam o parâmetro
	 * @param pType o tipo
	 * @return response a resposta
	 */
	private ResponseEntity execute(String pParam, int pType) {
		Response response = new Response();
		
		try {
			if (pType == 0) {
				response.setResponse(service.add(pParam));
			}
			else if (pType == 1) {
				response.setResponse(service.find(pParam));
			}
			else if (pType == 2) {
				response.setResponse(service.list());
			}
		}
		catch (AlreadyExistingNameException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				Message.ALREADY_NAME_EXISTING.getValue()
			);
		}
		catch (NameNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				Message.NAME_NOT_FOUND.getValue()
			);
		}
		catch (UnavailableException exception) {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(
				Message.UNAVAILABLE.getValue()
			);
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	/**
	 * Adicionar a seção.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pName o nome
	 * @return response a resposta
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity add(
		@RequestBody String params) {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(params).getAsJsonObject();
		String name = json.get("name").getAsString();
		return execute(name, 0);
	}
	
	/**
	 * Encontrar a seção.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParams os parâmetros
	 * @return response a resposta
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ResponseEntity find(
		@PathVariable("name")String name) {
		return execute(name, 1);
	}
	
	/**
	 * Listar as seções.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return response a resposta
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity list() {
		return execute("", 2);
	}
}
