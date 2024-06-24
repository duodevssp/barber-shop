package com.example.backend.Controllers;

import com.example.backend.Models.AgendamentoModel;
import com.example.backend.Models.BarbeiroModel;
import com.example.backend.Models.ClienteModel;
import com.example.backend.RecordDto.AgendamentoRecordDto;
import com.example.backend.Repositories.AgendamentoRepository;
import com.example.backend.Repositories.BarbeiroRepository;
import com.example.backend.Repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgendamentoController {
    @Autowired
    AgendamentoRepository agendamentoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    BarbeiroRepository barbeiroRepository;

    public ResponseEntity<AgendamentoModel> create(@RequestBody @Valid AgendamentoRecordDto agendamentoRecordDto){
        var agendamentoModel = new AgendamentoModel();

        ClienteModel cliente = clienteRepository.findById(agendamentoRecordDto.idCliente())
                .orElseThrow(() -> new RuntimeException("Cliente não encontradoo"));

        BarbeiroModel barbeiro = barbeiroRepository.findById(agendamentoRecordDto.idBarbeiro())
                .orElseThrow(() -> new RuntimeException("Barbeiro não encontrado"));

        agendamentoModel.setCliente(cliente);
        agendamentoModel.setBarbeiro(barbeiro);
        agendamentoModel.setDataAgendamento(agendamentoRecordDto.dataAgendamento());

        return ResponseEntity.status(HttpStatus.OK).body(agendamentoRepository.save(agendamentoModel));
    }

}
