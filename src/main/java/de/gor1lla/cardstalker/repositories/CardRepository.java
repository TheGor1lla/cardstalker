package de.gor1lla.cardstalker.repositories;

import de.gor1lla.cardstalker.domain.Card;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CardRepository extends CrudRepository<Card, Long> {

    @Override
    List<Card> findAll();

    @Query(value = "SELECT * FROM card where card_Id = :cardId", nativeQuery = true)
    Card findByCardId(String cardId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM card where card_Id = :cardId", nativeQuery = true)
    void deleteByCardId(String cardId);
}
