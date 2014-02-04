package com.spring4.hibernate4.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.spring4.hibernate4.persistence.HibernateUtil;
import com.spring4.hibernate4.dao.UsuariosDao;
import com.spring4.hibernate4.model.Usuario;

public class UsuariosHibernate implements UsuariosDao {
	  Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public void guardar(Usuario usuario){
		// TODO Auto-generated method stub
		try{
			session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();
		}finally{
			session.close();
		}
	}
	@Override
	public List listado() {
		// TODO Auto-generated method stub
		Criteria cr = session.createCriteria(Usuario.class);
		List usuarios = cr.list();
		return usuarios;
	}

	@Override
	public void borrar(int id) {
		// TODO Auto-generated method stub

	}

}
