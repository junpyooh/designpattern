# Design Pattern

---

### Factory Method

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
### 예시
<img src="/Users/camel/IdeaProjects/designpattern/src/main/resources/image/classDiagram.png"></img>