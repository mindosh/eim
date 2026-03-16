package mk.ukim.finki.wp.eimtlabaratoriska.service.domain.impl;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.Accommodation;
import mk.ukim.finki.wp.eimtlabaratoriska.model.exception.AccommodationNotFoundException;
import mk.ukim.finki.wp.eimtlabaratoriska.repository.AccommodationRepository;
import mk.ukim.finki.wp.eimtlabaratoriska.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;

    @Override
    public Accommodation create(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Optional<Accommodation> update(Long id, Accommodation accommodation) {
       Accommodation existing=accommodationRepository.findById(id).orElseThrow(()->new AccommodationNotFoundException(id));
       existing.setName(accommodation.getName());
       existing.setCategory(accommodation.getCategory());
       existing.setHost(accommodation.getHost());
       existing.setNumRooms(accommodation.getNumRooms());
       return Optional.of(accommodationRepository.save(existing));
    }

    @Override
    public Optional<Accommodation> delete(Long id) {
        Accommodation existing=accommodationRepository.findById(id).orElseThrow(()->new AccommodationNotFoundException(id));
        accommodationRepository.delete(existing);
        return Optional.of(existing);
    }

    @Override
    public Optional<Accommodation> rented(Long id) {
        Accommodation existing=accommodationRepository.findById(id).orElseThrow(()->new AccommodationNotFoundException(id));
        existing.setRented(true);
        return  Optional.of(accommodationRepository.save(existing));
    }
}
