package com.example.backend.Controllers;

import com.example.backend.Models.BarbeiroModel;
import com.example.backend.RecordDto.BarbeiroRecordDto;
import com.example.backend.Repositories.BarbeiroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class BarbeiroController {
    @Autowired
    BarbeiroRepository barbeiroRepository;

    @PostMapping("/barbeiros")
    public ResponseEntity<BarbeiroModel> createBarbeiro(@RequestBody @Valid BarbeiroRecordDto barbeiroRecordDto){
        var barbeiroModel = new BarbeiroModel();
        BeanUtils.copyProperties(barbeiroRecordDto, barbeiroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(barbeiroRepository.save(barbeiroModel));
    }

    @GetMapping("/barbeiros")
    public ResponseEntity<List<BarbeiroModel>> getBarbeiroAll(){
        return ResponseEntity.status(HttpStatus.OK).body(barbeiroRepository.findAll());
    }

    @GetMapping("/barbeiros/{id}")
    public ResponseEntity<Object> getOneBarbeiro(@PathVariable(value="id") UUID id){
        Optional<BarbeiroModel> barbeiroO = barbeiroRepository.findById(id);
        if(barbeiroO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Barbeiro não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(barbeiroO.get());
    }

    @PutMapping("/barbeiros/{id}")
    public ResponseEntity<Object> updateBarbeiro(@RequestBody @Valid BarbeiroRecordDto barbeiroRecordDto,
                                                 @PathVariable(value="id") UUID id){
        Optional<BarbeiroModel> barbeiroO = barbeiroRepository.findById(id);
        if(barbeiroO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Barbeiro não encontrado");
        }
        var barbeiroModel = barbeiroO.get();
        BeanUtils.copyProperties(barbeiroRecordDto, barbeiroModel);
        return ResponseEntity.status(HttpStatus.OK).body(barbeiroRepository.save(barbeiroModel));
    }

    @DeleteMapping("/barbeiros/{id}")
    public ResponseEntity<Object> deleteBarbeiro(@PathVariable(value="id") UUID id){
        Optional<BarbeiroModel> barbeiroO = barbeiroRepository.findById(id);
        if(barbeiroO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Barbeiro não encontrado");
        }
        barbeiroRepository.delete(barbeiroO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Barbeiro excluído com sucesso");
    }


}
