package com.senac.av2_request.controller;

import com.senac.av2_request.Dto.IdadeDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/envio")
public class IdadeController
{
    private RabbitTemplate rabbitTemplate;

    public IdadeController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/maioridade")
    public void enviarIdade()
    {
        System.out.println("Enviado");
        IdadeDTO dtoRequest = new IdadeDTO("Fulaninho", 19);
        rabbitTemplate.convertAndSend("provac2DarleyVieira", dtoRequest);

    }
}
