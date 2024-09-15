package com.jp.notify_me.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.jp.notify_me.dto.EnvioMensagemDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Mensagem {
    
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID id;

    private String mensagem;

    private LocalDateTime dataEnvio;

    private String numeroEmissor;

    private String numeroDestinatario;

    public Mensagem(EnvioMensagemDTO dto){
        this.mensagem = dto.mensagem();
        this.numeroDestinatario = dto.numeroDestino();
    }

}
