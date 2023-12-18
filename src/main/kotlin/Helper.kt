fun Customer.billingStatement(): String {


    val statementResult: String  = rentals.fold("Rental Record for $name\n"){
        statement, rental -> statement + "\t   ${rental.car.title}\t ${rental.calculatePrice()} \n"
    }

    //add footer lines
    return statementResult
        .plus("Final rental payment owed ${calculatePrice()}\n")
        .plus("You received an additional ${calculateRentedPoints()} frequent customer points")
}

fun Rental.calculateRentedPoints(): Int {


    var frequentRenterPoints = 0

    // add frequent renter points
    frequentRenterPoints += 1
    // add bonus for a two days new release rental
    if ((car.carPriceCode == CarPriceCode.SUPERCAR) && daysRented > 1) {
        frequentRenterPoints += 1
    }
    return frequentRenterPoints
}

fun Rental.calculatePrice(): Double {


    //determine amounts for each line
    when (car.carPriceCode) {
        CarPriceCode.ECONOMY -> {

            return if (daysRented > 2) {
                80.0 + ((daysRented) - 2).toDouble() * 30.0
            }else{
                80.0
            }

        }

        CarPriceCode.SUPERCAR ->
            return (daysRented).toDouble() * 200.0

        CarPriceCode.MUSCLE -> {

            return if (daysRented > 3) {
                200.0+ ((daysRented).toDouble() - 3) * 50.0
            }else{
                200.0
            }

        }
    }

}

fun Customer.calculatePrice(): Double {

    return rentals.sumOf { it.calculatePrice() }

}

fun Customer.calculateRentedPoints(): Int {

    return rentals.sumOf { it.calculateRentedPoints() }
}