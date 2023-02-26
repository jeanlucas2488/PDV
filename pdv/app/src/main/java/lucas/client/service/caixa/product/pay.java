package lucas.client.service.caixa.product;
import android.app.*;
import android.content.*;
import android.icu.text.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.util.*;
import lucas.client.service.*;
import lucas.client.service.etc.*;
import lucas.client.service.sqlite.*;
import android.widget.TableLayout.*;


public class pay extends Activity
{
	DB db;
	Context c = this;
	Button fim, tipo;
	ImageView im1, im2, im3, im4, im5;
	LinearLayout lay1, lay2, lay3, lay4, lay5;
	LinearLayout spnlay2, spnlay3, spnlay4, spnlay5;
	EditText som1, som2, som3, som4, som5, 
	         pagto1, pagto2, pagto3, pagto4, pagto5,
			 troco1, troco2, troco3, troco4, troco5;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		LayoutInflater li = getLayoutInflater();
		View r = li.inflate(R.layout.fecha_pedido, null);
		final String[] opts = {"Selecione","Dinheiro", "Elo Débito","Elo Crédito","Visa Débito", "Visa Crédito", "Master Débito", "Master Crédito", "Hiper", "Hiper Card", "Cabal Débito", "Pix", "Verde Card", "Soro Cred", "Ouro Card", "Personal Card", "Banrisul", "Banri Compras", "Banes Card", "American Express"};
		final Spinner spn1 = r.findViewById(R.id.spn1);
		final Spinner spn2 = r.findViewById(R.id.spn2);
		final Spinner spn3 = r.findViewById(R.id.spn3);
		final Spinner spn4 = r.findViewById(R.id.spn4);
		final Spinner spn5 = r.findViewById(R.id.spn5);
		fim = r.findViewById(R.id.finish);
		tipo = r.findViewById(R.id.tipo);
		lay1 = r.findViewById(R.id.lay1);
		lay2 = r.findViewById(R.id.lay2);
		lay3 = r.findViewById(R.id.lay3);
		lay4 = r.findViewById(R.id.lay4);
		lay5 = r.findViewById(R.id.lay5);
		spnlay2 = r.findViewById(R.id.spnlay2);
		spnlay3 = r.findViewById(R.id.spnlay3);
		spnlay4 = r.findViewById(R.id.spnlay4);
		spnlay5 = r.findViewById(R.id.spnlay5);
		som1 = r.findViewById(R.id.som1);
		som2 = r.findViewById(R.id.som2);
		som3 = r.findViewById(R.id.som3);
		som4 = r.findViewById(R.id.som4);
		som5 = r.findViewById(R.id.som5);
		im1 = r.findViewById(R.id.im1);
		im2 = r.findViewById(R.id.im2);
		im3 = r.findViewById(R.id.im3);
		im4 = r.findViewById(R.id.im4);
		im5 = r.findViewById(R.id.im5);
		pagto1 = r.findViewById(R.id.pagto1);
		pagto2 = r.findViewById(R.id.pagto2);
		pagto3 = r.findViewById(R.id.pagto3);
		pagto4 = r.findViewById(R.id.pagto4);
		pagto5 = r.findViewById(R.id.pagto5);
		troco1 = r.findViewById(R.id.troco1);
		troco2 = r.findViewById(R.id.troco2);
		troco3 = r.findViewById(R.id.troco3);
		troco4 = r.findViewById(R.id.troco4);
		troco5 = r.findViewById(R.id.troco5);
		spnlay2.setVisibility(View.GONE);
		spnlay3.setVisibility(View.GONE);
		spnlay4.setVisibility(View.GONE);
		spnlay5.setVisibility(View.GONE);
		lay2.setVisibility(View.GONE);
		lay3.setVisibility(View.GONE);
		lay4.setVisibility(View.GONE);
		lay5.setVisibility(View.GONE);
		spn1.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		spn2.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		spn3.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		spn4.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		spn5.setAdapter(new ArrayAdapter<String>(c, android.R.layout.simple_dropdown_item_1line, opts));
		fim.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
				}
		});
		tipo.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					String[] op = new String[] {"2 Pagamentos", "3 Pagamentos", "4 Pagamentos", "5 Pagamentos"};
					AlertDialog.Builder sel = new AlertDialog.Builder(pay.this, AlertDialog.THEME_DEVICE_DEFAULT_DARK);
					sel.setTitle("+1 Tipo Pagto");
					sel.setItems(op, new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								// TODO: Implement this method
								switch(p2){
									case 0:
										spnlay2.setVisibility(View.VISIBLE);

										break;
									case 1:
										spnlay2.setVisibility(View.VISIBLE);
										spnlay3.setVisibility(View.VISIBLE);
										break;
									case 2:
										spnlay2.setVisibility(View.VISIBLE);
										spnlay3.setVisibility(View.VISIBLE);
										spnlay4.setVisibility(View.VISIBLE);
										break;
									case 3:
										spnlay2.setVisibility(View.VISIBLE);
										spnlay3.setVisibility(View.VISIBLE);
										spnlay4.setVisibility(View.VISIBLE);
										spnlay5.setVisibility(View.VISIBLE);
										break;
								}
							}
						});
					sel.create();
					sel.show();
				}
			});
		spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					if(opts[p3].toString().startsWith("Dinheiro")){
						lay1.setVisibility(View.VISIBLE);
							try{
								db = new DB(c);
								List<util> rd;
								rd = db.moFind();
								if(!rd.get(0).getMoney().equals("")){
									String re1 = rd.get(0).getMoney();
									String re2 = som1.getText().toString();
									Double d0 = new Double(re1);
									Double d1 = new Double(re2);
									double res = d0 + d1;
									DecimalFormatSymbols df = new DecimalFormatSymbols();
									df.setGroupingSeparator('.');
									df.setDecimalSeparator('.');
									DecimalFormat dform = new DecimalFormat("####.##", df);
									util us = new util();
									us.setMoney(dform.format(res));
									db.delMoney();
									db.moneyIn(us);	
								} else {}
							}catch(Exception e){
								util us = new util();
								us.setMoney(som1.getText().toString());
								DB d1 = new DB(c);
								d1.moneyIn(us);
							}
					} else {lay1.setVisibility(View.GONE);}
					if(opts[p3].toString().startsWith("Selecione")){
						im1.setVisibility(View.GONE);
						som1.setEms(7);
					}
					if(opts[p3].toString().startsWith("Elo Débito")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,0,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloDFind();
							if(!rd.get(0).getEloD().equals("")){
								String re1 = rd.get(0).getEloD();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setEloD(dform.format(res));
								db.delEloD();
								db.eloDIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setEloD(som1.getText().toString());
							DB d1 = new DB(c);
							d1.eloDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Elo Crédito")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,0,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloCFind();
							if(!rd.get(0).getEloC().equals("")){
								String re1 = rd.get(0).getEloC();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setEloC(dform.format(res));
								db.delEloC();
								db.eloCIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setEloC(som1.getText().toString());
							DB d1 = new DB(c);
							d1.eloCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Visa Débito")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,0,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaDFind();
							if(!rd.get(0).getVisaD().equals("")){
								String re1 = rd.get(0).getVisaD();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVisaD(dform.format(res));
								db.delVisaD();
								db.visaDIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setVisaD(som1.getText().toString());
							DB d1 = new DB(c);
							d1.visaDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Visa Crédito")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,0,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaCFind();
							if(!rd.get(0).getVisaC().equals("")){
								String re1 = rd.get(0).getVisaC();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVisaC(dform.format(res));
								db.delVisaC();
								db.visaCIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setVisaC(som1.getText().toString());
							DB d1 = new DB(c);
							d1.visaCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Master Débito")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,0,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterDFind();
							if(!rd.get(0).getMasterD().equals("")){
								String re1 = rd.get(0).getMasterD();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMasterD(dform.format(res));
								db.delMasterD();
								db.masterDIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setMasterD(som1.getText().toString());
							DB d1 = new DB(c);
							d1.masterDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Master Crédito")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,0,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterCFind();
							if(!rd.get(0).getMasterC().equals("")){
								String re1 = rd.get(0).getMasterC();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setMasterC(dform.format(res));
								db.delMasterC();
								db.masterCIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setMasterC(som1.getText().toString());
							DB d1 = new DB(c);
							d1.masterCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Hiper")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(55,50);
						pr.setMargins(+15,15,-70,0);
						som1.setEms(10);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.hiper);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperFind();
							if(!rd.get(0).getHiper().equals("")){
								String re1 = rd.get(0).getHiper();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setHiper(dform.format(res));
								db.delHiper();
								db.hiperIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setHiper(som1.getText().toString());
							DB d1 = new DB(c);
							d1.hiperIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Hiper Card")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(85,80);
						pr.setMargins(+15,0,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.hiperc);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperCFind();
							if(!rd.get(0).getHiperC().equals("")){
								String re1 = rd.get(0).getHiperC();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setHiperC(dform.format(res));
								db.delHiperC();
								db.hiperCIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setHiperC(som1.getText().toString());
							DB d1 = new DB(c);
							d1.hiperCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Cabal")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(55,50);
						pr.setMargins(+15,15,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.cabal);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.cabalFind();
							if(!rd.get(0).getCabal().equals("")){
								String re1 = rd.get(0).getCabal();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setCabal(dform.format(res));
								db.delCabal();
								db.cabalIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setCabal(som1.getText().toString());
							DB d1 = new DB(c);
							d1.cabalIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Pix")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.pix);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.pixFind();
							if(!rd.get(0).getPix().equals("")){
								String re1 = rd.get(0).getPix();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setPix(dform.format(res));
								db.delPix();
								db.pixIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setPix(som1.getText().toString());
							DB d1 = new DB(c);
							d1.pixIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Verde Card")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.verde);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.verdeFind();
							if(!rd.get(0).getVerde().equals("")){
								String re1 = rd.get(0).getVerde();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setVerde(dform.format(res));
								db.delVerde();
								db.verdeIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setVerde(som1.getText().toString());
							DB d1 = new DB(c);
							d1.verdeIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Soro Cred")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(55,50);
						pr.setMargins(+15,20,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.soro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.soroFind();
							if(!rd.get(0).getSoro().equals("")){
								String re1 = rd.get(0).getSoro();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setSoro(dform.format(res));
								db.delSoro();
								db.soroIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setSoro(som1.getText().toString());
							DB d1 = new DB(c);
							d1.soroIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Personal Card")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.person);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.personFind();
							if(!rd.get(0).getPerson().equals("")){
								String re1 = rd.get(0).getPerson();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setPerson(dform.format(res));
								db.delPerson();
								db.personIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setPerson(som1.getText().toString());
							DB d1 = new DB(c);
							d1.personIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Ouro Card")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(70,60);
						pr.setMargins(+15,15,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.ouro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ouroFind();
							if(!rd.get(0).getOuro().equals("")){
								String re1 = rd.get(0).getOuro();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setOuro(dform.format(res));
								db.delOuro();
								db.ouroIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setOuro(som1.getText().toString());
							DB d1 = new DB(c);
							d1.ouroIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banrisul")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.banric);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriFind();
							if(!rd.get(0).getbanric().equals("")){
								String re1 = rd.get(0).getbanric();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanric(dform.format(res));
								db.delBanric();
								db.banriIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setBanric(som1.getText().toString());
							DB d1 = new DB(c);
							d1.banriIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banri Compras")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,15,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.banrico);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriCFind();
							if(!rd.get(0).getBanriC().equals("")){
								String re1 = rd.get(0).getBanriC();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanriC(dform.format(res));
								db.delBanriC();
								db.banriCIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setBanriC(som1.getText().toString());
							DB d1 = new DB(c);
							d1.banriCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banes Card")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.banes);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banesFind();
							if(!rd.get(0).getBanes().equals("")){
								String re1 = rd.get(0).getBanes();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setBanes(dform.format(res));
								db.delBanes();
								db.banesIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setBanes(som1.getText().toString());
							DB d1 = new DB(c);
							d1.banesIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("American Express")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,-70,0);
						som1.setEms(7);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.americ);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ameFind();
							if(!rd.get(0).getAmeric().equals("")){
								String re1 = rd.get(0).getAmeric();
								String re2 = som1.getText().toString();
								Double d0 = new Double(re1);
								Double d1 = new Double(re2);
								double res = d0 + d1;
								DecimalFormatSymbols df = new DecimalFormatSymbols();
								df.setGroupingSeparator('.');
								df.setDecimalSeparator('.');
								DecimalFormat dform = new DecimalFormat("####.##", df);
								util us = new util();
								us.setAmeric(dform.format(res));
								db.delAmeric();
								db.americIn(us);	
							} else {}
						}catch(Exception e){
							util us = new util();
							us.setAmeric(som1.getText().toString());
							DB d1 = new DB(c);
							d1.americIn(us);
						}
					} else {}
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
