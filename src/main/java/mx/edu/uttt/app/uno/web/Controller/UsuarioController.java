package mx.edu.uttt.app.uno.web.Controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.uttt.app.uno.web.Model.Usuario;
import mx.edu.uttt.app.uno.web.Model.Dao.IUsuarioDao;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private IUsuarioDao iUsuairo;
	
	
	@GetMapping("/")
	private List<Usuario> allUsuario() {
		return iUsuairo.allUsers();
	}
	
@PostMapping("/formSave")	
private void saveUsuario(@Validated @RequestBody Usuario usuario) {
	iUsuairo.saveUser(usuario);	
	}
	
@PutMapping("/formActu/{id}")	
private void updateUsuario(@PathVariable String id,@Validated @RequestBody Usuario usuario) {
    int idU=Integer.parseInt(id);
	iUsuairo.updateUser(idU,usuario);	
	}

@DeleteMapping("/formDelete/{id}")
private void deleteUser(@PathVariable String id) {
	
	int idU=Integer.parseInt(id);
	iUsuairo.deleteUser(idU);	
}

@GetMapping("/SearchBy/{id}")
private Usuario SearchUser(@PathVariable String id) {
	int idU=Integer.parseInt(id);
	return iUsuairo.getUserById(idU);	
}



}
