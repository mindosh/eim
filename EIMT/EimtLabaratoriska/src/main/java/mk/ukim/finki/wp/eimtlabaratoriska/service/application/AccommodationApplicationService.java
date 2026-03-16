package mk.ukim.finki.wp.eimtlabaratoriska.service.application;

import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.Accommodation;
import mk.ukim.finki.wp.eimtlabaratoriska.model.dto.CreateAccommodationDto;
import mk.ukim.finki.wp.eimtlabaratoriska.model.dto.DisplayAccommodationDto;

import java.util.Optional;

public interface AccommodationApplicationService {
    Accommodation create(CreateAccommodationDto createAccommodationDto);

    Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto);

    Optional<DisplayAccommodationDto> delete(Long id);

    Optional<DisplayAccommodationDto> rented(Long id);
}
