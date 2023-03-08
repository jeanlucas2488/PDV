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

public class fechaCaixa extends Activity
{
	Button canc, fecha;
	
	Context c = this;
	ProgressDialog progress;
	LinearLayout moneyid,sanid, elodid, elocid, visadid, visacid, masterdid, mastercid, hiperid, hipercid, cabalid, pixid, verdeid,
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
		setContentView(R.layout.fecha_caixa);
		moneyid = findViewById(R.id.money_ID);
		
		elodid = findViewById(R.id.eloD_ID);
		elocid = findViewById(R.id.eloC_ID);
		visadid = findViewById(R.id.visaD_ID);
		visacid = findViewById(R.id.visaC_ID);
		masterdid = findViewById(R.id.masterD_ID);
		mastercid = findViewById(R.id.masterC_ID);
		hiperid = findViewById(R.id.hiper_ID);
		hipercid = findViewById(R.id.hiperC_ID);
		cabalid = findViewById(R.id.cabal_ID);
		pixid = findViewById(R.id.pix_ID);
		verdeid = findViewById(R.id.verde_ID);
		soroid = findViewById(R.id.soro_ID);
		personid = findViewById(R.id.person_ID);
		ouroid = findViewById(R.id.ouro_ID);
		banricid = findViewById(R.id.banric_ID);
		banricoid = findViewById(R.id.banrico_ID);
		banesid = findViewById(R.id.banes_ID);
		americid = findViewById(R.id.americ_ID);
		fundo_ = findViewById(R.id.fundo);
		sangria_ = findViewById(R.id.sangria);
		operador_ = findViewById(R.id.operador);
		money_ = findViewById(R.id.dinheiro);
		eloD_ = findViewById(R.id.eloD);
		eloC_ = findViewById(R.id.eloC);
		visaD_ = findViewById(R.id.visaD);
		visaC_ = findViewById(R.id.visaC);
		masterD_ = findViewById(R.id.masterD);
		masterC_ = findViewById(R.id.masterC);
		hiper_ = findViewById(R.id.hiper);
		hiperC_ = findViewById(R.id.hiperc);
		cabal_ = findViewById(R.id.cabal);
		pix_ = findViewById(R.id.pix);
		verde_ = findViewById(R.id.verde);
		soro_ = findViewById(R.id.soro);
		person_ = findViewById(R.id.person);
		ouro_ = findViewById(R.id.ouro);
		banric_ = findViewById(R.id.banrisul);
		banrico_ = findViewById(R.id.banrico);
		banes_ = findViewById(R.id.banes);
		americ_ = findViewById(R.id.americ);
		canc = findViewById(R.id.canc);
		fecha = findViewById(R.id.fecha);
		
		try{
			DB db = new DB(c);
			sangria = db.saFind();
			if(sangria.get(0).getSangria().equals("")){
			    sangRes = sangria.get(0).getSangria();
			} 
		}catch(Exception e){
			sangRes = "";
		}
		try{
			DB db = new DB(c);
			americ = db.ameFind();
			if(americ.get(0).getAmeric().equals("")){
				americid.setVisibility(View.VISIBLE);
			    americResult = americ.get(0).getAmeric();
			} 
		}catch(Exception e){
			americid.setVisibility(View.GONE);
			americResult = "";
		}
		try{
			DB db = new DB(c);
			banes = db.banesFind();
			if(banes.get(0).getBanes().equals("")){
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
			if(banrico.get(0).getBanriC().equals("")){
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
			if(banric.get(0).getbanric().equals("")){
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
			if(ouro.get(0).getOuro().equals("")){
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
			if(person.get(0).getPerson().equals("")){
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
			if(soro.get(0).getSoro().equals("")){
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
			if(verde.get(0).getVerde().equals("")){
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
			if(pix.get(0).getPix().equals("")){
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
			if(cabal.get(0).getCabal().equals("")){
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
			if(hiperC.get(0).getHiperC().equals("")){
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
			if(hiper.get(0).getHiper().equals("")){
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
			if(masterC.get(0).getMasterC().equals("")){
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
			if(masterD.get(0).getMasterD().equals("")){
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
			if(visaC.get(0).getVisaC().equals("")){
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
			if(visaD.get(0).getVisaD().equals("")){
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
			if(eloC.get(0).getEloC().equals("")){
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
			if(eloD.get(0).getEloD().equals("")){
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
											String sanResult, moneyRes, eloDRes, eloCRes, visaDRes, visaCRes, masterDRes, masterCRes, hiperRes, hiperCRes, 
												verdeRes, soroRes, personRes, ouroRes, banriRes, banricRes, banesRes, americRes;
											if(!sangRes.toString().equals("")){
												Double somaSan = new Double(sangRes);
												Double compRes = new Double(sangria_.getText().toString());
												double res = somaSan - compRes;
												DecimalFormatSymbols df4 = new DecimalFormatSymbols();
												df4.setGroupingSeparator('.');
												df4.setDecimalSeparator('.');
												DecimalFormat dform4 = new DecimalFormat("####.##", df4);
												sanResult = "";
											} else {
												sanResult = "";
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
	}
}
