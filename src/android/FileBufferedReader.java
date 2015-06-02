package id.co.xinix.cordova.plugins.FileBufferedReader;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import android.os.Environment;

import org.apache.cordova.CallbackContext;

import org.apache.cordova.LOG;

public class FileBufferedReader extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals("read")) {
            JSONObject options = args.getJSONObject(0);
            this.read(options, callbackContext);
            return true;
        }
        return false;
    }

    private void read(JSONObject options, CallbackContext callbackContext) {

        try {

            File path = null;
            File pathFile = null;

            if(options.getBoolean("publicDirectory")) {

            } else {

                if("EXTERNAL".equals(options.getString("environment"))) {

                    path = Environment.getExternalStorageDirectory();
                    pathFile = new File(path, options.getString("src"));

                } else if("INTERNAL".equals(options.getString("environment"))) {

                } else {

                }
            }

            String contentString = convertStreamToString(new FileInputStream(pathFile));
            if("json".equals(options.getString("readAs"))) {
                JSONObject jsonResult = new JSONObject(contentString);
                callbackContext.success(jsonResult);
            }

        } catch(JSONException ex){
        } catch (FileNotFoundException e){
            // LOG.d("::FileBufferedReader::", "file not found");
        } catch(Exception e){
            // LOG.d("::FileBufferedReader::", "Exception");
        } finally {}
    }

    private static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
          sb.append(line);
        }
        reader.close();
        return sb.toString();
    }
}