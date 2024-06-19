package com.example.backend.Controllers;

import com.example.backend.Models.ClienteModel;
import com.example.backend.RecordDto.ClienteRecordDto;
import com.example.backend.Repositories.ClienteRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping("/clientes")
    public ResponseEntity<ClienteModel> create(@RequestBody @Valid ClienteRecordDto clienteRecordDto){
        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteRecordDto, clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(clienteModel));
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteModel>> getClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.findAll());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Object> getOneCliente(@PathVariable(value="id") UUID id){
        Optional<ClienteModel> clienteO = clienteRepository.findById(id);
        if(clienteO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteO.get());
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Object> updateClientes(@PathVariable(value = "id")UUID id,
                                                 @RequestBody @Valid ClienteRecordDto clienteRecordDto){
        Optional<ClienteModel> clienteO = clienteRepository.findById(id);
        if(clienteO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        var clienteModel = clienteO.get();
        BeanUtils.copyProperties(clienteRecordDto, clienteModel);
        return ResponseEntity.status(HttpStatus.OK).body(clienteRepository.save(clienteModel));
    }

    @DeleteMapping("clientes/{id}")
    public ResponseEntity<Object> deleteClientes(@PathVariable(value="id") UUID id){
        Optional<ClienteModel> clienteO = clienteRepository.findById(id);
        if(clienteO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        clienteRepository.delete(clienteO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente excluído com sucesso");
    }

}
