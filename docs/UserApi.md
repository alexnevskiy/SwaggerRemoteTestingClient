# UserApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**login**](UserApi.md#login) | **POST** /user/login | логин


<a name="login"></a>
# **login**
> User login(user)

логин

метод предназначен для логина пользователя

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApi;


UserApi apiInstance = new UserApi();
User user = new User(); // User | The user to login
try {
    User result = apiInstance.login(user);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApi#login");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | [**User**](User.md)| The user to login | [optional]

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

