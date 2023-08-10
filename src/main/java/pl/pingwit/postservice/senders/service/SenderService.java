package pl.pingwit.postservice.senders.service;

import pl.pingwit.postservice.senders.controller.model.SenderDTO;

import java.util.List;

public interface SenderService {

    SenderDTO getById(Long id);

    List<SenderDTO> getAllSenders();

    Long deleteSender(Long id);

    SenderDTO createSender(SenderDTO senderToCreate);

    SenderDTO update(SenderDTO senderToUpdate);
}
