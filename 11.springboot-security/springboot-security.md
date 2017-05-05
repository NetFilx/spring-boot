# Spring Boot 整合Spring Security

## 准备工作

首先，构建一个简单的Web工程，以用于后续添加安全控制

#### Web层实现请求映射

```java
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}
```

- `/`：映射到index.html
- `/hello`：映射到hello.html

#### 实现映射的页面

- src/main/resources/templates/index.html

```html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <title>Spring Security入门</title>
    </head>
    <body>
        <h1>欢迎使用Spring Security!</h1>
        <p>点击 <a th:href="@{/hello}">这里</a> 打个招呼吧</p>
    </body>
</html>
```

- src/main/resources/templates/hello.html

```html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <title>Hello World!</title>
    </head>
    <body>
        <h1>Hello world!</h1>
    </body>
</html>
```

可以看到在index.html中提供到`/hello`的链接，显然在这里没有任何安全控制，所以点击链接后就可以直接跳转到hello.html页面。

## 整合Spring Security

在这里，我们将对`/hello`页面进行权限控制，必须是授权用户才能访问。当没有权限的用户访问后，跳转到登录页面。

#### 添加依赖

在pom.xml中添加如下配置，引入对Spring Security的依赖。

```xml
<dependencies>
    ...
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
    ...
</dependencies>
```

#### Spring Security配置

创建Spring Security的配置类`WebSecurityConfig`，具体如下：

```java
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

}
```

- 通过`@EnableWebSecurity`注解开启Spring Security的功能
- 继承`WebSecurityConfigurerAdapter`，并重写它的方法来设置一些web安全的细节
- `configure(HttpSecurity http)`方法通过`authorizeRequests()`定义哪些URL需要被保护、哪些不需要被保护。例如以上代码指定了`/`和`/home`不需要任何认证就可以访问，其他的路径都必须通过身份验证。通过`formLogin()`定义当需要用户登录时候，转到的登录页面。
- `configureGlobal(AuthenticationManagerBuilder auth)`方法，在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER。

#### 新增登录请求与页面

在完成了Spring Security配置之后，我们还缺少登录的相关内容。

HelloController中新增`/login`请求映射至`login.html`

```Java
@Controller
public class HelloController {

    // 省略之前的内容...

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
```

新增登录页面：`src/main/resources/templates/login.html`

```Html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <title>Spring Security Example </title>
    </head>
    <body>
        <div th:if="${param.error}">
            用户名或密码错
        </div>
        <div th:if="${param.logout}">
            您已注销成功
        </div>
        <form th:action="@{/login}" method="post">
            <div><label> 用户名 : <input type="text" name="username"/> </label></div>
            <div><label> 密  码 : <input type="password" name="password"/> </label></div>
            <div><input type="submit" value="登录"/></div>
        </form>
    </body>
</html>
```

可以看到，实现了一个简单的通过用户名和密码提交到`/login`的登录方式。

根据配置，Spring Security提供了一个过滤器来拦截请求并验证用户身份。如果用户身份认证失败，页面就重定向到`/login?error`，并且页面中会展现相应的错误信息。若用户想要注销登录，可以通过访问`/login?logout`请求，在完成注销之后，页面展现相应的成功消息。

到这里，我们启用应用，并访问`http://localhost:8080/`，可以正常访问。但是访问`http://localhost:8080/hello`的时候被重定向到了`http://localhost:8080/login`页面，因为没有登录，用户没有访问权限，通过输入用户名user和密码password进行登录后，跳转到了Hello World页面，再也通过访问`http://localhost:8080/login?logout`，就可以完成注销操作。

为了让整个过程更完成，我们可以修改`hello.html`，让它输出一些内容，并提供“注销”的链接。

```Html
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <title>Hello World!</title>
    </head>
    <body>
        <h1 th:inline="text">Hello [[${#httpServletRequest.remoteUser}]]!</h1>
        <form th:action="@{/logout}" method="post">
            <input type="submit" value="注销"/>
        </form>
    </body>
</html>
```

本文通过一个最简单的示例完成了对Web应用的安全控制，Spring Security提供的功能还远不止于此，更多Spring Security的使用可参见[Spring Security Reference](http://docs.spring.io/spring-security/site/docs/4.1.0.RELEASE/reference/htmlsingle/)。