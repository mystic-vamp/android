package com.example.sdop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText E1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        E1=(EditText)findViewById(R.id.txtdata);

    }
    public void readData(View view){
        try {
            File f = new File("/sdcard/myfile.txt");
            FileInputStream fin = new FileInputStream(f);
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            String drow = "";
            String dbuf = "";
            while ((drow=br.readLine())!=null){
                dbuf+=drow+"\n";
            }
            E1.setText(dbuf);
            br.close();
            fin.close();

        }
        catch(Exception e){
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }
    public void writeData(View view){
        try {
            File f = new File("/sdcard/myfile.txt");
            f.createNewFile();
            FileOutputStream fout = new FileOutputStream(f);
            OutputStreamWriter mout = new OutputStreamWriter(fout);
            mout.append(E1.getText().toString());
            mout.close();
            fout.close();
            Toast.makeText(getBaseContext(),"Data Written to SDCARD",Toast.LENGTH_LONG).show();
        }
        catch(Exception e){
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    public void clearData(View view){
        E1.setText("");

    }
}
