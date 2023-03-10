package lucas.client.service.sqlite;
import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import java.util.*;
import lucas.client.service.etc.*;

public class DB
{
	SQLiteDatabase db;
	public DB(Context c){
		Core cor = new Core(c);
		db = cor.getWritableDatabase();
	}
	public void delEloD(){
		db.execSQL("delete from eloD");
	}
	public void delEloC(){
		db.execSQL("delete from eloC");
	}
	public void delVisaD(){
		db.execSQL("delete from visaD");
	}
	public void delVisaC(){
		db.execSQL("delete from visaC");
	}
	public void delMasterD(){
		db.execSQL("delete from masterD");
	}
	public void delMasterC(){
		db.execSQL("delete from masterC");
	}
	public void delHiper(){
		db.execSQL("delete from hiper");
	}
	public void delHiperC(){
		db.execSQL("delete from hiperC");
	}
	public void delCabal(){
		db.execSQL("delete from cabal");
	}
	public void delPix(){
		db.execSQL("delete from pix");
	}
	public void delVerde(){
		db.execSQL("delete from verde");
	}
	public void delSoro(){
		db.execSQL("delete from soro");
	}
	public void delPerson(){
		db.execSQL("delete from person");
	}
	public void delOuro(){
		db.execSQL("delete from ouro");
	}
	public void delBanric(){
		db.execSQL("delete from banrisul");
	}
	public void delBanriC(){
		db.execSQL("delete from banriC");
	}
	public void delBanes(){
		db.execSQL("delete from banes");
	}
	public void delMoney(){
		db.execSQL("delete from dinheiro");
	}
	public void delAmeric(){
		db.execSQL("delete from americ");
	}
	public void prodIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("loc", us.getLoc());
		ct.put("prod", us.getProd1());
		ct.put("quant", us.getQuant1());
		ct.put("valor", us.getValor1());
		ct.put("payType", us.getPay1());
		ct.put("pagto", us.getP1());
		ct.put("troco", us.getT1());
		db.insert("produtos", null, ct);
	}
	public void saIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("sangria", us.getSangria());
		db.insert("saldo", null, ct);
	}
	public void opIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("operador", us.getOp());
		db.insert("operador", null, ct);
	}
	public void sangIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("valor", us.getSanVal());
		ct.put("motivo", us.getSanMot());
		db.insert("sangria", null, ct);
	}
	public void moneyIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("money", us.getMoney());
		db.insert("dinheiro", null, ct);
	}
	public void eloDIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("eloD", us.getEloD());
		db.insert("eloD", null, ct);
	}
	public void eloCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("eloC", us.getEloC());
		db.insert("eloC", null, ct);
	}
	public void visaDIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("visaD", us.getVisaD());
		db.insert("visaD", null, ct);
	}
	public void visaCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("visaC", us.getVisaC());
		db.insert("visaC", null, ct);
	}
	public void masterDIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("masterD", us.getMasterD());
		db.insert("masterD", null, ct);
	}
	public void masterCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("masterC", us.getMasterC());
		db.insert("masterC", null, ct);
	}
	public void hiperIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("hiper", us.getHiper());
		db.insert("hiper", null, ct);
	}
	public void hiperCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("hiperC", us.getHiperC());
		db.insert("hiperC", null, ct);
	}
	public void cabalIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("cabal", us.getCabal());
		db.insert("cabal", null, ct);
	}
	public void pixIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("pix", us.getPix());
		db.insert("pix", null, ct);
	}
	public void verdeIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("verde", us.getVerde());
		db.insert("verde", null, ct);
	}
	public void soroIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("soro", us.getSoro());
		db.insert("soro", null, ct);
	}
	public void personIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("person", us.getPerson());
		db.insert("person", null, ct);
	}
	public void ouroIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("ouro", us.getOuro());
		db.insert("ouro", null, ct);
	}
	public void banriIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("banrisul", us.getbanric());
		db.insert("banrisul", null, ct);
	}
	public void banriCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("banriC", us.getBanriC());
		db.insert("banriC", null, ct);
	}
	public void banesIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("banes", us.getBanes());
		db.insert("banes", null, ct);
	}
	public void americIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("americ", us.getAmeric());
		db.insert("americ", null, ct);
	}
	public List<util> saFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "sangria"};
		Cursor cs = db.query("saldo", cl, null, null, null, null, "sangria ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setSangria(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public util sanFind(long id){
		util us = new util();
		Cursor cs = db.rawQuery("select * from sangria WHERE id="+id+"", null);
		if(cs.moveToFirst()){
			
			do{
				us.setSanId(cs.getLong(cs.getColumnIndex("id")));
				us.setSanVal(cs.getString(cs.getColumnIndex("valor")));
				us.setSanMot(cs.getString(cs.getColumnIndex("motivo")));
			}while(cs.moveToNext());
		}
		return us;
	}
	public List<util> opFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "operador"};
		Cursor cs = db.query("operador", cl, null, null, null, null, "operador ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setOp(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> ameFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "americ"};
		Cursor cs = db.query("americ", cl, null, null, null, null, "americ ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setAmeric(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> banesFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "banes"};
		Cursor cs = db.query("banes", cl, null, null, null, null, "banes ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setBanes(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> banriCFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "banriC"};
		Cursor cs = db.query("banriC", cl, null, null, null, null, "banriC ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setBanric(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> banriFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "banrisul"};
		Cursor cs = db.query("banrisul", cl, null, null, null, null, "banrisul ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setBanric(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> ouroFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "ouro"};
		Cursor cs = db.query("ouro", cl, null, null, null, null, "ouro ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setOuro(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> personFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "person"};
		Cursor cs = db.query("person", cl, null, null, null, null, "person ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setPerson(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> soroFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "soro"};
		Cursor cs = db.query("soro", cl, null, null, null, null, "soro ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setSoro(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> verdeFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "verde"};
		Cursor cs = db.query("verde", cl, null, null, null, null, "verde ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setVerde(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> pixFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "pix"};
		Cursor cs = db.query("pix", cl, null, null, null, null, "pix ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setPix(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> cabalFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "cabal"};
		Cursor cs = db.query("cabal", cl, null, null, null, null, "cabal ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setCabal(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> hiperCFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "hiperC"};
		Cursor cs = db.query("hiperC", cl, null, null, null, null, "hiperC ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setHiperC(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> hiperFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "hiper"};
		Cursor cs = db.query("hiper", cl, null, null, null, null, "hiper ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setHiper(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> masterCFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "masterC"};
		Cursor cs = db.query("masterC", cl, null, null, null, null, "masterC ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setMasterC(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> masterDFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "masterD"};
		Cursor cs = db.query("masterD", cl, null, null, null, null, "masterD ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setMasterD(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> visaCFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "visaC"};
		Cursor cs = db.query("visaC", cl, null, null, null, null, "visaC ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setVisaC(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> visaDFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "visaD"};
		Cursor cs = db.query("visaD", cl, null, null, null, null, "visaD ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setVisaD(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> eloCFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "eloC"};
		Cursor cs = db.query("eloC", cl, null, null, null, null, "eloC ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setEloC(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> eloDFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "eloD"};
		Cursor cs = db.query("eloD", cl, null, null, null, null, "eloD ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
			do{
				util us = new util();
				us.setEloD(cs.getString(1));
				arr.add(us);
			}while(cs.moveToNext());
		}
		return arr;
	}
	public List<util> moFind(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "money"};
		Cursor cs = db.query("dinheiro", cl, null, null, null, null, "money ASC");
		if(cs.getCount() >0){
			cs.moveToFirst();
		do{
			util us = new util();
			us.setMoney(cs.getString(1));
			arr.add(us);	
		}while(cs.moveToNext());
		}
		return arr;
	}
}
