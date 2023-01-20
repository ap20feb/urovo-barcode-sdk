
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNUrovoBarcodeSdkSpec.h"

@interface UrovoBarcodeSdk : NSObject <NativeUrovoBarcodeSdkSpec>
#else
#import <React/RCTBridgeModule.h>

@interface UrovoBarcodeSdk : NSObject <RCTBridgeModule>
#endif

@end
