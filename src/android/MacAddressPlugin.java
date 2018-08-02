package fr.dialog.macUtils;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.dialog.macUtils.MacAddressUtils;

/**
 * The Class MacAddressPlugin.
 */
public class MacAddressPlugin extends CordovaPlugin {

  public boolean isSynch(String action) {
    if (action.equals("getMacAddress")) {
      return true;
    }
    return false;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.apache.cordova.api.Plugin#execute(java.lang.String,
   * org.json.JSONArray, java.lang.String)
   */
  @Override
  public boolean execute(String action, JSONArray args,
      CallbackContext callbackContext) {

    if (action.equals("getMacAddress")) {

      String macAddress = MacAddressUtils.getMacAddress(this.cordova.getActivity().getApplicationContext());

      if (macAddress != null) {
        JSONObject JSONresult = new JSONObject();
        try {
          JSONresult.put("mac", macAddress);
          PluginResult r = new PluginResult(PluginResult.Status.OK,
              JSONresult);
          callbackContext.success(macAddress);
          r.setKeepCallback(true);
          callbackContext.sendPluginResult(r);
          return true;
        } catch (JSONException jsonEx) {
          PluginResult r = new PluginResult(
              PluginResult.Status.JSON_EXCEPTION);
          callbackContext.error("error");
          r.setKeepCallback(true);
          callbackContext.sendPluginResult(r);
          return true;
        }
      }
    }
    return false;
  }

}
