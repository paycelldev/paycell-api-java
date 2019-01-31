package com.example.paycellwebapiclient.ui.card.query;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CardQueryViewDto implements CardQueryListener {

  private String msisdn;

  private CardViewDto selectedCard;

  private List<CardViewDto> cards;

  private String threeDSessionId;

  private Boolean useCustomCard;

  private CardViewDto customCard;

  @JsonIgnore
  private CardQueryListener cardQueryListener;

  public CardQueryViewDto(CardQueryListener cardQueryListener) {
    this.cardQueryListener = cardQueryListener;
    customCard = new CardViewDto();
  }

  @Override
  public void queryCards() {
    if (cardQueryListener != null) {
      cardQueryListener.queryCards();
    }
  }

  @Override
  public void deleteCard(CardViewDto deletedCard) {
    if (cardQueryListener != null) {
      cardQueryListener.deleteCard(deletedCard);
    }
  }

  @Override
  public void updateCard(CardViewDto updatedCard) {
    if (cardQueryListener != null) {
      cardQueryListener.updateCard(updatedCard);
    }
  }

  @Override
  public void updateCardThreeD(CardViewDto updatedCard) {
    if (cardQueryListener != null) {
      cardQueryListener.updateCardThreeD(updatedCard);
    }
  }

  @Override
  public void listenUpdateCardThreeD(CardViewDto updatedCard) {
    if (cardQueryListener != null) {
      cardQueryListener.listenUpdateCardThreeD(updatedCard);
    }
  }

  public int indexOfSelectedCard() {
    return cards.indexOf(selectedCard);
  }

  public String getMsisdn() {
    return msisdn;
  }

  public void setMsisdn(String msisdn) {
    this.msisdn = msisdn;
  }

  public List<CardViewDto> getCards() {
    return cards;
  }

  public void setCards(List<CardViewDto> cards) {
    this.cards = cards;
  }

  public CardViewDto getSelectedCard() {
    return selectedCard;
  }

  public void setSelectedCard(CardViewDto selectedCard) {
    this.selectedCard = selectedCard;
  }

  @Override
  public String toString() {
    return "CardQueryViewDto [msisdn=" + msisdn + ", selectedCard=" + selectedCard
        + ", cards=" + cards + ", cardQueryListener=" + cardQueryListener + "]";
  }

  public String getThreeDSessionId() {
    return threeDSessionId;
  }

  public void setThreeDSessionId(String threeDSessionId) {
    this.threeDSessionId = threeDSessionId;
  }

  public Boolean getUseCustomCard() {
    return useCustomCard;
  }

  public void setUseCustomCard(Boolean useCustomCard) {
    this.useCustomCard = useCustomCard;
  }

  public CardViewDto getCustomCard() {
    return customCard;
  }

  public void setCustomCard(CardViewDto customCard) {
    this.customCard = customCard;
  }


}
