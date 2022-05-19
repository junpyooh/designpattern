# 디자인패턴 - 생성패턴

<aside>
💡 디자인 패턴이란?

</aside>

- 소프트웨어를 설계할 때 특정 맥락에서 자주 발생하는 고질적인 문제들이 또 발생했을 때 재사용할 수 있는 휼륭한 해결책!
- “바퀴를 다시 발명하지 마라”
- 이미 만들어져서 잘 되는 것을 처음부터 다시 만들 필요가 없다는 의미
- 패턴이란?
    - 각기 다른 소프트웨어 모듈이나 기능을 가진 다양한 응용 소프트웨어 시스템들을 개발할 때도 서로 간에 공통되는 설계 문제가 존재하며 이를 처리하는 해결책 사이에도 공통점이 있다. 이런 유사점을 패턴이라고 한다.
    - 패턴은 공통의 언어를 만들어주며 팀원 사이의 의사 소통을 원활하게 해주는 아주 중요한 역할을 한다.
    

<aside>
💡 디자인 패턴 구조

</aside>

- 콘텍스트
    - 문제가 발생하는 여러 상황을 기술한다. 즉, 패턴이 적용될 수 있는 상황
    - 경우에 따라서는 패턴이 유용하지 못한 상황을 나타내기도 한다.

- 문제
    - 패턴이 적용되어 해결될 필요가 있는 여러 디자인 이슈들을 기술한다.
    - 이때 여러 제약 사황과 영향력도 문제 해결을 위해 고려해야 한다.
    
- 해결
    - 문제를 해결하도록 설계를 구성하는 요소들과 그 요소들 사이의 관계, 책임, 협력 관계를 기술한다.
    - 해결은 반드시 구체적인 구현 방법이나 언어에 의존적이지 않으며 다양한 상황에 적용할 수 있는 일종의 템플릿이다.
    

<aside>
💡 디자인 패턴의 생성 패턴이란?

</aside>

- 객체 생성에 관련된 패턴
- 객체의 생성과 조합을 캡슐화 해 특정 객체가 생성되거나 변경되어도 프로그램 구조에 영향을 크게 받지 않도록 유연성을 제공한다.
- 생성패턴 특징
    - 생성패턴은 시스템이 어떤 구체 클래스를 사용하는지에 대한 정보를 캡슐화 한다.
    - 생성패턴은 이들 클래스의 인스턴스들이 어떻게 만들고 어떻게 서로 맞붙는지에 대한 부분을 완전히 가린다.
    

<aside>
💡 생성 패턴 종류

</aside>

- 싱글톤 패턴
    - 한 클래스에 한 객체만 존재하도록 제한한다.
- 추상 팩토리 패턴
    - 동일한 주제의 다른 팩토리를 묶어 준다.
- 팩토리 메서드 패턴
    - 생성할 객체의 클래스를 국한하지 않고 객체를 생성한다.
- 빌더 패턴
    - 생성과 표기를 분리해 복잡한 객체를 생성한다.
    

<aside>
💡 싱글톤 패턴

</aside>

- 싱글턴 패턴은 인스턴스를 하나만 만들어 사용하기 위한 패턴
    - 어플리케이션이 시작될 때 어떤 클래스가 최초 한번만 메모리를 할당하고 그 메모리에 인스턴스를 만들어 사용하는 디자인 패턴
- 사용 이유?
    - 레지스트리 같은 설정 파일의 경우 객체가 여러개 생성되면 설정 값이 변경될 위험이 생길 수 있다.
    - 인스턴스가 1개만 생성되는 특징을 가진 싱글턴 패턴을 이용하면, 하나의 인스턴스를 메모리에 등록해서 여러 쓰레드가 동시에 해당 인스턴스를 공유하여 사용할 수 있게끔 할 수 있기 때문에 요청이 많은 곳에서 사용하면 효율을 높일 수 있다.
    
- 주의
    - 무상태로 설계 해야한다.
        - 특정 클라이언트에 의존적인 필드가 있으면 안된다.
        - 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다.
        - 가급적 읽기만 가능해야 한다.

- Ex : Java

```java
public class SingletonClass {
	private static SingletonClass instance; // 1. static으로 선언된 객체를 담는 변수
	
	private SingletonClass(){} // 2. 접근제한자 private 사용으로 외부에서 객체 생성 막음.
	
	public static SingletonClass getInstance(){
		// 2. 만약 기존에 instance가 생성되어 있었다면 기존 instance를 사용.
		//    만약 초기화되지 않았다면 새로 생성
		if(instance == null){
			instance = new SingletonClass();
		}

		return instance; // 3. instance 반환
	}
	
}
```

- 클래스 내에 클래스의 인스턴스를 담는 변수 instance를 선언한다.
- SingletoneClass.getInstance()가 호출된다.
- 만약 instance가 초기화 되지 않았다면 instance를 생성한다.
- 이미 초기화 되어 있다면 아무것도 하지 않는다.
- instance를 반환한다.

- Ex : Kotlin에서 object키워드를 이용해 싱글톤 패턴을 간편하게 구현

```kotlin
object SingletonClass{
	fun printClass() = println("출력한다 인스턴스: $this")
}

fun main(){
	println("시작")
	SingletonClass.printClass() // (1)
	SingletonClass.printClass() // (2)
}
```

- 출력 결과
    - (1) → 출력한다 인스턴스: SingletonClass@6ff3c5b5
    - (2) → 출력한다 인스턴스: SingletonClass@6ff3c5b5

- 싱글톤 패턴의 장점 / 단점
    - 장점
        - 고정된 메모리 영역을 얻으면서 한번의 new로 인스턴스를 사용하기 때문에 메모리 낭비를 방지
        - 싱글톤으로 만들어진 클래스의 인스턴스는 전역이기 때문에 다른 클래스의 인스턴스들이 데이터를 공유하기 쉽다.
        - 인스턴스가 절대적으로 한 개만 존재하는 것을 보장하고 싶을 경우 사용한다.
        - 두 번째 이용시 부터는 객체 로딩 시간이 줄어 성능이 좋아지는 장점이 있다.
        
    - 단점
        - 싱글톤 인스턴스가 너무 많은 일을 하거나 많은 데이터를 공유시킬 경우에 다른 클래스의 인스턴스들간에 결합도가 높아져 “개방 폐쇄 원칙”을 위배하게 된다.
            - 개방 폐쇄 원칙 : 확장에는 열려 있어야 하고, 수정에 대해서는 닫혀 있어야 한다.
        - private 생성자를 갖고 있어 상속이 불가능하다.
        - 테스트하기 힘들다
        - 서버 환경에서는 싱글톤이 1개만 생성됨을 보장하지 못한다.
        - 전역 상태를 만들 수 있기 때문에 바람직하지 못하다.
        
    - 번외) 스프링 싱글톤 차이
        - 스프링은 직접 싱글톤 형태의 오브젝트를 만들고 관리하는 기능을 제공 → 싱글톤 레지스트리
        - 스프링 컨테이너는 싱글톤을 생성하고, 관리하고 공급하는 컨테이너
        - 싱글톤 레지스트리를 통해 static 메소드나 private를 사용하지 않아 객체지향적 개발을 할 수 있고, 테스트를 하기 편해진다.
        

<aside>
💡 팩토리 메서드 패턴

</aside>

- 객체의 생성을 캡슐화 하는 패턴이다.
    - 구체적인 객체의 생성 과정을 ‘팩토리’로 모듈화 하여 구체적인 부분이 아닌 추상적인 부분에 의존할 수 있도록 한다.
    - 객체의 생성부를 캡슐화하여 결합을 느슨하게 함 구체적인 타입에 의존하지 않도록 한다.
- 부모 클래스에 알려지지 않은 구체 클래스를 생성하는 패턴, 자식 클래스가 어떤 객체를 생성할지를 결정하도록 하는 패턴이기도 하다.
- 여러 개의 서브 클래스를 가지 슈퍼 클래스가 있을 때 인풋에 따라 하나의 자식 클래스의 인스턴스를 리턴해주는 방식이다.

- 사용 이유 ?
    - 생성할 객체 타입을 예측할 수 없을 때
    - 생성할 객체를 기술하는 책임을 서브클래스에게 정의하고자 할 때
    - 객체 생성의 책임을 서브클래스에 위임시키고 서브클래스에 대한 정보를 은닉하고자 할 때
    - 객체 간의 결합도를 낮추고 유지보수를 용이하게 하기 위해

- 결합도는 왜 낮아지는가?
    - 객체지향 성질중에 하나인 다형성을 이용하였기 때문이다. 인터페이스를 구현한 객체들은 같은 인터페이스를 바라보기 때문에 코드에 유연함이 있다.
    - 객체만 생성하는 공장을 통해서 간접적으로 객체를 생성하게 하고 인터페이스를 정의하되, 실제 구현 내용은 자식 클래스에서 구현이 되므로 세부 구현 코드를 몰라도 부모클래스에서 자유롭게 사용이 가능하며 객체 간의 결합도가 낮아지는 효과를 볼 수 있다.
    

![Untitled](%E1%84%83%E1%85%B5%E1%84%8C%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%91%E1%85%A2%E1%84%90%E1%85%A5%E1%86%AB%20-%20%E1%84%89%E1%85%A2%E1%86%BC%E1%84%89%E1%85%A5%E1%86%BC%E1%84%91%E1%85%A2%E1%84%90%E1%85%A5%E1%86%AB%20b7bd146696b942f58b90c98a686ed483/Untitled.png)

- Ex : Kotlin

```kotlin
interface Currency {
    val code: String
}

class Euro(override val code: String = "EUR") : Currency
class UnitedStatesDollar(override val code: String = "USD") : Currency

enum class Country {
    UnitedStates, Spain, UK, Greece
}

class CurrencyFactory {
    fun currencyForCountry(country: Country): Currency? {
        return when (country) {
            Country.Spain, Country.Greece -> Euro()
            Country.UnitedStates          -> UnitedStatesDollar()
            else                          -> null
                }
    }
}
```

- Currency라는 화폐의 종류를 결정짓는 인터페이스는 화폐 code를 가지고 있다.
- 이를 구현하는 Eruo와 UnitedStateDollar는 code를 override하고 있다.
- CurrencyFactory에서 currencyForCountry 메소드를 통해 country에 따라 각각 다른 화페를 return!

```kotlin
val greeceCode = CurrencyFactory().currencyForCountry(Country.Greece)?.code ?: noCurrencyCode
println("Greece currency: $greeceCode") // (1)

val usCode = CurrencyFactory().currencyForCountry(Country.UnitedStates)?.code ?: noCurrencyCode
println("US currency: $usCode") // (2)
```

- 출력 결과
    - (1) → Greece currency: EUR
    - (2) → US currency: USD
    
- 팩토리 메서드 패턴의 장점 / 단점
    - 장점
        - 팩터리 메서드 패턴은 응용프로그램에 국한된 클래스가 코드에 종속되지 않도록 해준다.
        - 확장에는 열려있고 변경에 닫혀있는 객체지향 원칙을 적용했기 때문에 가능
        - 코드가 간결해진다.
        - 객체들을 한 곳에서 관리할 수 있다는 장점이 있다.
        
    - 단점
        - 클래스가 많아진다. (클래스 계층도 커질 수 있다.)
    

<aside>
💡 추상 팩토리 패턴

</aside>

- 특정 그룹에 속하는 여러 객체들을 하나의 팩토리로 묶어서 생성할 수 있는 패턴
- 추상화된 팩토리를 이용하여 특정 그룹의 요소 객체들을 생성할 수 있는 메소드를 정의
- 추상화 팩토리를 구현한 구현체 클래스는 특성에 따라 구체화된 요소 객체를 반환 하도록 구현
- 상세화된 서브 클래스를 정의하지 않고도 서로 관련성이 있거나 독립적인 여러 객체군을 생성하기 위한 인터페이스를 제공
- 팩토리와 요소 객체들을 추상화하여 클라이언트와의 결합도를 낮춤
    - 결합도 : 한 클래스에 변경점이 얼마나 다른 클래스에 영향을 끼치는 정도

- 사용 이유
    - 객체가 생성되거나 구성, 표현되는 방식과는 무관하게 시스템을 독립적으로 만들고자 할 때
    - 실제 객체가 정확히 무엇인지 알지 못해도 객체를 생성하고 조작할 수 있도록 해준다.
    - 다양한 환경에서 작동하는 코드를 쉽게 만들 수 있도록 해준다.

- Ex: Kotlin

![Untitled](%E1%84%83%E1%85%B5%E1%84%8C%E1%85%A1%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%91%E1%85%A2%E1%84%90%E1%85%A5%E1%86%AB%20-%20%E1%84%89%E1%85%A2%E1%86%BC%E1%84%89%E1%85%A5%E1%86%BC%E1%84%91%E1%85%A2%E1%84%90%E1%85%A5%E1%86%AB%20b7bd146696b942f58b90c98a686ed483/Untitled%201.png)

→  라이더

```kotlin
interface Rider {
    fun delivery(): String
    fun repairVehicle(): String
}

class FullTimeRider : Rider {
    override fun delivery() = "오토바이배달"
    override fun repairVehicle() = "오토바이수리"
}

class PartTimeRider : Rider {
    override fun delivery() = "자전거배달"
    override fun repairVehicle() = "자전거수리"
}
```

→ 이동 수단

```kotlin
interface Vehicle {
    fun start(): String
    fun move(): String
}

class MotorCycle : Vehicle {
    override fun start() = "시동버튼"
    override fun move() = "악셀"
}

class Bike : Vehicle {
    override fun start() = "없다"
    override fun move() = "페달"
}
```

→ 헬멧

```kotlin
interface Helmet {
    fun wear(): String
}

class MotorCycleHelmet : Helmet {
    override fun wear() = "오토바이헬멧착용"
}

class BikeHelmet : Helmet {
    override fun wear() = "자전거헬멧착용"
}
```

→ 라이더, 헬멧, 이동수단 객체를 생성하는 팩토리 클래스를 추상화

```kotlin
interface RiderFactory {
    fun getRider(): Rider
    fun getHelmet(): Helmet
    fun getVehicle(): Vehicle
}

// 팩토리 클래스는 싱글톤으로 선언한다.
object FullTimeRiderFactory : RiderFactory {
    override fun getRider() = FullTimeRider()
    override fun getHelmet() = MotorCycleHelmet()
    override fun getVehicle() = MotorCycle()
}

object PartTimeRiderFactory : RiderFactory {
    override fun getRider() = PartTimeRider()
    override fun getHelmet() = BikeHelmet()
    override fun getVehicle() = Bike()
}
```

→ 클라이언트

```kotlin
class RiderService(private val riderFactory: RiderFactory) {
    fun work(): String {
        val rider = riderFactory.getRider()
        val helmet = riderFactory.getHelmet()
        val vehicle = riderFactory.getVehicle()
        return rider.delivery() + helmet.wear() + vehicle.move()
    }
}

// 라이더의 종류를 선택하여 팩토리를 매겨변수로 넘겨준다.
// 클라이언트가 원하는 종류를 선택하여 사용한다.
val riderService1 = RiderService(FullTimeRiderFactory)
val riderService2 = RiderService(PartTimeRiderFactory)

assertEquals("오토바이배달오토바이헬멧착용악셀", riderService1.work()) // 통과
assertEquals("자전거배달자전거헬멧착용페달", riderService2.work()) // 통과
```

- 추상팩토리 패턴 장점 / 단점
    - 장점
        - 객체 생성을 팩토리에 위임 느슨한 결합
        - 일련의 객체집합을 한번의 변경으로 모두 변경
        - 객체 집합을 생성할 때 일관성 유지
    - 단점
        - 객체 집합군이 늘어 날수록 관련 클래스들이 늘어나고 설계가 복잡
        - 객체 집합군에 새로운 객체가 생기면 모든 팩토리를 수정해야 한다.
            - 정규직 라이더 → 배달, 헬멧착용, 이동 인데 생필품 배달이라는 메소드가 생기면 정규직, 파트타임 전부 생필품 배달이라는 메소드를 추가해야한다.
            
- 팩토리 메서드 패턴 vs 추상 팩토리 패턴 차이점
    - Factory 클래스에서 객체에 대한 생성을 지원하는 범위
        - 팩토리 메소드 패턴
            - 한 팩토리당 한 종류 (create 메서드가 Factory 클래스에 1개)
        - 추상 팩토리 패턴
            - 한 팩토리에서 서로 연관된 여러 종류 모두 지원(create 메서드가 팩토리 클래스에 여러개)
            - 구상 클래스에 의존하지 않고 여러 개의 관련된 객체를 하나의 팩토리로 묶음
    

<aside>
💡 빌더 패턴

</aside>

- 빌더패턴은 복잡한 객체를 생성하는 방법을 정의하는 클래스와 표현하는 방법을 정의하는 클래스를 별도로 분리하여, 서로 다른 표현이라도 이를 생성할 수 있는 동일한 절차를 제공하는 패턴
    - 즉, 생성해야되는 객체가 Optional한 속성을 많이 가질 때 유용하다.
    - 점층적 생성자 패턴의 안정성 + 자바빈 패턴의 가독성을 결합한 패턴이다.
    
- 사용 이유
    - 생성자에 많은 인자가 있는 경우
    - 객체 생성 시 선택 인자가 있는 경우(여러 생성자를 갖게 됨)
    - 점층적 생성자 패턴처럼 매개변수 순서를 외울 필요도 없고 필요없는값에 null을 넣을 필요가 없다.
    - 자바빈 패턴과 다르게 객체 일관성이 지켜지며 변경 불가능한 상태로 생성된다.
    
- 라이벌 패턴들
    - 점층적 생성자 패턴 (Java)
    
    ```java
    Pizza(int size) {}
    Pizza(int size, boolean cheese) {}
    Pizza(int size, boolean cheese, boolean pepperoni) {}
    Pizza(int size, boolean cheese, boolean pepperoni, boolean bacon) {}
    ```
    
    - 만약 피자에 들어가는 내용물이 적을 경우에는 점층적 새성자 패턴을 사용하기에는 괜찮지만 피자에 토핑이 추가되는 가정하에 추가되면 될수록 피자를 만들기는 어렵다. 이유는 토핑이 추가될수록 사용자는 재료를 기억해야 되고 들어가는 순서를 기억해서 만들어야 하기 때문이다. 이러한 패턴의 문제점을 해결하기 위해 나온 패턴이 자바빈 패턴이다.
    
    - 자바빈 패턴 (Java)
    
    ```java
    public class Pizza{
    	private int size;
    	private boolean cheese;
    	private boolean pepperoni;
    	private boolean bacon;
    
    	public void setSize(int size){
    		this.size = size;
    	}
    
    	public void setCheese(boolean cheese){
    		this.cheese = cheese;
    	}
    
    	public void setPepperoni(boolean pepperoni){
    		this.pepperoni = pepperoni;
    	}
    
    	public void setBacon(boolean bacon){
    		this.bacon = bacon;
    	}
    }
    
    public static void main(String[] args){
    	Pizza pizza = new Pizza(); // (1)
    	pizza.setBacon(true); // (2)
    }
    ```
    
    - (1) 객체를 생성후 (2) setter를 사용해서 객체에 값을 지정해주는 방법
        - 그러나 setter를 통해 값을 변경하면 객체 일관성이 깨질수 있다.
        - 변경불가능한 상태로 만들수가 없어서 안전성이 떨어진다.
        
- 특이사항
    - kotlin에서는 기본값과 지명인자를 제공해서 빌더 클래스를 따로 구현할 필요가 없고 밑에 보기와 같이 필요한 값만 지정해서 넣어서 사용하면 된다.
        - 지명인자 : 함수를 호출할 때 각 매개변수의 값만 전달하는 것이 아니고 매개변수 이름과 값을 동시에 전달할 수 있다. 그래서 순서와 무관하게 값이 전달 된다.
- Ex : Kotlin

```kotlin
data class Pizza(
	val size: Int,
	val cheese: Boolean? = null,
	val pepperoni: Boolean? = null,
	val bacon: Boolean? = null
)

fun main(){
	val pizza = Pizza(size = 10) // size = 10 이라고 지명인자 명시되어있다.
}
```

- Ex: Java

```java
public class Pizza {
  private int size;
  private boolean cheese;
  private boolean pepperoni;
  private boolean bacon;

  public static class Builder {

    private final int size;

    private boolean cheese = false;
    private boolean pepperoni = false;
    private boolean bacon = false;

    public Builder(int size) {
      this.size = size;
    }

    public Builder cheese(boolean value) {
      cheese = value;
      return this;
    }

    public Builder pepperoni(boolean value) {
      pepperoni = value;
      return this;
    }

    public Builder bacon(boolean value) {
      bacon = value;
      return this;
    }

    public Pizza build() {
      return new Pizza(this);
    }
  }

  private Pizza(Builder builder) {
    size = builder.size;
    cheese = builder.cheese;
    pepperoni = builder.pepperoni;
    bacon = builder.bacon;
  }
}
```

```java
Pizza pizza = new Pizza.Builder(12)
                       .cheese(true)
                       .pepperoni(true)
                       .bacon(true)
                       .build();
```

- 빌더 패턴 장점 / 단점
    - 장점
        - 필요한 데이터만 설정 가능
        - 유연성을 확보
        - 가독성 높임
        - 불변성을 확보할 수 있음
    
    - 단점
        - 디렉터 또는 디렉터와 함께 빌더까지 만들어야 하는 단점이 있음
        - 구조자체가 기존에 비해 복잡해진다.