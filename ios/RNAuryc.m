//
//  RNAuryc.m
//  RNAuryc
//
//  Created by Alcides Zelaya on 7/22/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "RNAuryc.h"
#import <AurycSDK/Auryc.h>

@implementation RNAuryc
@synthesize bridge = _bridge;

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(initialize: (NSString *) token siteId: (NSString *)siteId){
  [Auryc initialize:token siteId:siteId];
}

RCT_EXPORT_METHOD(initializeWithUser:(NSString *)token siteId:(NSString *)siteId userId:(NSString *)userId){
  [Auryc initialize:token siteId:siteId userId:userId];
}

RCT_EXPORT_METHOD(initializeDev:(NSString *)token siteId:(NSString *)siteId){
  [Auryc initialize:token siteId:siteId development:YES];
}

RCT_EXPORT_METHOD(initializeDevWithUser:(NSString *)token siteId:(NSString *)siteId userId:(NSString *)userId){
  [Auryc initialize:token siteId:siteId userId:userId development:YES];
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

RCT_EXPORT_METHOD(showFeedback:(NSString *)feedbackID) {
  dispatch_async(dispatch_get_main_queue(), ^{
      [[Auryc mainInstance] showFeedback:feedbackID];
  });
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

RCT_EXPORT_METHOD(pause) {
    [Auryc.mainInstance pause];
}

RCT_EXPORT_METHOD(resume) {
    [Auryc.mainInstance resume];
}

RCT_REMAP_METHOD(urlForCurrentSessionReplay,
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject) {
  [[Auryc mainInstance] urlForCurrentSessionReplayWithCompletion:^(NSString *currentSessionReplayUrl) {
    if (currentSessionReplayUrl) {
      resolve(currentSessionReplayUrl);
    } else {
      reject(@"", @"", [NSError errorWithDomain:@"com.auryc.ios.sdk" code:0 userInfo:@{ @"Error": @"there was an error trying to get urlForCurrentSessionReplay" }]);
    }
  }];
}

RCT_REMAP_METHOD(metadataForCurrentSession,
                 metadataResolver:(RCTPromiseResolveBlock)resolver
                 metadataRejecter:(RCTPromiseRejectBlock)rejecter) {
  
  [[Auryc mainInstance] metadataForCurrentSessionWithCompletion:^(NSDictionary<NSString *,NSString *> *sessionMetadata) {
    if (sessionMetadata) {
      resolver(sessionMetadata);
    } else {
      rejecter(@"", @"", [NSError errorWithDomain:@"com.auryc.ios.react-natice.sdk" code:0 userInfo:@{ @"Error": @"there was an error trying to get metadataForCurrentSession" }]);
    }
  }];
}

RCT_EXPORT_METHOD(enableEventMarkerGesture:(BOOL)enable) {
  [Auryc enableEventMarkerGesture:enable];
}

RCT_EXPORT_METHOD(overrideAppVersionConfiguration:(NSString *)appVersion) {
    [Auryc overrideAppVersionConfiguration:appVersion];
}

RCT_EXPORT_METHOD(overrideBuildTypeConfiguration:(NSString *)buildType) {
    [Auryc overrideBuildTypeConfiguration:buildType];
}

@end

