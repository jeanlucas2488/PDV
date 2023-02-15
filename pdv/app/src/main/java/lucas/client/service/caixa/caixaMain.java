package lucas.client.service.caixa;

import android.app.*;
import android.os.*;
import lucas.client.service.*;
import android.widget.*;
import lucas.client.service.caixa.adapters.*;
import java.util.*;
import android.widget.AdapterView.*;
import android.view.*;
import android.content.*;

public class caixaMain extends Activity
{
List<String> lt = new ArrayList<String>();
Context c = this;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		lt.add("Acessórios");
		lt.add("Gamer");
		lt.add("Cliente");
		lt.add("Funções");
		GridView gd = findViewById(R.id.grid);
		gd.setAdapter(new gridAd(this, lt));
		gd.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					switch(p3){
						case 0:
							String[] l = {"Acessórios P/ Notebook", "Acessórios P/Computador"};
							AlertDialog.Builder sel = new AlertDialog.Builder(c);
							sel.setSingleChoiceItems(l, 0, new DialogInterface.OnClickListener(){

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
												ArrayList<String>list = new ArrayList<String>();

												list.add("January");
												list.add("February");
												list.add("March");
												list.add("April");
												list.add("May");
												list.add("June");
												list.add("July");
												list.add("August");
												list.add("September");
												list.add("October");
												list.add("November");
												list.add("December");

												final ArrayAdapter adapter = new ArrayAdapter<>(c, android.R.layout.simple_list_item_1, list);
												ls.setAdapter(adapter);

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
													ace.show();
												break;
											case 1:
												break;
										}
									}
							});
							sel.create();
							sel.show();
							break;
					case 1:
							String[] lg = {"Acessórios", "Consoles", "Linha G-Force"};
							AlertDialog.Builder selG = new AlertDialog.Builder(c);
							selG.setSingleChoiceItems(lg, 0, new DialogInterface.OnClickListener(){

									@Override
									public void onClick(DialogInterface p1, int p2)
									{
										// TODO: Implement this method
									}
								});
							selG.create();
							selG.show();
						break;
					case 2:
						break;
						
					case 3:
							String[] lc = new String[] 
							{"Histórico de vendas", "Controle Estoque", "Fechamento de Caixa", "Sangria"};

							LayoutInflater li = getLayoutInflater();
							View r = li.inflate(R.layout.list_ad, null);
							ListView lis = r.findViewById(R.id.list);
							lis.setAdapter(new mainAd(c, lc));
							AlertDialog.Builder selc = new AlertDialog.Builder(c);
							selc.setView(r);
							selc.create();
							selc.show();
						break;
					}
				}
		});
	}
	
}
