package mx.edu.uttt.app.uno.web.Model.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mx.edu.uttt.app.uno.web.Model.Usuario;

@Repository
public interface IUsuarioDao {

	public List<Usuario>allUsers();
	public void saveUser(Usuario usuario);
	public void deleteUser(int idUsuario);
	public void updateUser(int id,Usuario usuario);
	public Usuario getUserById(int idUsuario);
}
