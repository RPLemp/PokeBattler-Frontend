package de.aix.pokebattler.api.repository;

import de.aix.pokebattler.model.machine.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {
}
