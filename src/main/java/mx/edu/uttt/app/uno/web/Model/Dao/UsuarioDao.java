package mx.edu.uttt.app.uno.web.Model.Dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.uttt.app.uno.web.Model.Usuario;

@Repository
public class UsuarioDao implements IUsuarioDao{

	
	@PersistenceContext
	private EntityManager entityU;
	
	@Override
	public List<Usuario> allUsers() {
		// Retorna todos los usuarios de la base de datos
		return (List<Usuario>) entityU.createQuery("from Usuario").getResultList();
	}

	@Override
	@Transactional
	public void saveUser(Usuario usuario) {
		entityU.persist(usuario);
		entityU.close();
	}

	@Override
	@Transactional
	public void deleteUser(int idUsuario) {
		Usuario usuario =entityU.find(Usuario.class, idUsuario);
		
		if(usuario.getIdUser() !=0) {
			entityU.remove(usuario);
			entityU.close();	
		}
		
	}

	@Override
	@Transactional
	public void updateUser(int id,Usuario usuario) {
		// TODO Auto-generated method stub
		if(entityU.find(Usuario.class, id)!=null) {		
			entityU.merge(usuario);
			entityU.close();
		}else {
			
		}
		
	}

	@Override
	public Usuario getUserById(int idUsuario) {
		
		return (Usuario) entityU.find(Usuario.class, idUsuario);
	}

}
