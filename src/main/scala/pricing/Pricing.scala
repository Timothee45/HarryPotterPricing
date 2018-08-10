package pricing

object Pricing extends App {

  def countTomesOccurences(books: List[Int]): scala.collection.mutable.Map[Int, Int] = {
    val tomeQuantities = scala.collection.mutable.Map[Int, Int]()

    for (i <- 1 to 5) {
      tomeQuantities(i) = books.count(_ == i)
    }

    tomeQuantities
  }

  def useTimMethod(books: List[Int]): Double = {
    var myBooks:List[Int] = books

    val DEFAULT_BOOK_PRICE: Double = 8

    var finalPrice:Double = 0

    val separetedSerie:List[Int] = List.empty

    while (myBooks.length != 0) {
      val separetedSerie:List[Int] = myBooks.distinct
      val nbrBooksInSerie = separetedSerie.length

      finalPrice = finalPrice + (DEFAULT_BOOK_PRICE * getReduction(nbrBooksInSerie) * nbrBooksInSerie)

      myBooks = myBooks.diff(separetedSerie)
    }

    finalPrice
  }

  def createQuantityArray(books: List[Int]): Array[Int] = {
    var quantityArray = Array(0, 0, 0, 0, 0)

    for (i <- 1 to 5) {
      quantityArray(i - 1) = books.count(_ == i)
    }

    quantityArray
  }

  def getReduction(number: Int): Double = {
    number match {
      case 2 => 0.95
      case 3 => 0.9
      case 4 => 0.8
      case 5 => 0.75
      case _ => 1
    }
  }

  def useGeremMethod(books: List[Int]): Double = {
    var quantityArray = createQuantityArray(books)
    var nbrBooksInSerie: Int = 0
    var finalPrice = 0.0
    val DEFAULT_BOOK_PRICE: Double = 8

    do {
      nbrBooksInSerie = quantityArray.count(_ > 0)

      finalPrice = finalPrice + (DEFAULT_BOOK_PRICE * getReduction(nbrBooksInSerie) * nbrBooksInSerie)

      quantityArray = quantityArray.map(d => d - 1)
    }
    while( nbrBooksInSerie > 0 )

    finalPrice
  }

  def pricing(books: List[Int]): Double = {
    useGeremMethod(books)
  }
}
