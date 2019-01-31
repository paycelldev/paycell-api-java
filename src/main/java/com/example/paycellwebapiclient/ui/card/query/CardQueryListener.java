package com.example.paycellwebapiclient.ui.card.query;

public interface CardQueryListener {

  void queryCards();


  void deleteCard(CardViewDto deletedCard);

  void updateCard(CardViewDto updatedCard);

  void updateCardThreeD(CardViewDto updatedCard);

  void listenUpdateCardThreeD(CardViewDto updatedCard);

}
