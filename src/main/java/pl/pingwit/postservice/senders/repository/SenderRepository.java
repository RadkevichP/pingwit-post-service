package pl.pingwit.postservice.senders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pingwit.postservice.senders.repository.model.Sender;

public interface SenderRepository extends JpaRepository<Sender, Long> {
}
