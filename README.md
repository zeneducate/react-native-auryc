
# react-native-auryc

## iOS
1. Go to ./ios folder in your react native project and do the followings

    1.1 Add Auryc to your podfile
    ```
    pod 'Auryc'
    ```
    1.2 Run the following commands
    ```
    pod install
    pod update
    ```

2. Go to the root level and add the Auryc bridge to your project
  ```
  npm install react-native-auryc --save
  react-native link react-native-auryc
  ```

3. Call the following method when your app starts (when your root component loads):
```javascript
import Auryc from 'react-native-auryc';

componentDidMount () {
  Auryc.initialize(YOUR_SITE_TOKEN, YOUR_SITE_ID);
}
```

4. (Optional) Call the available APIs. Please refer to your portal instructions for the complete list of APIs.
```javascript
Auryc.identify('abc@example.com')
Auryc.addUserProperties({'company': 'Example Inc'});
...
```

## Android
1. Go to ./android folder in your react native project and add Auryc library

    1.1 In the project level, build.gradle, add Auryc’s maven repository.
    ```
    allprojects {
      repositories {
        ...
        maven {
          url "http://maven.auryc.com"
        }
        ...
      }
    }
    ```

    1.2  In the module level, build.gradle, define minimum SDK version to 18 and include the packaging options.
    ```
    android{
    ...
    defaultConfig {
      ...
      minSdkVersion 18
      multiDexEnabled false
      ...
    }
    packagingOptions {
    pickFirst 'META-INF/*'
    ...
    }
    }
    ```

    Then, add the Auryc SDK dependency.
    ```
    dependencies {
      compile 'com.auryc:android-sdk:1.1.0'
    }
    ```

    1.3 In your res/values/strings.xml, add the token and site_id.
    ```xml
    <string name="auryc_token">YOUR_SITE_TOKEN</string>
    <string name="auryc_site_id">YOUR_SITE_ID</string>
    ```

2. Add the Auryc package to your project
```
npm install react-native-auryc --save
react-native link react-native-auryc
```

3. Open MainApplication.java and change
`new RNAurycPackage()`
to
`
new RNAurycPackage(this.getApplication())
`

4. Call the following method when your app starts (when your root component loads):
```javascript
import Auryc from 'react-native-auryc';

componentDidMount () {
  Auryc.initialize(YOUR_SITE_TOKEN, YOUR_SITE_ID);
}
```

4. (Optional) Call the available APIs. Please refer to your portal instructions for the complete list of APIs.
```javascript
Auryc.identify('abc@example.com')
Auryc.addUserProperties({'company': 'Example Inc'});
...
```
## Other notes
### Android integration
1. Use gradle version 4+

2. React-Native uses Android SDK version 23 which might introduce conflicts when newer version of SDK is used in your project.
Consider adding the following block to build.gradle to resolve this.
```Java
subprojects {
     afterEvaluate {project ->
         if (project.hasProperty("android")) {
             android {
                 compileSdkVersion 25
                 buildToolsVersion '25.0.0'
            }
         }
    }
}
```

### iOS
If you run into issues regarding 
```
Print: Entry, “:CFBundleIdentifier”, Does Not Exist

```

follow the answers here: https://stackoverflow.com/a/41854111
  