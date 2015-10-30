var exec = require('cordova/exec');

// getExternalStorageDirectory = /storage/emulated/0
// getDownloadCacheDirectory = //cache

exports.DIRECTORY_EXTERNAL = 'EXTERNAL';
exports.DIRECTORY_INTERNAL = 'INTERNAL';

exports.DIRECTORY_ALARMS = 'Alarms';
exports.DIRECTORY_DCIM = 'DCIM';
exports.DIRECTORY_DOCUMENTS = 'Documents';
exports.DIRECTORY_DOWNLOADS = 'Download';
exports.DIRECTORY_MOVIES = 'Movies';
exports.DIRECTORY_MUSIC = 'Music';
exports.DIRECTORY_NOTIFICATIONS = 'Notifications';
exports.DIRECTORY_PICTURES = 'Pictures';
exports.DIRECTORY_PODCASTS = 'Podcasts';
exports.DIRECTORY_RINGTONES = 'Ringtones';

exports.TEXT = 'text';
exports.CSV = 'csv';
exports.JSON = 'json';

exports.read = function(arg, success, error) {
    return new Promise(function(resolve, reject) {
        var options = {
            environment: exports.DIRECTORY_EXTERNAL,
            publicDirectory: false,
            src: null,
            readAs: exports.TEXT,
            skip: 0,
            limit: 0
        };

        if(typeof(arg) === 'string') { // environment: EXTERNAL
            options.src = arg.replace('file:///storage/emulated/0/', '');
            options.readAs = arg.split('.').pop();
        } else if(typeof(arg) === 'object') { // json object
            if(!arg.src) {
                throw new Error('Source file is needed.');
            }
            if(arg.src) options.src = arg.src;
            if(arg.readAs) options.readAs = arg.readAs;
            if(arg.skip) options.skip = arg.skip;
            if(arg.limit) options.limit = arg.limit;
        }
        exec(resolve, reject, "FileBufferedReader", "read", [options]);
    });
};
