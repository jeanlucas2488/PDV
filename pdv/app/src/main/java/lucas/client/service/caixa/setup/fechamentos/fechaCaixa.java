package lucas.client.service.caixa.setup.fechamentos;
import android.app.*;
import android.content.*;
import android.icu.text.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.util.*;
import lucas.client.service.*;
import lucas.client.service.caixa.*;
import lucas.client.service.etc.*;
import lucas.client.service.sqlite.*;
import java.io.*;

public class fechaCaixa extends Activity
{
	Button canc, fecha;
	
	Context c = this;
	ProgressDialog progress;
	String sanR1, sanR2, sanR3, sanR4, sanR5, sanR6;
	LinearLayout trancard, moneyid,sanid, elodid, elocid, visadid, visacid, masterdid, mastercid, hiperid, hipercid, cabalid, pixid, verdeid,
	             soroid, personid, ouroid, banricid, banricoid, banesid, americid;
	String moneyResult,sangRes, eloDResult, eloCResult, visaDResult, visaCResult, masterDResult, masterCResult, hiperResult, HiperCResult,
	       cabalResult, pixResult, verdeResult, personResult, soroResult, ouroResult, banriResult, banricoResult, banesResult, americResult;
	EditText sangria_,operador_,  fundo_, money_, eloD_, eloC_, visaD_, visaC_, masterD_, masterC_,
	hiper_, hiperC_, cabal_, pix_, verde_, soro_, person_, ouro_, banric_, banrico_, banes_, americ_;
    List<util> operador, sangria, fundo, money, eloD, eloC, visaD, visaC, masterD, masterC,
    hiper, hiperC, cabal, pix, verde, soro, person, ouro, banric, banrico, banes, americ;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		LayoutInflater li = getLayoutInflater();
		View r = li.inflate(R.layout.fecha_caixa, null);
		moneyid = r.findViewById(R.id.money_ID);
		trancard = r.findViewById(R.id.trancard);
		trancard.setVisibility(View.GONE);
		elodid = r.findViewById(R.id.eloD_ID);
		elocid = r.findViewById(R.id.eloC_ID);
		visadid = r.findViewById(R.id.visaD_ID);
		visacid = r.findViewById(R.id.visaC_ID);
		masterdid = r.findViewById(R.id.masterD_ID);
		mastercid = r.findViewById(R.id.masterC_ID);
		hiperid = r.findViewById(R.id.hiper_ID);
		hipercid = r.findViewById(R.id.hiperC_ID);
		cabalid = r.findViewById(R.id.cabal_ID);
		pixid = r.findViewById(R.id.pix_ID);
		verdeid = r.findViewById(R.id.verde_ID);
		soroid = r.findViewById(R.id.soro_ID);
		personid = r.findViewById(R.id.person_ID);
		ouroid = r.findViewById(R.id.ouro_ID);
		banricid = r.findViewById(R.id.banric_ID);
		banricoid = r.findViewById(R.id.banrico_ID);
		banesid = r.findViewById(R.id.banes_ID);
		americid = r.findViewById(R.id.americ_ID);
		fundo_ = r.findViewById(R.id.fundo);
		sangria_ = r.findViewById(R.id.sangria);
		operador_ = r.findViewById(R.id.operador);
		money_ = r.findViewById(R.id.dinheiro);
		eloD_ = r.findViewById(R.id.eloD);
		eloC_ = r.findViewById(R.id.eloC);
		visaD_ = r.findViewById(R.id.visaD);
		visaC_ = r.findViewById(R.id.visaC);
		masterD_ = r.findViewById(R.id.masterD);
		masterC_ = r.findViewById(R.id.masterC);
		hiper_ = r.findViewById(R.id.hiper);
		hiperC_ = r.findViewById(R.id.hiperc);
		cabal_ = r.findViewById(R.id.cabal);
		pix_ = r.findViewById(R.id.pix);
		verde_ = r.findViewById(R.id.verde);
		soro_ = r.findViewById(R.id.soro);
		person_ = r.findViewById(R.id.person);
		ouro_ = r.findViewById(R.id.ouro);
		banric_ = r.findViewById(R.id.banrisul);
		banrico_ = r.findViewById(R.id.banrico);
		banes_ = r.findViewById(R.id.banes);
		americ_ = r.findViewById(R.id.americ);
		canc = r.findViewById(R.id.canc);
		fecha = r.findViewById(R.id.fecha);
		
		try{
			DB db = new DB(c);
			sangria = db.saFind();
			if(sangria.get(0).getSangria().equals("")){
				sangria_.setVisibility(View.VISIBLE);
			    sangRes = sangria.get(0).getSangria();
			} 
		}catch(Exception e){
			sangRes = "";
			sangria_.setVisibility(View.GONE);
		}
		try{
			DB db = new DB(c);
			americ = db.ameFind();
			if(!americ.get(0).getAmeric().equals("")){
				americid.setVisibility(View.VISIBLE);
				trancard.setVisibility(View.VISIBLE);
			    americResult = americ.get(0).getAmeric();
			} 
		}catch(Exception e){
			americid.setVisibility(View.GONE);
			americResult = "";
		}
		try{
			DB db = new DB(c);
			banes = db.banesFind();
			if(!banes.get(0).getBanes().equals("")){
				trancard.setVisibility(View.VISIBLE);
				banesid.setVisibility(View.VISIBLE);
			    banesResult = banes.get(0).getBanes();
			} 
		}catch(Exception e){
			banesid.setVisibility(View.GONE);
			banesResult = "";
		}
		try{
			DB db = new DB(c);
			banrico = db.banriCFind();
			if(!banrico.get(0).getBanriC().equals("")){
				trancard.setVisibility(View.VISIBLE);
				banricoid.setVisibility(View.VISIBLE);
			    banricoResult = banrico.get(0).getBanriC();
			} 
		}catch(Exception e){
			banricoid.setVisibility(View.GONE);
			banricoResult = "";
		}
		try{
			DB db = new DB(c);
			banric = db.banriFind();
			if(!banric.get(0).getbanric().equals("")){
				trancard.setVisibility(View.VISIBLE);
				banricid.setVisibility(View.VISIBLE);
			    banriResult = banric.get(0).getbanric();
			} 
		}catch(Exception e){
			banricid.setVisibility(View.GONE);
			banriResult = "";
		}
		try{
			DB db = new DB(c);
			ouro = db.ouroFind();
			if(!ouro.get(0).getOuro().equals("")){
				trancard.setVisibility(View.VISIBLE);
				ouroid.setVisibility(View.VISIBLE);
			    ouroResult = ouro.get(0).getOuro();
			} 
		}catch(Exception e){
			ouroid.setVisibility(View.GONE);
			ouroResult = "";
		}
		try{
			DB db = new DB(c);
			person = db.personFind();
			if(!person.get(0).getPerson().equals("")){
				trancard.setVisibility(View.VISIBLE);
				personid.setVisibility(View.VISIBLE);
			    personResult = person.get(0).getPerson();
			} 
		}catch(Exception e){
			personid.setVisibility(View.GONE);
			personResult = "";
		}
		try{
			DB db = new DB(c);
			soro = db.soroFind();
			if(!soro.get(0).getSoro().equals("")){
				trancard.setVisibility(View.VISIBLE);
				soroid.setVisibility(View.VISIBLE);
			    soroResult = soro.get(0).getSoro();
			} 
		}catch(Exception e){
			soroid.setVisibility(View.GONE);
			soroResult = "";
		}
		try{
			DB db = new DB(c);
			verde = db.verdeFind();
			if(!verde.get(0).getVerde().equals("")){
				trancard.setVisibility(View.VISIBLE);
				verdeid.setVisibility(View.VISIBLE);
			    verdeResult = verde.get(0).getVerde();
			} 
		}catch(Exception e){
			verdeid.setVisibility(View.GONE);
			verdeResult = "";
		}
		try{
			DB db = new DB(c);
			pix = db.pixFind();
			if(!pix.get(0).getPix().equals("")){
				trancard.setVisibility(View.VISIBLE);
				pixid.setVisibility(View.VISIBLE);
			    pixResult = pix.get(0).getPix();
			} 
		}catch(Exception e){
			pixid.setVisibility(View.GONE);
			pixResult = "";
		}
		try{
			DB db = new DB(c);
			cabal = db.cabalFind();
			if(!cabal.get(0).getCabal().equals("")){
				trancard.setVisibility(View.VISIBLE);
				cabalid.setVisibility(View.VISIBLE);
			    cabalResult = cabal.get(0).getCabal();
			} 
		}catch(Exception e){
			cabalid.setVisibility(View.GONE);
			cabalResult = "";
		}
		try{
			DB db = new DB(c);
			hiperC = db.hiperCFind();
			if(!hiperC.get(0).getHiperC().equals("")){
				trancard.setVisibility(View.VISIBLE);
				hipercid.setVisibility(View.VISIBLE);
			    HiperCResult = hiperC.get(0).getHiperC();
			} 
		}catch(Exception e){
			hipercid.setVisibility(View.GONE);
			HiperCResult = "";
		}
		try{
			DB db = new DB(c);
			hiper = db.hiperFind();
			if(!hiper.get(0).getHiper().equals("")){
				trancard.setVisibility(View.VISIBLE);
				hiperid.setVisibility(View.VISIBLE);
			    hiperResult = hiper.get(0).getHiper();
			} 
		}catch(Exception e){
			hiperid.setVisibility(View.GONE);
			hiperResult = "";
		}
		try{
			DB db = new DB(c);
			masterC = db.masterCFind();
			if(!masterC.get(0).getMasterC().equals("")){
				trancard.setVisibility(View.VISIBLE);
				mastercid.setVisibility(View.VISIBLE);
			    masterCResult = masterC.get(0).getMasterC();
			} 
		}catch(Exception e){
			mastercid.setVisibility(View.GONE);
			masterCResult = "";
		}
		try{
			DB db = new DB(c);
			masterD = db.masterDFind();
			if(!masterD.get(0).getMasterD().equals("")){
				trancard.setVisibility(View.VISIBLE);
				masterdid.setVisibility(View.VISIBLE);
			    masterDResult = masterD.get(0).getMasterD();
			} 
		}catch(Exception e){
			masterdid.setVisibility(View.GONE);
			masterDResult = "";
		}
		try{
			DB db = new DB(c);
			visaC = db.visaCFind();
			if(!visaC.get(0).getVisaC().equals("")){
				trancard.setVisibility(View.VISIBLE);
				visacid.setVisibility(View.VISIBLE);
			    visaCResult = visaC.get(0).getVisaC();
			} 
		}catch(Exception e){
			visacid.setVisibility(View.GONE);
			visaCResult = "";
		}
		try{
			DB db = new DB(c);
			visaD = db.visaDFind();
			if(!visaD.get(0).getVisaD().equals("")){
				trancard.setVisibility(View.VISIBLE);
				visadid.setVisibility(View.VISIBLE);
			    visaDResult = visaD.get(0).getVisaD();
			} 
		}catch(Exception e){
			visadid.setVisibility(View.GONE);
			visaDResult = "";
		}
		try{
			DB db = new DB(c);
			eloC = db.eloCFind();
			if(!eloC.get(0).getEloC().equals("")){
				trancard.setVisibility(View.VISIBLE);
				elocid.setVisibility(View.VISIBLE);
				eloCResult = eloC.get(0).getEloC();
			} 
		}catch(Exception e){
			elocid.setVisibility(View.GONE);
			eloCResult = "";
		}
		try{
			DB db = new DB(c);
			eloD = db.eloDFind();
			if(!eloD.get(0).getEloD().equals("")){
				trancard.setVisibility(View.VISIBLE);
				elodid.setVisibility(View.VISIBLE);
				eloDResult = eloD.get(0).getEloD();
			} 
		}catch(Exception e){
			elodid.setVisibility(View.GONE);
			eloDResult = "";
			
		}
		try{
			DB db = new DB(c);
			money = db.moFind();
			if(money.get(0).getMoney().equals("")){
				moneyid.setVisibility(View.VISIBLE);
				moneyResult = money.get(0).getMoney();
			} 
		}catch(Exception e){
			moneyid.setVisibility(View.GONE);
			moneyResult = "";
		}
		fecha.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					progress = new ProgressDialog(c);
					progress.setMax(100);
					progress.setMessage("Iniciando Fechamento...");
					progress.setTitle("Fechamento de Caixa");
					progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					progress.show();
					new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									while (progress.getProgress() <= progress
										   .getMax()) {
										Thread.sleep(600);
										handle.sendMessage(handle.obtainMessage());
										if (progress.getProgress() == 14) {
											progress.setMessage("Gerando NFe da Redução Z...");
											String sanResult, moneyRes, eloDRes, eloCRes, visaDRes, visaCRes, masterDRes, masterCRes, hiperRes, hiperCRes, cabalRes, pixRes,
												verdeRes, soroRes, personRes, ouroRes, banriRes, banricRes, banesRes, americRes;
											if(!sangRes.toString().equals("")){
												DB db = new DB(c);
												util sanRes1 = db.sanFind(1);
												util sanRes2 = db.sanFind(2);
												util sanRes3 = db.sanFind(3);
												util sanRes4 = db.sanFind(4);
												util sanRes5 = db.sanFind(5);
												util sanRes6 = db.sanFind(6);
												try{
													if(!sanRes1.toString().equals("")){
														sanR1 = "<tr>"+
															"<td id='clM'>" + sanRes1.getSanMot() + "</td> <td id='clVal'>" + sanRes1.getSanVal() + "</td>"+
															"</tr>";
													}else{}
												}catch(Exception e){
													sanR1 = "";
												}
												try{
													if(!sanRes2.toString().equals("")){
														sanR2 = "<tr>"+
															"<td id='clM'>" + sanRes2.getSanMot() + "</td> <td id='clVal'>" + sanRes2.getSanVal() + "</td>"+
															"</tr>";
													}else{}
												}catch(Exception e){
													sanR2 = "";
												}
												try{
													if(!sanRes3.toString().equals("")){
														sanR3 = "<tr>"+
															"<td id='clM'>" + sanRes3.getSanMot() + "</td> <td id='clVal'>" + sanRes3.getSanVal() + "</td>"+
															"</tr>";
													}else{}
												}catch(Exception e){
													sanR3 = "";
												}
												try{
													if(!sanRes4.toString().equals("")){
														sanR4 = "<tr>"+
															"<td id='clM'>" + sanRes4.getSanMot() + "</td> <td id='clVal'>" + sanRes4.getSanVal() + "</td>"+
															"</tr>";
													}else{}
												}catch(Exception e){
													sanR4 = "";
												}
												try{
													if(!sanRes5.toString().equals("")){
														sanR5 = "<tr>"+
															"<td id='clM'>" + sanRes5.getSanMot() + "</td> <td id='clVal'>" + sanRes5.getSanVal() + "</td>"+
															"</tr>";
													}else{}
												}catch(Exception e){
													sanR5 = "";
												}
												try{
													if(!sanRes6.toString().equals("")){
														sanR6 = "<tr>"+
															"<td id='clM'>" + sanRes6.getSanMot() + "</td> <td id='clVal'>" + sanRes6.getSanVal() + "</td>"+
															"</tr>";
													}else{}
												}catch(Exception e){
													sanR6 = "";
												}
												Double somaSan = new Double(sangRes);
												Double compRes = new Double(sangria_.getText().toString());
												double res = somaSan - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
												sanResult = "<div>"+
													"<center>"+
													"<div class='san'><b>Sangria de Caixa:</b></div>"+
													"<table>"+
													"<tr>"+
													"<th id='mot'>Motivo</th><th id='val'>Valor</th>"+
													sanR1.toString() +
													sanR2.toString() +
													sanR3.toString() +
													sanR4.toString() + 
													sanR5.toString() +
													sanR6.toString() +
													"<tr>"+
													"<td id='clS'>Soma:</td> <td id='clL'>Lançado:</td>"+
													"</tr>"+
													"<tr>"+
													"<td id='clso'>R$" + sangRes.toString() + "</td> <td id='clu'>R$" + sangria_.getText().toString() + "</td>"+
													"</tr>"+
													"<tr>"+
													"<td></td><td id='clVal'>Diferença:</td>"+
													"</tr>"+
													"<tr>"+
													"<td></td><td id='clVal'>R$" + dform4.format(res) + "</td>"+
													"</tr>"+
													"</tr>"+
													"</table>"+
													"</center>"+
													"</div>";
											} else {
												sanResult = "";
											}
											
											if(!moneyResult.toString().equals("")){
												Double somaMoney = new Double(moneyResult);
												Double compRes = new Double(money_.getText().toString());
												double res = somaMoney - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    moneyRes = "<div class='bo'><h4 id='bor'>BORDERO:</h4><h4 id='cx'>CAIXA:</h4>" +
													"<h5 id='ln'>------------</h5> <h5 id='ln2'>------------</h5>" +
												"</div>"+
												"<div class='bo'><h4 id='bor'>" + moneyResult.toString() + "</h4> <h4 id='cx'>" + money_.getText().toString() + "</h4></div>" +
													"<div class='bo'><h4 id='cx2'>Dif: R$" + dform4.format(res) + "</h4></div>"+
												"</div><br/><br/>";
											} else {
												moneyRes = "";
											}
											if(!eloDResult.toString().equals("")){
												Double somaEloD = new Double(eloDResult);
												Double compRes = new Double(eloD_.getText().toString());
												double res = somaEloD - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    eloDRes = "<div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Elo Débito: R$" + eloDResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + eloD_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												eloDRes = "";
											}
											if(!eloCResult.toString().equals("")){
												Double somaEloC = new Double(eloCResult);
												Double compRes = new Double(eloC_.getText().toString());
												double res = somaEloC - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    eloCRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Elo Crédito: R$" + eloCResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + eloC_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												eloCRes = "";
											}
											if(!visaDResult.toString().equals("")){
												Double somaVisaD = new Double(visaDResult);
												Double compRes = new Double(visaD_.getText().toString());
												double res = somaVisaD - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    visaDRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Visa Débito: R$" + visaDResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + visaD_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												visaDRes = "";
											}
											if(!visaCResult.toString().equals("")){
												Double somaVisaC = new Double(visaCResult);
												Double compRes = new Double(visaC_.getText().toString());
												double res = somaVisaC - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    visaCRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Visa Crédito: R$" + visaCResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + visaC_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												visaCRes = "";
											}
											if(!masterDResult.toString().equals("")){
												Double somaMasterD = new Double(masterDResult);
												Double compRes = new Double(masterD_.getText().toString());
												double res = somaMasterD - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    masterDRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Master Débito: R$" + masterDResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + masterD_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												masterDRes = "";
											}
											if(!masterCResult.toString().equals("")){
												Double somaMasterC = new Double(masterCResult);
												Double compRes = new Double(masterC_.getText().toString());
												double res = somaMasterC - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    masterCRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Master Crédito: R$" + masterCResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + masterC_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												masterCRes = "";
											}
											if(!hiperResult.toString().equals("")){
												Double somaHiper = new Double(hiperResult);
												Double compRes = new Double(hiper_.getText().toString());
												double res = somaHiper - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    hiperRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Hiper: R$" + hiperResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + hiper_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												hiperRes = "";
											}
											if(!HiperCResult.toString().equals("")){
												Double somaHiperC = new Double(HiperCResult);
												Double compRes = new Double(hiperC_.getText().toString());
												double res = somaHiperC - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    hiperCRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>HiperCard: R$" + HiperCResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + hiperC_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												hiperCRes = "";
											}
											if(!cabalResult.toString().equals("")){
												Double somaCabal = new Double(cabalResult);
												Double compRes = new Double(cabal_.getText().toString());
												double res = somaCabal - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    cabalRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Cabal Débito: R$" + cabalResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + cabal_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												cabalRes = "";
											}
											if(!pixResult.toString().equals("")){
												Double somaPix = new Double(pixResult);
												Double compRes = new Double(pix_.getText().toString());
												double res = somaPix - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    pixRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Pix: R$" + pixResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + pix_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												pixRes = "";
											}
											if(!verdeResult.toString().equals("")){
												Double somaVerde = new Double(verdeResult);
												Double compRes = new Double(verde_.getText().toString());
												double res = somaVerde - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    verdeRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>VerdeCard: R$" + verdeResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + verde_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												verdeRes = "";
											}
											if(!soroResult.toString().equals("")){
												Double somaSoro = new Double(soroResult);
												Double compRes = new Double(soro_.getText().toString());
												double res = somaSoro - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    soroRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>SoroCred: R$" + soroResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + soro_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												soroRes = "";
											}
											if(!personResult.toString().equals("")){
												Double somaPerson = new Double(personResult);
												Double compRes = new Double(person_.getText().toString());
												double res = somaPerson - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    personRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>Personal Card: R$" + personResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + person_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												personRes = "";
											}
											if(!ouroResult.toString().equals("")){
												Double somaOuro = new Double(ouroResult);
												Double compRes = new Double(ouro_.getText().toString());
												double res = somaOuro - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    ouroRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>OuroCard: R$" + ouroResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + ouro_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												ouroRes = "";
											}
											if(!banriResult.toString().equals("")){
												Double somaBanri = new Double(banriResult);
												Double compRes = new Double(banric_.getText().toString());
												double res = somaBanri - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    banriRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>BanriSul: R$" + banriResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + banric_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												banriRes = "";
											}
											if(!banricoResult.toString().equals("")){
												Double somaBanric = new Double(banricoResult);
												Double compRes = new Double(masterD_.getText().toString());
												double res = somaBanric - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    banricRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>BanriCompras: R$" + banricoResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + banrico_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												banricRes = "";
											}
											if(!banesResult.toString().equals("")){
												Double somaBanes = new Double(banesResult);
												Double compRes = new Double(banes_.getText().toString());
												double res = somaBanes - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    banesRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>BanesCard: R$" + banesResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + banes_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												banesRes = "";
											}
											if(!americResult.toString().equals("")){
												Double somaAmeric = new Double(americResult);
												Double compRes = new Double(americ_.getText().toString());
												double res = somaAmeric - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
											    americRes = "<br/><br/><div><p style='text-align:left;'>"+
													"<b style='text-align:left;'>American Express: R$" + americResult.toString() + "</b>"+
												    "<b style='float:right;'>R$" + americ_.getText().toString() + "</b><br/>"+
												    "<b style='float:right;'>---------</b><br/><b style='float:right;'>R$" + dform4.format(res) + "</b>"+
												    "</p></div><br/>";
											} else {
												americRes = "";
											}
											try{
											  File root = new File(Environment.getExternalStorageDirectory(), "redução.html");
											  FileWriter fw = new FileWriter(root);
												fw.write(
												    "<html>"+
													"<head>"+
													"<body>"+
													"<style>"+
													"body{"+
													"height:auto;"+
													"margin:5px;"+
												"}"+
												".nav2 {"+
													"margin-top:5px;"+
													"height:auto;"+
													"text-align:center;"+
													"padding:20px 20px 20px;"+
													"background:#eeff1566;"+
												"}"+
												".nav {"+
													"margin-top:10px;"+
													"margin:auto;"+
													"height:auto;"+
													"text-align:center;"+
													"padding:20px 20px 20px;"+
													"background:#eeff1566;"+
												"}"+
												"#bor{"+
													"text-align:left;"+
												"}"+
												"#bor_{"+
													"margin-top:-20px;"+
													"text-align:left;"+
												"}"+
												"#dat{"+
													"margin-left:20px;"+
												"}"+
												"#cx{"+
													"margin-top:-35px;"+
													"text-align:right;"+
												"}"+
												"#cx2{"+
													"margin-top:20px;"+
													"margin-right:5px;"+
													"text-align:right;"+
												"}"+
												"#ln {"+
													"text-align:left;"+
													"margin-top:-20px;"+
												"}"+
												"#ln2 {"+
													"text-align:right;"+
													"margin-top:-35px;"+
												"}"+
												".bo {"+
													"margin:10px;"+
												"}"+
													"#mot{"+
													"color:#fff;"+
													"padding:15px 50px 15px;"+
													"background:#7015ff;"+
												"}"+
												"#val{"+
													"color:#fff;"+
													"padding:15px 50px 15px;"+
													"background:#ff3400;"+
												"}"+
												"#clM{"+
													"background:#f4aaff;"+
													"padding:10px;"+
												"}"+
												"#clS{"+
													"background:#00cc46;"+
													"padding:10px;"+
												"}"+
												"#clL{"+
													"color:#fff;"+
													"background:#ff1f00;"+
													"padding:10px;"+
												"}"+
												"#clso{"+
													"background:#86ff6a68;"+
													"padding:10px;"+
												"}"+
												"#clu{"+
													"color:#fff;"+
													"background:#ff340089;"+
													"padding:10px;"+
												"}"+
												"#clVal{"+
													"background:#90ff2b;"+
													"padding:10px;"+
												"}"+
												".san{"+
													"padding:15px;"+
													"margin:10px;"+
													"color:#fff;"+
													"margin-bottom:0;"+
													"background:#e32bff;"+
												"}"+
												"</style>"+
												"</head>"+
												"<div class='nav'>Cupom Fiscal NFe</div>"+
												"<div class='nav2'><p id='bor'>Lucas Informática <br/><br/>Rua Colombo, 381 - Petrópolis <br/>CEP: 89209-005 - Joinville SC<br/><u>Data: 08/03/23</u><u id='dat'>Hora: 13:32:10</u></p><h4>+------------------------------------+</h4>REDUÇÃO Z:<h4>+------------------------------------+</h4>"+
												"<br/>"+
												moneyRes +
												sanResult +
												eloDRes +
												eloCRes + 
												visaDRes +
												visaCRes +
												masterDRes +
												masterCRes +
												hiperRes +
												hiperCRes +
												cabalRes +
												pixRes +
												verdeRes +
												soroRes +
												personRes +
												ouroRes +
												banriRes +
												banricRes +
												banesRes +
												americRes +
												"</div></body></html>");
											}catch(IOException e){
												
											}
										}
										if (progress.getProgress() == 24) {
											progress.setMessage("Escrevendo NFe da Redução Z no Sistema...");
										}
										if (progress.getProgress() == 40) {
											progress.setMessage("Zerando Transações...");
										}
										if (progress.getProgress() == 50) {
											progress.setMessage("Zerando Lançamentos...");
										}
										if (progress.getProgress() == 70) {
											progress.setMessage("Zerando Cupons...");
										}
										if (progress.getProgress() == 80) {
											progress.setMessage("Fazendo LogOff de Operador...");
										}
										if (progress.getProgress() == 90) {
											progress.setMessage("Salvando Banco de Dados...");
										}
										if (progress.getProgress() == 100) {
											progress.setMessage("Fechamento Concluído!");
										}
									}
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}).start();
				}
				Handler handle = new Handler() {
					@Override
					public void handleMessage(Message msg) {
						super.handleMessage(msg);
						progress.incrementProgressBy(2);
					}
				};
			});
		canc.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					Intent itt = new Intent(c, caixaMain.class);
					startActivity(itt);
					finish();
				}
			});
			AlertDialog.Builder br = new AlertDialog.Builder(c, R.style.dialog);
			br.setTitle("Fechamento de Caixa");
			br.setView(r);
			br.create();
			br.show();
	}
}
