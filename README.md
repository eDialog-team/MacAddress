# MacAddress plugin for Cordova / PhoneGap

This Plugin is inspired from MacAddress plugins
[here](https://github.com/purplecabbage/phonegap-plugins/tree/master/Android/MacAddress)
and [here](https://github.com/jcesarmobile/my-phonegap-plugins/tree/master/iOS/MacAddressPlugin),Using this plugins 
device MacAddress could be retrieved for Android/iOS devices.

It has been successfully tested on Cordova version 3.1.0.

## Installation 


`cordova plugin add https://github.com/eDialog-team/MacAddress.git`

**Example Usage:**

```js
window.MacAddress.getMacAddress(
    function(macAddress) {
      alert(macAddress);
    },
    function(fail){
      alert(fail);
    }
);
```
**As a Java helper class**
```java

import fr.dialog.macUtils.MacAddressUtils;

String macAddress = MacAddressUtils.getMacAddress(
  this.getApplication().getApplicationContext() // in some Activity
);
```
