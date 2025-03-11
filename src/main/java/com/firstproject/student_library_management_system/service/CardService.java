package com.firstproject.student_library_management_system.service;


import com.firstproject.student_library_management_system.converters.CardConverter;
import com.firstproject.student_library_management_system.model.Card;
import com.firstproject.student_library_management_system.repository.CardRepository;
import com.firstproject.student_library_management_system.requestdto.CardRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public String saveCard(CardRequestDto cardRequestDto) {

        Card card = CardConverter.convertCardRequestDtoIntoCard(cardRequestDto);
        cardRepository.save(card);

        return "Card saved successfully";
    }

    public Card findCardById(int id) {
        Optional<Card> cardOptional = cardRepository.findById(id);
        if (cardOptional.isPresent()) {
            return cardOptional.get();
        } else {
            throw new RuntimeException("Student cannot be updated with id : " + id);
        }
    }

    public List<Card> findAllCards() {
        List<Card> cardList = cardRepository.findAll();
        return cardList;
    }

    public String deleteCardById(int id) {
        cardRepository.deleteById(id);
        return "Card successfully deleted";
    }

    public String updateCard(int id, CardRequestDto cardRequestDto) {
        Card card = findCardById(id);

        if (card != null) {
            card.setCardStatus(cardRequestDto.getCardStatus());
            cardRepository.save(card);

            return "Card updated successfully";
        }
        else{
            return "Card cannot be updated";
        }
    }
}
