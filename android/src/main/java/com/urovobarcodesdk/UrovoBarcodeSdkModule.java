package com.urovobarcodesdk;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = UrovoBarcodeSdkModule.NAME)
public class UrovoBarcodeSdkModule extends ReactContextBaseJavaModule {
  public static final String NAME = "UrovoBarcodeSdk";

  public UrovoBarcodeSdkModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }


  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void multiply(double a, double b, Promise promise) {
    promise.resolve(a * b);
  }

  @ReactMethod
  public void getReferrerData(Promise promise) {
    Log.d("ReactNativeJS", "Inside getReferrerData in RNAndroidBroadcastReceiverForScannerModule");

    String referrerValue = "NOT AVAILABLE";

    if (ScannerBroadcastReceiver.content != null) {
      Log.d("ReactNativeJS", "ScannerBroadcastReceiver.referrer is not null. It is:" + ScannerBroadcastReceiver.content);
      referrerValue = ScannerBroadcastReceiver.content;
    }

    Log.d("ReactNativeJS", "Returning from getReferrerData in RNAndroidBroadcastReceiverForScannerModule. referrer is:" + referrerValue);
    promise.resolve(referrerValue);
  }
}
