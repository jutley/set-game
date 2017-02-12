package io.jutley.setgame.model

import scala.util.Random

object SetGameUtil extends SetGameConstants {

  def cardsFormLegalSet(cards: Set[Card]): Boolean = {
    val legalVariationSizes = Set(1, VariationsPerFeature)
    val colorsInCards   = cards.map(_.color)
    val shapesInCards   = cards.map(_.shape)
    val numbersInCards  = cards.map(_.number)
    val shadingsInCards = cards.map(_.shading)
    Seq(colorsInCards, shapesInCards, numbersInCards, shadingsInCards).forall(legalVariationSizes contains _.size)
  }

  def freshGameState(players: Seq[Player]): GameState = {
    val shuffledCards = Random.shuffle(allCards)
    GameState(
      players,
      shuffledCards.drop(StartingPlayAreaSize),
      shuffledCards.take(StartingPlayAreaSize),
      Seq.empty,
      players.map((_ -> 0)).toMap,
      Set.empty)
  }

  def getLegalSets(cards: Seq[Card]): Set[Set[Card]] =
    (for {
      card1 <- cards
      card2 <- cards
      card3 <- cards
    } yield Set(card1, card2, card3))
      .toSet
      .filter(_.size == 3)
      .filter(cardsFormLegalSet)
}
