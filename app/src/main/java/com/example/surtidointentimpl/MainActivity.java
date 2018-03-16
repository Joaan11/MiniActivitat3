package com.example.surtidointentimpl;


import android.Manifest;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.Contacts;
import android.provider.MediaStore;
import android.widget.ImageView;


public class MainActivity extends Activity implements OnClickListener{
	private Intent in;
	private final String lat = "41.60788";
	private final String lon = "0.623333";
	private final String url = "http://www.eps.udl.cat/";
    private final String udl = "http://www.udl.cat/";
	private final String adressa = "Carrer de Jaume II, 69, Lleida";
	private final String textoABuscar = "escuela politecnica superior";
	private final String telefon = "(+34)691778250";

    private static final int MYPERMISSIONS_CALL_PHONE = 0;
    private static final int MYPERMISSIONS_EX_STORAGE = 2 ;
    private static final int RESULT_LOAD_IMAGE = 0;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
	

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
        Button btn10 = findViewById(R.id.button10);
        Button btn11 = findViewById(R.id.button11);

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
	    btn10.setOnClickListener(this);
	    btn11.setOnClickListener(this);
	    
	}

    @SuppressWarnings("deprecation")
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
                Toast.makeText(this, getString(R.string.opcio10), Toast.LENGTH_LONG).show();
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
                in = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telefon));
                startActivity(in);
                break;
            case R.id.button6:
                Toast.makeText(this, getString(R.string.opcio6), Toast.LENGTH_LONG).show();
                in = new Intent(Intent.ACTION_VIEW);
                in.setData(Contacts.People.CONTENT_URI);
                startActivity(in);
                break;
            case R.id.button7:
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    accessResources(Manifest.permission.CALL_PHONE, MYPERMISSIONS_CALL_PHONE);
                } else {
                    button7();
                }
                break;
            case R.id.button8:
                Toast.makeText(this, getString(R.string.opcio8), Toast.LENGTH_LONG).show();
                in = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("sms", telefon, null));
                startActivity(in);
                break;
            case R.id.button9:
                Toast.makeText(this, getString(R.string.opcio9), Toast.LENGTH_LONG).show();
                in = new Intent(Intent.ACTION_SEND);
                String email = "sss@gmail.com";
                String subject = "demo";
                in.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                in.putExtra(Intent.EXTRA_SUBJECT, subject);
                in.setType("message/rfc822");
                startActivity(Intent.createChooser(in, "Escoger un Email"));
                break;
            case R.id.button10:
                if (ContextCompat.checkSelfPermission(this,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    accessResources(Manifest.permission.READ_EXTERNAL_STORAGE,MYPERMISSIONS_EX_STORAGE);
                }else {
                button10();
                }
                break;
            case R.id.button11:
                in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (in.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(in, REQUEST_IMAGE_CAPTURE);
                }
                break;
        }
	}

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MYPERMISSIONS_CALL_PHONE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted!
                    button7();

                } else {
                    // permission denied!
                }
                return;
            }

            case MYPERMISSIONS_EX_STORAGE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    button10();
                } else {
                    // permission denied!
                }
                return;
            }
        }
    }

    private void accessResources(String callPhone, int mypermissionsCallPhone) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, callPhone)) {

        }else {
            ActivityCompat.requestPermissions(this, new String[]{callPhone}, mypermissionsCallPhone);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }else if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imageView = (ImageView) findViewById(R.id.imgView);
            imageView.setImageBitmap(imageBitmap);
        }
    }

    private void button7(){
        Toast.makeText(this, "getString(R.string.opcio7", Toast.LENGTH_LONG).show();
        in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefon));
        startActivity(in);
    }

    private void button10(){
        Toast.makeText(this, "Accediendo a Galeria", Toast.LENGTH_LONG).show();
        in = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(in, RESULT_LOAD_IMAGE);
    }

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
