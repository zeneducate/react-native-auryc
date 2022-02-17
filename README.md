
# rn-auryc-sdk

## iOS

1. Go to the root level of your project and add the Auryc bridge

  ```
  npm install rn-auryc-sdk --save
  react-native link rn-auryc-sdk
  ```

### for projects using Cocoapods
2. Go to ./ios folder in your react native project and do the followings

    1.1 make sure the following line is added to your Podfile
    ```
    pod 'rn-auryc-sdk', :path => '../node_modules/rn-auryc-sdk'
    ```
    1.2 Run the following commands
    ```
    pod install
    pod update
    ```

### for projects NOT using cocoapods
2. Go to the {ProjectRootDirectory}/node_modules/rn-auryc-sdk/ios and copy (Command + C) *AurycSDK.framework*
into {ProjectRootDirectory}/ios

2.1 Open your project on Xcode and drag *AurycSDK.framework* from {ProjectRootDirectory}/ios into the folder named after your App; 
**Make sure 'Copy items if needed' is NOT selected**

2.2 click on your Xcode project to reveal the project settings and go to General; scroll and find the section 'Embedded Binaries'

2.3 drag *AurycSDK.framework* file added to Xcode in step 2.1 into 'Embedded Binaries'

### for all projects
3. Call the following method when your app starts (when your root component loads):
```javascript
componentDidMount () {
  var Auryc = require('rn-auryc-sdk');
  Auryc.initialize({YOUR_SITE_TOKEN}, {YOUR_SITE_ID});
}
```

4. (Optional) Call the available APIs. Please refer to your portal instructions for the complete list of APIs.
```javascript
var Auryc = require('rn-auryc-sdk');
Auryc.identify("abc@example.com");
Auryc.track("Event name", {"property key" : "property value"});
Auryc.addSessionProperties({"property key" : "property value"});
Auryc.addUserProperties({'company': 'Example Inc'});

<View ref={ x => Auryc.markViewAsSensitiveInformation(x) }>
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
        maven {
          url "https://bintray.auryc.com/repository/android-sdk/"
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
    }
    ```

    Then, add the Auryc SDK dependency.
    ```
    dependencies {
      compile 'com.auryc:android-sdk:2.1.0'
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

onCreate () {
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

### Other Notes iOS
1. RNAuryc currently requires the compiler to be ‘Objective-C’ or ‘Objective-C++’ in XCode.

2. If you run into issues regarding
```
Print: Entry, “:CFBundleIdentifier”, Does Not Exist

```

follow the answers here: https://stackoverflow.com/a/41854111
