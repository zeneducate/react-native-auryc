'use strict';
var { Platform, NativeModules, findNodeHandle, InteractionManager } = require('react-native');
var RNAurycBridge = NativeModules.RNAuryc;

class RNAuryc {

    static initialize(token, siteId) {
        RNAurycBridge.initialize(token, siteId);
    }

    static initialize(token, siteId, dev) {
        RNAurycBridge.initialize(token, siteId, dev);
    }

    static identify(identity) {
        RNAurycBridge.identify(identity);
    }

    static addUserProperties(userProperties) {
        RNAurycBridge.addUserProperties(userProperties);
    }

    static addSessionProperties(properties) {
        RNAurycBridge.addSessionProperties(properties);
    }

    static track(eventName, properties) {
        RNAurycBridge.track(eventName, properties);
    }

    static markViewAsSensitiveInformation(ref) {
        if (ref == null) {
            return;
        }

        RNAurycBridge.markViewAsSensitiveInformation(findNodeHandle(ref));
    }

    static unMarkViewAsSensitiveInformation(ref) {
        if (ref == null) {
            return;
        }

        RNAurycBridge.unMarkViewAsSensitiveInformation(findNodeHandle(ref));
    }

    static markScreenAsSensitiveInformation() {
        RNAurycBridge.markScreenAsSensitiveInformation();
    }

    static unMarkScreenAsSensitiveInformation() {
        RNAurycBridge.unMarkScreenAsSensitiveInformation();
    }

    // Manual Lifecycle events

    static didFinishLaunchingWithOptions() {
        RNAurycBridge.didFinishLaunchingWithOptions();
    }

    static applicationWillEnterForeground() {
        RNAurycBridge.applicationWillEnterForeground();
    }

    static applicationDidBecomeActive() {
        RNAurycBridge.applicationDidBecomeActive();
    }

    static applicationWillResignActive() {
        RNAurycBridge.applicationWillResignActive();
    }

    static applicationDidEnterBackground() {
        RNAurycBridge.applicationDidEnterBackground();
    }

    static applicationWillTerminate() {
        RNAurycBridge.applicationWillTerminate();
    }

    static applicationDidChangeStatusBarOrientation() {
        RNAurycBridge.applicationDidChangeStatusBarOrientation();
    }

    static disable() {
        RNAurycBridge.disable();
    }

    static pause() {
        RNAurycBridge.pause();
    }

    static resume() {
        RNAurycBridge.resume();
    }
}
module.exports = RNAuryc;
