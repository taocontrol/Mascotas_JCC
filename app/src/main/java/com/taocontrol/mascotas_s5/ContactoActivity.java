package com.taocontrol.mascotas_s5;

import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.taocontrol.mascotas_s5.POJO.Mail;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

public class ContactoActivity extends AppCompatActivity {

    private String user;
    private String pass;
    private EditText subject;
    private EditText body;
    private EditText recipient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

        user = "coursera1975@gmail.com";
        pass = "coursera";
        subject = (EditText) findViewById(R.id.tiNombre); //en el subject use el nombre
        body = (EditText) findViewById(R.id.tiComentario);
        recipient = (EditText) findViewById(R.id.tiEmail);

    }

    private void sendMessage() {
        String[] recipients = {recipient.getText().toString()};
        SendEmailAsyncTask email = new SendEmailAsyncTask();
        email.activity = this;
        email.m = new Mail(user, pass);
        email.m.set_from(user);
        email.m.setBody(body.getText().toString());
        email.m.set_to(recipients);
        email.m.set_subject(subject.getText().toString());
        email.execute();
    }

    public void displayMessage(String message) {
        Snackbar.make(findViewById(R.id.btnSend), message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


    class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
        Mail m;
        ContactoActivity activity;

        public SendEmailAsyncTask() {
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                if (m.send()) {
                    activity.displayMessage("Correo enviado.");
                } else {
                    activity.displayMessage("Fallo el envio del correo.");
                }

                return true;
            } catch (AuthenticationFailedException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "Los datos de la cuenta son incorrectos");
                e.printStackTrace();
                activity.displayMessage("Fallo Autentificacion ");
                return false;
            } catch (MessagingException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "Email failed");
                e.printStackTrace();
                activity.displayMessage("Fallo el envio del correo");
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                activity.displayMessage("Error inesperado");
                return false;
            }
        }
    }
}