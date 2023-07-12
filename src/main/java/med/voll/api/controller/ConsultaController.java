package med.voll.api.controller;

import med.voll.api.domain.consulta.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity<?> agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {

        agenda.agendar(dados);
        
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<?> cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}