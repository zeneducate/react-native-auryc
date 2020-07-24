
#import "RNAuryc.h"
#import <AurycSDK/Auryc.h>

@implementation RNAuryc
@synthesize bridge = _bridge;

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(initialize: (NSString *) apiKey siteId: (NSString *)siteId){
    [Auryc initialize:apiKey siteId:siteId development:YES];
}

RCT_EXPORT_METHOD(identify:(NSString *)identity){
    [[Auryc mainInstance] identify:identity];
}

RCT_EXPORT_METHOD(addUserProperties:(NSDictionary *)properties){
    [[Auryc mainInstance] addUserProperties:properties];
}

RCT_EXPORT_METHOD(addSessionProperties:(NSDictionary *)properties){
    [[Auryc mainInstance] addSessionProperties:properties];
}

RCT_EXPORT_METHOD(track: (NSString *) eventName properties:(NSDictionary *)properties){
    [[Auryc mainInstance] track:eventName properties:properties];
}

RCT_EXPORT_METHOD(markViewAsSensitiveInformation:(nonnull NSNumber *)tag) {
    dispatch_async(dispatch_get_main_queue(), ^{
        UIView *view = [self.bridge.uiManager viewForReactTag:tag];
        [[Auryc mainInstance] markViewAsSensitiveInformation:view];
    });
}

RCT_EXPORT_METHOD(unMarkViewAsSensitiveInformation:(nonnull NSNumber *)tag) {
    dispatch_async(dispatch_get_main_queue(), ^{
        UIView *view = [self.bridge.uiManager viewForReactTag:tag];
        [[Auryc mainInstance] unMarkViewAsSensitiveInformation:view];
    });
}

RCT_EXPORT_METHOD(markScreenAsSensitiveInformation) {
    [[Auryc mainInstance] markScreenAsSensitiveInformation];
}

RCT_EXPORT_METHOD(unMarkScreenAsSensitiveInformation) {
    [[Auryc mainInstance] unMarkScreenAsSensitiveInformation];
}

// Manual Lifecycle events

RCT_EXPORT_METHOD(didFinishLaunchingWithOptions) {
    [[Auryc mainInstance] didFinishLaunchingWithOptions];
}

RCT_EXPORT_METHOD(applicationWillEnterForeground) {
    [[Auryc mainInstance] applicationWillEnterForeground];
}

RCT_EXPORT_METHOD(applicationDidBecomeActive) {
    [[Auryc mainInstance] applicationDidBecomeActive];
}

RCT_EXPORT_METHOD(applicationWillResignActive) {
    [[Auryc mainInstance] applicationWillResignActive];
}

RCT_EXPORT_METHOD(applicationDidEnterBackground) {
    [[Auryc mainInstance] applicationDidEnterBackground];
}

RCT_EXPORT_METHOD(applicationWillTerminate) {
    [[Auryc mainInstance] applicationWillTerminate];
}

RCT_EXPORT_METHOD(applicationDidChangeStatusBarOrientation) {
    [[Auryc mainInstance] applicationDidChangeStatusBarOrientation];
}

RCT_EXPORT_METHOD(disable) {
    [Auryc disable];
}
@end

