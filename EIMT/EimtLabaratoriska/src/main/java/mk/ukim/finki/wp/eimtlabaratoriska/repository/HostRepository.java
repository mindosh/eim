package mk.ukim.finki.wp.eimtlabaratoriska.repository;

import mk.ukim.finki.wp.eimtlabaratoriska.model.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
}
