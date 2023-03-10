package lucas.client.service.caixa;

import android.app.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.*;
import java.io.*;
import java.nio.channels.*;
import java.util.*;
import lucas.client.service.*;
import lucas.client.service.caixa.adapters.*;
import lucas.client.service.caixa.product.*;
import lucas.client.service.sqlite.*;
import lucas.client.service.etc.*;
import lucas.client.service.caixa.setup.fechamentos.*;

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
												final ArrayList<String>list = new ArrayList<String>();

												list.add("Mouse USB");
												

												final ArrayAdapter adapter = new ArrayAdapter<>(c, android.R.layout.simple_list_item_1, list);
												ls.setAdapter(adapter);
												ls.setOnItemClickListener(new OnItemClickListener(){

														@Override
														public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
														{
															// TODO: Implement this method
															Object sub = list.get(p3);
															String valor = "25.50";
															Intent it = new Intent(c, productActivity.class);
															Bundle b = new Bundle();
															b.putString("cod", "233");
															b.putString("prod", sub.toString());
															b.putString("valor", valor);
															b.putString("quant", "1");
															it.putExtras(b);
															startActivity(it);
															
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
							final String[] lc = new String[] 
							{"Histórico de vendas", "Controle Estoque", "Fechamento de Caixa", "Sangria"};

							LayoutInflater li = getLayoutInflater();
							View r = li.inflate(R.layout.list_ad, null);
							ListView lis = r.findViewById(R.id.list);
							lis.setAdapter(new mainAd(c, lc));
							lis.setOnItemClickListener(new OnItemClickListener(){

									@Override
									public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4)
									{
										// TODO: Implement this method
										if(lc[p3].toString().startsWith("F")){
											
											Intent itr = new Intent(c, fechaCaixa.class);
											startActivity(itr);
											finish();
										}
									}			
							});
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
