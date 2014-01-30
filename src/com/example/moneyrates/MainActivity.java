package com.example.moneyrates;

import java.text.DecimalFormat;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

	public Spinner currency1;
	public Spinner currency2;
	double convertedMoney=0;
	final DecimalFormat d = new DecimalFormat("#");
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		currency1 = (Spinner) findViewById(R.id.currency1);
		currency2 = (Spinner) findViewById(R.id.currency2);
		
		Button calculate = (Button)findViewById(R.id.button1);
		
		final EditText editCurrency = (EditText)findViewById(R.id.editText1);
		final EditText finalCurrency = (EditText)findViewById(R.id.editText2);
		finalCurrency.setEnabled(false);
		
		calculate.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				double initialMoney = Double.valueOf(editCurrency.getText().toString());
				String typeFirst = currency1.getSelectedItem().toString();
				String typeSecond = currency2.getSelectedItem().toString();
				
				//Messy 20 total conversion cases
				
				//USD
				if (typeFirst.equals("USD") && typeSecond.equals("EUR")){
					convertedMoney= initialMoney * .732708;
				}
				else if (typeFirst.equals("USD") && typeSecond.equals("BTC")){
					convertedMoney= initialMoney * .00118051210615;
				}
				else if (typeFirst.equals("USD") && typeSecond.equals("CNY")){
					convertedMoney= initialMoney * 6.0582;
				}
				else if (typeFirst.equals("USD") && typeSecond.equals("DOGE")){
					convertedMoney= initialMoney * 682.39110522;
				}
				
				//EURO
				else if (typeFirst.equals("EUR") && typeSecond.equals("USD")){
					convertedMoney= initialMoney * 1.3648;
				}
				else if (typeFirst.equals("EUR") && typeSecond.equals("BTC")){
					convertedMoney= initialMoney * 0.001672;
				}
				else if (typeFirst.equals("EUR") && typeSecond.equals("CNY")){
					convertedMoney= initialMoney * 8.270074;
				}
				else if (typeFirst.equals("EUR") && typeSecond.equals("DOGE")){
					convertedMoney= initialMoney * 905.79710145;
				}
				
				//BitCoin
				else if (typeFirst.equals("BTC") && typeSecond.equals("USD")){
					convertedMoney= initialMoney * 847.09;
				}
				else if (typeFirst.equals("BTC") && typeSecond.equals("EUR")){
					convertedMoney= initialMoney * 600;
				}
				else if (typeFirst.equals("BTC") && typeSecond.equals("CNY")){
					convertedMoney= initialMoney * 4945;
				}
				else if (typeFirst.equals("BTC") && typeSecond.equals("DOGE")){
					convertedMoney= initialMoney * 543478.26086957;
				}
				
				//CNY, Chinese RenMinBi
				else if (typeFirst.equals("CNY") && typeSecond.equals("USD")){
					convertedMoney= initialMoney * .165125;
				}
				else if (typeFirst.equals("CNY") && typeSecond.equals("EUR")){
					convertedMoney= initialMoney * .120945;
				}
				else if (typeFirst.equals("CNY") && typeSecond.equals("BTC")){
					convertedMoney= initialMoney * 0.0002021;
				}
				else if (typeFirst.equals("CNY") && typeSecond.equals("DOGE")){
					convertedMoney= initialMoney * 112.679831249;
				}
				
				//DOGE
				else if (typeFirst.equals("DOGE") && typeSecond.equals("USD")){
					convertedMoney= initialMoney * 0.00146544;
				}
				else if (typeFirst.equals("DOGE") && typeSecond.equals("EUR")){
					convertedMoney= initialMoney * 0.00110400;
				}
				else if (typeFirst.equals("DOGE") && typeSecond.equals("BTC")){
					convertedMoney= initialMoney * 0.00000184;
				}
				else if (typeFirst.equals("DOGE") && typeSecond.equals("RMB")){
					convertedMoney= initialMoney * 0.0088779286;
				}
				
				//Base Case
				else if (typeFirst.equals(typeSecond)){
					convertedMoney = initialMoney;
				}
				else{
					convertedMoney = 6666666.666;
				}
				finalCurrency.setText(d.format(convertedMoney));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
