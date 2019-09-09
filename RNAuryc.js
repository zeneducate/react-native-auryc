'use strict';
var { Platform, NativeModules, findNodeHandle, InteractionManager } = require('react-native');
var RNAurycBridge = NativeModules.RNAuryc;

class RNAuryc {

    static initialize(token, siteId) {
        RNAurycBridge.initialize(token, siteId);
    }

    static initializeDev(token, siteId, dev) {
        RNAurycBridge.initializeDev(token, siteId, dev);
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
}
module.exports = RNAuryc;
