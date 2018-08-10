package pricing

import org.scalatest._
import Pricing._

class PricingSpec extends FlatSpec with Matchers {

  "Calculate the price of a list of one book" should "return 8" in {
    pricing(List(1)) shouldEqual 8
  }

  "Calculate the price of a list of two books" should "return 16" in {
    pricing(List(1, 1)) shouldEqual 16
  }

  "Calculate the price of a list of two books" should "return 15.2" in {
    pricing(List(1, 2)) shouldEqual 15.2
  }

  "Calculate the price of a list of three books" should "return 21.6" in {
    pricing(List(1, 2, 3)) shouldEqual 21.6
  }

  "Calculate the price of a list of four books" should "return 25.6" in {
    pricing(List(1, 2, 3, 4)) shouldEqual 25.6
  }

  "Calculate the price of a list of four books" should "return 30" in {
    pricing(List(1, 2, 3, 4, 5) ) shouldEqual 30
  }

  "Calculate the price of a list of four books" should "return 38" in {
    pricing(List(1, 2, 3, 4, 5, 1)) shouldEqual 38
  }

  "Calculate the price of a list of four books" should "return 51.6" in {
    pricing(List(1, 2, 3, 4, 5, 1, 2, 3)) shouldEqual 51.6
  }
}



