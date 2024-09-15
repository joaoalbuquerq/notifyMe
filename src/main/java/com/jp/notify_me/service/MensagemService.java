package com.jp.notify_me.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import com.jp.notify_me.dto.EnvioMensagemDTO;
import com.jp.notify_me.model.Mensagem;
import com.jp.notify_me.repository.MensagemRepository;

@Service
public class MensagemService {

    public static final String ACCOUNT_SID = "AC226f0336ac0867a3e28c876a6f42df95";
    public static final String AUTH_TOKEN = "38d2d9e4eff21628d7fbed3ddb474294";

    @Autowired
    MensagemRepository repository;

    public String enviarMensagem(EnvioMensagemDTO dto){
        var mensagem = repository.save(new Mensagem(dto));

        var response = realizarEnvioMensagem(mensagem);
        return response;
    }

    public String realizarEnvioMensagem(Mensagem mensagem){

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(mensagem.getNumeroDestinatario()),
                new com.twilio.type.PhoneNumber("+13862024865"),
                mensagem.getMensagem())
        .create();

        System.out.println(message.getSid());

        return message.getSid();
    }
    
}
