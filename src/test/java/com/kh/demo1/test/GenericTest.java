package com.kh.demo1.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

class Apple{
  String type;

  Apple(String type){
    this.type = type;
  }
  public String getType(){
    return type;
  }
}

class Banana{}

// 개념을 정리하는 시점. 개념을 담을 수 있는 박스. 유동적으로 바뀌는 데이터 구조를 사용할 때 쓰인다.
//✔Generic타입. : 타입을 일반화하여 정의하는 문법. T(알파벳은 임의로 정할 수 있음)라는 속성을 갖는다. T는 기본타입이 아니라 참조타입.
// 구체적인 타입은 사용 시점에 결정되고 컴파일 시점에 반영이 된다.
// 장점 : 타입을 일반화하여 정의. 컴파일 시 타입체크, 타입변환 비용 제거
 class Box<T>{
  T field;

  public T getField() {
    return field;
  }
  public void setField(T field) {
    this.field = field;
  }
}

class Box2{
  Object field;
}

@Slf4j
//✔사용하는 시점.
public class GenericTest {

  @Test
  void test1(){
  Box<Apple> box = new Box<Apple>();
  box.field = new Apple("부사");
  //box.field = new Banana(); //컴파일 시 타입 체크
  log.info("box={}",box.field.getClass());  //Apple
  log.info("typeOfApple={}", box.field.getType());
  }
  @Test
  void test2(){
    Box2 box = new Box2();
    box.field = new Apple("부사");
    //box.field = new Banana(); //컴파일 시 타입 체크불가
    log.info("box={}",box.field.getClass());  ///object
    log.info("typeOfApple={}", ((Apple)(box.field)).getType());
  }
}
