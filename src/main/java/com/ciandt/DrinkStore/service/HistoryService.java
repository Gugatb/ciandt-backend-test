package com.ciandt.DrinkStore.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciandt.DrinkStore.constant.Collection;
import com.ciandt.DrinkStore.constant.Message;
import com.ciandt.DrinkStore.entity.History;
import com.ciandt.DrinkStore.exception.UnavailableException;
import com.ciandt.DrinkStore.mongo.Mongo;

@Service("history")
public class HistoryService {
	@Autowired
	private Mongo mongo;
	
	/**
	 * Listar as entidades.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return entities as entidades
	 */
	public List<History> list() {
		List<History> historys = new ArrayList<History>();
		
		try {
			for (Document document : mongo.find(Collection.HISTORY.getValue())) {
				History history = new History();
				history.set(document);
				historys.add(history);
			}
		}
		catch (Exception exception) {
			throw new UnavailableException(
				Message.UNAVAILABLE.getValue()
			);
		}
		return historys;
	}
}
