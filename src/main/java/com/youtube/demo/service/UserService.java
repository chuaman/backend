package com.youtube.demo.service;

import java.util.List;

import com.youtube.demo.model.User;

public interface UserService {

	/**
	 * Guardar usuario
	 * @param user
	 * @return  el usuario guardado
	 */
	User save(User user);

	/**
	 * REcupera Lista de Usuarios
	 * @return lista de Usuarios
	 */
	List<User> finAll();

	/**
	 * Elimina un id recibidos
	 * @param id
	 */
	void deleteUser(Long id);
	


}
