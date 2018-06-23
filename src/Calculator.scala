import java.util.{InputMismatchException, Scanner}

import util.control.Breaks._

object Main {
  def main(args: Array[String]): Unit = {

    var result = 0.0
    var b = 0.0
    val scanner = new Scanner(System.in)
    val calculator = Calculator
    var op = 0
    var i = 0

    while (true) {
      breakable {
        while (true) {
          try {
            calculator.showMenu()
            op = scanner.nextInt()
            break()
          } catch {
            case e: InputMismatchException =>
              scanner.next()
          }
        }
      }

      breakable {
        if (i == 0) {
          while (true) {
            try {
              println("Wartość a:")
              result = scanner.nextDouble()
              break()
            } catch {
              case e: InputMismatchException =>
                scanner.next()
            }
          }
        }
      }

      breakable {
        while (true) {
          try {
            println("Wartość b:")
            b = scanner.nextDouble()
            op match {
              case 1 => result = calculator.add(result, b)
              case 2 => result = calculator.sub(result, b)
              case 3 => result = calculator.mul(result, b)
              case 4 => result = calculator.div(result, b)
            }
            break()
          } catch {
            case e: InputMismatchException =>
              scanner.next()
          }
        }
      }
      println("Wynik działania: " + result)
      i += 1
    }
  }
}

object Calculator {

  def showMenu() = {
    println("Wybierz operację:")
    println("1 - Dodawanie")
    println("2 - Odejmowanie")
    println("3 - Mnożenie")
    println("4 - Dzielenie")
    println("5 - Wyjście")
  }

  def add(a: Double, b: Double): Double = {
    return a + b
  }

  def sub(a: Double, b: Double): Double = {
    return a - b
  }

  def mul(a: Double, b: Double): Double = {
    return a * b
  }

  def div(a: Double, b: Double): Double = {
    return a / b
  }
}