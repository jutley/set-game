package io.jutley.setgame.webview

import io.jutley.setgame.model._

import scala.scalajs.js.JSApp
import org.scalajs.jquery._

object SetGameApp extends JSApp {

  var gameState: GameState = _

  def main(): Unit = {
    val startState = SetGameUtil.freshGameState(Seq(Player("Jake"), Player("Johnny")))
    jQuery(() => setupUI(startState))
    gameState = startState
  }

  def setupUI(state: GameState): Unit = {
    jQuery("#play-area").text("").append(getPlayAreaCardElements(state): _*)
    jQuery("#deck-details").text(s"Cards remaining in deck: ${state.deck.size}")
    jQuery("#player-details").text("").append(getPlayerRows(state): _*)
    println(SetGameUtil.getLegalSets(state.playArea))
  }

  def getPlayAreaCardElements(state: GameState): Seq[JQuery] =
    state.playArea.zipWithIndex.map { case (c, i) => createCardElement(c, i) }

  def createCardElement(card: Card, index: Int): JQuery = {
    val startCardDiv = jQuery(s"""<div class="play-area-card" idx="$index"></div>""")
    val image = jQuery(s"""<img src="deck-images/${card.color.name}-${card.shape.name}-${card.number.name}-${card.shading.name}.png" />""")
    val colorDiv   = jQuery("""<div class="color"></div""").text(card.color.name)
    val shapeDiv   = jQuery("""<div class="shape"></div""").text(card.shape.name)
    val numberDiv  = jQuery("""<div class="number"></div""").text(card.number.name)
    val shadingDiv = jQuery("""<div class="shading"></div""").text(card.shading.name)
    startCardDiv.click(() => toggleCard(startCardDiv))
    startCardDiv.append(image)
  }

  def getPlayerRows(state: GameState): Seq[JQuery] = {
    state.players.map(player => createPlayerRow(player, state))
  }

  def createPlayerRow(player: Player, state: GameState): JQuery = {
    val row = jQuery("""<tr class="player-row"></tr>""")
    val idCell = jQuery("<td></td>").text(player.id)
    val pointsCell = jQuery("<td></td>").text(state.scoreboard.getOrElse(player, 0).toString)
    val claimNoSetsButton = jQuery(s"""<button value="${player.id}"></button>""").text("Claim no set")
    claimNoSetsButton.click(() => claimNoSet(player))
    row.append(idCell, pointsCell, claimNoSetsButton)
  }

  def toggleCard(card: JQuery): Unit = {
    card.toggleClass("selected")
    val cardsToggled = jQuery(".selected")
    if (cardsToggled.length == 3) {
      val cardIndexes = cardsToggled.get().map(_.getAttribute("idx"))
      val cards = cardIndexes.map(idx => gameState.playArea(idx.toInt)).toSet
      val nextState = gameState.claimSet(Player("Jake"), cards)
      cardsToggled.removeClass("selected")
      setupUI(nextState)
      gameState = nextState
    }
  }

  def claimNoSet(player: Player): Unit = {
    val nextState = gameState.claimNoSets(player)
    setupUI(nextState)
    gameState = nextState
  }

}
