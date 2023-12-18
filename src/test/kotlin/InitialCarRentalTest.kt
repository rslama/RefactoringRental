import org.testng.Assert.assertEquals
import org.testng.annotations.Test


class InitialCarRentalTest {


    @Test
    fun statementOutput() {

        val rental1 = Rental(Car("Mustang", CarPriceCode.MUSCLE), 5)
        val rental2 = Rental(Car("Lambo", CarPriceCode.SUPERCAR), 20)
        val customer = Customer("Liviu", listOf(rental1, rental2))


        val actualOutput = customer.billingStatement()
        val expectedOutput =
            "Rental Record for Liviu\n" +
                    "\t   Mustang	 300.0 \n" +
                    "\t   Lambo	 4000.0 \n" +
                    "Final rental payment owed 4300.0\n" +
                    "You received an additional 3 frequent customer points"

        assertEquals(actualOutput, expectedOutput)

    }

    @Test
    fun calculateSingleRentalPoints() {

        val rental = Rental(Car("Mustang", CarPriceCode.MUSCLE), 1)

        val customer = Customer("Liviu", listOf(rental))

        assertEquals(customer.calculateRentedPoints(), 1)
    }

    @Test
    fun calculateMultipleRentalPoints() {

        val rental1 = Rental(Car("Mustang", CarPriceCode.MUSCLE), 5)
        val rental2 = Rental(Car("Lambo", CarPriceCode.SUPERCAR), 20)

        val customer = Customer("Liviu", listOf(rental1, rental2))

        assertEquals(customer.calculateRentedPoints(), 3)
    }

    @Test
    fun calculateSingleRentalPrice() {
        val rental = Rental(Car("Mustang", CarPriceCode.MUSCLE), 5)

        val customer = Customer("Liviu", listOf(rental))

        assertEquals(customer.calculatePrice(), 300.0)
    }

    @Test
    fun calculateMultipleRentalPrice() {
        val rental1 = Rental(Car("Mustang", CarPriceCode.MUSCLE), 5)
        val rental2 = Rental(Car("Lambo", CarPriceCode.SUPERCAR), 20)

        val customer = Customer("Liviu", listOf(rental1, rental2))

        assertEquals(customer.calculatePrice(), 4300.0)
    }
}