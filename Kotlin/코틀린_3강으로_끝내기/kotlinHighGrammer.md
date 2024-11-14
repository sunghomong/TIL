# 코틀린 고급 문법 Section. 02

## Lamda

### 기본 정의

- 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
- 메소드의 파라미터로 넘겨줄수가 있다. fun maxBy(a : Int)
-  return 값으로 사용할 수가 있다.
- val lamdaName : Type = {argumentList -> codeBody}

```kotlin
val square : (Int) -> (Int) = {number -> number * number}

// String,int -> String
val nameAge = {name : String, age : Int ->
    "my name is ${name} I'm ${age}"
}

fun main() {
    println(square(12))
    println(nameAge("joyce",99))
}
```

- 타입 추론이 가능하게 만들어야 한다. ex) (Int) -> (Int) 또는 name : String 처럼 타입을 정의를 해줘야 한다.

### 람다와 확장함수

```kotlin
fun main() {
    val a = "joyce said"
    val b = "mac said"

    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(extendString("ariana",27))
}

val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString(name : String, age : Int) : String {
    val introduceMyself : String.(Int) -> String = {
        "I am ${this} and ${it} years old"
    }
    return name.introduceMyself(age)
}
```

```console
joyce saidPizza is the best!
mac saidPizza is the best!
I am ariana and 27 years old
```

- 위의 코드를 실행시키면 아래와 같이 결과가 나온다.
- String.() -> 확장 함수란 기존에 있는 거에 추가적으로 뭔가를 실행할 때 사용된다.
- ${this} -> 내부에 name 을 뜻한다. 
- ${it} -> age 를 뜻한다.
- return 을 보면 이해하기 쉽다. name.(Int) 라 해석을 하면 extendString 에서 name 과 age 값을 받았을때 내부의 람다 introduceMyself 가 실행되는 거를 확인 가능하다.

### 람다의 리턴

```kotlin
val calculateGrade : (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}
```

- 위의 코드와 같이 람다는 String 으로 반환한다고 선언을 했다면 default 값도 return 해주는 값을 무조건 넣어야한다.

## Data Class

```kotlin
data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int)
// toString(), hashCode(), equals(), copy()

class TicketNormal(val companyName : String, val name : String, var date : String, var seatNumber : Int)

fun main() {
    val ticketA = Ticket("koreanAir","joyceHong","2020-02-16",14)
    val ticketB = TicketNormal("koreanAir","joyceHong","2020-02-16",14)

    println(ticketA) // 객체 내부의 값들을 친절히 설명해줌
    println(ticketB)
}
```

- 기존 class 와 다른 점은 print 할때 알 수 있다.

```console
Ticket(companyName=koreanAir, name=joyceHong, date=2020-02-16, seatNumber=14)
com.example.kotlinpractice.TicketNormal@26f67b76
```

## Companion object

```kotlin
class Book private constructor(val id : Int, val name : String) {
    companion object BookFactory : IdProvider { // static
        override fun getId(): Int {
            return 444
        }

        val myBook = "new book"

        fun create() = Book(0, myBook)
    }
}

interface IdProvider {
    fun getId() : Int
}

fun main() {
    val book = Book.create()

    val bookId = Book.BookFactory.getId()

    println("${book.id} ${book.name}")
}
```

- 클래스 내부에 있는 object 를 굳힌 형태이다.
- companion object 는 클래스 당 1개로 제한
- 클래스가 메모리에 올라갈 때, 동시에 companion object 가 인스터스로서 힙에 올라간다 하여 '동반 객체'라고 한다.

## Object

```kotlin
// singleton pattern
object CarFactory {
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower : Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower : Int)

fun main() {
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)

    println(car)
    println(car2)
    println(CarFactory.cars.size.toString())
}
```

- 싱글턴 패턴이다.
- 자바와 다르게 단 한 문장으로 객체를 만들어서 처리가 가능하다.
