
package com.auryc.reactnative;

import android.app.Application;
import android.view.View;

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

  public final void initializeDev(final String apiKey, final String siteId) {
    // apiKey and siteId are added for consistency with ios sdk.
    Auryc.initialize(this.mApplication, true);
  }

  @ReactMethod
  public static final void addSessionProperties(final ReadableMap properties) {
    ReadableNativeMap nativeProperties = (ReadableNativeMap) properties;

    if(nativeProperties != null) {
      HashMap hashMap = nativeProperties.toHashMap();
      Auryc.addSessionProperties(hashMap);
    }
  }

  @ReactMethod
  public static final void addUserProperties(final ReadableMap properties){
    ReadableNativeMap nativeProperties = (ReadableNativeMap) properties;

    if(nativeProperties != null) {
      HashMap hashMap = nativeProperties.toHashMap();
      Auryc.addUserProperties(hashMap);
    }
  }

  @ReactMethod
  public static void track(final String eventName, final ReadableMap properties){
    ReadableNativeMap nativeProperties = (ReadableNativeMap) properties;
    if(nativeProperties == null) {
      Auryc.track(eventName);
    } else {
      HashMap hashMap = nativeProperties.toHashMap();
      Auryc.track(eventName, hashMap);
    }
  }

  @ReactMethod
  public static final void identify(final String identity) {
    Auryc.identify(identity);
  }

  @ReactMethod
  public static final void markViewAsSensitiveInformation(final View view) {
    Auryc.markViewAsSensitiveInformation(view);
  }
}