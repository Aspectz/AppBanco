package jogasa.simarro.aplicacionbanco.pojo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.content.res.Configuration;
import android.widget.Toast;

import java.util.Locale;

import jogasa.simarro.aplicacionbanco.R;


public class SettingsActivity extends PreferenceActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences pref;
        pref=getSharedPreferences("preferenciasbancarias", Context.MODE_PRIVATE);
        SharedPreferences.Editor edt=pref.edit();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, new PreferenciasFragment());
        fragmentTransaction.commit();

    }

    public static class PreferenciasFragment extends PreferenceFragment {
        @Override


        public void onCreate(final Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.opciones);

            SharedPreferences pref=getActivity().getSharedPreferences("preferenciasbancarias",Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor=pref.edit();


            ListPreference idioma=(ListPreference)findPreference("idioma");
            idioma.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    switch(newValue.toString()){
                        case "ESP":
                          //  Toast.makeText(getActivity(), "Espanol", Toast.LENGTH_SHORT).show();
                            Locale espanol=new Locale("es","ES");
                            Locale.setDefault(espanol);

                            Configuration config_es=new Configuration();
                            config_es.locale=espanol;
                            getResources().updateConfiguration(config_es,getResources().getDisplayMetrics());

                            editor.putString("idioma","esp");
                            editor.commit();

                            //Reiniciar activity para ver cambios
                            getActivity().recreate();
                            break;
                        case "ENG":
                            Locale ingles=new Locale("en","EN");
                            Locale.setDefault(ingles);

                            Configuration config_en=new Configuration();
                            config_en.locale=ingles;
                            getResources().updateConfiguration(config_en,getResources().getDisplayMetrics());

                            editor.putString("idioma","eng");
                            editor.commit();

                            //Reiniciar activity para ver cambios
                            getActivity().recreate();

                            break;
                    }
                    return false;
                }
            });

            ListPreference color = (ListPreference) findPreference("color");
            color.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(Preference preference, Object newValue) {
                    switch (newValue.toString()){
                        case "RED":
                            editor.putString("color","#FF0000");
                            editor.commit();
                            break;
                        case "BLUE":
                            editor.putString("color","#0000ff");
                            editor.commit();
                            break;
                        case "YELLOW":
                            editor.putString("color","#ffff00");
                            editor.commit();
                            break;
                        case "GREEN":
                            editor.putString("color","#008f39");
                            editor.commit();
                            break;
                        case "DEFAULT":
                            editor.putString("color","#ffffff");
                            editor.commit();
                            break;
                    }
                    editor.putString("color", newValue.toString());
                    return false;
                }
            });

        }




    }
    }
