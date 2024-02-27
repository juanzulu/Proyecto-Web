package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.Usuario;
import com.example.demo.entity.gato;


@Repository
public class UsuarioRepository {

    private Map<Integer, Usuario> usuarios = new HashMap<>();

    
    
    
    public UsuarioRepository() {

        List<gato> mascotas = new ArrayList<gato>();
        mascotas.add( new gato(1, "Michaki", "Gato", 2, "https://www.mirringo.com.co/Portals/mirringo/contenidos/razas/banner-interna-razas.jpg?ver="));
        mascotas.add( new gato(2, "Gato", "Persa", 3, "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/fotolia_103481419.jpg"));
        mascotas.add( new gato(3, "Felis silvestris catus", "Maine Coon", 5, "https://www.zooplus.es/magazine/wp-content/uploads/2018/08/maine-coon-3.jpg"));

        usuarios.put(1, new Usuario(1, "Juan", "Masculino", 25, 123456789, "Juan@gmail.com", mascotas));
        usuarios.put(2, new Usuario(2, "Maria", "Femenino", 30, 987654321, "maria@gmail.com", mascotas));
}

    public Usuario findbyid(int id) {
        return usuarios.get(id);
    }

    public Collection<Usuario> findAll() {
        return usuarios.values();
    }

    public void deleletebyid(int id) {
        usuarios.remove(id);
    }

    public void update(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }

    public void add(Usuario usuario) {
        int tam = usuarios.size();
        int lastid = usuarios.get(tam).getId();
        usuario.setId(lastid + 1);
        usuarios.put(usuario.getId(), usuario);

    }

}
