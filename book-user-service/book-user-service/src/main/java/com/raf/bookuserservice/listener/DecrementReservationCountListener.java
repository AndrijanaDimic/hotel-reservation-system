package com.raf.bookuserservice.listener;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.raf.bookuserservice.dto.DecrementReservationCountDto;
import com.raf.bookuserservice.service.ClientService;

@Component
public class DecrementReservationCountListener {

    private MessageHelper messageHelper;
    private ClientService clientService;

    public DecrementReservationCountListener(MessageHelper messageHelper, ClientService clientService) {
        this.messageHelper = messageHelper;
        this.clientService= clientService;
    }
     //naziv je isti kao u service impl
    @JmsListener(destination = "${destination.decrementReservationCount}", concurrency = "5-10")
    public void DecrementReservationCount(Message message) throws JMSException {
        DecrementReservationCountDto dto = messageHelper.getMessage(message, DecrementReservationCountDto.class);
        System.out.println(dto);
        clientService.decrementReservationCount(dto);
  }
}