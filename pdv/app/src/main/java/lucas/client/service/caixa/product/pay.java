package lucas.client.service.caixa.product;
import android.app.*;
import android.content.*;
import android.icu.text.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.io.*;
import java.nio.channels.*;
import java.util.*;
import lucas.client.service.*;
import lucas.client.service.caixa.*;
import lucas.client.service.etc.*;
import lucas.client.service.sqlite.*;


public class pay extends Activity
{
	DB db;
	Context c = this;
	int opts1, opts2, opts3, opts4, opts5;
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
		Bundle b2 = getIntent().getExtras();
		String val1 = b2.getString("valor1");
		String val2 = b2.getString("valor2");
		String val3 = b2.getString("valor3");
		String val4 = b2.getString("valor4");
		String val5 = b2.getString("valor5");
		Double v1 = new Double(val1);
		Double v2 = new Double(val2);
		Double v3 = new Double(val3);
		Double v4 = new Double(val4);
		Double v5 = new Double(val5);
		double result = v1 + v2 + v3 + v4 + v5;
		DecimalFormatSymbols df = new DecimalFormatSymbols();
		df.setGroupingSeparator('.');
		df.setDecimalSeparator('.');
		DecimalFormat dform = new DecimalFormat("####.##", df);
		som1.setText(dform.format(result));
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
					String pg1, pg2, pg3, pg4, pg5, tr1, tr2, tr3, tr4, tr5;
					Bundle b = getIntent().getExtras();
					String loc1 = b.getString("loc1");
					String prod1 = b.getString("prod1");
					String quant1 = b.getString("quant1");
					String loc2 = b.getString("loc2");
					String prod2 = b.getString("prod2");
					String quant2 = b.getString("quant2");
					String loc3 = b.getString("loc3");
					String prod3 = b.getString("prod3");
					String quant3 = b.getString("quant3");
					String loc4 = b.getString("loc4");
					String prod4 = b.getString("prod4");
					String quant4 = b.getString("quant4");
					String loc5 = b.getString("loc5");
					String prod5 = b.getString("prod5");
					String quant5 = b.getString("quant5");
					if(!pagto1.getText().toString().equals("")){
						pg1 = pagto1.getText().toString();
					}else {pg1 = "0.00";}
					if(!pagto2.getText().toString().equals("")){
						pg2 = pagto2.getText().toString();
					}else {pg2 = "0.00";}
					if(!pagto3.getText().toString().equals("")){
						pg3 = pagto3.getText().toString();
					}else {pg3 = "0.00";}
					if(!pagto4.getText().toString().equals("")){
						pg4 = pagto4.getText().toString();
					}else {pg4 = "0.00";}
					if(!pagto5.getText().toString().equals("")){
						pg5 = pagto5.getText().toString();
					}else {pg5 = "0.00";}
					if(!troco1.getText().toString().equals("")){
						tr1 = troco1.getText().toString();
					}else {tr1 = "0.00";}
					if(!troco2.getText().toString().equals("")){
						tr2 = troco2.getText().toString();
					}else {tr2 = "0.00";}
					if(!troco3.getText().toString().equals("")){
						tr3 = troco3.getText().toString();
					}else {tr3 = "0.00";}
					if(!troco4.getText().toString().equals("")){
						tr4 = troco4.getText().toString();
					}else {tr4 = "0.00";}
					if(!troco5.getText().toString().equals("")){
						tr5 = troco5.getText().toString();
					}else {tr5 = "0.00";}
					util us = new util();
					us.setLoc(loc1.toString());
					us.setProd1(prod1.toString());
					us.setQuant1(quant1.toString());
					us.setValor1(som1.getText().toString());
					us.setP1(pg1.toString());
					us.setPay1(opts[opts1].toString());
					us.setT1(tr1.toString());
					us.setLoc2(loc2.toString());
					us.setProd2(prod2.toString());
					us.setQuant2(quant2.toString());
					us.setValor2(som2.getText().toString());
					us.setP2(pg2.toString());
					us.setPay2(opts[opts2].toString());
					us.setT2(tr2.toString());
					us.setLoc3(loc3.toString());
					us.setProd3(prod3.toString());
					us.setQuant3(quant3.toString());
					us.setValor3(som3.getText().toString());
					us.setP3(pg3.toString());
					us.setPay3(opts[opts3].toString());
					us.setT3(tr3.toString());	
					us.setLoc4(loc4.toString());
					us.setProd4(prod4.toString());
					us.setQuant4(quant4.toString());
					us.setValor4(som4.getText().toString());
					us.setP4(pg4.toString());
					us.setPay4(opts[opts4].toString());
					us.setT4(tr4.toString());	
					us.setLoc5(loc5.toString());
					us.setProd5(prod5.toString());
					us.setQuant5(quant5.toString());
					us.setValor5(som5.getText().toString());
					us.setP5(pg5.toString());
					us.setPay5(opts[opts5].toString());
					us.setT5(tr5.toString());
					DB pr = new DB(c);
					pr.prodIn(us);
					
					Intent itt = new Intent(c, caixaMain.class);
					startActivity(itt);
					finish();
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
										Double so1 = new Double(som1.getText().toString());
										double res = so1 /2;
										DecimalFormatSymbols df = new DecimalFormatSymbols();
										df.setGroupingSeparator('.');
										df.setDecimalSeparator('.');
										DecimalFormat dform = new DecimalFormat("####.##", df);
										som1.getText().clear();
										som1.setText(dform.format(res));
										som2.setText(dform.format(res));
										break;
									case 1:
										spnlay2.setVisibility(View.VISIBLE);
										spnlay3.setVisibility(View.VISIBLE);
										Double so2 = new Double(som1.getText().toString());
										double res2 = so2 /3;
										DecimalFormatSymbols df2 = new DecimalFormatSymbols();
										df2.setGroupingSeparator('.');
										df2.setDecimalSeparator('.');
										DecimalFormat dform2 = new DecimalFormat("####.##", df2);
										som1.setText(dform2.format(res2));
										som2.setText(dform2.format(res2));
										som3.setText(dform2.format(res2));
										break;
									case 2:
										spnlay2.setVisibility(View.VISIBLE);
										spnlay3.setVisibility(View.VISIBLE);
										spnlay4.setVisibility(View.VISIBLE);
										Double so3 = new Double(som1.getText().toString());
										double res3 = so3 /4;
										DecimalFormatSymbols df3 = new DecimalFormatSymbols();
										df3.setGroupingSeparator('.');
										df3.setDecimalSeparator('.');
										DecimalFormat dform3 = new DecimalFormat("####.##", df3);
										som1.setText(dform3.format(res3));
										som2.setText(dform3.format(res3));
										som3.setText(dform3.format(res3));
										som4.setText(dform3.format(res3));
										break;
									case 3:
										Double so4 = new Double(som1.getText().toString());
										double res4 = so4 /5;
										DecimalFormatSymbols df4 = new DecimalFormatSymbols();
										df4.setGroupingSeparator('.');
										df4.setDecimalSeparator('.');
										DecimalFormat dform4 = new DecimalFormat("####.##", df4);
										som1.setText(dform4.format(res4));
										som2.setText(dform4.format(res4));
										som3.setText(dform4.format(res4));
										som4.setText(dform4.format(res4));
										som5.setText(dform4.format(res4));
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
					opts1 = p3;
					if(opts[p3].toString().startsWith("Dinheiro")){
						im1.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(90,85);
						pr.setMargins(+15,+15,+10,0);
						som1.setEms(6);
						im1.setLayoutParams(pr);
						im1.setImageResource(R.drawable.money);
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
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som1.setEms(5);
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
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som1.setEms(5);
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
						pr.setMargins(+15,+17,+5,0);
						som1.setEms(5);
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
						pr.setMargins(+15,+17,+5,0);
						som1.setEms(5);
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
						pr.setMargins(+15,+15,+5,0);
						som1.setEms(5);
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
						pr.setMargins(+15,+15,+5,0);
						som1.setEms(5);
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
						pr.setMargins(+15,+30,+5,0);
						som1.setEms(8);
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
						pr.setMargins(+15,+15,+5,0);
						som1.setEms(6);
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
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+35,+5,0);
						som1.setEms(5);
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
						pr.setMargins(+15,+15,0,0);
						som1.setEms(8);
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
						pr.setMargins(+15,+20,+5,0);
						som1.setEms(6);
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
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+20,+5,0);
						som1.setEms(6);
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
						pr.setMargins(+15,+25,+5,0);
						som1.setEms(5);
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
						pr.setMargins(+15,+25,+5,0);
						som1.setEms(5);
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
						pr.setMargins(+15,15,+5,0);
						som1.setEms(6);
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
						pr.setMargins(+15,+25,+5,0);
						som1.setEms(6);
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
						pr.setMargins(+15,+25,+5,0);
						som1.setEms(6);
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
						pr.setMargins(+15,+25,0,0);
						som1.setEms(5);
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
					opts2 = p3;
					if(opts[p3].toString().startsWith("Dinheiro")){
						lay2.setVisibility(View.VISIBLE);
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(90,85);
						pr.setMargins(+15,+15,+10,0);
						som2.setEms(6);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.money);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.moFind();
							if(!rd.get(0).getMoney().equals("")){
								String re1 = rd.get(0).getMoney();
								String re2 = som2.getText().toString();
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
							us.setMoney(som2.getText().toString());
							DB d1 = new DB(c);
							d1.moneyIn(us);
						}
					} else {lay2.setVisibility(View.GONE);}
					if(opts[p3].toString().startsWith("Selecione")){
						im2.setVisibility(View.GONE);
						som2.setEms(7);
					}
					if(opts[p3].toString().startsWith("Elo Débito")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloDFind();
							if(!rd.get(0).getEloD().equals("")){
								String re1 = rd.get(0).getEloD();
								String re2 = som2.getText().toString();
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
							us.setEloD(som2.getText().toString());
							DB d1 = new DB(c);
							d1.eloDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Elo Crédito")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloCFind();
							if(!rd.get(0).getEloC().equals("")){
								String re1 = rd.get(0).getEloC();
								String re2 = som2.getText().toString();
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
							us.setEloC(som2.getText().toString());
							DB d1 = new DB(c);
							d1.eloCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Visa Débito")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaDFind();
							if(!rd.get(0).getVisaD().equals("")){
								String re1 = rd.get(0).getVisaD();
								String re2 = som2.getText().toString();
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
							us.setVisaD(som2.getText().toString());
							DB d1 = new DB(c);
							d1.visaDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Visa Crédito")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaCFind();
							if(!rd.get(0).getVisaC().equals("")){
								String re1 = rd.get(0).getVisaC();
								String re2 = som2.getText().toString();
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
							us.setVisaC(som2.getText().toString());
							DB d1 = new DB(c);
							d1.visaCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Master Débito")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterDFind();
							if(!rd.get(0).getMasterD().equals("")){
								String re1 = rd.get(0).getMasterD();
								String re2 = som2.getText().toString();
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
							us.setMasterD(som2.getText().toString());
							DB d1 = new DB(c);
							d1.masterDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Master Crédito")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterCFind();
							if(!rd.get(0).getMasterC().equals("")){
								String re1 = rd.get(0).getMasterC();
								String re2 = som2.getText().toString();
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
							us.setMasterC(som2.getText().toString());
							DB d1 = new DB(c);
							d1.masterCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Hiper")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(55,50);
						pr.setMargins(+15,+30,+5,0);
						som2.setEms(8);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.hiper);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperFind();
							if(!rd.get(0).getHiper().equals("")){
								String re1 = rd.get(0).getHiper();
								String re2 = som2.getText().toString();
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
							us.setHiper(som2.getText().toString());
							DB d1 = new DB(c);
							d1.hiperIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Hiper Card")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(85,80);
						pr.setMargins(+15,+15,+5,0);
						som2.setEms(6);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.hiperc);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperCFind();
							if(!rd.get(0).getHiperC().equals("")){
								String re1 = rd.get(0).getHiperC();
								String re2 = som2.getText().toString();
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
							us.setHiperC(som2.getText().toString());
							DB d1 = new DB(c);
							d1.hiperCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Cabal")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+35,+5,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.cabal);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.cabalFind();
							if(!rd.get(0).getCabal().equals("")){
								String re1 = rd.get(0).getCabal();
								String re2 = som2.getText().toString();
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
							us.setCabal(som2.getText().toString());
							DB d1 = new DB(c);
							d1.cabalIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Pix")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+15,0,0);
						som2.setEms(8);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.pix);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.pixFind();
							if(!rd.get(0).getPix().equals("")){
								String re1 = rd.get(0).getPix();
								String re2 = som2.getText().toString();
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
							us.setPix(som2.getText().toString());
							DB d1 = new DB(c);
							d1.pixIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Verde Card")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+20,+5,0);
						som2.setEms(6);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.verde);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.verdeFind();
							if(!rd.get(0).getVerde().equals("")){
								String re1 = rd.get(0).getVerde();
								String re2 = som2.getText().toString();
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
							us.setVerde(som2.getText().toString());
							DB d1 = new DB(c);
							d1.verdeIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Soro Cred")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+20,+5,0);
						som2.setEms(6);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.soro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.soroFind();
							if(!rd.get(0).getSoro().equals("")){
								String re1 = rd.get(0).getSoro();
								String re2 = som2.getText().toString();
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
							us.setSoro(som2.getText().toString());
							DB d1 = new DB(c);
							d1.soroIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Personal Card")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.person);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.personFind();
							if(!rd.get(0).getPerson().equals("")){
								String re1 = rd.get(0).getPerson();
								String re2 = som2.getText().toString();
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
							us.setPerson(som2.getText().toString());
							DB d1 = new DB(c);
							d1.personIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Ouro Card")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(70,60);
						pr.setMargins(+15,+25,+5,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.ouro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ouroFind();
							if(!rd.get(0).getOuro().equals("")){
								String re1 = rd.get(0).getOuro();
								String re2 = som2.getText().toString();
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
							us.setOuro(som2.getText().toString());
							DB d1 = new DB(c);
							d1.ouroIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banrisul")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,+5,0);
						som2.setEms(6);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.banric);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriFind();
							if(!rd.get(0).getbanric().equals("")){
								String re1 = rd.get(0).getbanric();
								String re2 = som2.getText().toString();
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
							us.setBanric(som2.getText().toString());
							DB d1 = new DB(c);
							d1.banriIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banri Compras")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+25,+5,0);
						som2.setEms(6);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.banrico);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriCFind();
							if(!rd.get(0).getBanriC().equals("")){
								String re1 = rd.get(0).getBanriC();
								String re2 = som2.getText().toString();
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
							us.setBanriC(som2.getText().toString());
							DB d1 = new DB(c);
							d1.banriCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banes Card")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som2.setEms(6);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.banes);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banesFind();
							if(!rd.get(0).getBanes().equals("")){
								String re1 = rd.get(0).getBanes();
								String re2 = som2.getText().toString();
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
							us.setBanes(som2.getText().toString());
							DB d1 = new DB(c);
							d1.banesIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("American Express")){
						im2.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,0,0);
						som2.setEms(5);
						im2.setLayoutParams(pr);
						im2.setImageResource(R.drawable.americ);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ameFind();
							if(!rd.get(0).getAmeric().equals("")){
								String re1 = rd.get(0).getAmeric();
								String re2 = som2.getText().toString();
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
							us.setAmeric(som2.getText().toString());
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
		spn3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					opts3 = p3;
					if(opts[p3].toString().startsWith("Dinheiro")){
						lay3.setVisibility(View.VISIBLE);
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(90,85);
						pr.setMargins(+15,+15,+10,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.money);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.moFind();
							if(!rd.get(0).getMoney().equals("")){
								String re1 = rd.get(0).getMoney();
								String re2 = som3.getText().toString();
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
							us.setMoney(som3.getText().toString());
							DB d1 = new DB(c);
							d1.moneyIn(us);
						}
					} else {lay3.setVisibility(View.GONE);}
					if(opts[p3].toString().startsWith("Selecione")){
						im3.setVisibility(View.GONE);
						som3.setEms(7);
					}
					if(opts[p3].toString().startsWith("Elo Débito")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloDFind();
							if(!rd.get(0).getEloD().equals("")){
								String re1 = rd.get(0).getEloD();
								String re2 = som3.getText().toString();
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
							us.setEloD(som3.getText().toString());
							DB d1 = new DB(c);
							d1.eloDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Elo Crédito")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloCFind();
							if(!rd.get(0).getEloC().equals("")){
								String re1 = rd.get(0).getEloC();
								String re2 = som3.getText().toString();
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
							us.setEloC(som3.getText().toString());
							DB d1 = new DB(c);
							d1.eloCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Visa Débito")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaDFind();
							if(!rd.get(0).getVisaD().equals("")){
								String re1 = rd.get(0).getVisaD();
								String re2 = som3.getText().toString();
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
							us.setVisaD(som3.getText().toString());
							DB d1 = new DB(c);
							d1.visaDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Visa Crédito")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaCFind();
							if(!rd.get(0).getVisaC().equals("")){
								String re1 = rd.get(0).getVisaC();
								String re2 = som3.getText().toString();
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
							us.setVisaC(som3.getText().toString());
							DB d1 = new DB(c);
							d1.visaCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Master Débito")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterDFind();
							if(!rd.get(0).getMasterD().equals("")){
								String re1 = rd.get(0).getMasterD();
								String re2 = som3.getText().toString();
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
							us.setMasterD(som3.getText().toString());
							DB d1 = new DB(c);
							d1.masterDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Master Crédito")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterCFind();
							if(!rd.get(0).getMasterC().equals("")){
								String re1 = rd.get(0).getMasterC();
								String re2 = som3.getText().toString();
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
							us.setMasterC(som3.getText().toString());
							DB d1 = new DB(c);
							d1.masterCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Hiper")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(55,50);
						pr.setMargins(+15,+30,+5,0);
						som3.setEms(8);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.hiper);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperFind();
							if(!rd.get(0).getHiper().equals("")){
								String re1 = rd.get(0).getHiper();
								String re2 = som3.getText().toString();
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
							us.setHiper(som3.getText().toString());
							DB d1 = new DB(c);
							d1.hiperIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Hiper Card")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(85,80);
						pr.setMargins(+15,+15,+5,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.hiperc);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperCFind();
							if(!rd.get(0).getHiperC().equals("")){
								String re1 = rd.get(0).getHiperC();
								String re2 = som3.getText().toString();
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
							us.setHiperC(som3.getText().toString());
							DB d1 = new DB(c);
							d1.hiperCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Cabal")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+35,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.cabal);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.cabalFind();
							if(!rd.get(0).getCabal().equals("")){
								String re1 = rd.get(0).getCabal();
								String re2 = som3.getText().toString();
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
							us.setCabal(som3.getText().toString());
							DB d1 = new DB(c);
							d1.cabalIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Pix")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+15,0,0);
						som3.setEms(8);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.pix);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.pixFind();
							if(!rd.get(0).getPix().equals("")){
								String re1 = rd.get(0).getPix();
								String re2 = som3.getText().toString();
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
							us.setPix(som3.getText().toString());
							DB d1 = new DB(c);
							d1.pixIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Verde Card")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+20,+5,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.verde);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.verdeFind();
							if(!rd.get(0).getVerde().equals("")){
								String re1 = rd.get(0).getVerde();
								String re2 = som3.getText().toString();
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
							us.setVerde(som3.getText().toString());
							DB d1 = new DB(c);
							d1.verdeIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Soro Cred")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+20,+5,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.soro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.soroFind();
							if(!rd.get(0).getSoro().equals("")){
								String re1 = rd.get(0).getSoro();
								String re2 = som3.getText().toString();
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
							us.setSoro(som3.getText().toString());
							DB d1 = new DB(c);
							d1.soroIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Personal Card")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.person);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.personFind();
							if(!rd.get(0).getPerson().equals("")){
								String re1 = rd.get(0).getPerson();
								String re2 = som3.getText().toString();
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
							us.setPerson(som3.getText().toString());
							DB d1 = new DB(c);
							d1.personIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Ouro Card")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(70,60);
						pr.setMargins(+15,+25,+5,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.ouro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ouroFind();
							if(!rd.get(0).getOuro().equals("")){
								String re1 = rd.get(0).getOuro();
								String re2 = som3.getText().toString();
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
							us.setOuro(som3.getText().toString());
							DB d1 = new DB(c);
							d1.ouroIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banrisul")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,+5,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.banric);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriFind();
							if(!rd.get(0).getbanric().equals("")){
								String re1 = rd.get(0).getbanric();
								String re2 = som3.getText().toString();
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
							us.setBanric(som3.getText().toString());
							DB d1 = new DB(c);
							d1.banriIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banri Compras")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+25,+5,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.banrico);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriCFind();
							if(!rd.get(0).getBanriC().equals("")){
								String re1 = rd.get(0).getBanriC();
								String re2 = som3.getText().toString();
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
							us.setBanriC(som3.getText().toString());
							DB d1 = new DB(c);
							d1.banriCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banes Card")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som3.setEms(6);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.banes);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banesFind();
							if(!rd.get(0).getBanes().equals("")){
								String re1 = rd.get(0).getBanes();
								String re2 = som3.getText().toString();
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
							us.setBanes(som3.getText().toString());
							DB d1 = new DB(c);
							d1.banesIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("American Express")){
						im3.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,0,0);
						som3.setEms(5);
						im3.setLayoutParams(pr);
						im3.setImageResource(R.drawable.americ);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ameFind();
							if(!rd.get(0).getAmeric().equals("")){
								String re1 = rd.get(0).getAmeric();
								String re2 = som3.getText().toString();
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
							us.setAmeric(som3.getText().toString());
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
		spn4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					opts4 = p3;
					if(opts[p3].toString().startsWith("Dinheiro")){
						lay4.setVisibility(View.VISIBLE);
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(90,85);
						pr.setMargins(+15,+15,+10,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.money);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.moFind();
							if(!rd.get(0).getMoney().equals("")){
								String re1 = rd.get(0).getMoney();
								String re2 = som4.getText().toString();
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
							us.setMoney(som4.getText().toString());
							DB d1 = new DB(c);
							d1.moneyIn(us);
						}
					} else {lay4.setVisibility(View.GONE);}
					if(opts[p3].toString().startsWith("Selecione")){
						im4.setVisibility(View.GONE);
						som4.setEms(7);
					}
					if(opts[p3].toString().startsWith("Elo Débito")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloDFind();
							if(!rd.get(0).getEloD().equals("")){
								String re1 = rd.get(0).getEloD();
								String re2 = som4.getText().toString();
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
							us.setEloD(som4.getText().toString());
							DB d1 = new DB(c);
							d1.eloDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Elo Crédito")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloCFind();
							if(!rd.get(0).getEloC().equals("")){
								String re1 = rd.get(0).getEloC();
								String re2 = som4.getText().toString();
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
							us.setEloC(som4.getText().toString());
							DB d1 = new DB(c);
							d1.eloCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Visa Débito")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaDFind();
							if(!rd.get(0).getVisaD().equals("")){
								String re1 = rd.get(0).getVisaD();
								String re2 = som4.getText().toString();
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
							us.setVisaD(som4.getText().toString());
							DB d1 = new DB(c);
							d1.visaDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Visa Crédito")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaCFind();
							if(!rd.get(0).getVisaC().equals("")){
								String re1 = rd.get(0).getVisaC();
								String re2 = som4.getText().toString();
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
							us.setVisaC(som4.getText().toString());
							DB d1 = new DB(c);
							d1.visaCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Master Débito")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterDFind();
							if(!rd.get(0).getMasterD().equals("")){
								String re1 = rd.get(0).getMasterD();
								String re2 = som4.getText().toString();
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
							us.setMasterD(som4.getText().toString());
							DB d1 = new DB(c);
							d1.masterDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Master Crédito")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterCFind();
							if(!rd.get(0).getMasterC().equals("")){
								String re1 = rd.get(0).getMasterC();
								String re2 = som4.getText().toString();
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
							us.setMasterC(som4.getText().toString());
							DB d1 = new DB(c);
							d1.masterCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Hiper")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(55,50);
						pr.setMargins(+15,+30,+5,0);
						som4.setEms(8);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.hiper);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperFind();
							if(!rd.get(0).getHiper().equals("")){
								String re1 = rd.get(0).getHiper();
								String re2 = som4.getText().toString();
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
							us.setHiper(som4.getText().toString());
							DB d1 = new DB(c);
							d1.hiperIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Hiper Card")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(85,80);
						pr.setMargins(+15,+15,+5,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.hiperc);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperCFind();
							if(!rd.get(0).getHiperC().equals("")){
								String re1 = rd.get(0).getHiperC();
								String re2 = som4.getText().toString();
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
							us.setHiperC(som4.getText().toString());
							DB d1 = new DB(c);
							d1.hiperCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Cabal")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+35,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.cabal);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.cabalFind();
							if(!rd.get(0).getCabal().equals("")){
								String re1 = rd.get(0).getCabal();
								String re2 = som4.getText().toString();
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
							us.setCabal(som4.getText().toString());
							DB d1 = new DB(c);
							d1.cabalIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Pix")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+15,0,0);
						som4.setEms(8);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.pix);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.pixFind();
							if(!rd.get(0).getPix().equals("")){
								String re1 = rd.get(0).getPix();
								String re2 = som4.getText().toString();
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
							us.setPix(som4.getText().toString());
							DB d1 = new DB(c);
							d1.pixIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Verde Card")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+20,+5,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.verde);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.verdeFind();
							if(!rd.get(0).getVerde().equals("")){
								String re1 = rd.get(0).getVerde();
								String re2 = som4.getText().toString();
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
							us.setVerde(som4.getText().toString());
							DB d1 = new DB(c);
							d1.verdeIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Soro Cred")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+20,+5,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.soro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.soroFind();
							if(!rd.get(0).getSoro().equals("")){
								String re1 = rd.get(0).getSoro();
								String re2 = som4.getText().toString();
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
							us.setSoro(som4.getText().toString());
							DB d1 = new DB(c);
							d1.soroIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Personal Card")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.person);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.personFind();
							if(!rd.get(0).getPerson().equals("")){
								String re1 = rd.get(0).getPerson();
								String re2 = som4.getText().toString();
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
							us.setPerson(som4.getText().toString());
							DB d1 = new DB(c);
							d1.personIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Ouro Card")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(70,60);
						pr.setMargins(+15,+25,+5,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.ouro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ouroFind();
							if(!rd.get(0).getOuro().equals("")){
								String re1 = rd.get(0).getOuro();
								String re2 = som4.getText().toString();
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
							us.setOuro(som4.getText().toString());
							DB d1 = new DB(c);
							d1.ouroIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banrisul")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,+5,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.banric);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriFind();
							if(!rd.get(0).getbanric().equals("")){
								String re1 = rd.get(0).getbanric();
								String re2 = som4.getText().toString();
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
							us.setBanric(som4.getText().toString());
							DB d1 = new DB(c);
							d1.banriIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banri Compras")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+25,+5,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.banrico);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriCFind();
							if(!rd.get(0).getBanriC().equals("")){
								String re1 = rd.get(0).getBanriC();
								String re2 = som4.getText().toString();
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
							us.setBanriC(som4.getText().toString());
							DB d1 = new DB(c);
							d1.banriCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banes Card")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som4.setEms(6);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.banes);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banesFind();
							if(!rd.get(0).getBanes().equals("")){
								String re1 = rd.get(0).getBanes();
								String re2 = som4.getText().toString();
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
							us.setBanes(som4.getText().toString());
							DB d1 = new DB(c);
							d1.banesIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("American Express")){
						im4.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,0,0);
						som4.setEms(5);
						im4.setLayoutParams(pr);
						im4.setImageResource(R.drawable.americ);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ameFind();
							if(!rd.get(0).getAmeric().equals("")){
								String re1 = rd.get(0).getAmeric();
								String re2 = som4.getText().toString();
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
							us.setAmeric(som4.getText().toString());
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
		spn5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

				@Override
				public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
				{
					// TODO: Implement this method
					opts5 = p3;
					if(opts[p3].toString().startsWith("Dinheiro")){
						lay5.setVisibility(View.VISIBLE);
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(90,85);
						pr.setMargins(+15,+15,+10,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.money);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.moFind();
							if(!rd.get(0).getMoney().equals("")){
								String re1 = rd.get(0).getMoney();
								String re2 = som5.getText().toString();
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
							us.setMoney(som5.getText().toString());
							DB d1 = new DB(c);
							d1.moneyIn(us);
						}
					} else {lay5.setVisibility(View.GONE);}
					if(opts[p3].toString().startsWith("Selecione")){
						im5.setVisibility(View.GONE);
						som5.setEms(7);
					}
					if(opts[p3].toString().startsWith("Elo Débito")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloDFind();
							if(!rd.get(0).getEloD().equals("")){
								String re1 = rd.get(0).getEloD();
								String re2 = som5.getText().toString();
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
							us.setEloD(som5.getText().toString());
							DB d1 = new DB(c);
							d1.eloDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Elo Crédito")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(100,95);
						pr.setMargins(+15,+15,+10,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.elo);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.eloCFind();
							if(!rd.get(0).getEloC().equals("")){
								String re1 = rd.get(0).getEloC();
								String re2 = som5.getText().toString();
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
							us.setEloC(som5.getText().toString());
							DB d1 = new DB(c);
							d1.eloCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Visa Débito")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaDFind();
							if(!rd.get(0).getVisaD().equals("")){
								String re1 = rd.get(0).getVisaD();
								String re2 = som5.getText().toString();
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
							us.setVisaD(som5.getText().toString());
							DB d1 = new DB(c);
							d1.visaDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Visa Crédito")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+17,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.visa);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.visaCFind();
							if(!rd.get(0).getVisaC().equals("")){
								String re1 = rd.get(0).getVisaC();
								String re2 = som5.getText().toString();
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
							us.setVisaC(som5.getText().toString());
							DB d1 = new DB(c);
							d1.visaCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Master Débito")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterDFind();
							if(!rd.get(0).getMasterD().equals("")){
								String re1 = rd.get(0).getMasterD();
								String re2 = som5.getText().toString();
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
							us.setMasterD(som5.getText().toString());
							DB d1 = new DB(c);
							d1.masterDIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Master Crédito")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(95,90);
						pr.setMargins(+15,+15,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.master);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.masterCFind();
							if(!rd.get(0).getMasterC().equals("")){
								String re1 = rd.get(0).getMasterC();
								String re2 = som5.getText().toString();
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
							us.setMasterC(som5.getText().toString());
							DB d1 = new DB(c);
							d1.masterCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Hiper")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(55,50);
						pr.setMargins(+15,+30,+5,0);
						som5.setEms(8);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.hiper);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperFind();
							if(!rd.get(0).getHiper().equals("")){
								String re1 = rd.get(0).getHiper();
								String re2 = som5.getText().toString();
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
							us.setHiper(som5.getText().toString());
							DB d1 = new DB(c);
							d1.hiperIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Hiper Card")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(85,80);
						pr.setMargins(+15,+15,+5,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.hiperc);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.hiperCFind();
							if(!rd.get(0).getHiperC().equals("")){
								String re1 = rd.get(0).getHiperC();
								String re2 = som5.getText().toString();
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
							us.setHiperC(som5.getText().toString());
							DB d1 = new DB(c);
							d1.hiperCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Cabal")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+35,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.cabal);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.cabalFind();
							if(!rd.get(0).getCabal().equals("")){
								String re1 = rd.get(0).getCabal();
								String re2 = som5.getText().toString();
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
							us.setCabal(som5.getText().toString());
							DB d1 = new DB(c);
							d1.cabalIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Pix")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+15,0,0);
						som5.setEms(8);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.pix);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.pixFind();
							if(!rd.get(0).getPix().equals("")){
								String re1 = rd.get(0).getPix();
								String re2 = som5.getText().toString();
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
							us.setPix(som5.getText().toString());
							DB d1 = new DB(c);
							d1.pixIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Verde Card")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+20,+5,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.verde);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.verdeFind();
							if(!rd.get(0).getVerde().equals("")){
								String re1 = rd.get(0).getVerde();
								String re2 = som5.getText().toString();
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
							us.setVerde(som5.getText().toString());
							DB d1 = new DB(c);
							d1.verdeIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Soro Cred")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+20,+5,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.soro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.soroFind();
							if(!rd.get(0).getSoro().equals("")){
								String re1 = rd.get(0).getSoro();
								String re2 = som5.getText().toString();
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
							us.setSoro(som5.getText().toString());
							DB d1 = new DB(c);
							d1.soroIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Personal Card")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.person);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.personFind();
							if(!rd.get(0).getPerson().equals("")){
								String re1 = rd.get(0).getPerson();
								String re2 = som5.getText().toString();
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
							us.setPerson(som5.getText().toString());
							DB d1 = new DB(c);
							d1.personIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Ouro Card")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(70,60);
						pr.setMargins(+15,+25,+5,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.ouro);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ouroFind();
							if(!rd.get(0).getOuro().equals("")){
								String re1 = rd.get(0).getOuro();
								String re2 = som5.getText().toString();
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
							us.setOuro(som5.getText().toString());
							DB d1 = new DB(c);
							d1.ouroIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banrisul")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,15,+5,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.banric);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriFind();
							if(!rd.get(0).getbanric().equals("")){
								String re1 = rd.get(0).getbanric();
								String re2 = som5.getText().toString();
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
							us.setBanric(som5.getText().toString());
							DB d1 = new DB(c);
							d1.banriIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banri Compras")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(65,60);
						pr.setMargins(+15,+25,+5,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.banrico);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banriCFind();
							if(!rd.get(0).getBanriC().equals("")){
								String re1 = rd.get(0).getBanriC();
								String re2 = som5.getText().toString();
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
							us.setBanriC(som5.getText().toString());
							DB d1 = new DB(c);
							d1.banriCIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("Banes Card")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,+5,0);
						som5.setEms(6);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.banes);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.banesFind();
							if(!rd.get(0).getBanes().equals("")){
								String re1 = rd.get(0).getBanes();
								String re2 = som5.getText().toString();
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
							us.setBanes(som5.getText().toString());
							DB d1 = new DB(c);
							d1.banesIn(us);
						}
					} else {}
					if(opts[p3].toString().startsWith("American Express")){
						im5.setVisibility(View.VISIBLE);
						LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(75,70);
						pr.setMargins(+15,+25,0,0);
						som5.setEms(5);
						im5.setLayoutParams(pr);
						im5.setImageResource(R.drawable.americ);
						try{
							db = new DB(c);
							List<util> rd;
							rd = db.ameFind();
							if(!rd.get(0).getAmeric().equals("")){
								String re1 = rd.get(0).getAmeric();
								String re2 = som5.getText().toString();
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
							us.setAmeric(som5.getText().toString());
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
		AlertDialog.Builder b = new AlertDialog.Builder(c, R.style.dialog);
		b.setTitle("Fechar Conta");
		b.setView(r);
		
		b.create();
		b.show();
	}
}
