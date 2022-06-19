package com.example.dzikir;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edmail, edpassword;

    String nama, password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin=findViewById(R.id.btSignin);
        edmail=findViewById(R.id.edEmail);
        edpassword=findViewById(R.id.edPassword);

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                nama = edmail.getText().toString();
                password = edpassword.getText().toString();
                String email = "admin";
                String pass = "123";

                if
                (nama.equals(email) && password.equals(password)) {
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_LONG).show();
                    Bundle b = new Bundle();
                    b.putString("a",nama.trim());
                    b.putString("b",password.trim());
                    Intent i = new Intent(MainActivity.this,Dzikir.class);
                    i.putExtras(b);
                    OpenActDzikir();
                }

                else if (nama.isEmpty()||password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Email dan Password tidak boleh kosong",Toast.LENGTH_LONG).show();
                }
                //Email Salah
                else if (password.equals(password)) {
                    //jika Email salah
                    Toast.makeText(getApplicationContext(), "Email salah", Toast.LENGTH_LONG).show();

                }
                //Password Salah
                else if (nama.equals(email)) {
                    //jika Password salah
                    Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_LONG).show();

                }
                //Email dan Password Salah
                else {
                    //jika email dan password salah
                    Toast.makeText(getApplicationContext(), "Email dan Password Salah", Toast.LENGTH_LONG).show();
                }
            }
            public void OpenActDzikir(){
                Intent i = new Intent(MainActivity.this,Dzikir.class);
                startActivity(i);
            }

        });
    }
}