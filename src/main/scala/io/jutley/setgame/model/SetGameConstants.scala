package io.jutley.setgame.model

trait SetGameConstants {
  val NumberOfFeatures = 4
  val VariationsPerFeature = 3
  val SetSize = VariationsPerFeature
  val StartingPlayAreaSize = NumberOfFeatures * VariationsPerFeature

  val allCards = for {
    color   <- CardFeatures.colors
    shape   <- CardFeatures.shapes
    number  <- CardFeatures.numbers
    shading <- CardFeatures.shadings
  } yield Card(color, shape, number, shading)
}
