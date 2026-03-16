package mk.ukim.finki.wp.eimtlabaratoriska.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.*;

public record CreateAccommodationDto(
        @NotBlank(message = "You must enter a name for the accommodation")
        String name,

        @NotNull(message = "You must enter a category for the accommodation")
        Category category,

        @NotNull(message = "You must enter the host of the accommodation")
        Host host,

        @NotNull(message = "You must enter the number of rooms for the accommodation")
        Integer numRooms,

        @NotNull(message = "You must enter the condition of the unit")
        Condition condition
) {
    public Accommodation toAccommodation() {
        return new Accommodation(name,category,host,numRooms,condition);
    }
}
