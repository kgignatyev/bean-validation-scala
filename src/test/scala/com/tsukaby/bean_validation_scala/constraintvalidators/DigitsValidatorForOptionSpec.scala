package com.tsukaby.bean_validation_scala.constraintvalidators

import javax.validation.constraints.Digits

import com.tsukaby.bean_validation_scala.BaseSpec

import scala.annotation.meta.field

class DigitsValidatorForOptionSpec extends BaseSpec {

  private[this] case class TestBeanWithOptionString(
                                                     @(Digits@field)(integer = 1, fraction = 1)
                                                     value: Option[String]
                                                     )

  private[this] case class TestBeanWithOptionInt(
                                                  @(Digits@field)(integer = 1, fraction = 0)
                                                  value: Option[Int]
                                                  )

  private[this] case class TestBeanWithOptionDouble(
                                                     @(Digits@field)(integer = 1, fraction = 1)
                                                     value: Option[Double]
                                                     )

  s"$targetClassName" should {


    val testCases = Seq(
      (TestBeanWithOptionString(Some("10.1")), 1),
      (TestBeanWithOptionString(Some("1.1")), 0),
      (TestBeanWithOptionInt(Some(10)), 1),
      (TestBeanWithOptionInt(Some(1)), 0),
      (TestBeanWithOptionDouble(Some(10.1)), 1),
      (TestBeanWithOptionDouble(Some(1.1)), 0)
    )

    testValidation(testCases)

  }
}
