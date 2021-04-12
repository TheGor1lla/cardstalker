package de.gor1lla.cardstalker.repositories;

import de.gor1lla.cardstalker.domain.Card;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CardRepository extends CrudRepository<Card, Long> {

    @Override
    List<Card> findAll();

    @Query(value = "SELECT * FROM card where uuid = :cardId", nativeQuery = true)
    Card findByUUID(String cardId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM card where uuid = :cardId", nativeQuery = true)
    void deleteByUUID(@Param("cardId")String cardId);
}
