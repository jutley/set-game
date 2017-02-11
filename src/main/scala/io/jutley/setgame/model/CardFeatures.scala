package io.jutley.setgame.model

sealed trait CardFeature

sealed trait CardColor   extends CardFeature
sealed trait CardShape   extends CardFeature
sealed trait CardNumber  extends CardFeature
sealed trait CardShading extends CardFeature

case object Red      extends CardColor
case object Purple   extends CardColor
case object Green    extends CardColor

case object Oval     extends CardShape
case object Squiggle extends CardShape
case object Diamond  extends CardShape

case object One      extends CardNumber
case object Two      extends CardNumber
case object Three    extends CardNumber

case object Solid    extends CardShading
case object Striped  extends CardShading
case object Outlined extends CardShading

object CardFeatures {
  Set()
  Set(1, 2, 3)
  scala.collection.Set.apply()
  scala.collection.Set(Red, Purple, Green)
  val colors   = scala.collection.Set(Red, Purple, Green)
  val shapes   = Set(Oval, Squiggle, Diamond)
  val numbers  = Set(One, Two, Three)
  val shadings = Set(Solid, Striped, Outlined)

  val features = Set(colors, shapes, numbers, shadings)
}