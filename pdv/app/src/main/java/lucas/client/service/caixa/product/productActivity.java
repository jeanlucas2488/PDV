package lucas.client.service.caixa.product;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import java.util.*;
import lucas.client.service.*;
import android.widget.TextView.*;

public class productActivity extends Activity
{
	AlertDialog bs, bs2;
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
		quant5.setOnEditorActionListener(new OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p5, int p2, KeyEvent p3)
				{
					// TODO: Implement this method
					Double q = new Double(quant5.getText().toString());
					Double qt = new Double(valor5.getText().toString());
					double res = qt * q;
					valor5.setText(String.valueOf(res));
					return false;
				}
			});
		quant4.setOnEditorActionListener(new OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p4, int p2, KeyEvent p3)
				{
					// TODO: Implement this method
					Double q = new Double(quant4.getText().toString());
					Double qt = new Double(valor4.getText().toString());
					double res = qt * q;
					valor4.setText(String.valueOf(res));
					return false;
				}
			});
		quant3.setOnEditorActionListener(new OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p1, int p2, KeyEvent p3)
				{
					// TODO: Implement this method
					Double q = new Double(quant3.getText().toString());
					Double qt = new Double(valor3.getText().toString());
					double res = qt * q;
					valor3.setText(String.valueOf(res));
					return false;
				}
			});
		quant2.setOnEditorActionListener(new OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p1, int p2, KeyEvent p3)
				{
					// TODO: Implement this method
					Double q = new Double(quant2.getText().toString());
					Double qt = new Double(valor2.getText().toString());
					double res = qt * q;
					valor2.setText(String.valueOf(res));
					return false;
				}
			});
		quant1.setOnEditorActionListener(new OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p1, int p2, KeyEvent p3)
				{
					// TODO: Implement this method
					Double q = new Double(quant1.getText().toString());
					Double qt = new Double(valor1.getText().toString());
					double res = qt * q;
					valor1.setText(String.valueOf(res));
					return false;
				}
		});
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
				String[] l = {"Acessórios P/ Notebook", "Acessórios P/Computador"};
				AlertDialog.Builder sel = new AlertDialog.Builder(c);
				sel.setItems(l, new DialogInterface.OnClickListener(){

						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							// TODO: Implement this method
							switch(p2){
								case 0:
									LayoutInflater li = getLayoutInflater();
									View r = li.inflate(R.layout.ace_list, null);
									ListView ls = r.findViewById(R.id.acelist);
									SearchView sc = r.findViewById(R.id.searchView);
									final ArrayList<String>list = new ArrayList<String>();

									list.add("Mouse USB");
									list.add("Teclado USB Multilaser");
									final ArrayAdapter adapter = new ArrayAdapter<>(c, android.R.layout.simple_list_item_1, list);
									ls.setAdapter(adapter);
									ls.setOnItemClickListener(new OnItemClickListener(){

											@Override
											public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
											{
												// TODO: Implement this method
												Object sub = list.get(p3);
												if(sub.toString().startsWith("Teclado USB Multilaser")){
													bs.dismiss();
													if(!cod4.getText().toString().equals("")){
														layp5.setVisibility(View.VISIBLE);
														cod5.setText("0233");
														prod5.setText(sub.toString());
														quant5.setText("1");
														valor5.setText("32.90");
													} else {

													}
													if(!cod3.getText().toString().equals("")){
														layp4.setVisibility(View.VISIBLE);
														cod4.setText("0233");
														prod4.setText(sub.toString());
														quant4.setText("1");
														valor4.setText("32.90");
													} else {
														
													}
													if(!cod2.getText().toString().equals("")){
														layp3.setVisibility(View.VISIBLE);
														cod3.setText("0233");
														prod3.setText(sub.toString());
														quant3.setText("1");
														valor3.setText("32.90");
													
													}else {
														layp2.setVisibility(View.VISIBLE);
														cod2.setText("0233");
														prod2.setText(sub.toString());
														quant2.setText("1");
														valor2.setText("32.90");
													}
												}
											}

										});
									sc.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
											@Override
											public boolean onQueryTextSubmit(String s) {
												return false;
											}

											@Override
											public boolean onQueryTextChange(String s) {

												adapter.getFilter().filter(s);

												return false;
											}
										});
									AlertDialog.Builder ace = new AlertDialog.Builder(c);
									ace.setView(r);
									ace.create();
									bs = ace.show();
									break;
								case 1:
									break;
							}
						}
					});
				sel.create();
				bs2 = sel.show();
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
