package msd.prog8170.assignment3.newcalculator

import junit.framework.TestSuite
import org.junit.Test

import org.junit.Assert.*

const val PRECISION = 0.0000001

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CalculatorUnitTests : TestSuite() {
    @Test
    fun addition_Input0And0_Returns0() {
        // Arrange
        val calc = Calculator()
        val lhs = 0.0
        val rhs = 0.0
        val expected = 0.0

        // Act
        val result = calc.addition(lhs, rhs)

        // Assert
        assertEquals(expected, result, PRECISION)
    }

    @Test
    fun addition_Input0And1_Returns1() {
        // Arrange
        val calc = Calculator()
        val lhs = 0.0
        val rhs = 1.0
        val expected = 1.0

        // Act
        val result = calc.addition(lhs, rhs)

        // Assert
        assertEquals(expected, result, PRECISION)
    }

    @Test
    fun addition_Input3And4_Returns7() {
        // Arrange
        val calc = Calculator()
        val lhs = 3.0
        val rhs = 4.0
        val expected = 7.0

        // Act
        val result = calc.addition(lhs, rhs)

        // Assert
        assertEquals(expected, result, PRECISION)
    }

    @Test
    fun subtraction_Input0And0_Returns0() {
        // Arrange
        val calc = Calculator()
        val lhs = 0.0
        val rhs = 0.0
        val expected = 0.0

        // Act
        val result = calc.subtraction(lhs, rhs)

        // Assert
        assertEquals(expected, result, PRECISION)
    }

    @Test
    fun subtraction_Input1And0_Returns1() {
        // Arrange
        val calc = Calculator()
        val lhs = 1.0
        val rhs = 0.0
        val expected = 1.0

        // Act
        val result = calc.subtraction(lhs, rhs)

        // Assert
        assertEquals(expected, result, PRECISION)
    }

    @Test
    fun subtraction_Input4And3_Returns1() {
        // Arrange
        val calc = Calculator()
        val lhs = 4.0
        val rhs = 3.0
        val expected = 1.0

        // Act
        val result = calc.subtraction(lhs, rhs)

        // Assert
        assertEquals(expected, result, PRECISION)
    }

    @Test
    fun multiplication_Input2And1_Returns2() {
        // Arrange
        val calc = Calculator()
        val lhs = 2.0
        val rhs = 1.0
        val expected = 2.0

        // Act
        val result = calc.multiplication(lhs, rhs)

        // Assert
        assertEquals(expected, result, PRECISION)
    }

    @Test
    fun multiplication_Input2And0_Returns0() {
        // Arrange
        val calc = Calculator()
        val lhs = 2.0
        val rhs = 0.0
        val expected = 0.0

        // Act
        val result = calc.multiplication(lhs, rhs)

        // Assert
        assertEquals(expected, result, PRECISION)
    }

    @Test
    fun multiplication_Input2And3_Returns6() {
        // Arrange
        val calc = Calculator()
        val lhs = 2.0
        val rhs = 3.0
        val expected = 6.0

        // Act
        val result = calc.multiplication(lhs, rhs)

        // Assert
        assertEquals(expected, result, PRECISION)
    }

    @Test
    fun division_Input0And1_Returns0() {
        // Arrange
        val calc = Calculator()
        val lhs = 0.0
        val rhs = 1.0
        val expected = 0.0

        // Act
        val result = calc.division(lhs, rhs)

        // Assert
        assertEquals(expected, result, PRECISION)
    }

    @Test
    fun division_Input3And1_Returns3() {
        // Arrange
        val calc = Calculator()
        val lhs = 3.0
        val rhs = 1.0
        val expected = 3.0

        // Act
        val result = calc.division(lhs, rhs)

        // Assert
        assertEquals(expected, result, PRECISION)
    }

    @Test
    fun division_Input6And3_Returns2() {
        // Arrange
        val calc = Calculator()
        val lhs = 6.0
        val rhs = 3.0
        val expected = 2.0

        // Act
        val result = calc.division(lhs, rhs)

        // Assert
        assertEquals(expected, result, PRECISION)
    }
}