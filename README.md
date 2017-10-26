# MacAddress plugin for Cordova / PhoneGap

This Plugin is inspired from MacAddress plugins
[here](https://github.com/purplecabbage/phonegap-plugins/tree/master/Android/MacAddress)
and [here](https://github.com/jcesarmobile/my-phonegap-plugins/tree/master/iOS/MacAddressPlugin),Using this plugins 
device MacAddress could be retrieved for Android/iOS devices.

It has been successfully tested on Cordova version 3.1.0.

## Installation 

for Cordova >= 3.0.0

phonegap local plugin add https://github.com/mohamed-salah/MacAddress.git

cordova plugin add https://github.com/mohamed-salah/MacAddress.git

for Cordova >= 5.0.0

cordova plugin add com-badrit-macaddress

**Example Usage:**

```js
window.MacAddress.getMacAddress(
function(macAddress) {alert(macAddress);},function(fail) {alert(fail);}
);
```
