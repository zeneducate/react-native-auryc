//
//  Auryc.h
//  AurycSDK
//
//  Created by Alcides Zelaya on 4/5/19.
//  Copyright © 2019 Auryc. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

typedef enum : NSUInteger {
    AurycScopeAllSessions,
    AurycScopeCurrentSession NS_UNAVAILABLE,
    AurycScopeCurrentView NS_UNAVAILABLE,
    AurycScopeNone = 999,
} AurycScope;

typedef enum : NSUInteger {
    AurycServiceDataAndSessionReplay,
    AurycServiceSessionReplay,
    AurycServiceNone = 999,
} AurycService;

@protocol AurycSDKDebugProtocol <NSObject>

- (void)didStartSession:(NSString *)sessionId;
- (void)aurycDebugLog:(NSString *)message;
@end

@interface Auryc : NSObject
@property (nonatomic) id<AurycSDKDebugProtocol> debugDelegate;
@property (readonly) BOOL initialized;
@property (nonatomic) BOOL debugMode;
@property (nonatomic, readonly) BOOL onlyEnableForAuthorizedUsers;
@property (readonly, nonatomic) BOOL isShowingFeedback;
@property (readonly, nonatomic) BOOL paused;
@property (readonly, nonatomic) BOOL appInBackground;
@property (readonly, nonatomic) BOOL appInNotificationCenter;

+ (void)initialize:(NSString *)token siteId:(NSString *)siteId;                                     // default initializer for production environment
+ (void)initialize:(NSString *)token siteId:(NSString *)siteId userId:(NSString *)userId;           // user id whitelist
+ (void)initialize:(NSString *)token siteId:(NSString *)siteId development:(BOOL)dev;
+ (void)initialize:(NSString *)token siteId:(NSString *)siteId userId:(NSString *)userId development:(BOOL)dev;

+ (void)disable;

+ (void)pauseService:(AurycService)service scope:(AurycScope)scope;
+ (void)resumeService:(AurycService)service;
+ (AurycScope)isPausedForService:(AurycService)service;

+ (void)enableEventMarkerGesture:(BOOL)enable;
+ (void)overrideAppVersionConfiguration:(NSString *)appVersion;
+ (void)overrideBuildTypeConfiguration:(NSString *)buildType;


+ (Auryc *)mainInstance;
+ (NSString *)aurycSDKVersionString;

- (void)pause;
- (void)resume;

- (void)addSessionProperties:(NSDictionary<NSString *, NSObject *> *)properties;
- (void)addUserProperties:(NSDictionary<NSString *, NSObject *> *)properties;
- (void)identify:(NSString *)identity;
- (void)track:(NSString *)key;
- (void)track:(NSString *)key properties:(NSDictionary *)properties;

// masking
- (void)markScreenAsSensitiveInformation;
- (void)unMarkScreenAsSensitiveInformation;
- (void)markViewAsSensitiveInformation:(UIView *)view;
- (void)unMarkViewAsSensitiveInformation:(UIView *)view;
- (void)markViewsAsSensitiveInformation:(NSArray<UIView *> *)views;
- (void)unMarkViewsAsSensitiveInformation:(NSArray<UIView *> *)views;

+ (void)ignoreKeyboardGestures:(BOOL)ignoreKeyboardGestures;

// Event Marker
- (void)startEventMarker;
- (void)stopEventMarker;

// Feedback
- (void)showFeedback:(NSString *)feedbackID;                                                                               // shows feedback in key window's root view controller; animated = true
- (void)showFeedback:(NSString *)feedbackID inViewController:(UIViewController *)viewController;                            // shows feedback in passed view controller; animated = true
- (void)showFeedback:(NSString *)feedbackID inViewController:(UIViewController *)viewController animated:(BOOL)animated;    // shows feedback in passed view controller allowing 'animated' to be set

// user id whitelist
- (void)isUserEnabled:(NSString *)userId withCompletion:(void (^)(bool isEnabled))completion;

// returns session replay url for current session
- (NSString *)urlForCurrentSessionReplay;
- (void)urlForCurrentSessionReplayWithCompletion:(void (^)(NSString *currentSessionReplayUrl))completion;

// returns session metadata
- (NSDictionary<NSString *, NSString *> *)metadataForCurrentSession;
- (void)metadataForCurrentSessionWithCompletion:(void (^)(NSDictionary<NSString *, NSString *> *sessionMetadata))completion;

// Manual Lifecycle events
- (void)didFinishLaunchingWithOptions;
- (void)applicationWillEnterForeground;
- (void)applicationDidBecomeActive;
- (void)applicationWillResignActive;
- (void)applicationDidEnterBackground;
- (void)applicationWillTerminate;
- (void)applicationDidChangeStatusBarOrientation;

@end

