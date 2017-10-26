package fr.dialog.macUtils;


import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class MacAddressUtils {


  /**
   * Gets the mac address on version >= Marshmallow.
   *
   * @return the mac address
   */
  private static String getMacAddr() {
    try {
      List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
      for (NetworkInterface nif : all) {
        if (!nif.getName().equalsIgnoreCase("wlan0")) continue;

        byte[] macBytes = nif.getHardwareAddress();
        if (macBytes == null) {
          return "";
        }

        StringBuilder res1 = new StringBuilder();
        for (byte b : macBytes) {
          res1.append(String.format("%02X:",b));
        }

        if (res1.length() > 0) {
          res1.deleteCharAt(res1.length() - 1);
        }
        return res1.toString();
      }
    } catch (Exception ex) {
    }
    return "02:00:00:00:00:00";
  }


  /**
   * Gets the mac address on version < Marshmallow.
   *
   * @param context need any kind context to work
   * @return the mac address
   */
  private static String getLegacyMacAddress(Context context) {

    String macAddress = null;

    WifiManager wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    macAddress = wm.getConnectionInfo().getMacAddress();

    if (macAddress == null || macAddress.length() == 0) {
      macAddress = "02:00:00:00:00:00";
    }

    return macAddress;

  }

  /**
   * Gets the mac address.
   *
   * @param context need any kind context to work
   * @return the mac address
   */
  public static String getMacAddress(Context context) {

    if (Build.VERSION.SDK_INT >= 23) { // Build.VERSION_CODES.M
      return getMacAddr();
    }

    return getLegacyMacAddress(context);

  }

}
