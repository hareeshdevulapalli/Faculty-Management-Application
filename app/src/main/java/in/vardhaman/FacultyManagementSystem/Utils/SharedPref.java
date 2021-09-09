package in.vardhaman.FacultyManagementSystem.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref
{
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SharedPref(Context context){
        sharedPreferences = context.getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public String getData(String key){
        return sharedPreferences.getString(key,"");
    }

    public void setData(String key, String value) {
        editor.putString(key,value);
        editor.commit();
    }
}
