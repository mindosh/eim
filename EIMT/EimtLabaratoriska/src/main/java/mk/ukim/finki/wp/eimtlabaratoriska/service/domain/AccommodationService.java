package mk.ukim.finki.wp.eimtlabaratoriska.service.domain;

import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.Accommodation;

import java.util.Optional;

public interface AccommodationService {


    Accommodation create(Accommodation accommodation);

    Optional<Accommodation> update(Long id,Accommodation accommodation);

    Optional<Accommodation> delete(Long id);

    Optional<Accommodation> rented(Long id);
}
