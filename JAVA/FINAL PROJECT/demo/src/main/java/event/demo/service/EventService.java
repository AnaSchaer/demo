package event.demo.service;

import event.demo.dto.EventCreateDto;
import event.demo.dto.EventInfoDto;

public interface EventService {
    EventInfoDto createEvent(EventCreateDto eventCreateDto);

}
