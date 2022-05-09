# Design Pattern

---

### Factory Method Pattern

1. 정의
   - 객체 생성을 위한 인터페이스를 정의할 때 어떤 클래스의 인스턴스를 만들지 서브 클래스에서 결정하게 만드는 패턴
<br><br>
2. 배경
   - OCP(Open Closed Principle)
     - 객체 지향 디자인 패턴의 기본 원칙
     - 확장에 있어서는 열려 있어야 하며, 수정에 있어서는 닫혀 있어야 한다.
     - 수정이 일어날 가능성이 큰 부분과 그렇지 않은 부분을 분리
   - 객체 생성을 담당하는 코드는 변경 가능성 높음
<br><br>
3. 결론
   - 객체 생성을 담당하는 클래스를 한 곳에서 관리하여 결합도를 낮춤
     - 결합도 : 한 클래스에 변경점이 얼마나 다른 클래스에 영향을 끼치는 정도
     
---
**### 팩토리 메소드 패턴 예제
- 클래스 다이어그램
  - Client가 생성하고자 하는 BenzCar와 VolkswagenCar를 Car 클래스로 추상화
  - Client에서 Car를 직접 생성하지 않고 CarFactory를 통해서 생성

<img src="/Users/camel/IdeaProjects/designpattern/src/main/resources/image/classDiagram_1.png"></img>
---

### Abstract Factory Pattern
1. 정의
   - 특정 그룹에 속하는 여러 객체들을 하나의 팩토리로 묶어서 생성할 수 있는 패턴
   - 추상화된 팩토리를 이용하여 특정 그룹의 요소 객체들을 생성할 수 있는 메소드를 정의
   - 추상화 팩토리를 구현한 구현체 클래스는 특성에 따라 구체화된 요소 객체를 반환하도록 구현
   - 팩토리와 요소 객체들을 추상화하여 클라이언트와의 결합도를 낮춤
2. 사용점
   - 인터페이스보다는 구조체에 접근할 수 있는 코드 제공
   - 다른 서브클래스 확장에 용이
   - 기존 팩토리 패턴의 if-else 로직에서 벗어남
<br><br>
3. 추상 팩토리 패턴 예제
   - OS 환경에 따라 버튼과 알람 형태를 다르게 정의하는 예제에 추상 팩토리 패턴 적용

<img src="/Users/camel/IdeaProjects/designpattern/src/main/resources/image/classDiagram_2.png"></img>
- 코드
```java
public interface ThemeFactory {
    Button createButton();
    Alarm createAlarm();
}

public class MacOSThemeFactory implements ThemeFactory {

    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Alarm createAlarm() {
        return new MacOSAlarm();
    }
}

public class WindowsThemeFactory implements ThemeFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Alarm createAlarm() {
        return new WindowsAlarm();
    }
}
```
```java
public interface Button {}
public class MacOSButton implements Button {}
public class WindowsButton implements Button {}
```
```java
public interface Alarm {}
public class MacOSAlarm implements Alarm {}
public class WindowsAlarm implements Alarm {}
```