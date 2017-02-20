package io.jutley.setgame.model

case class GameState(players: Seq[Player], deck: Seq[Card], playArea: Seq[Card], discardPile: Seq[Card], scoreboard: Map[Player, Int], noSetClaims: Set[Player]) extends SetGameConstants {

  val gameOver = deck.isEmpty && players.toSet == noSetClaims

  def claimSet(player: Player, setCards: Set[Card]): GameState = {
    if (!setCards.forall(playArea.toSet.contains)) throw IllegalGameOperationException("The play area doesn't contain the claimed cards")
    if (setCards.size != SetSize) throw IllegalGameOperationException(s"A set must contain $SetSize cards")

    if (SetGameUtil.cardsFormLegalSet(setCards)) {
      val newDiscardPile = discardPile ++ setCards
      val newScoreboard = scoreboard + (player -> (scoreboard.getOrElse(player, 0) + 1))
      val newDeck = if (playArea.size == StartingPlayAreaSize) deck.drop(SetSize) else deck
      val newPlayArea =
        if (playArea.size == StartingPlayAreaSize)
          playArea.filterNot(setCards.contains) ++ deck.take(SetSize)
        else
          playArea.filterNot(setCards.contains)
      GameState(players, newDeck, newPlayArea, newDiscardPile, newScoreboard, Set.empty)
    } else {
      val newScoreboard = scoreboard + (player -> (scoreboard.getOrElse(player, 0) - 1))
      this.copy(scoreboard = newScoreboard)
    }
  }

  def claimNoSets(player: Player): GameState = {
    val newNoSetClaims = noSetClaims + player
    players.toSet match {
      case s if s == newNoSetClaims =>
        deck match {
          case Seq() => this.copy(noSetClaims = newNoSetClaims)
          case _ =>
            val newDeck = deck.drop(SetSize)
            val newPlayArea = playArea ++ deck.take(SetSize)
            this.copy(deck = newDeck, playArea = newPlayArea, noSetClaims = Set.empty)
        }
      case _ =>
        this.copy(noSetClaims = newNoSetClaims)
    }
  }
}
