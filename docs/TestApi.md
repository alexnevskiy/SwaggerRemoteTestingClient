# TestApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**finishTest**](TestApi.md#finishTest) | **GET** /test/finish/{testId} | конец теста и получение результата
[**getLastResult**](TestApi.md#getLastResult) | **GET** /test/latest/{userUuid} | получение последнего результата
[**getTestAnswer**](TestApi.md#getTestAnswer) | **GET** /test/{testId}/{questionId} | получить вопрос и варианты ответа
[**postTestAnswer**](TestApi.md#postTestAnswer) | **POST** /test/{testId}/{questionId}/{answerId} | отправить ответ
[**startTest**](TestApi.md#startTest) | **GET** /test/start/{testId} | запуск теста и получение количества вопросов


<a name="finishTest"></a>
# **finishTest**
> Integer finishTest(userUuid, testId)

конец теста и получение результата

метод предназначен для завершения теста

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TestApi;


TestApi apiInstance = new TestApi();
Integer userUuid = 56; // Integer | выбранный пользователь
Long testId = 789L; // Long | testId для поиска нужного теста
try {
    Integer result = apiInstance.finishTest(userUuid, testId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestApi#finishTest");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userUuid** | **Integer**| выбранный пользователь |
 **testId** | **Long**| testId для поиска нужного теста |

### Return type

**Integer**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getLastResult"></a>
# **getLastResult**
> Integer getLastResult(userUuid)

получение последнего результата

метод предназначен для получения списка всех операций

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TestApi;


TestApi apiInstance = new TestApi();
Long userUuid = 789L; // Long | userUuid для поиска
try {
    Integer result = apiInstance.getLastResult(userUuid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestApi#getLastResult");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userUuid** | **Long**| userUuid для поиска |

### Return type

**Integer**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getTestAnswer"></a>
# **getTestAnswer**
> Question getTestAnswer(userUuid, testId, questionId)

получить вопрос и варианты ответа

метод предназначен для получения вариантов ответа

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TestApi;


TestApi apiInstance = new TestApi();
Integer userUuid = 56; // Integer | выбранный пользователь
Long testId = 789L; // Long | testId для поиска нужного теста
Long questionId = 789L; // Long | questionId для поиска нужного вопроса
try {
    Question result = apiInstance.getTestAnswer(userUuid, testId, questionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestApi#getTestAnswer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userUuid** | **Integer**| выбранный пользователь |
 **testId** | **Long**| testId для поиска нужного теста |
 **questionId** | **Long**| questionId для поиска нужного вопроса |

### Return type

[**Question**](Question.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postTestAnswer"></a>
# **postTestAnswer**
> Answer postTestAnswer(userUuid, testId, questionId, answerId)

отправить ответ

метод предназначен для отправления ответа на вопрос

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TestApi;


TestApi apiInstance = new TestApi();
Integer userUuid = 56; // Integer | выбранный пользователь
Long testId = 789L; // Long | testId для поиска нужного теста
Long questionId = 789L; // Long | questionId для поиска нужного вопроса
Long answerId = 789L; // Long | answerId для поиска нужного вопроса
try {
    Answer result = apiInstance.postTestAnswer(userUuid, testId, questionId, answerId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestApi#postTestAnswer");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userUuid** | **Integer**| выбранный пользователь |
 **testId** | **Long**| testId для поиска нужного теста |
 **questionId** | **Long**| questionId для поиска нужного вопроса |
 **answerId** | **Long**| answerId для поиска нужного вопроса |

### Return type

[**Answer**](Answer.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="startTest"></a>
# **startTest**
> Integer startTest(userUuid, testId)

запуск теста и получение количества вопросов

метод предназначен для запуска теста и получения количества вопросов

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TestApi;


TestApi apiInstance = new TestApi();
Integer userUuid = 56; // Integer | выбранный пользователь
Long testId = 789L; // Long | testId для поиска
try {
    Integer result = apiInstance.startTest(userUuid, testId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestApi#startTest");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userUuid** | **Integer**| выбранный пользователь |
 **testId** | **Long**| testId для поиска |

### Return type

**Integer**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

