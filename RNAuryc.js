'use strict';
var { Platform, NativeModules, findNodeHandle, InteractionManager } = require('react-native');
var RNAurycBridge = NativeModules.RNAuryc;

if (!RNAurycBridge) {
    console.error("RNAurycBridge not available");
}

class RNAuryc {

    static initialize(token, siteId) {
        RNAurycBridge?.initialize(token, siteId);
    }

    static initializeWithUser(token, siteId, userId) {
        RNAurycBridge?.initializeWithUser(token, siteId, userId);
    }

    static initializeDev(token, siteId) {
        RNAurycBridge?.initializeDev(token, siteId);
    }

    static initializeDevWithUser(token, siteId, userId) {
        RNAurycBridge?.initializeDevWithUser(token, siteId, userId);
    }

    static identify(identity) {
        RNAurycBridge?.identify(identity);
    }

    static addUserProperties(userProperties) {
        RNAurycBridge?.addUserProperties(userProperties);
    }

    static addSessionProperties(properties) {
        RNAurycBridge?.addSessionProperties(properties);
    }

    static track(eventName, properties) {
        RNAurycBridge?.track(eventName, properties);
    }

    static markViewAsSensitiveInformation(ref) {
        if (ref == null) {
            return;
        }

        RNAurycBridge?.markViewAsSensitiveInformation(findNodeHandle(ref));
    }

    static unMarkViewAsSensitiveInformation(ref) {
        if (ref == null) {
            return;
        }

        RNAurycBridge?.unMarkViewAsSensitiveInformation(findNodeHandle(ref));
    }

    static markScreenAsSensitiveInformation() {
        RNAurycBridge?.markScreenAsSensitiveInformation();
    }

    static unMarkScreenAsSensitiveInformation() {
        RNAurycBridge?.unMarkScreenAsSensitiveInformation();
    }

    static showFeedback(feedbackId) {
        RNAurycBridge?.showFeedback(feedbackId);
    }
    
    // Manual Lifecycle events

    static didFinishLaunchingWithOptions() {
        RNAurycBridge?.didFinishLaunchingWithOptions();
    }

    static applicationWillEnterForeground() {
        RNAurycBridge?.applicationWillEnterForeground();
    }

    static applicationDidBecomeActive() {
        RNAurycBridge?.applicationDidBecomeActive();
    }

    static applicationWillResignActive() {
        RNAurycBridge?.applicationWillResignActive();
    }

    static applicationDidEnterBackground() {
        RNAurycBridge?.applicationDidEnterBackground();
    }

    static applicationWillTerminate() {
        RNAurycBridge?.applicationWillTerminate();
    }

    static applicationDidChangeStatusBarOrientation() {
        RNAurycBridge?.applicationDidChangeStatusBarOrientation();
    }

  // Advanced API
    static disable() {
        RNAurycBridge?.disable();
    }

    static pause() {
        RNAurycBridge?.pause();
    }

    static resume() {
        RNAurycBridge?.resume();
    }

    static urlForCurrentSessionReplay() {
        return RNAurycBridge?.urlForCurrentSessionReplay();
    }
  
    static metadataForCurrentSession() {
        return RNAurycBridge?.metadataForCurrentSession();
    }
  
    static enableEventMarkerGesture(enable) {
        RNAurycBridge?.enableEventMarkerGesture(enable);
    }
  
    static overrideAppVersionConfiguration(appVersion) {
        RNAurycBridge?.overrideAppVersionConfiguration(appVersion);
    }
  
    static overrideBuildTypeConfiguration(buildType) {
        RNAurycBridge?.overrideBuildTypeConfiguration(buildType);
    }

    static isUserEnabled(userId) {
        return RNAurycBridge?.isUserEnabled(userId);
    }
  
    static startEventMarker() {
        RNAurycBridge?.startEventMarker();
    }
  
    static stopEventMarker() {
        RNAurycBridge?.stopEventMarker();
    }
  
    static ignoreKeyboardGestures(ignoreKeyboardGestures) {
        RNAurycBridge?.ignoreKeyboardGestures(ignoreKeyboardGestures);
    }
  
    static aurycSDKVersionString() {
        return RNAurycBridge?.aurycSDKVersionString();
    }
  
    static pauseService(service, scope) {
        RNAurycBridge?.pauseService(service, scope);
    }
  
    static resumeService(service) {
        RNAurycBridge?.resumeService(service);
    }
  
    static isPausedForService(service) {
        return RNAurycBridge?.isPausedForService(service);
    }

    static setLogLevel(logLevel) {
        RNAurycBridge?.setLogLevel(logLevel);
    }
}
module.exports = RNAuryc;

