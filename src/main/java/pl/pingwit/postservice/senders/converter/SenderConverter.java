package pl.pingwit.postservice.senders.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.postservice.senders.controller.model.SenderDTO;
import pl.pingwit.postservice.senders.repository.model.Sender;

import java.util.List;

@Component
public class SenderConverter {

    public SenderDTO convertToDto(Sender sender) {
        return toDto(sender);
    }

    public List<SenderDTO> convertToDto(List<Sender> senders) {
        return senders.stream()
                .map(this::toDto)
                .toList();
    }

    public Sender convertToEntity(SenderDTO senderDTO) {
        Sender sender = new Sender();
        sender.setPhone(senderDTO.getPhone());
        sender.setId(senderDTO.getId());
        sender.setName(senderDTO.getName());
        sender.setSurname(senderDTO.getSurname());
        sender.setEmail(senderDTO.getEmail());
        return sender;
    }

    private SenderDTO toDto(Sender sender) {
        SenderDTO senderDTO = new SenderDTO();
        senderDTO.setId(sender.getId());
        senderDTO.setName(sender.getName());
        senderDTO.setSurname(sender.getSurname());
        senderDTO.setPhone(sender.getPhone());
        senderDTO.setEmail(sender.getEmail());
        return senderDTO;
    }

}
