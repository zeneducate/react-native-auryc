
package com.auryc.reactnative;

import android.app.Application;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableNativeMap;

import java.util.HashMap;


import auryc.com.Auryc;

public class RNAurycModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private Application mApplication = null;


  public RNAurycModule(ReactApplicationContext reactContext, Application application) {
    super(reactContext);
    this.reactContext = reactContext;
    this.mApplication = application;
  }

  @Override
  public String getName() {
    return "RNAuryc";
  }

  @ReactMethod
  public final void initialize(final String apiKey, final String siteId) {
    // apiKey and siteId are added for consistency with ios sdk.
    Auryc.initialize(this.mApplication);
  }

  @ReactMethod
  public static final void addSessionProperties(final ReadableMap properties) {
    ReadableNativeMap nativeProperties = (ReadableNativeMap) properties;

    if(nativeProperties != null) {
//      Auryc.addSessionProperties(nativeProperties.toHashMap());
    }
  }

  @ReactMethod
  public static final void addUserProperties(final ReadableMap properties){
    ReadableNativeMap nativeProperties = (ReadableNativeMap) properties;

    if(nativeProperties != null) {
//      Auryc.addUserProperties(nativeProperties.toHashMap());
    }
  }

  @ReactMethod
  public static void track(final String eventName, final ReadableMap properties){
    ReadableNativeMap nativeProperties = (ReadableNativeMap) properties;
    if(nativeProperties == null) {
      Auryc.track(eventName);
    } else {
//      Auryc.track(eventName, nativeProperties.toHashMap());
    }
  }

  @ReactMethod
  public static final void identify(final String identity) {
    Auryc.identify(identity);
  }

  // TODO: add masking APIs
}