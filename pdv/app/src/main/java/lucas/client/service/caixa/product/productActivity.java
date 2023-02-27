package lucas.client.service.caixa.product;
import android.app.*;
import android.widget.*;
import android.os.*;
import lucas.client.service.*;
import android.view.*;
import android.content.*;

public class productActivity extends Activity
{
	Context c = this;
	EditText cod1, prod1, quant1, valor1, cod2, prod2, quant2, valor2,
	         cod3, prod3, quant3, valor3, cod4, prod4, quant4, valor4,
	cod5, prod5, quant5, valor5;
	LinearLayout layp2, layp3, layp4, layp5;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product_added);
		
		Bundle b = getIntent().getExtras();
		String quan = b.getString("quant");
		String va = b.getString("valor");
		String cod = b.getString("cod");
		String prod = b.getString("prod");
		layp2 = findViewById(R.id.layP2);
		layp3 = findViewById(R.id.layP3);
		layp4 = findViewById(R.id.layP4);
		layp5 = findViewById(R.id.layP5);
		
		
		cod1 = findViewById(R.id.cod1);
		prod1 = findViewById(R.id.prod1);
		quant1 = findViewById(R.id.quant1);
		valor1 = findViewById(R.id.val1);
		
		cod2 = findViewById(R.id.cod2);
		prod2 = findViewById(R.id.prod2);
		quant2 = findViewById(R.id.quant2);
		valor2 = findViewById(R.id.val2);
		
		cod3 = findViewById(R.id.cod3);
		prod3 = findViewById(R.id.prod3);
		quant3 = findViewById(R.id.quant3);
		valor3 = findViewById(R.id.val3);
		
		cod4 = findViewById(R.id.cod4);
		prod4 = findViewById(R.id.prod4);
		quant4 = findViewById(R.id.quant4);
		valor4 = findViewById(R.id.val4);
		
		cod5 = findViewById(R.id.cod5);
		prod5 = findViewById(R.id.prod5);
		quant5 = findViewById(R.id.quant5);
		valor5 = findViewById(R.id.val5);
		
		cod1.setText(cod.toString());
		prod1.setText(prod.toString());
		quant1.setText(quan.toString());
		valor1.setText(va.toString());
		if(!cod2.getText().toString().equals("")){
			
		}else{
			layp2.setVisibility(View.GONE);
		}
		if(!cod3.getText().toString().equals("")){

		}else{
			layp3.setVisibility(View.GONE);
		}
		if(!cod4.getText().toString().equals("")){

		}else{
			layp4.setVisibility(View.GONE);
		}
		if(!cod5.getText().toString().equals("")){

		}else{
			layp5.setVisibility(View.GONE);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// TODO: Implement this method
		getMenuInflater().inflate(R.menu.util_product, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO: Implement this method
		switch(item.getItemId()){
			case R.id.add:
				return true;
			case R.id.finalizar:
				String result2, result3, result4, result5;
				if(!valor2.getText().toString().equals("")){
					result2 = valor2.getText().toString();
				} else{result2 = "0";}
				if(!valor3.getText().toString().equals("")){
					result3 = valor3.getText().toString();
				} else{result3 = "0";}
				if(!valor4.getText().toString().equals("")){
					result4 = valor4.getText().toString();
				} else{result4 = "0";}
				if(!valor5.getText().toString().equals("")){
					result5 = valor5.getText().toString();
				} else{result5 = "0";}
				Intent it = new Intent(c, pay.class);
				Bundle b = new Bundle();
				b.putString("loc1", cod1.getText().toString());
				b.putString("prod1", prod1.getText().toString());
				b.putString("quant1", quant1.getText().toString());
				b.putString("valor1", valor1.getText().toString());
				
				b.putString("loc2", cod2.getText().toString());
				b.putString("prod2", prod2.getText().toString());
				b.putString("quant2", quant2.getText().toString());
				b.putString("valor2", result2.toString());
				
				b.putString("loc3", cod3.getText().toString());
				b.putString("prod3", prod3.getText().toString());
				b.putString("quant3", quant3.getText().toString());
				b.putString("valor3", result3.toString());
				
				b.putString("loc4", cod4.getText().toString());
				b.putString("prod4", prod4.getText().toString());
				b.putString("quant4", quant4.getText().toString());
				b.putString("valor4", result4.toString());
				
				b.putString("loc5", cod5.getText().toString());
				b.putString("prod5", prod5.getText().toString());
				b.putString("quant5", quant5.getText().toString());
				b.putString("valor5", result5.toString());
				it.putExtras(b);
				startActivity(it);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
