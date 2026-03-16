package mk.ukim.finki.wp.eimtlabaratoriska.model.dto;

import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.Accommodation;
import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.Category;
import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.Condition;
import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.Host;

import java.util.List;

public record DisplayAccommodationDto(
        String name,
        Category category,
        Host host,
        Integer numRooms,
        Boolean rented,
        Condition condition
) {
    public static DisplayAccommodationDto create(Accommodation accommodation) {
        return new DisplayAccommodationDto(
                accommodation.getName(),
                accommodation.getCategory(),
                accommodation.getHost(),
                accommodation.getNumRooms(),
                accommodation.getRented(),
                accommodation.getCondition()
        );
    }

    public static List<DisplayAccommodationDto> create(List<Accommodation> accommodations) {
        return accommodations.stream().map(DisplayAccommodationDto::create).toList();
    }
}
