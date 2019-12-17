package restaurant.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import restaurant.Entity.Summary;

import java.time.LocalDate;
import java.util.List;

public interface SummaryRepository extends JpaRepository<Summary, Integer> {

    @Query(
            value = "select * from summary where extract(year from date) = :yearParam and extract(day from date) = :dayParam and extract(month from date) = :monthParam",
            nativeQuery = true
    )
    List<Summary> findAllByDate(@Param("dayParam") int dayParam,
                                @Param("monthParam") int monthParam,@Param("yearParam") int yearParam);

}
