// Basic program that calculates a statement of a customer's charges at a car rental store.
//
// A customer can have multiple "Rental"s and a "Rental" has one "Car"
// As an ASCII class diagram:
//          Customer 1 ----> * Rental
//          Rental   * ----> 1 Car
//
// The charges depend on how long the car is rented and the type of the car (economy, muscle or supercar)
//
// The program also calculates frequent renter points.
//
//
// Refactor this class how you would see fit.
//
// The actual code is not that important, as much as its structure. You can even use "magic" functions (e.g. foo.sort()) if you want

data class Car(val title: String, val carPriceCode: CarPriceCode)

enum class CarPriceCode(val priceCode: Int){
    MUSCLE(2),
    ECONOMY(0),
    SUPERCAR(1)
}

data class Rental(val car: Car, val daysRented: Int)
data class Customer(val name: String, val rentals: List<Rental>)


