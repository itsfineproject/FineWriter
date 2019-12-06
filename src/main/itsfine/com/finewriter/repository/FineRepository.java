package main.itsfine.com.finewriter.repository;

import main.itsfine.com.finewriter.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepository extends JpaRepository<Fine,Integer> {
}
