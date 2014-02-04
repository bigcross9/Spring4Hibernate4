package com.spring4.hibernate4.dao;

import java.util.List;

import com.spring4.hibernate4.model.Usuario;

public interface UsuariosDao {
	public void guardar(Usuario usuario);
	public List listado();
	public void borrar(int id);
}
