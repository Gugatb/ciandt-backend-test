package com.ciandt.DrinkStore.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciandt.DrinkStore.constant.Collection;
import com.ciandt.DrinkStore.constant.Message;
import com.ciandt.DrinkStore.entity.Drink;
import com.ciandt.DrinkStore.entity.DrinkType;
import com.ciandt.DrinkStore.exception.AlreadyExistingNameException;
import com.ciandt.DrinkStore.exception.DrinkTypeNotFoundException;
import com.ciandt.DrinkStore.exception.NameNotFoundException;
import com.ciandt.DrinkStore.exception.UnavailableException;
import com.ciandt.DrinkStore.mongo.Mongo;

@Service("drink")
public class DrinkService {
	@Autowired
	private Mongo mongo;
	
	/**
	 * Adicionar a entidade.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParam1 o parâmetro
	 * @param pParam2 o parâmetro
	 * @param pParam3 o parâmetro
	 * @return entity a entidade
	 */
	public Drink add(String pParam1, String pParam2, double pParam3) {
		Drink drink = new Drink();
		
		try {
			if (mongo.find(Collection.DRINK.getValue(), pParam1) == null) {
				Document document = mongo.find(Collection.DRINK_TYPE.getValue(), pParam2);
				
				if (document != null) {
					DrinkType drinkType = new DrinkType();
					drinkType.set(document);
					drink.setPrice(pParam3);
					drink.setDate(new Date());
					drink.setName(pParam1);
					drink.setType(drinkType.getId());
					mongo.insert(Collection.DRINK.getValue(), drink.get());
				}
				else {
					throw new DrinkTypeNotFoundException(
						Message.DRINK_TYPE_NOT_FOUND.getValue()
					);
				}
			}
			else {
				throw new AlreadyExistingNameException(
					Message.ALREADY_NAME_EXISTING.getValue()
				);
			}
		}
		catch (AlreadyExistingNameException exception) {
			throw new AlreadyExistingNameException(
				Message.ALREADY_NAME_EXISTING.getValue()
			);
		}
		catch (DrinkTypeNotFoundException exception) {
			throw new DrinkTypeNotFoundException(
				Message.DRINK_TYPE_NOT_FOUND.getValue()
			);
		}
		catch (NullPointerException | NumberFormatException exception) {
			throw new NumberFormatException();
		}
		catch (Exception exception) {
			throw new UnavailableException(
				Message.UNAVAILABLE.getValue()
			);
		}
		return drink;
	}
	
	/**
	 * Encontrar a entidade.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParam o parâmetro
	 * @return entity a entidade
	 */
	public Drink find(String pParam) {
		Drink drink = new Drink();
		
		try {
			Document document = mongo.find(Collection.DRINK.getValue(), pParam);
			
			if (document != null) {
				drink.set(document);
			}
			else {
				throw new NameNotFoundException(
					Message.NAME_NOT_FOUND.getValue()
				);
			}
		}
		catch (NameNotFoundException exception) {
			throw new NameNotFoundException(
				Message.NAME_NOT_FOUND.getValue()
			);
		}
		catch (Exception exception) {
			throw new UnavailableException(
				Message.UNAVAILABLE.getValue()
			);
		}
		return drink;
	}
	
	/**
	 * Listar as entidades.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return entities as entidades
	 */
	public List<Drink> list() {
		List<Drink> drinks = new ArrayList<Drink>();
		
		try {
			for (Document document : mongo.find(Collection.DRINK.getValue())) {
				Drink drink = new Drink();
				drink.set(document);
				drinks.add(drink);
			}
		}
		catch (Exception exception) {
			throw new UnavailableException(
				Message.UNAVAILABLE.getValue()
			);
		}
		return drinks;
	}
}
