package main.itsfine.com.finewriter.repository;

import main.itsfine.com.finewriter.entity.Fine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FineRepository extends JpaRepository<Fine,Integer> {
}
