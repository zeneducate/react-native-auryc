'use strict';
var { Platform, NativeModules, findNodeHandle, InteractionManager } = require('react-native');
var AurycBridge = NativeModules.RNAuryc;

class RNAuryc {

    static markViewAsSensitiveInformation(ref) {
        if (ref == null) {
            console.log('Auryc : Can\'t mark a null ref as sensitive (are you sure the component has a ref?)');
            return;
        }

        AurycBridge.markViewAsSensitiveInformation(findNodeHandle(ref));
    }

    static unMarkViewAsSensitiveInformation(ref) {
        if (ref == null) {
            console.log('Auryc : Can\'t unmark a null ref as sensitive (are you sure the component has a ref?)');
            return;
        }

        AurycBridge.unMarkViewAsSensitiveInformation(findNodeHandle(ref));
    }
}
module.exports = RNAuryc;
