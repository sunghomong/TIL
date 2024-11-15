# 코틀린 심리테스트 앱 만들기 Section. 03

## 레이아웃 만들기

### gradle dependencies 추가 (navigation)

```kotlin
val nav_version = "2.8.4"

// Jetpack Compose integration
implementation("androidx.navigation:navigation-compose:$nav_version")

// Views/Fragments integration
implementation("androidx.navigation:navigation-fragment:$nav_version")
implementation("androidx.navigation:navigation-ui:$nav_version")

// Feature module support for Fragments
implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

// Testing Navigation
androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")
```

- 필요한 lib 만 추가하면 될 거 같다.
- 추가했다면 build 작업

### navigation 패키지

![img_1.png](img/img_1.png)

- res 에 Android Resource Directory 생성 (resource type : navigation) -> Navigation resource file 생성

### layout 생성

![img_2.png](img/img_2.png)

- 디렉토리 layout 생성 후 main,question,result,section xml 생성

### drawable

![img_3.png](img/img_3.png)

- 필요 이미지 drawable 에 추가

### Fragment 추가 (Fragment blank)

![img_4.png](img/img_4.png)

- Question,Result,Selector fragment 추가

