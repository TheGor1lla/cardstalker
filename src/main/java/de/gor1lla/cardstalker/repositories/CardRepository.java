package de.gor1lla.cardstalker.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CardRepository extends CrudRepository<CardEntity, Long> {

    @Override
    List<CardEntity> findAll();

    @Query(value = "SELECT * FROM cards where stalk_code = :stalkCode", nativeQuery = true)
    CardEntity findByStalkCode(String stalkCode);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cards where stalk_code = :stalkCode", nativeQuery = true)
    void deleteByStalkCode(String stalkCode);
}
