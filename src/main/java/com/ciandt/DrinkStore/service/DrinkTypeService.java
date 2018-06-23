package com.ciandt.DrinkStore.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciandt.DrinkStore.constant.Collection;
import com.ciandt.DrinkStore.constant.Message;
import com.ciandt.DrinkStore.entity.DrinkType;
import com.ciandt.DrinkStore.exception.AlreadyExistingNameException;
import com.ciandt.DrinkStore.exception.NameNotFoundException;
import com.ciandt.DrinkStore.exception.UnavailableException;
import com.ciandt.DrinkStore.mongo.Mongo;

@Service("drinkType")
public class DrinkTypeService {
	@Autowired
	private Mongo mongo;
	
	/**
	 * Adicionar a entidade.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParam1 o parâmetro
	 * @param pParam2 o parâmetro
	 * @return entity a entidade
	 */
	public DrinkType add(String pParam1, double pParam2) {
		DrinkType drinkType = new DrinkType();
		
		try {
			if (mongo.find(Collection.DRINK_TYPE.getValue(), pParam1) == null) {
				drinkType.setCapacity(pParam2);
				drinkType.setDate(new Date());
				drinkType.setName(pParam1);
				mongo.insert(Collection.DRINK_TYPE.getValue(), drinkType.get());
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
		catch (NullPointerException | NumberFormatException exception) {
			throw new NumberFormatException();
		}
		catch (Exception exception) {
			throw new UnavailableException(
				Message.UNAVAILABLE.getValue()
			);
		}
		return drinkType;
	}
	
	/**
	 * Encontrar a entidade.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParam o parâmetro
	 * @return entity a entidade
	 */
	public DrinkType find(String pParam) {
		DrinkType drinkType = new DrinkType();
		
		try {
			Document document = mongo.find(Collection.DRINK_TYPE.getValue(), pParam);
			
			if (document != null) {
				drinkType.set(document);
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
		return drinkType;
	}
	
	/**
	 * Listar as entidades.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return entities as entidades
	 */
	public List<DrinkType> list() {
		List<DrinkType> drinkTypes = new ArrayList<DrinkType>();
		
		try {
			for (Document document : mongo.find(Collection.DRINK_TYPE.getValue())) {
				DrinkType drinkType = new DrinkType();
				drinkType.set(document);
				drinkTypes.add(drinkType);
			}
		}
		catch (Exception exception) {
			throw new UnavailableException(
				Message.UNAVAILABLE.getValue()
			);
		}
		return drinkTypes;
	}
}
