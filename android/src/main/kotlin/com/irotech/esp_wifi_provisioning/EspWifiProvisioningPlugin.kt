package com.irotech.esp_wifi_provisioning

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import android.util.Log

class EspWifiProvisioningPlugin : FlutterPlugin, ActivityAware {
    // holds references to the three native adapters
    private var bluetoothAdapter: BluetoothAdapter? = null
    private var locationAdapter: LocationAdapter? = null
    private var esp: Esp? = null

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        bluetoothAdapter = BluetoothAdapter()
        locationAdapter = LocationAdapter()
        esp = Esp()

        bluetoothAdapter?.onAttachedToEngine(binding)
        locationAdapter?.onAttachedToEngine(binding)
        esp?.onAttachedToEngine(binding)
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        bluetoothAdapter?.onDetachedFromEngine(binding)
        locationAdapter?.onDetachedFromEngine(binding)
        esp?.onDetachedFromEngine(binding)
        bluetoothAdapter = null
        locationAdapter = null
        esp = null
    }

    // ActivityAware lifecycle -> forward to components
    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        bluetoothAdapter?.onAttachedToActivity(binding)
        locationAdapter?.onAttachedToActivity(binding)
        esp?.onAttachedToActivity(binding)
    }

    override fun onDetachedFromActivityForConfigChanges() {
        bluetoothAdapter?.onDetachedFromActivityForConfigChanges()
        locationAdapter?.onDetachedFromActivityForConfigChanges()
        esp?.onDetachedFromActivityForConfigChanges()
    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
        bluetoothAdapter?.onReattachedToActivityForConfigChanges(binding)
        locationAdapter?.onReattachedToActivityForConfigChanges(binding)
        esp?.onReattachedToActivityForConfigChanges(binding)
    }

    override fun onDetachedFromActivity() {
        bluetoothAdapter?.onDetachedFromActivity()
        locationAdapter?.onDetachedFromActivity()
        esp?.onDetachedFromActivity()
    }
}
