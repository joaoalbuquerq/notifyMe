package com.jp.notify_me.dto;

import jakarta.validation.constraints.NotBlank;

public record EnvioMensagemDTO(
    @NotBlank
    String mensagem,

    @NotBlank
    String numeroDestino
) {
    
}
