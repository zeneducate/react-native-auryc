
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/Base/RCTBridgeModule.h>
#endif

#if __has_include("RCTUIManager.h")
#import "RCTUIManager.h"
#else
#import <React/Modules/RCTUIManager.h>
#endif

@interface RNAuryc : NSObject <RCTBridgeModule>

@end
  
