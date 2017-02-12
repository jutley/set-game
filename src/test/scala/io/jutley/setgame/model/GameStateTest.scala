package io.jutley.setgame.model

import org.scalatest.FunSpec
import org.scalatest.Matchers

class GameStateTest extends FunSpec with Matchers {

  val alice = Player("Alice")
  val bob = Player("Bob")
  val players = Seq(alice, bob)

  val playArea = Seq(
    Card(Red, Oval, One, Solid),
    Card(Red, Oval, One, Solid),
    Card(Red, Oval, One, Solid),
    Card(Red, Oval, One, Solid),
    Card(Red, Oval, One, Solid),
    Card(Red, Oval, One, Solid),
    Card(Red, Oval, One, Solid),
    Card(Red, Oval, One, Solid),
    Card(Red, Oval, One, Solid),
    Card(Red, Oval, One, Solid),
    Card(Red, Oval, One, Solid),
    Card(Red, Oval, One, Solid)
  )
  //
  // val deck = Seq(
  //   Card(Red, Oval, One, Solid)
  // )
  //
  // Seq(
  //   GameState(
  //     players,
  //     deck: Seq[Card],
  //     playArea: Seq[Card] = Seq(
  //       Card(Red, Oval, One, Solid),   Card(Green, Oval, One,   Solid), Card(Red, Squiggle, One, Solid),   Card(Green, Squiggle, One, Solid),
  //       Card(Red, Oval, Two, Solid),   Card(Green, Oval, Two,   Solid), Card(Red, Squiggle, Two, Solid),   Card(Green, Squiggle, Two, Solid),
  //       Card(Red, Oval, Three, Solid), Card(Green, Oval, Three, Solid), Card(Red, Squiggle, Three, Solid), Card(Green, Squiggle, Three, Solid),
  //     ),
  //     Seq.empty,
  //     Map(alice -> 0, bob -> 0),
  //     Set.empty),
  //   GameState(
  //     players,
  //     deck: Seq[Card],
  //     playArea: Seq[Card] = Seq(
  //       Card(Red, Oval, One, Solid),   Card(Green, Oval, One,   Solid), Card(Red, Squiggle, One, Solid),   Card(Green, Squiggle, One, Solid),
  //       Card(Red, Oval, Two, Solid),   Card(Green, Oval, Two,   Solid), Card(Red, Squiggle, Two, Solid),   Card(Green, Squiggle, Two, Solid),
  //       Card(Red, Oval, Three, Solid), Card(Green, Oval, Three, Solid), Card(Red, Squiggle, Three, Solid), Card(Green, Squiggle, Three, Solid),
  //     ),
  //     Seq(Card(Red, Oval, One, Solid), ),
  //     Map(alice -> 1, bob -> 0),
  //     Set.empty)
  // )

  describe("GameState") {
    it("move 3 cards from deck to play area, give a point, move chosen cards to discard when a player picks a set") {

    }

    it("should remove a point when a player picks an invalid sequence") {

    }

    it("should mark game as over when deck is empty and all players have claimed no sets are present") {

    }

    it("should add a set's worth of cards to the play area if all players claim no sets are present") {

    }

    it("should not add new cards to the play area after a set claim if there were more than the starting number of cards in the play area") {

    }
  }

}
