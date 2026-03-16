package mk.ukim.finki.wp.eimtlabaratoriska.web.controller;

import jakarta.validation.Valid;
import mk.ukim.finki.wp.eimtlabaratoriska.model.dto.CreateAccommodationDto;
import mk.ukim.finki.wp.eimtlabaratoriska.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.wp.eimtlabaratoriska.service.application.AccommodationApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {

    private final AccommodationApplicationService accommodationService;

    public AccommodationController(AccommodationApplicationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayAccommodationDto> create(@RequestBody @Valid CreateAccommodationDto dto) {
        var accommodation = accommodationService.create(dto);
        return ResponseEntity.ok(DisplayAccommodationDto.create(accommodation));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayAccommodationDto> update(
            @PathVariable Long id,
            @RequestBody @Valid CreateAccommodationDto dto
    ) {
        return accommodationService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayAccommodationDto> delete(@PathVariable Long id) {
        return accommodationService.delete(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/rent")
    public ResponseEntity<DisplayAccommodationDto> markAsRented(@PathVariable Long id) {
        return accommodationService.rented(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}