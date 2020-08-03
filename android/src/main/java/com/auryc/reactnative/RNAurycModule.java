
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

import java.io.IOException;
import java.util.HashMap;


import auryc.com.Auryc;
import auryc.com.Constant;
import auryc.com.callback.MetadataForCurrentSessionCallback;
import auryc.com.callback.UrlForCurrentSessionReplayCallback;
import auryc.com.callback.UserIdFilterCallback;

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
  public static final void identify(final String identity) {
    Auryc.identify(identity);
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
  public static final void addSessionProperties(final ReadableMap properties) {
    ReadableNativeMap nativeProperties = (ReadableNativeMap) properties;

    if(nativeProperties != null) {
      HashMap hashMap = nativeProperties.toHashMap();
      Auryc.addSessionProperties(hashMap);
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

  @ReactMethod
  public static final void startEventMarker() {
    Auryc.startEventMarker();
  }

  @ReactMethod
  public static final void stopEventMarker() {
    Auryc.stopEventMarker();
  }

  @ReactMethod
  public static final void showFeedback(final String feedbackId) {
    // TODO: needs implementation
  }

  @ReactMethod
  public static final void enableEventMarkerGesture(final boolean enable) {
    Auryc.enableEventMarkerGesture(enable);
  }

  @ReactMethod
  public static final void overrideAppVersionConfiguration(final String appVersion) {
    Auryc.overrideAppVersionConfiguration(appVersion);
  }

  @ReactMethod
  public static final void overrideBuildTypeConfiguration(final String buildType) {
    Auryc.overrideBuildTypeConfiguration(buildType);
  }

  @ReactMethod
  public static final void isUserEnabled(final String userId, final Promise promise) {
    Auryc.isUserEnabled(userId, new UserIdFilterCallback() {
      @Override
      public void onFailure(IOException e) {
        promise.resolve(false);
      }
      @Override
      public void onSuccess(Boolean isEnabled) {
        promise.resolve(isEnabled);
      }
    });
  }

  @ReactMethod
  public static final void ignoreKeyboardGestures(final boolean ignore) {
    // this does not apply for Android.
    // adding it to avoid crash in case a customer has both ios and android
    // in the same react native project.
  }

  @ReactMethod
  public static final void aurycSDKVersionString(final Promise promise) {
    promise.resolve(Auryc.aurycSDKVersionString());
  }

  @ReactMethod
  public static final void pauseService(final int service, final int scope) {
    Constant.AURYC.SERVICE parsedService = Constant.AURYC.SERVICE.values()[service];
    Constant.AURYC.SCOPE parsedScope = Constant.AURYC.SCOPE.values()[scope];
    Auryc.pauseService(parsedService, parsedScope);
  }

  @ReactMethod
  public static final void resumeService(final int service) {
    Constant.AURYC.SERVICE parsedService = Constant.AURYC.SERVICE.values()[service];
    Auryc.resumeService(parsedService);
  }

  @ReactMethod
  public static final void isPausedForService(final int service, final Promise promise) {
    Constant.AURYC.SERVICE parsedService = Constant.AURYC.SERVICE.values()[service];
    Constant.AURYC.SCOPE returnValue = Auryc.isPausedForService(parsedService);
    promise.resolve(returnValue);
  }
}