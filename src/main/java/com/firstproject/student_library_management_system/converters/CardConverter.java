package com.firstproject.student_library_management_system.converters;

import com.firstproject.student_library_management_system.enums.CardStatus;
import com.firstproject.student_library_management_system.model.Card;
import com.firstproject.student_library_management_system.requestdto.CardRequestDto;

public class CardConverter {
    public static Card convertCardRequestDtoIntoCard(CardRequestDto cardRequestDto){

        Card card = new Card();

        card.setCardStatus(cardRequestDto.getCardStatus());

        return card;
    }
}
