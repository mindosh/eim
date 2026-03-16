package mk.ukim.finki.wp.eimtlabaratoriska.service.application.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.Accommodation;
import mk.ukim.finki.wp.eimtlabaratoriska.model.dto.CreateAccommodationDto;
import mk.ukim.finki.wp.eimtlabaratoriska.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.wp.eimtlabaratoriska.repository.AccommodationRepository;
import mk.ukim.finki.wp.eimtlabaratoriska.service.application.AccommodationApplicationService;
import mk.ukim.finki.wp.eimtlabaratoriska.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {
    private final AccommodationService accommodationService;
    private final AccommodationRepository accommodationRepository;

    @Override
    public Accommodation create(CreateAccommodationDto createAccommodationDto) {
        Accommodation accommodation=createAccommodationDto.toAccommodation();
        return accommodationService.create(accommodation);
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto dto) {
        return accommodationRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.name());
                    existing.setCategory(dto.category());
                    existing.setHost(dto.host());
                    existing.setNumRooms(dto.numRooms());
                    existing.setCondition(dto.condition());

                    Accommodation updated = accommodationRepository.save(existing);
                    return DisplayAccommodationDto.create(updated);
                });
    }

    @Override
    public Optional<DisplayAccommodationDto> delete(Long id) {
        return accommodationRepository.findById(id)
                .map(accommodation -> {
                    accommodationRepository.delete(accommodation);
                    return DisplayAccommodationDto.create(accommodation);
                });
    }

    @Override
    public Optional<DisplayAccommodationDto> rented(Long id) {
        return accommodationRepository.findById(id)
                .map(accommodation -> {
                    accommodation.setRented(true);
                    Accommodation updated = accommodationRepository.save(accommodation);
                    return DisplayAccommodationDto.create(updated);
                });
    }
}

