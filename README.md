
# rn-auryc-sdk

## iOS

1. Go to the root level of your project and add the Auryc bridge

  ```
  npm install rn-auryc-sdk --save
  react-native link rn-auryc-sdk
  ```

### for projects using Cocoapods
2. Go to ./ios folder in your react native project and do the followings

    1.1 Add Auryc to your podfile
    ```
    pod 'AurycSDK'
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

### Other Notes iOS
1. RNAuryc currently requires the compiler to be ‘Objective-C’ or ‘Objective-C++’ in XCode.

2. If you run into issues regarding
```
Print: Entry, “:CFBundleIdentifier”, Does Not Exist

```

follow the answers here: https://stackoverflow.com/a/41854111
