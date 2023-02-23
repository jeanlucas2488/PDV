package lucas.client.service.caixa.product;
import android.app.*;
import android.content.*;
import android.icu.text.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import lucas.client.service.*;
import lucas.client.service.etc.*;
import lucas.client.service.sqlite.*;

import android.support.v7.app.AlertDialog;

public class pay extends Activity
{
	DB db;
	Context c = this;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		LayoutInflater li = getLayoutInflater();
		View r = li.inflate(R.layout.fecha_pedido, null);
		final String[] opts = {"Selecione","Dinheiro", "Elo Débito","Elo Crédito","Visa Débito", "Visa Crédito", "Master Débito", "Master Crédito", "Hiper", "HiperCard", "Cabal Débito", "Pix", "VerdeCard", "SoroCred", "OuroCard", "PersonalCard", "Banrisul", "BanriCompras", "BanesCard", "American Express"};
		final Spinner spn1 = r.findViewById(R.id.spn1);
		final Spinner spn2 = r.findViewById(R.id.spn2);
		final Spinner spn3 = r.findViewById(R.id.spn3);
		final Spinner spn4 = r.findViewById(R.id.spn4);
		final Spinner spn5 = r.findViewById(R.id.spn5);
		final EditText som = r.findViewById(R.id.som1);
		db = new DB(c);
		List<util> rd;
		rd = db.moFind();
		som.setText(rd.get(0).getMoney());
		spn1.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		spn2.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		spn3.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		spn4.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		spn5.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					if(opts[p3].toString().startsWith("Dinheiro")){
							try{
								db = new DB(c);
								List<util> rd;
								rd = db.moFind();
								if(!rd.get(0).getMoney().equals("")){
									String re1 = rd.get(0).getMoney();
									String re2 = "10.75";
									Double d0 = new Double(re1);
									Double d1 = new Double(re2);
									double res = d0 + d1;
									DecimalFormatSymbols df = new DecimalFormatSymbols();
									DecimalFormat dform = new DecimalFormat("####.##", df);
									util us = new util();
									us.setMoney(dform.format(res));
									db.delMoney();
									db.moneyIn(us);	
								} else {}
							}catch(Exception e){
								util us = new util();
								us.setMoney("10");
								DB d1 = new DB(c);
								d1.moneyIn(us);
							}
					} 
				}
				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
				}
		});
		spn2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
				}
			});
		spn3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
				}
			});
		spn4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
				}
			});
		spn5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
				}

				@Override
				public void onNothingSelected(AdapterView<?> p1)
				{
					// TODO: Implement this method
				}
			});
		AlertDialog.Builder b = new AlertDialog.Builder(c, R.style.dialog);
		b.setTitle("Fechar Conta");
		b.setView(r);
		b.create();
		b.show();
	}
}
