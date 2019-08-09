package com.example.cafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int cont = 0;
    int precocafe = 4;
    int precoleite = 5;
    int precochoco = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.email);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent sendEmail = new Intent(Intent.ACTION_SEND);

                sendEmail.setType("text/plain");
                //email
                String[] addresses = {"cafe.do.ifc.concordia@gmail.com"};
                sendEmail.putExtra(Intent.EXTRA_EMAIL, addresses);
                sendEmail.putExtra(Intent.EXTRA_TEXT, "Olá, quero um café!");
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Café!");
                if (sendEmail.resolveActivity(getPackageManager()) != null) {

                    startActivity(sendEmail);
                }
            }
        });
            }
    public void aumentar(View view){
        TextView contagem = (TextView) findViewById(R.id.contagem);
    cont++;
    String m = String.valueOf(cont);
    contagem.setText(m);

    }
    public void diminuir(View view){
        TextView contagem = (TextView) findViewById(R.id.contagem);
        if(cont>0) {
            cont--;
            String m = String.valueOf(cont);
            contagem.setText(m);
        }
    }

    public void radiobotao(View view){
        switch(view.getId()) {
            case R.id.cafe:
                 cafezin();
                    break;
            case R.id.leite:
                    late();
                    break;
            case R.id.choco:
                    chocolate();
                    break;
        }
    }
    public void cafezin(){
        TextView uni = (TextView)findViewById(R.id.unitario);
        TextView tot = (TextView)findViewById(R.id.total);
        uni.setText("R$"+precocafe+",00");
        int x = cont*precocafe;
        tot.setText("R$"+x+",00");
        TextView modelo = (TextView)findViewById(R.id.modelo);
        if(cont ==1) {
            modelo.setText("Gostaria de 1 cafe, por favor. \nO valor total sera de R$4,00. \nObrigado!");
        } else {
            modelo.setText("Gostaria de "+cont+" cafes, por favor. \nO valor total sera de R$"+x+",00. \nObrigado!");
        }
    }
    public void late(){
        TextView uni = (TextView)findViewById(R.id.unitario);
        TextView tot = (TextView)findViewById(R.id.total);
        uni.setText("R$"+precoleite+",00");
        int x = cont*precoleite;
        tot.setText("R$"+x+",00");
        TextView modelo = (TextView)findViewById(R.id.modelo);
        if(cont ==1) {
            modelo.setText("Gostaria de 1 cafe com leite, por favor. \nO valor total sera de R$5,00. \nObrigado!");
        } else {
            modelo.setText("Gostaria de "+cont+" cafes com leite, por favor. \nO valor total sera de R$"+x+",00. \nObrigado!");
        }
    }
    public void chocolate(){
        TextView uni = (TextView)findViewById(R.id.unitario);
        TextView tot = (TextView)findViewById(R.id.total);
        uni.setText("R$"+precochoco+",00");
        int x = cont*precochoco;
        tot.setText("R$"+x+",00");
        TextView modelo = (TextView)findViewById(R.id.modelo);
        if(cont ==1) {
            modelo.setText("Gostaria de 1 Chocolate quente, por favor. \nO valor total sera de R$6,00. \nObrigado!");
        } else {
            modelo.setText("Gostaria de "+cont+" Chocolates quente, por favor. \nO valor total sera de R$"+x+",00. \nObrigado!");
        }
    }

}
