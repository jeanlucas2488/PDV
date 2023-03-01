package lucas.client.service.caixa.setup.fechamentos;
import android.app.*;
import android.os.*;
import java.util.*;
import lucas.client.service.etc.*;
import android.widget.*;
import android.content.*;
import lucas.client.service.*;
import lucas.client.service.sqlite.*;
import android.view.*;

public class fechaCaixa extends Activity
{
	Context c = this;
	ProgressDialog progress;
	LinearLayout moneyid, elodid, elocid, visadid, visacid, masterdid, mastercid, hiperid, hipercid, cabalid, pixid, verdeid,
	             soroid, personid, ouroid, banricid, banricoid, banesid, americid;
	String moneyResult, eloDResult, eloCResult, visaDResult, visaCResult, masterDResult, masterCResult, hiperResult, HiperCResult,
	       cabalResult, pixResult, verdeResult, personResult, soroResult, ouroResult, banriResult, banricoResult, banesResult, americResult;
	EditText sangria_, fundo_, money_, eloD_, eloC_, visaD_, visaC_, masterD_, masterC_,
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
		fundo = findViewById(R.id.fundo);
		sangria = findViewById(R.id.sangria);
		operador = findViewById(R.id.operador);
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
	}
}
