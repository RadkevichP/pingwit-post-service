package pl.pingwit.postservice.senders.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pingwit.postservice.exception.PostServiceNotFoundException;
import pl.pingwit.postservice.senders.controller.model.SenderDTO;
import pl.pingwit.postservice.senders.converter.SenderConverter;
import pl.pingwit.postservice.senders.repository.SenderRepository;
import pl.pingwit.postservice.senders.repository.model.Sender;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class SenderServiceImpl implements SenderService {

    private final SenderRepository senderRepository;
    private final SenderConverter senderConverter;

    public SenderServiceImpl(SenderRepository senderRepository, SenderConverter senderConverter) {
        this.senderRepository = senderRepository;
        this.senderConverter = senderConverter;
    }

    @Override
    public SenderDTO getById(Long id) {
        Sender sender = senderRepository.findById(id).orElseThrow(() -> new PostServiceNotFoundException("Sender "));
        return senderConverter.convertToDto(sender);
    }

    @Override
    public List<SenderDTO> getAllSenders() {
        List<Sender> allSenders = senderRepository.findAll();
        return senderConverter.convertToDto(allSenders);
    }

    @Transactional
    @Override
    public Long deleteSender(Long id) {
        Sender sender = senderRepository.findById(id).orElseThrow(() -> new PostServiceNotFoundException("Sender "));
        senderRepository.delete(sender);
        return id;
    }

    @Transactional
    @Override
    public SenderDTO update(SenderDTO sendertoUpdate) {
        Sender sender = senderConverter.convertToEntity(sendertoUpdate);
        Sender savedSender = senderRepository.save(sender);
        return senderConverter.convertToDto(savedSender);
    }

    @Transactional
    @Override
    public SenderDTO createSender(SenderDTO senderToCreate) {
        Sender sender = senderConverter.convertToEntity(senderToCreate);
        Sender savedSender = senderRepository.save(sender);
        return senderConverter.convertToDto(savedSender);
    }
}
