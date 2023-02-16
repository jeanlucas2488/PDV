package lucas.client.service.caixa.product;
import android.app.*;
import android.support.v7.app.AlertDialog;
import lucas.client.service.sqlite.*;
import android.content.*;
import android.os.*;
import lucas.client.service.*;
import android.view.*;
import android.widget.*;

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
		String[] opts = {"Selecione","Elo Débito","Elo Crédito","Visa Débito", "Visa Crédito", "Master Débito", "Master Crédito", "Hiper", "HiperCard", "Cabal Débito", "Pix", "VerdeCard", "SoroCred", "OuroCard", "PersonalCard", "Banrisul", "BanriCompras", "BanesCard", "American Express"};
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
