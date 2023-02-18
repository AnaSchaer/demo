package event.demo.service.impl;

import event.demo.convertor.EventConvertor;
import event.demo.dto.EventCreateDto;
import event.demo.dto.EventInfoDto;
import event.demo.repository.EventRepository;
import event.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventInfoDto createEvent(EventCreateDto eventCreateDto) {
        return EventConvertor.entityToInfoDto(eventRepository.save(EventConvertor.createDtoToEntity(eventCreateDto)));
    }


}
