package com.jp.notify_me.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jp.notify_me.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem,UUID>{
    
}
