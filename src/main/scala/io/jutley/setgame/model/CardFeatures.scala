package io.jutley.setgame.model

sealed trait CardFeature { val name: String }

sealed trait CardColor   extends CardFeature
sealed trait CardShape   extends CardFeature
sealed trait CardNumber  extends CardFeature
sealed trait CardShading extends CardFeature

case object Red      extends CardColor   { val name: String = "red"      }
case object Purple   extends CardColor   { val name: String = "purple"   }
case object Green    extends CardColor   { val name: String = "green"    }

case object Oval     extends CardShape   { val name: String = "oval"     }
case object Squiggle extends CardShape   { val name: String = "squiggle" }
case object Diamond  extends CardShape   { val name: String = "diamond"  }

case object One      extends CardNumber  { val name: String = "one"      }
case object Two      extends CardNumber  { val name: String = "two"      }
case object Three    extends CardNumber  { val name: String = "three"    }

case object Solid    extends CardShading { val name: String = "solid"    }
case object Striped  extends CardShading { val name: String = "striped"  }
case object Outlined extends CardShading { val name: String = "outlined" }

object CardFeatures {
  val colors   = Seq(Red, Purple, Green)
  val shapes   = Seq(Oval, Squiggle, Diamond)
  val numbers  = Seq(One, Two, Three)
  val shadings = Seq(Solid, Striped, Outlined)

  val features = Seq(colors, shapes, numbers, shadings)
}
