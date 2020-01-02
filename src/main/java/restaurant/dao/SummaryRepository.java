package restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import restaurant.Entity.Summary;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface SummaryRepository extends JpaRepository<Summary, Integer> {

    @Query(
            value = "select * from summary where extract(year from date) = :yearParam and extract(day from date) = :dayParam and extract(month from date) = :monthParam",
            nativeQuery = true
    )
    List<Summary> findAllByDate(@Param("dayParam") int dayParam,
                                @Param("monthParam") int monthParam,@Param("yearParam") int yearParam);

    @Query(
            value = "SELECT DISTINCT extract(year from date) " +
                    "FROM summary ORDER BY extract(year from date) DESC ",
            nativeQuery = true

    )
    List<Integer> findDistinctYears();

    @Query(
            value = "SELECT DISTINCT extract(month from date) FROM summary " +
                    "WHERE extract(year from date) = :yearParam ORDER BY extract(month from date)",
            nativeQuery = true

    )
    List<Integer> findDistinctMonths(@Param("yearParam") Integer year);

    @Query(
            value = "SELECT DISTINCT extract(day from date) FROM summary " +
                    "WHERE extract(year from date) = :yearParam " +
                    "AND extract(month from date) = :monthParam " +
                    "ORDER BY extract(day from date)",
            nativeQuery = true

    )
    List<Integer> findDistinctDays(@Param("yearParam") Integer year, @Param("monthParam") Integer month);



    @Query(
            value = "SELECT * FROM summary " +
                    "WHERE extract(year from date) = :yearParam " +
                    "AND extract(month from date) = :monthParam " +
                    "AND extract(day from date) = :dayParam",
            nativeQuery = true
    )
    List<Summary> getSummaryOfDay(@Param("yearParam") Integer year, @Param("monthParam") Integer month,@Param("dayParam") Integer day);
}
