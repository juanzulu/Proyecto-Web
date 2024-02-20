package com.example.demo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.gato;

@Repository
public class GatoRepository {

    private Map<Integer, gato> gaterio = new HashMap<>();

    public GatoRepository() {
        gaterio.put(1, new gato("Michi", "Gato", 2,
                "https://www.mirringo.com.co/Portals/mirringo/contenidos/razas/banner-interna-razas.jpg?ver="));
        gaterio.put(2, new gato("Gato", "Persa,", 3,
                "https://www.zooplus.es/magazine/wp-content/uploads/2017/10/fotolia_103481419.jpg"));
        gaterio.put(3, new gato("Felis silvestris catus", "Maine Coon", 5,
                "https://www.zooplus.es/magazine/wp-content/uploads/2018/08/maine-coon-3.jpg"));
        gaterio.put(4, new gato("Thomas", "Russian Blue", 83,
                "https://i.pinimg.com/originals/1f/2d/4f/1f2d4fa68799ba91ff4787cfe18aaee1.jpg"));
    }

    public gato findbyid(int id) {
        return gaterio.get(id);
    }

    public Collection<gato> findAll() {
        return gaterio.values();
    }
}
