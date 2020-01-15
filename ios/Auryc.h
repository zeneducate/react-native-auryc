//
//  Auryc.h
//  AurycSDK
//
//  Created by Alcides Zelaya on 4/5/19.
//  Copyright © 2019 Auryc. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface Auryc : NSObject
@property (readonly) BOOL initialized;
@property (nonatomic) BOOL debugMode;
@property (nonatomic, assign) BOOL marksAllTextFieldsAsSensitiveInformation;                        // default : YES
@property (readonly, nonatomic) BOOL isShowingFeedback;

+ (void)initialize:(NSString *)token siteId:(NSString *)siteId;                                     // default initializer for production environment
+ (void)initialize:(NSString *)token siteId:(NSString *)siteId development:(BOOL)dev;

+ (Auryc *)mainInstance;
+ (NSString *)aurycSDKVersionString;

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

// Event Marker
- (void)startEventMarker;
- (void)stopEventMarker;

// Feedback
- (void)showFeedback:(NSString *)feedbackID;                                                                               // shows feedback in key window's root view controller; animated = true
- (void)showFeedback:(NSString *)feedbackID inViewController:(UIViewController *)viewController;                            // shows feedback in passed view controller; animated = true
- (void)showFeedback:(NSString *)feedbackID inViewController:(UIViewController *)viewController animated:(BOOL)animated;    // shows feedback in passed view controller allowing 'animated' to be set
@end

NS_ASSUME_NONNULL_END
