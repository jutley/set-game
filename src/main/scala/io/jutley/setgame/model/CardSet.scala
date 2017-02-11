package io.jutley.setgame.model

case object InvalidSetException extends Exception("Cards don't meet set requirements")

case class CardSet(card1: Card, card2: Card, card3: Card) extends SetGameConstants {
  val cards = Set(card1, card2, card3)

//  if (cards)
}