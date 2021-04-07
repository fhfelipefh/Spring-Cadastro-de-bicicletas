package com.registerbicycle.register_bicycle.api;

import com.registerbicycle.register_bicycle.domain.BikeModel;
import com.registerbicycle.register_bicycle.service.BikeService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bikes")
public class BikeController {

    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
       this.bikeService = bikeService;
    }

    //listar uma bike cadastrada por ID GET
    @GetMapping("/{id}")
    public ResponseEntity<BikeModel> obter(@PathVariable Long id) {
        Optional<BikeModel> bikeOptional = bikeService.obter(id);
        if (bikeOptional.isPresent()) {
            return ResponseEntity.ok(bikeOptional.get());
        }
        return ResponseEntity.noContent().build();
    }

    //obter modelo por modelo
   @GetMapping("")
    public ResponseEntity<List<BikeModel>> obter(@RequestParam String Model) {
       return ResponseEntity.ok(bikeService.obterPorModelo(Model));
   }


    //listar todas as bikes cadastradas GET
    @GetMapping(params = {"page", "size"})
    public ResponseEntity<List<BikeModel>> listar(@RequestParam("page") Integer page,
                                                   @RequestParam("size") Integer size) {
        return ResponseEntity.ok(bikeService.listar(page, size).getContent());
    }

    //deletar uma bike DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<BikeModel> excluir(@PathVariable Long id) {
        bikeService.excluir(id);
        return ResponseEntity.ok().build();
    }

    //atualizar todas as informações da bike PUT
    @PutMapping("/{id}")
    public ResponseEntity<BikeModel> atualizar(@PathVariable Long id,
                                                @RequestBody BikeModel bikeinf) {
        return ResponseEntity.ok(bikeService.atualizar(id, bikeinf));
    }

    //Criar uma bike POST
    @PostMapping("/")
    public ResponseEntity<BikeModel> incluir(@RequestBody BikeModel bikeinf) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bikeService.incluir(bikeinf));
    }

    //PATCH atualizar alguma informação
    @PatchMapping("/{id}")
    public void editprice(@PathVariable("id") Long id, @RequestBody BikeModel price){
        bikeService.editprice(id, price);

    }


}

