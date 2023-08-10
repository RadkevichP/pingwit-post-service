package pl.pingwit.postservice.senders.converter;

import org.junit.jupiter.api.Test;
import pl.pingwit.postservice.senders.controller.model.SenderDTO;
import pl.pingwit.postservice.senders.repository.model.Sender;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SenderConverterTest {

    public static final String TEST_NAME = "TestName";
    public static final String TEST_SURNAME = "TestSurname";
    public static final String TEST_EMAIL = "TestEmail";
    public static final String SOMEPHONE = "somephone";
    private final SenderConverter target = new SenderConverter();

    @Test
    void shouldConvertToDto() {
        // given
        long id = 77L;
        Sender sender = someSender(id);

        SenderDTO expected = expected(id);

        // when
        SenderDTO actual = target.convertToDto(sender);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    private SenderDTO expected(Long id) {
        SenderDTO senderDTO = new SenderDTO();
        senderDTO.setId(id);
        senderDTO.setName(TEST_NAME);
        senderDTO.setSurname(TEST_SURNAME);
        senderDTO.setEmail(TEST_EMAIL);
        senderDTO.setPhone(SOMEPHONE);
        return senderDTO;
    }

    private Sender someSender(Long id) {
        Sender sender = new Sender();
        sender.setId(id);
        sender.setName(TEST_NAME);
        sender.setSurname(TEST_SURNAME);
        sender.setEmail(TEST_EMAIL);
        sender.setPhone(SOMEPHONE);
        return sender;
    }
}