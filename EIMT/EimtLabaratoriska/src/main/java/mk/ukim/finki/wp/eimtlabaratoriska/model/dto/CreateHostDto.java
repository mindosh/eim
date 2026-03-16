package mk.ukim.finki.wp.eimtlabaratoriska.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.Country;
import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.Host;

public record CreateHostDto(
        @NotBlank(message = "You must enter a name for the host")
        String name,

        @NotBlank(message = "You must enter a surname for the host")
        String surname,

        @NotNull(message = "You must enter a country of where the host comes from")
        Country country
) {
    public Host toHost() {
        return new Host(name,surname,country);
    }
}
