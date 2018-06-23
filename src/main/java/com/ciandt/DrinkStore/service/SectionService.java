package com.ciandt.DrinkStore.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciandt.DrinkStore.constant.Collection;
import com.ciandt.DrinkStore.constant.Message;
import com.ciandt.DrinkStore.entity.Section;
import com.ciandt.DrinkStore.exception.AlreadyExistingNameException;
import com.ciandt.DrinkStore.exception.NameNotFoundException;
import com.ciandt.DrinkStore.exception.UnavailableException;
import com.ciandt.DrinkStore.mongo.Mongo;

@Service("section")
public class SectionService {
	@Autowired
	private Mongo mongo;
	
	/**
	 * Adicionar a entidade.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParam o parâmetro
	 * @return entity a entidade
	 */
	public Section add(String pParam) {
		Section section = new Section();
		
		try {
			if (mongo.find(Collection.SECTION.getValue(), pParam) == null) {
				section.setDate(new Date());
				section.setName(pParam);
				mongo.insert(Collection.SECTION.getValue(), section.get());
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
		return section;
	}
	
	/**
	 * Encontrar a entidade.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParam o parâmetro
	 * @return entity a entidade
	 */
	public Section find(String pParam) {
		Section section = new Section();
		
		try {
			Document document = mongo.find(Collection.SECTION.getValue(), pParam);
			
			if (document != null) {
				section.set(document);
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
		return section;
	}
	
	/**
	 * Listar as entidades.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @return entities as entidades
	 */
	public List<Section> list() {
		List<Section> sections = new ArrayList<Section>();
		
		try {
			for (Document document : mongo.find(Collection.SECTION.getValue())) {
				Section section = new Section();
				section.set(document);
				sections.add(section);
			}
		}
		catch (Exception exception) {
			throw new UnavailableException(
				Message.UNAVAILABLE.getValue()
			);
		}
		return sections;
	}
}
