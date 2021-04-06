package com.registerbicycle.register_bicycle.service;

import com.registerbicycle.register_bicycle.domain.BikeModel;
import com.registerbicycle.register_bicycle.domain.BikeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import com.registerbicycle.register_bicycle.exeption.BikeException;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public Optional<BikeModel> obter(Long id){
        return this.bikeRepository.findById(id);
    }

    //incluir
    public BikeModel incluir(BikeModel bikeinf) {
        if (bikeinf.getId() != null) {
            throw new BikeException("Bike", "incluir", bikeinf.getId());
        }
        return this.bikeRepository
                .save(bikeinf);
    }
    //


    //listar
    public Page<BikeModel> listar(Integer page, Integer size) {
        return this.bikeRepository
                .findAll(
                        PageRequest.of(page, size, Sort.by("Model").descending().and(Sort.by("price"))));
    }
    //excluir
    public void excluir(Long id) {
        this.bikeRepository.deleteById(id);
    }

    //Listar
    public List<BikeModel> obterPorNome(String nome) {
        return this.bikeRepository
                .findAllByModelContaining(nome);
    }

    //PUT
    public BikeModel atualizar(Long id, BikeModel bikeinf) {
        BikeModel bikeatualizada = obter(id)
                .orElseThrow(() -> new BikeException("Bike", "atualizar", id));
        bikeatualizada.setName_of_the_store_where_you_bought_it(bikeinf.getName_of_the_store_where_you_bought_it());
        return this.bikeRepository.save(bikeatualizada);
    }

    //obter por modelo
       public List<BikeModel> obterPorModelo(String Model) {
        return this.bikeRepository
                .findAllByModelContaining(Model);
    }

    //patch
    public BikeModel editprice(Long id, BikeModel price) {
       final BikeModel newprice =
               bikeRepository.findById(id).orElseThrow(() -> new RuntimeException("preço não encontrado"));
       newprice.setPrice(price.getPrice());
      return bikeRepository.save(newprice);
    }



}
