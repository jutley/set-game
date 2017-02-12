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
  val colors   = Seq(Red, Purple, Green)
  val shapes   = Seq(Oval, Squiggle, Diamond)
  val numbers  = Seq(One, Two, Three)
  val shadings = Seq(Solid, Striped, Outlined)

  val features = Seq(colors, shapes, numbers, shadings)
}
