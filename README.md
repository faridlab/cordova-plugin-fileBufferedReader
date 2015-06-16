cordova-plugin-fileBufferedReader
=================================
Another cordova file plugin

Installation
============
```bash
cordova plugin add https://github.com/faridlab/cordova-plugin-fileBufferedReader.git
```

Supported Platforms
===================
*   Android

Usage
=====

##Read whole content of file

_Example read whole json file's content_
```json
[{a: 1},{a: 2},{a: 3},{a: 4},{a: 5}]
```

```javascript
var
    filename = "/path/to/file.json",
    reader = window.cordova.plugins.FileBufferedReader.read(filename);

reader.then(function(result) {
    console.log(result);
    // Output json object
    // [{a: 1},{a: 2},{a: 3},{a: 4},{a: 5}]
}).catch(function(err) {
    // Instead, this happens:
    console.log("It failed!", err);
});
```

_Example read whole csv file's content_
```csv
Farid Hidayat, 26, Male
Tiffany Alvord, 22, Female
```

```javascript
var filename = "/path/to/file.csv",
    reader = window.cordova.plugins.FileBufferedReader.read(filename);

reader.then(function(result) {
    console.log(result);
    // Output json object
    // [["Farid Hidayat", 26, "Male"],["Tiffany Alvord", 22, "Female"]]
}).catch(function(err) {
    // Instead, this happens:
    console.log("It failed!", err);
});
```
