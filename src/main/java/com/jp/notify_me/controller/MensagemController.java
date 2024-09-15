package com.jp.notify_me.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jp.notify_me.dto.EnvioMensagemDTO;
import com.jp.notify_me.service.MensagemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    MensagemService service;

    @PostMapping("/enviar")
    public ResponseEntity<?> enviarMensagem(@RequestBody @Valid EnvioMensagemDTO dto){
        var mensagem = service.enviarMensagem(dto);
        return ResponseEntity.ok(mensagem);
    }

}