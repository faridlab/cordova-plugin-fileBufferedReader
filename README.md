cordova-plugin-fileBufferedReader
=================================

Installation
============
```bash
cordova plugin add https://github.com/apache/cordova-plugin-file.git
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
var filename = "/path/to/file.json";
window.FileBufferedReader.read(filename, function(result) {
    console.log(result);
    // Output json object
    // [{a: 1},{a: 2},{a: 3},{a: 4},{a: 5}]
});
```

_Example read whole csv file's content_
```csv
Farid Hidayat, 26, Male
Tiffany Alvord, 22, Female
```

```javascript
var filename = "/path/to/file.csv";
window.FileBufferedReader.read(filename, function(result) {
    console.log(result);
    // Output json object
    // [["Farid Hidayat", 26, "Male"],["Tiffany Alvord", 22, "Female"]]
});
```
