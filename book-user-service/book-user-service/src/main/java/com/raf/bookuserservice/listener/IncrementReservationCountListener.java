package com.raf.bookuserservice.listener;
import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.raf.bookuserservice.dto.IncrementReservationCountDto;
import com.raf.bookuserservice.service.ClientService;


@Component
public class IncrementReservationCountListener {

    private MessageHelper messageHelper;
    private ClientService clientService;

    public IncrementReservationCountListener(MessageHelper messageHelper, ClientService clientService) {
        this.messageHelper = messageHelper;
        this.clientService= clientService;
    }
     //naziv je isti kao u service impl
    @JmsListener(destination = "${destination.incrementReservationCount}", concurrency = "5-10")
    public void incrementReservationCount(Message message) throws JMSException {
        IncrementReservationCountDto dto  = messageHelper.getMessage(message, IncrementReservationCountDto.class);
        System.out.println(dto);
        clientService.incrementReservationCount(dto);
  }
}
