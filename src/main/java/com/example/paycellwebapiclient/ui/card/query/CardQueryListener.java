package com.example.paycellwebapiclient.ui.card.query;

public interface CardQueryListener {

  void queryCards();

  void selectCard();

  void deleteCard(CardViewDto deletedCard);

  void updateCard();

  void updateCardThreeD();

  void listenUpdateCardThreeD(CardViewDto updatedCard);

}
