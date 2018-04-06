
#import "RNAuryc.h"
#import <Auryc-Swift.h>

@implementation RNAuryc

RCT_EXPORT_MODULE(RNAuryc)

- (dispatch_queue_t)methodQueue {
 return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(initialize: (NSString *) apiKey siteId: (NSString *)siteId){
    [Auryc initializeRN: apiKey siteId: siteId];
}

RCT_EXPORT_METHOD(identify: (NSString *) identity){
    [[Auryc mainInstance] identify: identity];
}

RCT_EXPORT_METHOD(addUserProperties:  (NSDictionary *) properties){
    [[Auryc mainInstance] addUserProperties: properties];
}

RCT_EXPORT_METHOD(addSessionProperties:  (NSDictionary *) properties){
    [[Auryc mainInstance] addSessionProperties: properties];
}

RCT_EXPORT_METHOD(track: (NSString *) eventName properties: (NSDictionary *) properties){
    [[Auryc mainInstance] track: eventName properties: properties];
}

RCT_EXPORT_METHOD(markALLTextFieldsAsSensitiveInformation: (BOOL) visible){
    [[Auryc mainInstance] markALLTextFieldsAsSensitiveInformation: visible];
}

RCT_EXPORT_METHOD(markScreenAsSensitive: (BOOL) visible){
    [[Auryc mainInstance] markScreenAsSensitive: visible];
}

@end
  