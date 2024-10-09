# Kakao Login Plugin

## Setting Up

### 1. Kakao Developers Setup

- **Kakao Developers** 사이트에서 설정을 시작합니다.  
  [Kakao Developers](https://developers.kakao.com/)

#### 1.1 앱 설정

1. 앱 만들기
2. 비즈앱 확인하기
3. 앱 키에서 **네이티브 앱 키** 가져오기
4. 플랫폼 > Android 정보 추가 및 **키 해시** 생성

   - Android 디버그/릴리즈 키 해시 생성하기:

   [Android 시작하기 가이드](https://developers.kakao.com/docs/latest/ko/android/getting-started)

5. 플랫폼 > iOS **번들 ID** 추가
6. 카카오 로그인 > 동의 항목에서 **카카오 이메일 필수 설정**

---

### 2. Kakao Plugin 설정

#### 2.1 Android 설정

- **`build.gradle (project.android)`** 파일에서 `allprojects` 섹션에 다음을 추가합니다:

  ```groovy
  maven { url 'https://devrepo.kakao.com/nexus/content/groups/public/' }
  ```

#### 2.2 iOS 설정

- iOS 설정은 해당 사항이 없습니다. (X)

---

## Usage Example

```javascript
let emailObject = await kakaoLogin.kakaoLogin({ appKey: `${native App Key}` });
console.log(emailObject.email);
```
