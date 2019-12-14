package itsfine.com.finewriter.repository;

import itsfine.com.finewriter.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FineRepository extends JpaRepository<Fine,Integer> {

}
