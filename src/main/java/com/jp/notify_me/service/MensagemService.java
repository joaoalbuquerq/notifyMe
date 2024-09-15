package com.jp.notify_me.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.notify_me.dto.EnvioMensagemDTO;
import com.jp.notify_me.model.Mensagem;
import com.jp.notify_me.repository.MensagemRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class MensagemService {

    public static final String ACCOUNT_SID = "AC226f0336ac0867a3e28c876a6f42df95";
    public static final String AUTH_TOKEN = "38d2d9e4eff21628d7fbed3ddb474294";

    @Autowired
    MensagemRepository repository;

    public Mensagem enviarMensagem(EnvioMensagemDTO dto){
        var mensagem = repository.save(new Mensagem(dto));

        var response = realizarEnvioMensagem(mensagem);
        if(response != null && response.getErrorCode() == null){

            mensagem.setDataEnvio(LocalDateTime.now());
            repository.save(mensagem);
            return mensagem;
        }else{
            System.out.println("erro ao enviar mensagem");
            return mensagem;
        }
    }

    public Message realizarEnvioMensagem(Mensagem mensagem){

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(mensagem.getNumeroDestinatario()),
                new com.twilio.type.PhoneNumber("+13862024865"),
                mensagem.getMensagem())
        .create();

        System.out.println(message.getSid());

        return message;
    }
    
}
