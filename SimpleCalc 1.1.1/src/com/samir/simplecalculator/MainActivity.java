package com.samir.simplecalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener, OnRefreshListener  {

	final int MENU_RESET_ID = 1;
	final int MENU_QUIT_ID = 2;
  
	SwipeRefreshLayout swipeLayout;
  
	EditText etNum1;
	EditText etNum2;

	Button btnAdd;
	Button btnSub;
	Button btnMult;
	Button btnDiv;
//	Button btnSquare;
//	Button btnPi;
	
	double pi = 3.141592;
	  
	TextView tvResult;
	
	String oper = "";
  

	/** When the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    
	    // set the swipe to clear
	    swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
	    swipeLayout.setOnRefreshListener(this);
	    swipeLayout.setColorScheme(R.color.pink,  R.color.indigo, R.color.pink, R.color.indigo);
	    
	    // find the elements
	    etNum1 = (EditText) findViewById(R.id.etNum1);
	    etNum2 = (EditText) findViewById(R.id.etNum2);
	
	    btnAdd = (Button) findViewById(R.id.btnAdd);
	    btnSub = (Button) findViewById(R.id.btnSub);
	    btnMult = (Button) findViewById(R.id.btnMult);
	    btnDiv = (Button) findViewById(R.id.btnDiv);
//	    btnSquare = (Button) findViewById(R.id.btnSquare);
//	    btnPi = (Button) findViewById(R.id.btnPi);
	
	    tvResult = (TextView) findViewById(R.id.tvResult);
	
	    // set a listener
	    btnAdd.setOnClickListener(this);
	    btnSub.setOnClickListener(this);
	    btnMult.setOnClickListener(this);
	    btnDiv.setOnClickListener(this);
//	    btnSquare.setOnClickListener(this);
//	    btnPi.setOnClickListener(this);

	    
	    Toast.makeText(getApplicationContext(), "Hint: pull down to clear the calculator", Toast.LENGTH_SHORT).show();
	    
	}
	  
	@Override public void onRefresh() {
		new Handler().postDelayed(new Runnable() {
			@Override public void run() {
				swipeLayout.setRefreshing(false);
			}
	    }, 500);
	      
		etNum1.setText("");
		etNum2.setText("");
		tvResult.setText("");
	}
	  
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	    float num1 = 0;
	    float num2 = 0;
	    double result = 0;
	
	    // check if the fields are empty
	    if (TextUtils.isEmpty(etNum1.getText().toString())
	        || TextUtils.isEmpty(etNum2.getText().toString())) {
	      return;
	    }
	
	    // read EditText and fill variables with numbers
	    num1 = Float.parseFloat(etNum1.getText().toString());
	    num2 = Float.parseFloat(etNum2.getText().toString());
	
	    // defines the button that has been clicked and performs the corresponding operation
	    // write operation into oper, we will use it later for output
	    switch (v.getId()) {
	    case R.id.btnAdd:
	    	oper = "+";
	        result = num1 + num2;
	        break;
	    case R.id.btnSub:
	    	oper = "-";
	    	result = num1 - num2;
	    	break;
	    case R.id.btnMult:
		    oper = "*";
		    result = num1 * num2;
		    break;
	    case R.id.btnDiv:
	        oper = "/";
	        result = num1 / num2;
	        break;
//	    case R.id.btnSquare:
//	        oper = "^2";
//	        result = num1 * num1;
//	        break;
//	    case R.id.btnPi:
//	        oper = "π";
//	        result = num1 * pi;
//	        break;
	    default:
	        break;
	    }
	
	    // form the output line
	    tvResult.setText("" + result + "");
	}
	  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub 
			 
		 MenuInflater inflater = getMenuInflater();
		 inflater.inflate(R.menu.main, menu);
		   
	//	 menu.add(0, MENU_RESET_ID, 0, "Clear");
	//	 menu.add(0, MENU_QUIT_ID, 0, "Quit");
		 return super.onCreateOptionsMenu(menu);
	}
		
	 @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 // TODO Auto-generated method stub
		 switch (item.getItemId()) {
		 case R.id.about:
			 // transition to the "about" activity
			 Intent intent = new Intent(this, AboutActivity.class );
	         startActivity(intent);
	         break;
		   
	//	 case MENU_RESET_ID:
	//	 	// clear the fields
	//	    etNum1.setText("");
	//	    etNum2.setText("");
	//	    tvResult.setText("");
	//	    break;
	//	     
	//	 case MENU_QUIT_ID:
	//	 	// exit the application
	//	    finish();
	//	    break;
		 }
		   
		 return super.onOptionsItemSelected(item);
		 
	}
	
	 
}
