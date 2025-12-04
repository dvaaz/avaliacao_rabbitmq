package com.senac.av2_response.service;

import com.senac.av2_response.Dto.IdadeDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class IdadeService {

    @RabbitListener(queues = "provac2DarleyVieira")
    public String verificarMaioridade(IdadeDTO dtoRequest){
        System.out.println("Recebido o pedido de conferencia de idade para"+dtoRequest.getNome());
        System.out.println(". . .");
        System.out.println("Idade: "+dtoRequest.getIdade());
        String response = "";
        if (dtoRequest.getIdade() < 18 && dtoRequest.getIdade() >= 0){
            response = "menor";
        } if (dtoRequest.getIdade() >= 18){
            response = "menor";
        } else {
            response = "idade inválida";
        }
        return response;
    }
}
