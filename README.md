
# react-native-auryc

## Getting started

`$ npm install react-native-auryc --save`

### Automatic installation

`$ react-native link react-native-auryc`

## Initialization

### iOS
Follow the instructions in the portal and intialize Auryc in native languages Objective-C and Swift.
Then you use Auryc in Javascript as decribed below.

## Usage
```javascript
import Auryc from 'react-native-auryc';

// calling APIs
Auryc.identify('abc@example.com')
Auryc.addUserProperties({'company': 'Example Inc'});
...
```
## Notes
### Android integration
React-Native uses Android SDK version 23 which might introduce conflicts when newer version of SDK is used in your project.
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