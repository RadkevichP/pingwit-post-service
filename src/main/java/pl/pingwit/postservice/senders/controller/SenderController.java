package pl.pingwit.postservice.senders.controller;

import org.springframework.web.bind.annotation.*;
import pl.pingwit.postservice.senders.controller.model.SenderDTO;
import pl.pingwit.postservice.senders.service.SenderService;

import java.util.List;

@RestController
@RequestMapping("/senders")
public class SenderController {

    private final SenderService senderService;

    public SenderController(SenderService senderService) {
        this.senderService = senderService;
    }

    @GetMapping
    public List<SenderDTO> getAllSystemSenders() {
        return senderService.getAllSenders();
    }

    @GetMapping("/{id}")
    public SenderDTO getById(@PathVariable Long id) {
        return senderService.getById(id);
    }

    @PostMapping
    public SenderDTO createSender(@RequestBody SenderDTO senderDTO) {
        return senderService.createSender(senderDTO);
    }
}
