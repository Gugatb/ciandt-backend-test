package com.ciandt.DrinkStore.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciandt.DrinkStore.constant.Collection;
import com.ciandt.DrinkStore.constant.Message;
import com.ciandt.DrinkStore.entity.User;
import com.ciandt.DrinkStore.exception.AlreadyExistingNameException;
import com.ciandt.DrinkStore.exception.NameNotFoundException;
import com.ciandt.DrinkStore.exception.UnavailableException;
import com.ciandt.DrinkStore.mongo.Mongo;

@Service("user")
public class UserService {
	@Autowired
	private Mongo mongo;
	
	/**
	 * Adicionar a entidade.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParam o parâmetro
	 * @return entity a entidade
	 */
	public User add(String pParam) {
		User user = new User();
		
		try {
			if (mongo.find(Collection.USER.getValue(), pParam) == null) {
				user.setDate(new Date());
				user.setName(pParam);
				mongo.insert(Collection.USER.getValue(), user.get());
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
		catch (Exception exception) {
			throw new UnavailableException(
				Message.UNAVAILABLE.getValue()
			);
		}
		return user;
	}
	
	/**
	 * Encontrar a entidade.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParam o parâmetro
	 * @return entity a entidade
	 */
	public User find(String pParam) {
		User user = new User();
		
		try {
			Document document = mongo.find(Collection.USER.getValue(), pParam);
			
			if (document != null) {
				user.set(document);
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
		return user;
	}
	
	/**
	 * Listar as entidades.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return entities as entidades
	 */
	public List<User> list() {
		List<User> users = new ArrayList<User>();
		
		try {
			for (Document document : mongo.find(Collection.USER.getValue())) {
				User user = new User();
				user.set(document);
				users.add(user);
			}
		}
		catch (Exception exception) {
			throw new UnavailableException(
				Message.UNAVAILABLE.getValue()
			);
		}
		return users;
	}
}
