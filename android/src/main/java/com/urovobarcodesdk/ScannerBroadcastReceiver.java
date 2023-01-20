package com.urovobarcodesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class ScannerBroadcastReceiver extends BroadcastReceiver {
  public static final String ACTION = "android.intent.ACTION_DECODE_DATA";
  final String BARCODE_STRING_TAG = "barcode_string";
  static String content;

  @Override
  public void onReceive(Context context, Intent intent) {

    if (!ACTION.equals(intent.getAction())) {
      return;
    }

    content = intent.getStringExtra(BARCODE_STRING_TAG);
    Log.d("ReactNativeJS", "ScannerBroadcastReceiver referrer: " + content);

    WritableMap map = new WritableNativeMap();
    map.putString("referrer", content);
    sendEvent("ScannerBroadcastReceiver" ,map);
  }

  private void sendEvent(String eventName, WritableMap map) {
    try{
      ReactContext reactContext = RNAndroidBroadcastReceiverForScannerModule.reactContext;

      reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
        .emit(eventName, map);
    }
    catch(Exception e){
      Log.d("ReactNativeJS","Exception in sendEvent in ScannerBroadcastReceiver is:"+e.toString());
    }

  }
}
