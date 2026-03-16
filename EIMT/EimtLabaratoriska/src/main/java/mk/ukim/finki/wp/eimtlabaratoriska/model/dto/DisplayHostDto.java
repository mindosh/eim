package mk.ukim.finki.wp.eimtlabaratoriska.model.dto;

import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.Country;
import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.Host;

import java.util.List;

public record DisplayHostDto(
        String name,

        String surname,

        Country country
) {
    private static DisplayHostDto create(Host host) {
        return new DisplayHostDto(
                host.getName(),
                host.getSurname(),
                host.getCountry()
        );
    }

    private static List<DisplayHostDto> create(List<Host> hosts) {
        return hosts.stream().map(DisplayHostDto::create).toList();
    }
}
