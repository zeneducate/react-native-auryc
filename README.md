
# react-native-auryc

## Getting started

`$ npm install react-native-auryc --save`

### Mostly automatic installation

`$ react-native link react-native-auryc`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-auryc` and add `RNAuryc.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNAuryc.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.auryc.reactnative.RNAurycPackage;` to the imports at the top of the file
  - Add `new RNAurycPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-auryc'
  	project(':react-native-auryc').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-auryc/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-auryc')
  	```


## Usage
```javascript
import RNAuryc from 'react-native-auryc';

// TODO: What to do with the module?
RNAuryc;
```
  