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
import com.ciandt.DrinkStore.entity.History;
import com.ciandt.DrinkStore.entity.Section;
import com.ciandt.DrinkStore.entity.Storage;
import com.ciandt.DrinkStore.entity.User;
import com.ciandt.DrinkStore.exception.DrinkNotFoundException;
import com.ciandt.DrinkStore.exception.DrinkTypeNotFoundException;
import com.ciandt.DrinkStore.exception.InsufficientInventoryException;
import com.ciandt.DrinkStore.exception.InvalidDrinkTypeException;
import com.ciandt.DrinkStore.exception.SectionNotFoundException;
import com.ciandt.DrinkStore.exception.UnavailableException;
import com.ciandt.DrinkStore.exception.UserNotFoundException;
import com.ciandt.DrinkStore.mongo.Mongo;

@Service("storage")
public class StorageService {
	@Autowired
	private Mongo mongo;
	
	/**
	 * Encontrar o estoque.
	 * @author Gugatb
	 * @date 04/07/2018
	 * @param pParam1 o parâmetro
	 * @param pParam2 o parâmetro
	 * @param pParam3 o parâmetro
	 * @param pOperation a operação
	 * @return storages os estoques
	 */
	public List<Storage> find(String pParam1, String pParam2, double pParam3, int pOperation) {
		Document document1 = mongo.find(Collection.DRINK.getValue(), pParam1);
		Document document2 = mongo.find(Collection.DRINK_TYPE.getValue(), pParam2);
		List<Storage> storages = new ArrayList<Storage>();
		
		try {
			if (document1 != null) {
				if (document2 == null && pOperation == 0) {
					throw new DrinkTypeNotFoundException(
						Message.DRINK_TYPE_NOT_FOUND.getValue()
					);
				}
				
				// Definir o tipo de bebida.
				DrinkType drinkType = new DrinkType();
				drinkType.set(document2);
				
				// Encontrar o estoque disponível para adicionar tipo de bebida.
				for (Document document : mongo.find(Collection.STORAGE.getValue())) {
					Storage storage = new Storage();
					storage.set(document);
					
					if (drinkType.getCapacity() >= storage.getVolume() + pParam3 &&
						drinkType.getId() == storage.getDrinkType()) {
						storages.add(storage);
					}
				}
				
				/*
				 * Verificar o volume total em cada estoque antes de de verificar a disponibilidade.
				 * Encontrar o estoque disponível para remover uma bebida.
				 * Talvez utilizar a lógica de "disponível para adicionar" antes de adicionar novas bebidas?
				 */
			}
			else {
				throw new DrinkNotFoundException(
					Message.DRINK_NOT_FOUND.getValue()
				);
			}
		}
		catch (DrinkNotFoundException exception) {
			throw new DrinkNotFoundException(
				Message.DRINK_NOT_FOUND.getValue()
			);
		}
		catch (DrinkTypeNotFoundException exception) {
			throw new DrinkTypeNotFoundException(
				Message.DRINK_TYPE_NOT_FOUND.getValue()
			);
		}
		catch (Exception exception) {
			exception.printStackTrace();
			throw new UnavailableException(
				Message.UNAVAILABLE.getValue()
			);
		}
		return storages;
	}
	
	/**
	 * Configurar o estoque.
	 * @author Gugatb
	 * @date 13/05/2018
	 */
	public void setingUp() {
		// Configurar o tipo de bebida.
		if (mongo.find(Collection.DRINK_TYPE.getValue(), "alcoolicas") == null) {
			DrinkType drinkType = new DrinkType();
			drinkType.setCapacity(500.0d);
			drinkType.setName("alcoolicas");
			mongo.insert(Collection.DRINK_TYPE.getValue(), drinkType.get());
		}
		
		// Configurar o tipo de bebida.
		if (mongo.find(Collection.DRINK_TYPE.getValue(), "nao alcoolicas") == null) {
			DrinkType drinkType = new DrinkType();
			drinkType.setCapacity(400.0d);
			drinkType.setName("nao alcoolicas");
			mongo.insert(Collection.DRINK_TYPE.getValue(), drinkType.get());
		}
		
		// Definir a seção.
		if (mongo.find(Collection.SECTION.getValue(), "1") == null) {
			Section section = new Section();
			section.setName("1");
			mongo.insert(Collection.SECTION.getValue(), section.get());
		}
		
		// Definir a seção.
		if (mongo.find(Collection.SECTION.getValue(), "2") == null) {
			Section section = new Section();
			section.setName("2");
			mongo.insert(Collection.SECTION.getValue(), section.get());
		}
		
		// Definir a seção.
		if (mongo.find(Collection.SECTION.getValue(), "3") == null) {
			Section section = new Section();
			section.setName("3");
			mongo.insert(Collection.SECTION.getValue(), section.get());
		}
		
		// Definir a seção.
		if (mongo.find(Collection.SECTION.getValue(), "4") == null) {
			Section section = new Section();
			section.setName("4");
			mongo.insert(Collection.SECTION.getValue(), section.get());
		}
		
		// Definir a seção.
		if (mongo.find(Collection.SECTION.getValue(), "5") == null) {
			Section section = new Section();
			section.setName("5");
			mongo.insert(Collection.SECTION.getValue(), section.get());
		}
		
		// Definir o usuário.
		if (mongo.find(Collection.USER.getValue(), "usuario padrao") == null) {
			User user = new User();
			user.setName("usuario padrao");
			mongo.insert(Collection.USER.getValue(), user.get());
		}
	}
	
	/**
	 * Atualizar o estoque.
	 * @author Gugatb
	 * @date 13/05/2018
	 * @param pParam1 o parâmetro
	 * @param pParam2 o parâmetro
	 * @param pParam3 o parâmetro
	 * @param pParam4 o parâmetro
	 * @param pParam5 o parâmetro
	 * @param pOperation a operação
	 * @return entity a entidade
	 */
	public Storage update(String pParam1, String pParam2, String pParam3, String pParam4, double pParam5, int pOperation) {
		Document document1 = mongo.find(Collection.DRINK.getValue(), pParam1);
		Document document2 = mongo.find(Collection.DRINK_TYPE.getValue(), pParam2);
		Document document3 = mongo.find(Collection.SECTION.getValue(), pParam3);
		Document document4 = mongo.find(Collection.USER.getValue(), pParam4);
		Storage storage = new Storage();
		
		try {
			if (document1 != null) {
				if (document2 != null) {
					if (document3 != null) {
						if (document4 != null) {
							Drink drink = new Drink(document1);
							DrinkType drinkType = new DrinkType(document2);
							Section section = new Section(document3);
							User user = new User(document4);
							
							// Definir o estoque.
							storage = new Storage();
							storage.setDrink(drink.getId());
							storage.setDrinkType(drinkType.getId());
							storage.setName(drink, drinkType, section);
							storage.setSection(section.getId());
							storage.setVolume(pParam5);
							
							// Adicionar ou atualizar o estoque.
							Document document5 = mongo.find(Collection.STORAGE.getValue(), storage.getName());
							boolean createHistory = false;
							
							if (document5 != null) {
								Storage old = new Storage(document5);
								
								if (old.getDrinkType().equalsIgnoreCase(drinkType.getId())) {
									double result = pOperation == 0 ? old.getVolume() + pParam5 : old.getVolume() - pParam5;
									mongo.update(Collection.STORAGE.getValue(), storage.getName(), "volume", result);
									createHistory = true;
								}
								else {
									throw new InvalidDrinkTypeException(
										Message.INVALID_DRINK_TYPE.getValue()
									);
								}
							}
							else if (pOperation == 0) {
								mongo.insert(Collection.STORAGE.getValue(), storage.get());
								createHistory = true;
							}
							
							// Adicionar o histórico.
							if (createHistory) {
								History history = new History();
								history.setDate(new Date());
								history.setDrink(drink.getId());
								history.setDrinkType(drinkType.getId());
								history.setName(drink, drinkType, section);
								history.setSection(section.getId());
								history.setType(pOperation == 0 ? "buy" : "sell");
								history.setUser(user.getId());
								history.setVolume(pParam5);
								mongo.insert(Collection.HISTORY.getValue(), history.get());
							}
							else {
								throw new InsufficientInventoryException(
									Message.INSUFFICIENT_INVENTORY.getValue()
								);
							}
						}
						else {
							throw new UserNotFoundException(
								Message.USER_NOT_FOUND.getValue()
							);
						}
					}
					else {
						throw new SectionNotFoundException(
							Message.SECTION_NOT_FOUND.getValue()
						);
					}
				}
				else {
					throw new DrinkTypeNotFoundException(
						Message.DRINK_TYPE_NOT_FOUND.getValue()
					);
				}
			}
			else {
				throw new DrinkNotFoundException(
					Message.DRINK_NOT_FOUND.getValue()
				);
			}
		}
		catch (DrinkNotFoundException exception) {
			throw new DrinkNotFoundException(
				Message.DRINK_NOT_FOUND.getValue()
			);
		}
		catch (DrinkTypeNotFoundException exception) {
			throw new DrinkTypeNotFoundException(
				Message.DRINK_TYPE_NOT_FOUND.getValue()
			);
		}
		catch (InsufficientInventoryException exception) {
			throw new InsufficientInventoryException(
				Message.INSUFFICIENT_INVENTORY.getValue()
			);
		}
		catch (InvalidDrinkTypeException exception) {
			throw new InvalidDrinkTypeException(
				Message.INVALID_DRINK_TYPE.getValue()
			);
		}
		catch (NullPointerException | NumberFormatException exception) {
			throw new NumberFormatException();
		}
		catch (SectionNotFoundException exception) {
			throw new SectionNotFoundException(
				Message.SECTION_NOT_FOUND.getValue()
			);
		}
		catch (UserNotFoundException exception) {
			throw new UserNotFoundException(
				Message.USER_NOT_FOUND.getValue()
			);
		}
		catch (Exception exception) {
			exception.printStackTrace();
			throw new UnavailableException(
				Message.UNAVAILABLE.getValue()
			);
		}
		return storage;
	}
}
