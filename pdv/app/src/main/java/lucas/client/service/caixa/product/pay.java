package lucas.client.service.caixa.product;
import android.app.*;
import android.content.*;
import android.os.*;
import android.support.v7.app.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.nio.channels.*;
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
		db = new DB(c);
		
		File backupDB = null;
		try {

			File sd = Environment.getExternalStorageDirectory();
			File data = Environment.getDataDirectory();

			if (sd.canWrite()) {
				String currentDBPath = "//data//" + c.getPackageName()
					+ "//databases//" + "myDB.db";
				File currentDB = new File(data, currentDBPath);
				backupDB = new File(sd, "myDB.db");

				if (currentDB.exists()) {
					FileChannel src = new FileInputStream(currentDB).getChannel();
					FileChannel dst = new FileOutputStream(backupDB).getChannel();
					dst.transferFrom(src, 0, src.size());                    
					src.close();
					dst.close();
				}
			} else {
				System.out.println("Não pode escrever no sd");
			}

		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
		LayoutInflater li = getLayoutInflater();
		View r = li.inflate(R.layout.fecha_pedido, null);
		final String[] opts = {"Selecione","Dinheiro", "Elo Débito","Elo Crédito","Visa Débito", "Visa Crédito", "Master Débito", "Master Crédito", "Hiper", "HiperCard", "Cabal Débito", "Pix", "VerdeCard", "SoroCred", "OuroCard", "PersonalCard", "Banrisul", "BanriCompras", "BanesCard", "American Express"};
		final Spinner spn1 = r.findViewById(R.id.spn1);
		final Spinner spn2 = r.findViewById(R.id.spn2);
		final Spinner spn3 = r.findViewById(R.id.spn3);
		final Spinner spn4 = r.findViewById(R.id.spn4);
		final Spinner spn5 = r.findViewById(R.id.spn5);
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
							util us = new util();
							String u = "10";
							us.setMoney(u.toString());
							db.moneyIn(us);
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
