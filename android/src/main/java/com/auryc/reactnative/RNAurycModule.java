
package com.auryc.reactnative;

import android.app.Application;
import android.view.View;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableNativeMap;

import java.util.HashMap;


import auryc.com.Auryc;
import auryc.com.callback.MetadataForCurrentSessionCallback;
import auryc.com.callback.UrlForCurrentSessionReplayCallback;

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
  public final void initialize(final String token, final String siteId) {
    // apiKey and siteId are added for consistency with ios sdk.
    Auryc.initialize(this.mApplication);
  }

  @ReactMethod
  public final void initializeWithUser(final String token, final String siteId, final String userId) {
    // apiKey and siteId are added for consistency with ios sdk.
    Auryc.initialize(this.mApplication, userId);
  }

  @ReactMethod
  public final void initializeDev(final String token, final String siteId) {
    // apiKey and siteId are added for consistency with ios sdk.
    Auryc.initialize(this.mApplication, true);
  }

  @ReactMethod
  public final void initializeDevWithUser(final String token, final String siteId, final String userId) {
    // apiKey and siteId are added for consistency with ios sdk.
    Auryc.initialize(this.mApplication, userId, true);
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

  @ReactMethod
  public static final void unMarkViewAsSensitiveInformation(final View view) {
    Auryc.unMarkViewAsSensitiveInformation(view);
  }

  @ReactMethod
  public static final void markScreenAsSensitiveInformation() {
    Auryc.markScreenAsSensitiveInformation();
  }

  @ReactMethod
  public static final void unMarkScreenAsSensitiveInformation() {
    Auryc.unMarkScreenAsSensitiveInformation();
  }

  @ReactMethod
  public static final void disable() {
    Auryc.disable();
  }

  @ReactMethod
  public static final void pause() {
    Auryc.pauseCurrentAndFutureSessions();
  }

  @ReactMethod
  public static final void resume() {
    Auryc.resumeCurrentAndFutureSessions();
  }

  @ReactMethod
  public static final void startEventMarker() {
    Auryc.startEventMarker();
  }

  @ReactMethod
  public static final void stopEventMarker() {
    Auryc.stopEventMarker();
  }

  @ReactMethod
  public static final void urlForCurrentSessionReplay(final Promise promise) {
    Auryc.urlForCurrentSessionReplayWithCompletion(new UrlForCurrentSessionReplayCallback() {
      @Override
      public void onFailure(String reason) {
        promise.reject(reason);
      }
      @Override
      public void onSuccess(String sessionUrl) {
        promise.resolve(sessionUrl);
      }
    });
  }

  @ReactMethod
  public static final void metadataForCurrentSession(final Promise promise) {
    Auryc.metadataForCurrentSessionWithCompletion(new MetadataForCurrentSessionCallback() {
      @Override
      public void onFailure(String reason) {
        promise.reject(reason);
      }
      @Override
      public void onSuccess(HashMap<String, Object> metadata) {
        promise.resolve(metadata);
      }
    });
  }
}