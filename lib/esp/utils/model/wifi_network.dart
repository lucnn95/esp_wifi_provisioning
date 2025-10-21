// ignore_for_file: constant_identifier_names

enum EspWifiSecurity {
  WIFI_OPEN,
  WIFI_WEP,
  WIFI_WPA_PSK,
  WIFI_WPA2_PSK,
  WIFI_WPA_WPA2_PSK,
  WIFI_WPA2_ENTERPRISE,
  WIFI_WPA3_PSK,
  WIFI_WPA2_WPA3_PSK,
}

class EspWifiNetwork {
  final String name;
  int? rssi;
  EspWifiSecurity? security;

  EspWifiNetwork({
    required this.name,
    this.rssi,
    this.security,
  });

  String get ssid => name;

  factory EspWifiNetwork.fromJson(Map<String, dynamic> json) {
    return EspWifiNetwork(
      name: json['name'],
      rssi: json['rssi'],
      security: EspWifiSecurity.values[(json['security'] as int)],
    );
  }
}
