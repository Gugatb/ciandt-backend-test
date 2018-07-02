package com.ciandt.DrinkStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.DrinkStore.constant.Message;
import com.ciandt.DrinkStore.entity.Response;
import com.ciandt.DrinkStore.exception.AlreadyExistingNameException;
import com.ciandt.DrinkStore.exception.DrinkNotFoundException;
import com.ciandt.DrinkStore.exception.DrinkTypeNotFoundException;
import com.ciandt.DrinkStore.exception.InsufficientInventoryException;
import com.ciandt.DrinkStore.exception.InvalidDrinkTypeException;
import com.ciandt.DrinkStore.exception.NameNotFoundException;
import com.ciandt.DrinkStore.exception.SectionNotFoundException;
import com.ciandt.DrinkStore.exception.UnavailableException;
import com.ciandt.DrinkStore.exception.UserNotFoundException;
import com.ciandt.DrinkStore.service.StorageService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
@RequestMapping("/storage")
public class StorageController {
	@Autowired
	private StorageService service;
	
	/**
	 * Executar o serviço.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParam1 o parâmetro
	 * @param pParam2 o parâmetro
	 * @param pParam3 o parâmetro
	 * @param pParam4 o parâmetro
	 * @param pParam5 o parâmetro
	 * @param pType o tipo
	 * @return response a resposta
	 */
	private ResponseEntity execute(String pParam1, String pParam2, String pParam3, String pParam4, double pParam5, int pType) {
		Response response = new Response();
		
		try {
			if (pType == 0) {
				service.setingUp();
				response.setResponse("Configuracao executada com sucesso");
			}
			else if (pType == 1) {
				response.setResponse(service.update(pParam1, pParam2, pParam3, pParam4, pParam5, 0));
			}
			else if (pType == 2) {
				response.setResponse(service.update(pParam1, pParam2, pParam3, pParam4, pParam5, 1));
			}
		}
		catch (AlreadyExistingNameException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				Message.ALREADY_NAME_EXISTING.getValue()
			);
		}
		catch (DrinkNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				Message.DRINK_NOT_FOUND.getValue()
			);
		}
		catch (DrinkTypeNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				Message.DRINK_TYPE_NOT_FOUND.getValue()
			);
		}
		catch (NameNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				Message.NAME_NOT_FOUND.getValue()
			);
		}
		catch (InvalidDrinkTypeException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				Message.INVALID_DRINK_TYPE.getValue()
			);
		}
		catch (NumberFormatException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				Message.INVALID_REQUEST_FORMAT.getValue()
			);
		}
		catch (InsufficientInventoryException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				Message.INSUFFICIENT_INVENTORY.getValue()
			);
		}
		catch (SectionNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				Message.SECTION_NOT_FOUND.getValue()
			);
		}
		catch (UserNotFoundException exception) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				Message.USER_NOT_FOUND.getValue()
			);
		}
		catch (UnavailableException exception) {
			exception.printStackTrace();
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(
				Message.UNAVAILABLE.getValue()
			);
		}
		return new ResponseEntity(response, HttpStatus.OK);
	}
	
	/**
	 * Comprar a bebida.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParams os parâmetros
	 * @return response a resposta
	 */
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public ResponseEntity buy(
		@RequestBody String params) {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(params).getAsJsonObject();
		String drink = json.get("drink").getAsString();
		String drinkType = json.get("drink_type").getAsString();
		String section = json.get("section").getAsString();
		String user = json.get("user").getAsString();
		double volume = json.get("volume").getAsDouble();
		return execute(drink, drinkType, section, user, volume, 1);
	}
	
	/**
	 * Vender a bebida.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParams os parâmetros
	 * @return response a resposta
	 */
	@RequestMapping(value = "/sell", method = RequestMethod.POST)
	public ResponseEntity sell(
		@RequestBody String params) {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(params).getAsJsonObject();
		String drink = json.get("drink").getAsString();
		String drinkType = json.get("drink_type").getAsString();
		String section = json.get("section").getAsString();
		String user = json.get("user").getAsString();
		double volume = json.get("volume").getAsDouble();
		return execute(drink, drinkType, section, user, volume, 2);
	}
	
	/**
	 * Configurar o estoque.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return response a resposta
	 */
	@RequestMapping(value = "/seting_up", method = RequestMethod.GET)
	public ResponseEntity setUp() {
		return execute("", "", "", "", 0, 0);
	}
}
