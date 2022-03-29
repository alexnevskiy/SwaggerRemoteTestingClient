/*
 * API для приложения для тестирования
 * Описание API для приложения для тестирования
 *
 * OpenAPI spec version: 1.0.2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * тест
 */
@ApiModel(description = "тест")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2022-03-29T19:46:44.526Z")
public class Test {
  @SerializedName("testName")
  private String testName = null;

  @SerializedName("id")
  private Integer id = null;

  public Test testName(String testName) {
    this.testName = testName;
    return this;
  }

   /**
   * имя теста
   * @return testName
  **/
  @ApiModelProperty(value = "имя теста")
  public String getTestName() {
    return testName;
  }

  public void setTestName(String testName) {
    this.testName = testName;
  }

  public Test id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * номер теста
   * @return id
  **/
  @ApiModelProperty(value = "номер теста")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Test test = (Test) o;
    return Objects.equals(this.testName, test.testName) &&
        Objects.equals(this.id, test.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(testName, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Test {\n");
    
    sb.append("    testName: ").append(toIndentedString(testName)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
