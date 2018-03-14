package com.example.surtidointentimpl;


import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private Intent in;
	private final String lat = "41.60788";
	private final String lon = "0.623333";
	private final String url = "http://www.eps.udl.cat/";
    private final String udl = "http://www.udl.cat/";
	private final String adressa = "Carrer de Jaume II, 69, Lleida";
	private final String textoABuscar = "escuela politecnica superior";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

	    Button btn1 = findViewById(R.id.button1);
	    Button btn2 = findViewById(R.id.button2);
	    Button btn3 = findViewById(R.id.button3);
	    Button btn4 = findViewById(R.id.button4);
	    Button btn5 = findViewById(R.id.button5);
	    Button btn6 = findViewById(R.id.button6);
	    Button btn7 = findViewById(R.id.button7);
        Button btn8 = findViewById(R.id.button8);
        Button btn9 = findViewById(R.id.button9);
        TextView udl = findViewById(R.id.udl);

	    btn1.setOnClickListener(this);
	    btn2.setOnClickListener(this);
	    btn3.setOnClickListener(this);
	    btn4.setOnClickListener(this);
	    btn5.setOnClickListener(this);
	    btn6.setOnClickListener(this);
	    btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
	    udl.setOnClickListener(this);
	    
	}

	public void onClick (View v) {
		switch (v.getId()) {
            case R.id.button1:
              Toast.makeText(this, getString(R.string.opcio1), Toast.LENGTH_LONG).show();
              in = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + lat + ',' + lon));
              startActivity(in);
              break;
            case R.id.button2:
                Toast.makeText(this, getString(R.string.opcio2), Toast.LENGTH_LONG).show();
                in = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + adressa));
                startActivity(in);
                break;
            case R.id.button3:
                Toast.makeText(this, getString(R.string.opcio3), Toast.LENGTH_LONG).show();
                in = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(in);
                break;
            case R.id.udl:
                Toast.makeText(this, getString(R.string.opcio3), Toast.LENGTH_LONG).show();
                in = new Intent(Intent.ACTION_VIEW, Uri.parse(udl));
                startActivity(in);
                break;
            case R.id.button4:
                Toast.makeText(this, getString(R.string.opcio4), Toast.LENGTH_LONG).show();
                in = new Intent(Intent.ACTION_WEB_SEARCH);
                in.putExtra(SearchManager.QUERY, textoABuscar);
                startActivity(in);
                break;
            case R.id.button5:
                Toast.makeText(this, getString(R.string.opcio5), Toast.LENGTH_LONG).show();
                in = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "@string/telef"));
                startActivity(in);
                break;
            case R.id.button6:
                Toast.makeText(this, getString(R.string.opcio6), Toast.LENGTH_LONG).show();
                in = new Intent(Intent.ACTION_VIEW);
                in.setData(ContactsContract.Contacts.CONTENT_URI);
                startActivity(in);
                break;
            case R.id.button7:
                Toast.makeText(this, getString(R.string.opcio7), Toast.LENGTH_LONG).show();
                in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "@string/telef"));
                startActivity(in);
                break;
            case R.id.button8:
                Toast.makeText(this, getString(R.string.opcio8), Toast.LENGTH_LONG).show();
                in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "@string/telef"));
                startActivity(in);
                break;
            case R.id.button9:
                Toast.makeText(this, getString(R.string.opcio9), Toast.LENGTH_LONG).show();
                in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "@string/telef"));
                startActivity(in);
                break;
        }
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
